package com.sebprunier.jobboard;

import java.util.List;

public interface JobPublisher {

    void publish(Job job);

    void publishAll(List<Job> jobs);

}
