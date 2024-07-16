package com.whatsapp.controllers;


import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

public class RepositorySync {

    private static final String SOURCE_REPO_URL = "https://github.com/vemulas19/whatsapp.git";
    private static final String STAGING_REPO_URL = "https://github.com/vemulas19/whatsapp-stagging.git";
    private static final String FINAL_REPO_URL = "https://github.com/vemulas19/whatsapp-final.git";
    private static final List<String> WHITELIST_USERS = Arrays.asList("vemulas19@gmail.com", "user2@example.com");  // Replace with actual whitelisted usernames

    private static final String LOCAL_PATH_SOURCE = "./whatsapp";
    private static final String LOCAL_PATH_STAGING = "./whatsapp-stagging";
    private static final String LOCAL_PATH_FINAL = "./whatsapp-final";

    private static final String GITHUB_USERNAME = "your_github_username";
    private static final String GITHUB_TOKEN = "your_github_token";

    public static void main(String[] args) {
        try {
            // Clone or open the source repository
            Git sourceRepo = cloneOrOpenRepository(SOURCE_REPO_URL, LOCAL_PATH_SOURCE);

            // Clone or open the staging repository
            Git stagingRepo = cloneOrOpenRepository(STAGING_REPO_URL, LOCAL_PATH_STAGING);

            // Clone or open the final repository
            Git finalRepo = cloneOrOpenRepository(FINAL_REPO_URL, LOCAL_PATH_FINAL);

            // Filter commits by whitelisted users
            Iterable<RevCommit> commits = sourceRepo.log().call();
            for (RevCommit commit : commits) {
                if (WHITELIST_USERS.contains(commit.getAuthorIdent().getEmailAddress())) {
                    // Cherry-pick the commit to the staging repository
                    try {
                        stagingRepo.cherryPick().include(commit).call();
                    } catch (GitAPIException e) {
                        System.out.println("Cherry-pick failed for commit " + commit.getId() + ": " + e.getMessage());
                    }
                } else {
                    // Here, you can implement your approval process.
                    // For example, you can send an email, create a PR, etc.
                    System.out.println("Commit " + commit.getId() + " by " + commit.getAuthorIdent().getEmailAddress() + " needs approval.");
                }
            }

            // Push changes from staging to the final repository
            finalRepo.pull().call();
            finalRepo.merge().include(stagingRepo.getRepository().resolve("HEAD")).call();
            finalRepo.push().setCredentialsProvider(new UsernamePasswordCredentialsProvider(GITHUB_USERNAME, GITHUB_TOKEN)).call();

            System.out.println("Sync completed.");

        } catch (IOException | GitAPIException e) {
            e.printStackTrace();
        }
    }

    private static Git cloneOrOpenRepository(String repoUrl, String localPath) throws IOException, GitAPIException {
        File localRepo = new File(localPath);
        if (localRepo.exists()) {
            return Git.open(localRepo);
        } else {
            return Git.cloneRepository()
                    .setURI(repoUrl)
                    .setDirectory(localRepo)
                    .setCredentialsProvider(new UsernamePasswordCredentialsProvider(GITHUB_USERNAME, GITHUB_TOKEN))
                    .call();
        }
    }
}