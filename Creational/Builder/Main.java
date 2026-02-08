package Creational.Builder;

import java.time.Duration;

public class Main {

    public static void main(String[] args) {

        HttpRequest request = new HttpRequest.Builder("https://dummy.com", HttpMethod.POST)
                .setHeader("Authorization", "Bearer token")
                .setQueryParam("version", "v1")
                .setBody("{json}")
                .setTimeout(Duration.ofSeconds(5))
                .setCompression(true)
                .setIdempotencyKey("order-123")
                .build();

        System.out.println(request.prettyPrint());
    }
}
