package com.sebprunier.jobboard.persistence;

import java.util.List;
import java.util.UUID;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.Lists;
import com.google.inject.Singleton;
import com.sebprunier.jobboard.Job;

@Singleton
public class InMemoryJobPersister implements JobPersister {

    private Cache<String, Job> cache;

    public InMemoryJobPersister() {
        super();
        cache = CacheBuilder.newBuilder().maximumSize(100).build();
    }

    @Override
    public Job find(String jobId) {
        return cache.getIfPresent(jobId);
    }

    @Override
    public List<Job> findAll() {
        return Lists.newArrayList(cache.asMap().values());
    }

    @Override
    public void saveOrUpdate(Job job) {
        String jobId = job.getId();
        if (jobId == null) {
            jobId = UUID.randomUUID().toString();
            job.setId(jobId);
            cache.put(jobId, job);
        } else {
            cache.invalidate(jobId);
            cache.put(jobId, job);
        }
    }

    @Override
    public void delete(Job job) {
        cache.invalidate(job.getId());
    }

    protected Cache<String, Job> getCache() {
        return cache;
    }

}
