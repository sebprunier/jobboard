package com.sebprunier.jobboard.serialization;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import com.sebprunier.jobboard.Job;

public class JsonJobSerializer implements JobSerializer {

    private ObjectMapper newObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, true);
        // objectMapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
        return objectMapper;
    }

    @Override
    public String marshall(Job job) {
        try {
            ObjectMapper mapper = newObjectMapper();
            return mapper.writeValueAsString(job);
        } catch (Exception e) {
            throw new RuntimeException("Error while marshalling job !", e);
        }
    }

    @Override
    public String marshallAll(List<Job> jobs) {
        try {
            ObjectMapper mapper = newObjectMapper();
            return mapper.writeValueAsString(jobs);
        } catch (Exception e) {
            throw new RuntimeException("Error while marshalling jobs !", e);
        }
    }

    @Override
    public Job unmarshall(String text) {
        throw new UnsupportedOperationException("Not yet implemented !");
    }

    @Override
    public List<Job> unmarshallAll(String text) {
        throw new UnsupportedOperationException("Not yet implemented !");
    }

}
