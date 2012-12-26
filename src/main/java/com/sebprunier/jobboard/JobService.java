package com.sebprunier.jobboard;

import java.util.List;

public interface JobService {

    Job get(Long jobId);

    List<Job> getAll();

    void create(Job job);

    void update(Job job);

    void delete(Job job);
}
