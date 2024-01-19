package com.app.service;

import java.util.List;

import com.app.pojos.JobPosting;

public interface JobPostingService {
    JobPosting postJob(JobPosting jobPosting);

    JobPosting updateJob(long jobId, JobPosting updatedJobPosting);

    void deleteJob(long jobId);

    List<JobPosting> getAllJobPostings();
}

