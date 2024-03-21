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
    public Post getSinglePostB(int id) {

        try {
            HttpRequest request = HttpRequest.newBuilder(new URI(postURL + "/" + id)).GET().build();
            // ZROBIĆ ŻEBY ZWRACAŁ POST
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public HttpResponse<String> getAllPosts() {

        try {
            HttpRequest request = HttpRequest.newBuilder(postURL).GET().build();
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

//    public //ARRAYLIST getAllPostsB() { 4.b
//
//        try {
//            HttpRequest request = HttpRequest.newBuilder(postURL).GET().build();
//            return client.send(request, HttpResponse.BodyHandlers.ofString());
//        } catch (IOException | InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }

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
