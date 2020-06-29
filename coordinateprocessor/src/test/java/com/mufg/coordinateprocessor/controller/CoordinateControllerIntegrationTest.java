package com.mufg.coordinateprocessor.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.mufg.coordinateprocessor.model.Coordinate;
import com.mufg.coordinateprocessor.util.CoordinateConstants;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CoordinateControllerIntegrationTest {

	private static final Logger logger = LoggerFactory.getLogger(CoordinateControllerIntegrationTest.class);

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getLineInputTest() throws Exception {
		logger.info("getLineInput Test");
		assertThat(
				this.restTemplate.withBasicAuth(CoordinateConstants.ADMIN_IDENTIFIER, CoordinateConstants.ADMIN_PASSWORD).getForObject(CoordinateConstants.BASE_URL + "getinput", String.class))
						.contains("lineNumber");
	}

	@Test
	public void calcCordinateDistanceFromCSVTest() throws Exception {
		logger.info("getLineIcalcCordinateDistanceFromCSVnput Test");
		assertThat(this.restTemplate.withBasicAuth(CoordinateConstants.ADMIN_IDENTIFIER, CoordinateConstants.ADMIN_PASSWORD).getForObject(CoordinateConstants.BASE_URL + "getMaxLength",
				String.class)).contains("longestLine");
	}

	@Test
	public void addLineInputTest() throws Exception {
		logger.info("getLineIcalcCordinateDistanceFromCSVnput Test");

		List<String> cordinateList = new ArrayList<String>();
		Coordinate coordinate = new Coordinate(2, 12.0f, 5.0f, 13.0f, 7.0f);
		cordinateList.add(coordinate.toString());
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Lines", cordinateList);
		logger.info(jsonObject.toString());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> request = new HttpEntity<String>(jsonObject.toString(), headers);
		assertThat(this.restTemplate.withBasicAuth(CoordinateConstants.ADMIN_IDENTIFIER, CoordinateConstants.ADMIN_PASSWORD)
				.postForEntity(CoordinateConstants.BASE_URL + "postInput", request, String.class).getStatusCode())
						.isEqualByComparingTo(HttpStatus.BAD_REQUEST);
	}
}
