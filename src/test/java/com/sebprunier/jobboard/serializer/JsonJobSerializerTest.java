package com.sebprunier.jobboard.serializer;

import java.util.Arrays;
import java.util.Date;

import org.junit.Test;

import com.sebprunier.jobboard.Job;

public class JsonJobSerializerTest {

    @Test
    public void testMarshall() {
        JsonJobSerializer serializer = new JsonJobSerializer();
        String json = serializer.marshall(new Job(1L, "Job 1", "This is Job number one", new Date()));
        System.out.println(json);
    }

    @Test
    public void testMarshallAll() {
        JsonJobSerializer serializer = new JsonJobSerializer();
        String json = serializer.marshallAll(Arrays.asList(new Job[] {
                new Job(1L, "Job 1", "This is Job number one", new Date()),
                new Job(2L, "Job 2", "This is Job number two", new Date()) }));
        System.out.println(json);
    }

}
