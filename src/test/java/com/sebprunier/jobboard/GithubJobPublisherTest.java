package com.sebprunier.jobboard;

import java.util.ArrayList;

import org.junit.Test;

public class GithubJobPublisherTest {

    @Test(expected = UnsupportedOperationException.class)
    public void testPublish() {
        GithubJobPublisher publisher = new GithubJobPublisher();
        publisher.publish(new Job());
    }

    @Test
    public void testPublishAll() {
        GithubJobPublisher publisher = new GithubJobPublisher();
        ArrayList<Job> jobs = new ArrayList<Job>();
        publisher.publishAll(jobs);
    }

}
