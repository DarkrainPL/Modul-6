package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.http.HttpRequest;

public class JSONMapper {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static Post convertJSONToPost(HttpRequest postJSON) {

        Post post = new Post();

        try {
            JsonNode node = MAPPER.readTree(String.valueOf(postJSON)); // wczytaj tego JSONa

            post.setUserID(node.get("userId").longValue());
            post.setId(node.get("id").longValue());
            post.setTitle(node.get("title").textValue());
            post.setBody(node.get("body").textValue());

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return post;
    }

    public static Post convertJSONToPost(String postJSON) {

        Post post = new Post();

        try {
            JsonNode node = MAPPER.readTree(postJSON); // wczytaj tego JSONa

            post.setUserID(node.get("userId").longValue());
            post.setId(node.get("id").longValue());
            post.setTitle(node.get("title").textValue());
            post.setBody(node.get("body").textValue());

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return post;
    }
    public static String convertPostToJson(Post postJSON) {

        System.out.println("{\"userID\": " + postJSON.getUserID());
        System.out.println("\"id\": " + postJSON.getId());
        System.out.println("\"title\": " + postJSON.getTitle());
        System.out.println("\"body\": " + postJSON.getBody() + "}");

        String jsonString = "{\"userID\": " + postJSON.getUserID() + "\"id\": " + postJSON.getId() + "\"title\": " + postJSON.getTitle() + "\"body\": " + postJSON.getBody() + "}";

        return jsonString;
    }

}