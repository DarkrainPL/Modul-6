package org.example;

import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) {

        // TASK 2.a

        JSONPlaceholderFetcher postFetcher = new JSONPlaceholderFetcher();

        HttpResponse<String> response = postFetcher.getSinglePost(1);
        System.out.println("TASK 2.a");
        System.out.println(response.statusCode());
        System.out.println(response.body());
        System.out.println();

        // Task 2.b

        HttpResponse<String> response1 = postFetcher.getAllPosts();
        System.out.println("TASK 2.b");
        System.out.println(response1.statusCode());
        System.out.println(response1.body());
        System.out.println();

        // Task 2.c

        System.out.println("TASK 2.c");
        HttpResponse<String> response2 = postFetcher.addPost("{\n" +
                "  \"userId\": 1,\n" +
                "  \"id\": 1,\n" +
                "  \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
                "  \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\n" +
                "}");
        int answer = response2.statusCode();

        if (answer == 200 || answer == 201) {
            System.out.println("Operation has been successful!");
        } else {
            System.out.println("Operation has NOT been successful!");
        }


    }
}