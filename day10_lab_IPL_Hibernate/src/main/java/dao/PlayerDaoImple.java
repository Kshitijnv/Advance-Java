package dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.PlayerPojo;
import pojos.Team;

public class PlayerDaoImple implements PlayerDao {
	@Override
	public String addPlayer(PlayerPojo player,String teamAbbr) {
		System.out.println("in playerDAO imple");
		String msg = "Player adding Failed!!!";
		String jpql = "select t from Team t where abbreviation=:abbr";
		Team t;
		// 1. getting session from session factory
		Session session = getFactory().getCurrentSession();
		// 2. begin a transaction
		Transaction tx = session.beginTransaction();
		try {
			t = session.createQuery(jpql, Team.class)
					.setParameter("abbr", teamAbbr)
					.getSingleResult();
			t.addPlayer(player);
			session.persist(player);
			tx.commit();
			msg = "Player added Successfully"; 
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

}
