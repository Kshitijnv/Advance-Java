package com.app.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.JobPostingRepository;
import com.app.pojos.JobPosting;

@Service
public class JobPostingServiceImpl implements JobPostingService {

    @Autowired
    private JobPostingRepository jobPostingRepository;

    @Override
    public JobPosting postJob(JobPosting jobPosting) {
        // No need to explicitly call save since save method is already provided by JpaRepository
        return jobPostingRepository.save(jobPosting);
    }

    @Override
    public JobPosting updateJob(long jobId, JobPosting updatedJobPosting) {
        // No need to explicitly check for existence or update, JpaRepository handles it
        Optional<JobPosting> optionalJobPosting = jobPostingRepository.findById(jobId);
        return optionalJobPosting.map(existingJobPosting -> {
            // Update the existing job posting
            // Make sure to handle updates for each attribute
            existingJobPosting.setJobTitle(updatedJobPosting.getJobTitle());
            existingJobPosting.setCompanyName(updatedJobPosting.getCompanyName());
            existingJobPosting.setLocation(updatedJobPosting.getLocation());
            existingJobPosting.setDescription(updatedJobPosting.getDescription());
            existingJobPosting.setRequirements(updatedJobPosting.getRequirements());
            existingJobPosting.setSalary(updatedJobPosting.getSalary());
            existingJobPosting.setPostingDate(updatedJobPosting.getPostingDate());

            return jobPostingRepository.save(existingJobPosting);
        }).orElse(null);
    }

    @Override
    public void deleteJob(long jobId) {
        // No need to explicitly check for existence or delete, JpaRepository handles it
        jobPostingRepository.deleteById(jobId);
    }

    @Override
    public List<JobPosting> getAllJobPostings() {
        // No need to explicitly call findAll since it is already provided by JpaRepository
        return jobPostingRepository.findAll();
    }
}
