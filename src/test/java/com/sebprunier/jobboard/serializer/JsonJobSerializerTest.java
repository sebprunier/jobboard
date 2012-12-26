package com.sebprunier.jobboard.serializer;

import java.util.Arrays;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.sebprunier.jobboard.Job;

public class JsonJobSerializerTest {

    @Test
    public void testMarshall() {
        JsonJobSerializer serializer = new JsonJobSerializer();
        String json = serializer.marshall(new Job(1L, "Job 1", "This is Job number one", new Date(1356537739208L)));
        Assert.assertEquals(
                "{\"id\":1,\"title\":\"Job 1\",\"description\":\"This is Job number one\",\"creationDate\":1356537739208}",
                json);
    }

    @Test
    public void testMarshallAll() {
        JsonJobSerializer serializer = new JsonJobSerializer();
        String json = serializer.marshallAll(Arrays.asList(new Job[] {
                new Job(1L, "Job 1", "This is Job number one", new Date(1356537739208L)),
                new Job(2L, "Job 2", "This is Job number two", new Date(1356537739208L)) }));
        Assert.assertEquals(
                "[{\"id\":1,\"title\":\"Job 1\",\"description\":\"This is Job number one\",\"creationDate\":1356537739208},{\"id\":2,\"title\":\"Job 2\",\"description\":\"This is Job number two\",\"creationDate\":1356537739208}]",
                json);
    }

}
