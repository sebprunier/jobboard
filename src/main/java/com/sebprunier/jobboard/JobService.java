package com.sebprunier.jobboard;

import java.util.List;

import com.google.inject.Inject;
import com.sebprunier.jobboard.persistence.JobPersister;

public class JobService {

    private JobPersister persister;

    @Inject
    public JobService(JobPersister persister) {
        super();
        this.persister = persister;
    }

    public Job get(Long jobId) {
        return persister.find(jobId);
    }

    public List<Job> getAll() {
        return persister.findAll();
    }

    public void create(Job job) {
        persister.saveOrUpdate(job);
    }

    public void update(Job job) {
        persister.saveOrUpdate(job);
    }

    public void delete(Job job) {
        persister.delete(job);
    }
}
