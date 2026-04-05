package com.JobProj.Basic.Service;

import com.JobProj.Basic.model.Job;
import com.JobProj.Basic.repo.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobService {
    @Autowired
    private JobRepository repo;

    // SAVE JOB
    public Job saveJob(Job job) {
        return repo.save(job);
    }

    // GET ALL JOBS
    public List<Job> getAllJobs() {
        return repo.findAll();
    }

    // GET JOB BY ID
    public Job getJobById(Long id) {
        return repo.findById(id).orElse(null);
    }

    // DELETE JOB
    public void deleteJob(Long id) {
        repo.deleteById(id);
    }

    // UPDATE JOB
    public Job updateJob(Job job) {
        return repo.save(job);
    }
}
