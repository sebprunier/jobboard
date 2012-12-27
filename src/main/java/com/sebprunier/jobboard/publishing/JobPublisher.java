package com.sebprunier.jobboard.publishing;

import java.util.List;

import com.sebprunier.jobboard.Job;

public interface JobPublisher {

    void publish(Job job);

    void publishAll(List<Job> jobs);

}
