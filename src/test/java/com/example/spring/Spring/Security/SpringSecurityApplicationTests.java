package com.example.spring.Spring.Security;

import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringSecurityApplicationTests {

	private HttpHeaders getHeaders() {
		String credential="osman:m123";
		//String credential="tarun:t123";
		String encodedCredential = new String(Base64.encodeBase64(credential.getBytes()));
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", "Basic " + encodedCredential);
		return headers;
	}


}
