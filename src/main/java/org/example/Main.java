package org.example;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) {

        // TASK 2.a

        JSONPlaceholderFetcher postFetcher = new JSONPlaceholderFetcher();

        HttpResponse<String> response = postFetcher.getSinglePost(1);
        System.out.println("TASK 1:");
        System.out.println(response.statusCode());
        System.out.println(response.body());
        System.out.println();

        // Task 2.b

        HttpResponse<String> response1 = postFetcher.getAllPosts();
        System.out.println("TASK 2");
        System.out.println(response1.statusCode());
        System.out.println(response1.body());
        System.out.println();

    }


}