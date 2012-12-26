package com.sebprunier.jobboard.service;

import java.util.List;

import com.sebprunier.jobboard.Job;

public interface JobService {

    Job get(Long jobId);

    List<Job> getAll();

    void create(Job job);

    void update(Job job);

    void delete(Job job);
}
