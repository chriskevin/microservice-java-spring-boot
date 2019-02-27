package se.chriskevin.microservice.springboot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@HoverflyCore(mode = HoverflyMode.CAPTURE, config = @HoverflyConfig(adminPort = 9000, proxyPort = 9001))
@HoverflySimulate(source = @Source(value = "build/resources/test/hoverfly/missing-simulation.json", type = SourceType.FILE),
        enableAutoCapture = true)
@ExtendWith(HoverflyExtension.class)
class HoverflyIT {

    @Test
    void shouldDoSomethingWith(final Hoverfly hoverfly) {
        hoverfly.simulate(dsl(
                service("www.my-test.com")
                        .post("/api/bookings").body("{\"flightId\": \"1\"}")
                        .willReturn(created("http://localhost/api/bookings/1"))));

        // ...
    }
}
