package de.ait;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;



import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;



public class Main {
    public static void main(String[] args) throws URISyntaxException {



        RestTemplate restTemplate = new RestTemplate();
        URI uri = new URI("https://jsonplaceholder.typicode.com/comments");
        RequestEntity<String> request = new RequestEntity<>(HttpMethod.GET, uri);


        ResponseEntity<List<PostDot>> response =
                restTemplate.exchange(request, new ParameterizedTypeReference<List<PostDot>>() { });

        System.out.println(request);

      List<PostDot> body  = response.getBody();
        for (PostDot post: body){
            System.out.println(post);
            System.out.println();
        }

    }
}