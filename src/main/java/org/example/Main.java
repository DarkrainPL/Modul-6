package org.example;

import java.net.http.HttpResponse;
import java.util.ArrayList;

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
        System.out.println(response2.statusCode());
        System.out.println(response2.body());

        if (answer == 200 || answer == 201) {
            System.out.println("Operation has been successful!");
        } else {
            System.out.println("Operation has NOT been successful!");
        }

        // Task 3.c
        System.out.println();
        System.out.println("TASK 3.c");
        HttpResponse<String> response3 = postFetcher.getSinglePost(1);
        Post post = JSONMapper.convertJSONToPost(response3.body()); // przemapowałem obiektJSON na jave
        System.out.println(post);

        // Task 4

        System.out.println();
        System.out.println("TASK 4");
        System.out.println();
        System.out.println("Single post as Post");
        Post response4 = postFetcher.getSinglePostB(1);
        System.out.println(response4);
        System.out.println("Get all post as array list");
        ArrayList<Post> response5 = postFetcher.getAllPostsB();
        System.out.println(response5);


        // Task 5
        System.out.println();
        System.out.println("TASK 5");
        Post postJson = new Post();

        postJson.setId(1);
        postJson.setUserID(1);
        postJson.setBody("cogito ergo sum");
        postJson.setTitle("zarcik");

        String stringJson = JSONMapper.convertPostToJson(postJson);
        System.out.println(stringJson);
    }

}