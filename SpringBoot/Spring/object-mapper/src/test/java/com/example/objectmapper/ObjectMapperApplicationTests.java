package com.example.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObjectMapperApplicationTests {

	@Test
	void contextLoads() throws JsonProcessingException {
		System.out.println("---------------------");

		// Text Json -> Object
		// Object -> Text Json

		// controller req json(text) - > object
		// response object -> json(text)

		var objectMapper = new ObjectMapper();

		// object -> text
		// ovject mapper get method 를 활용한다. 그래서 꼭 getters가 있어야한다
		var user = new User("steve", 10, "010-4646-5555");

		var text = objectMapper.writeValueAsString(user);

		System.out.println(text);

		// text -> object
		// object mapper 는 default constructor 가 필요함
		var objectUser = objectMapper.readValue(text, User.class);
		System.out.println(objectUser);
	}

}
