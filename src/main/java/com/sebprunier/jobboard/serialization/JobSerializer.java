package com.sebprunier.jobboard.serialization;

import java.util.List;

import com.sebprunier.jobboard.Job;

public interface JobSerializer {

    String marshall(Job job);

    String marshallAll(List<Job> jobs);

    Job unmarshall(String text);

    List<Job> unmarshallAll(String text);

}
