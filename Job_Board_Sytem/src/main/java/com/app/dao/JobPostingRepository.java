package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.JobPosting;

public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {
}
