package com.example.spring.Spring.Security;

import com.example.spring.Spring.Security.entity.Book;
import com.github.javafaker.Faker;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public class RestClientUtil extends AbstractFakerTest{

    public static void main(String args[]) {
        RestClientUtil util = new RestClientUtil();
        //util.getArticleByIdDemo();
        //createpassword("ekin123");
        util.getAllBooks();
        //util.addBooks(20);
        //util.generateBook();

    }


    String base_url = "http://localhost:8080/";
    private HttpHeaders getHeaders() {
        String credential="osman:osman123";
        String encodedCredential = new String(Base64.encodeBase64(credential.getBytes()));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Basic " + encodedCredential);
        return headers;
    }

    public void getAllBooks() {
        HttpHeaders headers = getHeaders();
        RestTemplate restTemplate = new RestTemplate();
        String url = base_url + "user/books";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Book[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Book[].class);
        Book[] books = responseEntity.getBody();
        for(Book book : books) {
            System.out.println(book);
        }
    }

    private void addBooks(int count) {
        for (int x = 0; x< count; x++){
            HttpHeaders headers = getHeaders();
            RestTemplate restTemplate = new RestTemplate();
            String url = base_url + "user/book";
            HttpEntity<Book> requestEntity = new HttpEntity<Book>(generateBook(), headers);
            URI uri = restTemplate.postForLocation(url, requestEntity);
            System.out.println(uri.getPath());
        }
    }

    private Book generateBook() {
            Book b = new Book();
            Faker faker = new Faker();
            b.setTitle(faker.book().title());
            b.setAuthor(faker.book().author());
            b.setGenre(faker.book().genre());
            b.setPublisher(faker.book().publisher());
            return b;
    }

    private static void createpassword(String s) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode(s));
    }


}
