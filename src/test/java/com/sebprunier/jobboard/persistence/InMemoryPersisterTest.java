package com.sebprunier.jobboard.persistence;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.sebprunier.jobboard.Job;

public class InMemoryPersisterTest {

    private Injector injector;

    @Before
    public void setUp() {
        injector = Guice.createInjector(new InMemoryPersisterTestModule());
        populate();
    }

    private void populate() {
        InMemoryPersister persister = injector.getInstance(InMemoryPersister.class);
        persister.getCache().put("1", new Job("1", "Job 1", "This is Job number one", new Date(1356537739208L)));
        persister.getCache().put("2", new Job("2", "Job 2", "This is Job number two", new Date(1356537739208L)));
    }

    @Test
    public void testFind() {
        InMemoryPersister persister = injector.getInstance(InMemoryPersister.class);
        Assert.assertNull(persister.find("0"));
        Assert.assertNotNull(persister.find("1"));
    }

    @Test
    public void testFindAll() {
        InMemoryPersister persister = injector.getInstance(InMemoryPersister.class);
        Assert.assertEquals(2, persister.findAll().size());
    }

    @Test
    public void testSaveOrUpdate() {
        InMemoryPersister persister = injector.getInstance(InMemoryPersister.class);
        // Save
        Job job = new Job("3", "Job 3", "This is Job number three", new Date(1356537739208L));
        persister.saveOrUpdate(job);
        Assert.assertNotNull(persister.getCache().getIfPresent("3"));
        Assert.assertEquals(3, persister.getCache().size());

        // Update
        job.setDescription("new description ...");
        persister.saveOrUpdate(job);
        Assert.assertNotNull(persister.getCache().getIfPresent("3"));
        Assert.assertEquals(3, persister.getCache().size());
    }

    @Test
    public void testDelete() {
        InMemoryPersister persister = injector.getInstance(InMemoryPersister.class);
        Job job = persister.getCache().getIfPresent("1");
        persister.delete(job);
        Assert.assertNull(persister.getCache().getIfPresent("1"));
        Assert.assertEquals(1, persister.getCache().size());
    }

    private class InMemoryPersisterTestModule extends AbstractModule {
        @Override
        protected void configure() {
        }
    }

}
