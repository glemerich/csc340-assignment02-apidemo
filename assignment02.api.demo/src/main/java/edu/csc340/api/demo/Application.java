package edu.csc340.api.demo;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
public class Application {

	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);
		getJoke();
	}

	public static void getJoke() {
        try {
            String url = "https://official-joke-api.appspot.com/jokes/random";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jSonFact = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jSonFact);

            String setup = root.findValue("setup").asText();
            String punchline = root.findValue("punchline").asText();

            System.out.println("**********JOKE********");
            System.out.println(setup);
            System.out.println();
            System.out.println(punchline);

        } catch (JsonProcessingException ex) {
            System.out.println("error in getJoke");

        }
    }
}
