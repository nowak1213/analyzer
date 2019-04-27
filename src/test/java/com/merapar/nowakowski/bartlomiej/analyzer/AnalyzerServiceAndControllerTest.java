package com.merapar.nowakowski.bartlomiej.analyzer;

import com.merapar.nowakowski.bartlomiej.analyzer.model.AnalyzeResponse;
import com.merapar.nowakowski.bartlomiej.analyzer.model.Row;
import com.merapar.nowakowski.bartlomiej.analyzer.service.AnalyzerService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockserver.client.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.verify.VerificationTimes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.Parameter.param;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnalyzerServiceAndControllerTest {

	private ClientAndServer mockServer;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	HttpEntity<List<Row>> entity = new HttpEntity<>(null, headers);

	private static final String URL = "https://s3-eu-west-1.amazonaws.com/merapar-assessment/3dprinting-posts.xml";

	@Autowired
	AnalyzerService analyzerService;

	@Before
	public void startMockServer() {
		mockServer = startClientAndServer(1080);
	}

	@After
	public void stopMockServer() {
		mockServer.stop();
	}

	@Test
	public void shouldCallControllerOnlyOnce() {
		hitTheServerWithPostRequest();
		verifyPostRequest();
	}

	@Test
	public void shouldCallServiceMethod() {
		AnalyzeResponse response = getResponseEntity();

		assertThat(LocalDateTime.parse("2016-01-12T18:45:19.963")).isEqualTo(response.getDetails().getFirstPost());
		assertThat(LocalDateTime.parse("2016-03-04T13:30:22.41")).isEqualTo(response.getDetails().getLastPost());
		assertThat(655L).isEqualTo(response.getDetails().getTotalPosts());
		assertThat(102L).isEqualTo(response.getDetails().getTotalAcceptedPosts());
		assertThat(3).isEqualTo(response.getDetails().getAvgScore());
	}

	private AnalyzeResponse getResponseEntity() {
		return analyzerService.analyzeXML(URL);
	}

	private void hitTheServerWithPostRequest() {
		restTemplate.exchange(
				"http://localhost:1080/analyze?url=" + URL,
                HttpMethod.POST,
                entity,
                new ParameterizedTypeReference<List<Row>>(){});
	}

	private void verifyPostRequest() {
		new MockServerClient("localhost", 1080).verify(
				request()
						.withMethod("POST")
						.withPath("/analyze")
						.withQueryStringParameters(
								param("url", URL)
						),
				VerificationTimes.exactly(1)
		);
	}

}

