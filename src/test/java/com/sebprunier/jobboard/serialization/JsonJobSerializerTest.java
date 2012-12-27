package com.sebprunier.jobboard.serialization;

import java.util.Arrays;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.sebprunier.jobboard.Job;
import com.sebprunier.jobboard.serialization.JsonJobSerializer;

public class JsonJobSerializerTest {

    private static final String JOB_1_JSON = "{\"id\":1,\"title\":\"Job 1\",\"description\":\"This is Job number one\",\"creationDate\":1356537739208}";
    private static final String ALL_JOBS_JSON = "[{\"id\":1,\"title\":\"Job 1\",\"description\":\"This is Job number one\",\"creationDate\":1356537739208},"
            + "{\"id\":2,\"title\":\"Job 2\",\"description\":\"This is Job number two\",\"creationDate\":1356537739208}]";

    @Test
    public void testMarshall() {
        JsonJobSerializer serializer = newSerializer();
        String json = serializer.marshall(new Job(1L, "Job 1", "This is Job number one", new Date(1356537739208L)));
        Assert.assertEquals(JOB_1_JSON, json);
    }

    @Test
    public void testMarshallAll() {
        JsonJobSerializer serializer = newSerializer();
        String json = serializer.marshallAll(Arrays.asList(new Job[] {
                new Job(1L, "Job 1", "This is Job number one", new Date(1356537739208L)),
                new Job(2L, "Job 2", "This is Job number two", new Date(1356537739208L)) }));
        Assert.assertEquals(ALL_JOBS_JSON, json);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testUnmarshall() {
        JsonJobSerializer serializer = newSerializer();
        serializer.unmarshall("");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testUnmarshallAll() {
        JsonJobSerializer serializer = newSerializer();
        serializer.unmarshall("");
    }

    private JsonJobSerializer newSerializer() {
        return new JsonJobSerializer();
    }
}
