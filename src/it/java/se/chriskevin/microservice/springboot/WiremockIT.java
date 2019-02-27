package se.chriskevin.microservice.springboot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({
        WiremockResolver.class,
        WiremockUriResolver.class
})
class WiremockIT {

    @Test
    void shouldInjectWiremock(@Wiremock WireMockServer server, @WiremockUri String uri) {
        customize(server); // your setup
        //SomeApiClient api = SomeApiClient.connect(uri);

        Response response = api.call();
        assertThat(response.headers(), hasSize(1));
    }
}
