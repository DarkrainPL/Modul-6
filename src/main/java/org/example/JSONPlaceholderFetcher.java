package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;


public class JSONPlaceholderFetcher {

    private final URI postURL = URI.create("https://jsonplaceholder.typicode.com/posts");
    private final HttpClient client = HttpClient.newHttpClient();

    public HttpResponse<String> getSinglePost(int id) {

        try {
            HttpRequest request = HttpRequest.newBuilder(new URI(postURL + "/" + id)).GET().build();
            return client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Post getSinglePostB(int id) { // czy to może być aż tak proste??

        Post post;

        JSONPlaceholderFetcher postFetcher = new JSONPlaceholderFetcher();
        HttpResponse<String> response = postFetcher.getSinglePost(id);
        post = JSONMapper.convertJSONToPost(response.body());

        return post;
    }

    public HttpResponse<String> getAllPosts() {

        try {
            HttpRequest request = HttpRequest.newBuilder(postURL).GET().build();
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Post> getAllPostsB() {

        // Post post = new Post();
        ArrayList<Post> listPost = new ArrayList<>();
        JSONPlaceholderFetcher postFetcher = new JSONPlaceholderFetcher();

        for (int i = 1; i<100; i++) {
            Post response = postFetcher.getSinglePostB(i);
            listPost.add(response);
        }
        return listPost;
    }

    public HttpResponse<String> addPost(String post) {

        try {
            HttpRequest request = HttpRequest.newBuilder(postURL)
                    .POST(HttpRequest.BodyPublishers.ofString(post))
                    .build();

            return client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);

        }


    }
}
