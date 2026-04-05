package com.JobProj.Basic.repo;

import com.JobProj.Basic.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Long> {
}
