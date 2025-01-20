package com.booknbite.app.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class ImageService {

    private static String SUPABASE_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Im91cGNxdnh1ZHdhbHRidnloY3luIiwicm9sZSI6InNlcnZpY2Vfcm9sZSIsImlhdCI6MTczMDk3NTc1MywiZXhwIjoyMDQ2NTUxNzUzfQ.L655MfFJBZq-R_qedtPyFfc0-n9zzVPuyeUZ-hWLY1U";
    private static String BUCKET = "https://oupcqvxudwaltbvyhcyn.supabase.co/storage/v1/object/images/proizvodi/";

    public static String uploadImage(MultipartFile file) throws IOException {
        String fileName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();

        String uploadUrl = BUCKET + fileName;

        MultipartBodyBuilder bodyBuilder = new MultipartBodyBuilder();

        bodyBuilder.part("image", file.getResource())
                .header("Content-Type", file.getContentType());

        MultiValueMap<String, HttpEntity<?>> body = bodyBuilder.build();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "Bearer " + SUPABASE_TOKEN);

        HttpEntity<MultiValueMap<String, HttpEntity<?>>> requestEntity = new HttpEntity<>(body, httpHeaders);

        System.out.println(uploadUrl);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(uploadUrl, HttpMethod.POST, requestEntity, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            // Return the public URL for the uploaded image
            return uploadUrl;
        } else {
            throw new IOException("Failed to upload image: " + response.getBody());
        }
    }

}