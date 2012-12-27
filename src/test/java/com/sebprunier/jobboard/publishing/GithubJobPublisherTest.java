package com.sebprunier.jobboard.publishing;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.sebprunier.jobboard.Job;
import com.sebprunier.jobboard.serialization.JobSerializer;
import com.sebprunier.jobboard.serialization.JsonJobSerializer;

public class GithubJobPublisherTest {

    private Injector injector;

    @Before
    public void setUp() {
        injector = Guice.createInjector(new GithubJobPublisherTestModule());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testPublish() {
        GithubJobPublisher publisher = injector.getInstance(GithubJobPublisher.class);
        publisher.publish(new Job());
    }

    private class GithubJobPublisherTestModule extends AbstractModule {
        @Override
        protected void configure() {
            bind(JobSerializer.class).to(JsonJobSerializer.class);
        }
    }

}
