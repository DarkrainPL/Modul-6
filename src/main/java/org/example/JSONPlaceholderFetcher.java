package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

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

    public HttpResponse<String> getAllPosts() {

        try {
            HttpRequest request = HttpRequest.newBuilder(new URI(postURL+"/")).GET().build();
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean addPost(String post) {
        return false;
    }
}
