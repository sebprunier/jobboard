package com.sebprunier.jobboard.publishing;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.eclipse.egit.github.core.Gist;
import org.eclipse.egit.github.core.GistFile;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.GistService;

import com.google.inject.Inject;
import com.sebprunier.jobboard.Job;
import com.sebprunier.jobboard.serialization.JobSerializer;

public class GithubJobPublisher implements JobPublisher {

    private static final String JOBS_GIST_ID = "4380455";
    private static final String JOBS_GIST_FILE = "jobs.json";

    private JobSerializer serializer;

    @Inject
    public GithubJobPublisher(JobSerializer serializer) {
        super();
        this.serializer = serializer;
    }

    @Override
    public void publishAll(List<Job> jobs) {
        try {
            updateGistContent(jobs);
        } catch (IOException e) {
            throw new RuntimeException("Error while pushing content to github !", e);
        }
    }

    private void updateGistContent(List<Job> jobs) throws IOException {
        // Read github authentication info from properties
        final Properties githubProperties = new Properties();
        githubProperties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("github.properties"));
        final String githubUser = githubProperties.getProperty("github.user");
        final String githubPassword = githubProperties.getProperty("github.password");

        // Create client and gist service
        GitHubClient client = new GitHubClient();
        client.setCredentials(githubUser, githubPassword);
        GistService service = new GistService(client);

        // Retrieve jobs gist, especially the .json file.
        Gist gist = service.getGist(JOBS_GIST_ID);
        System.out.println(gist.getCreatedAt());
        Map<String, GistFile> gistFiles = gist.getFiles();
        GistFile jobsFile = gistFiles.get(JOBS_GIST_FILE);

        // Update gist content !
        String serializedJobs = serializer.marshallAll(jobs);
        jobsFile.setContent(serializedJobs);
        service.updateGist(gist);
    }

    @Override
    public void publish(Job job) {
        throw new UnsupportedOperationException("Cannot publish only one job !");
    }
}
