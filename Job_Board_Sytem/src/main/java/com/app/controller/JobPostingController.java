package com.app.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.JobPosting;
import com.app.service.JobPostingService;

@RestController
@RequestMapping("/jobPostings")
public class JobPostingController {

    @Autowired
    private JobPostingService jobPostingService;
/*   localhost:7070/jobPostings  */
    @PostMapping
    public ResponseEntity<Object> postJob(@RequestBody JobPosting jobPosting) {
        try {
            JobPosting createdJob = jobPostingService.postJob(jobPosting);
            return ResponseEntity.status(HttpStatus.CREATED).body("Job posted successfully. Job ID: " + createdJob.getJobId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to post job");
        }
    }
    /*   localhost:7070/jobPostings/1  */
    @PutMapping("/{jobId}")
    public ResponseEntity<Object> updateJob(@PathVariable long jobId, @RequestBody JobPosting updatedJobPosting) {
        try {
            JobPosting updatedJob = jobPostingService.updateJob(jobId, updatedJobPosting);
            if (updatedJob != null) {
                return ResponseEntity.status(HttpStatus.OK).body("Job updated successfully. Job ID: " + updatedJob.getJobId());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Job with ID " + jobId + " not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update job");
        }
    }
    /*   localhost:7070/jobPostings/1  */
    @DeleteMapping("/{jobId}")
    public ResponseEntity<Object> deleteJob(@PathVariable long jobId) {
        try {
            jobPostingService.deleteJob(jobId);
            return ResponseEntity.status(HttpStatus.OK).body("Job deleted successfully. Job ID: " + jobId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete job");
        }
    }
    /*   localhost:7070/jobPostings  */
    @GetMapping
    public ResponseEntity<Object> getAllJobPostings() {
        try {
            List<JobPosting> jobPostings = jobPostingService.getAllJobPostings();
            return ResponseEntity.status(HttpStatus.OK).body(jobPostings);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve job postings");
        }
    }
}
