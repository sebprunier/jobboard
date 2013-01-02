package com.sebprunier.jobboard.service;

import java.util.Date;
import java.util.List;

import com.google.inject.Inject;
import com.sebprunier.jobboard.Job;
import com.sebprunier.jobboard.persistence.JobPersister;
import com.sebprunier.jobboard.publishing.JobPublisher;

public class JobService {

    private JobPersister persister;
    private JobPublisher publisher;
    
    @Inject
    public JobService(JobPersister persister, JobPublisher publisher) {
        super();
        this.persister = persister;
        this.publisher = publisher;
    }

    public Job get(String jobId) {
        return persister.find(jobId);
    }

    public List<Job> getAll() {
        return persister.findAll();
    }

    public void create(Job job) {
        job.setCreationDate(new Date());
        persister.saveOrUpdate(job);
        publisher.publishAll(getAll());
    }

    public void update(Job job) {
        persister.saveOrUpdate(job);
        publisher.publishAll(getAll());
    }

    public void delete(Job job) {
        persister.delete(job);
        publisher.publishAll(getAll());
    }
}
