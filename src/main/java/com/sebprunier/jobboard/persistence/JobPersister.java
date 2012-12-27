package com.sebprunier.jobboard.persistence;

import java.util.List;

import com.sebprunier.jobboard.Job;

public interface JobPersister {

    public Job find(Long jobId);
    
    public List<Job> findAll();
    
    public void saveOrUpdate(Job job);
    
    public void delete(Job job);
    
}
