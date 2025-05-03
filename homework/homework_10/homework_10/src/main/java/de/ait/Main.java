package de.ait;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class Main {
    public static void main(String[] args) {
        String imgUrl = "https://cdn.javarush.com/images/article/431abcb1-71aa-4137-97bd-ad26d7aa0e00/800.jpeg";
        String lang = "de,ru";
        String token = "Basic YWNjXzAzNGVmZGIxM2YwZTY4ZToxZjgwNDY5MGRjYmE5NjZhZTAwNzc3NWViNjYwZTZjMw==";
        String url = "https://api.imagga.com/v2/tags";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token);

        URI uri = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("image_url", imgUrl)
                .queryParam("language", lang)
                .build()
                .toUri();

        RequestEntity<String> request = new RequestEntity<>(headers, HttpMethod.GET, uri);
        ResponseEntity<TagsResponseDto> response = restTemplate.exchange(request, TagsResponseDto.class);

        response.getBody().getResult().getTags().forEach(System.out::println);

    }
}