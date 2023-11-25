package dao;

import java.util.List;

import pojos.Team;
public class TeamDaoImple implements TeamDao {
	
	@Override
	public List<Team> getAbrevation() {
//		Session session = getFactory().getCurrentSession();
//		Transaction tx = session.beginTransaction();
//		List<Team> teamList = null;  
//		String jpql = "select t from Team t";
//	try {
//		teamList = session.createQuery(jpql, Team.class)
//				.getResultList();
//		tx.commit();
//	}catch(RuntimeException e) {
//		if(tx!=null)
//			tx.rollback();
//		throw e;
//	}
		return null;
	}

	@Override
	public Team getTeamDetails(String abbrevation)  {
		//setting the IN parameter
		return null;
	}
	
}
