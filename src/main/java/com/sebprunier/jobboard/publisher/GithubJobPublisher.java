package com.sebprunier.jobboard.publisher;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.eclipse.egit.github.core.Gist;
import org.eclipse.egit.github.core.GistFile;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.GistService;

import com.sebprunier.jobboard.Job;

public class GithubJobPublisher implements JobPublisher {

    private static final String JOBS_GIST_ID = "4380455";

    private static final String JOBS_GIST_FILE = "jobs.json";

    @Override
    public void publish(Job job) {
        throw new UnsupportedOperationException("Cannot publish only one job !");
    }

    @Override
    public void publishAll(List<Job> jobs) {
        try {
            updateGistContent();
        } catch (IOException e) {
            throw new RuntimeException("Error while pushing content to github !", e);
        }
    }

    private void updateGistContent() throws IOException {
        // Read github authentication info from system properties
        // TODO read from properties file ?
        final String githubUser = System.getProperty("github.user");
        final String githubPassword = System.getProperty("github.password");

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
        jobsFile.setContent("// TODO !");
        service.updateGist(gist);
    }
}
