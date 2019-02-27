package se.chriskevin.microservice.springboot;

import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;

@ExtendWith(PactConsumerTestExt.class)
@PactTestFor(providerName = "ArticlesProvider", port = "1234")
class PactConsumerIT {

    private Map<String, String> headers = MapUtils.putAll(new HashMap<>(), new String[] {
            "Content-Type", "application/json"
    });

    @Pact(provider = "ArticlesProvider", consumer = "ArticlesConsumer")
    public RequestResponsePact articles(final PactDslWithProvider builder) {
        return builder
                .given("Pact for Issue 313")
                .uponReceiving("retrieving article data")
                .path("/articles.json")
                .method("GET")
                .willRespondWith()
                .headers(headers)
                .status(200)
                .body(
                        new PactDslJsonBody()
                                .minArrayLike("articles", 1)
                                .object("variants")
                                .eachKeyLike("0032")
                                .stringType("description", "sample description")
                                .closeObject()
                                .closeObject()
                                .closeObject()
                                .closeArray()
                )
                .toPact();
    }

    @Test
    void testArticles(final MockServer mockServer) throws IOException {
        HttpResponse httpResponse = Request.Get(mockServer.getUrl() + "/articles.json").execute().returnResponse();
        assertThat(httpResponse.getStatusLine().getStatusCode(), is(equalTo(200)));
    }
}
