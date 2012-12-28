package com.sebprunier.jobboard.web;

import com.google.inject.AbstractModule;
import com.sebprunier.jobboard.persistence.InMemoryPersister;
import com.sebprunier.jobboard.persistence.JobPersister;
import com.sebprunier.jobboard.serialization.JobSerializer;
import com.sebprunier.jobboard.serialization.JsonJobSerializer;

public class JobboardWebModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(JobSerializer.class).to(JsonJobSerializer.class);
        bind(JobPersister.class).to(InMemoryPersister.class);
    }

}
