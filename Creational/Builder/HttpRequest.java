package Creational.Builder;

import java.time.Duration;
import java.util.*;

enum HttpMethod {
    GET, POST, PUT, DELETE, PATCH
}

class RetryPolicy {
    int retries;

    public static RetryPolicy defaultPolicy() {
        RetryPolicy p = new RetryPolicy();
        p.retries = 3;
        return p;
    }
}

public class HttpRequest {
    private final String url;
    private final HttpMethod method;
    private final Map<String, String> headers;
    private final Map<String, String> queryParams;
    private final String body;
    private final Duration timeout;
    private final RetryPolicy retryPolicy;
    private final String authToken;
    private final boolean compressionEnabled;
    private final String traceId;
    private final String idempotencyKey;

    private HttpRequest(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.headers = Collections.unmodifiableMap(new HashMap<>(builder.headers));
        this.queryParams = Collections.unmodifiableMap(new HashMap<>(builder.queryParams));
        this.body = builder.body;
        this.timeout = builder.timeout;
        this.retryPolicy = builder.retryPolicy;
        this.authToken = builder.authToken;
        this.compressionEnabled = builder.compressionEnabled;
        this.traceId = builder.traceId;
        this.idempotencyKey = builder.idempotencyKey;
    }

    public String prettyPrint() {
        StringBuilder sb = new StringBuilder();

        sb.append("HTTP Request\n");
        sb.append("------------\n");
        sb.append("URL: ").append(url).append("\n");
        sb.append("Method: ").append(method).append("\n");

        sb.append("\nHeaders:\n");
        if (headers.isEmpty()) {
            sb.append("  (none)\n");
        } else {
            headers.forEach((k, v) -> sb.append("  ").append(k).append(": ").append(v).append("\n"));
        }

        sb.append("\nQuery Params:\n");
        if (queryParams.isEmpty()) {
            sb.append("  (none)\n");
        } else {
            queryParams.forEach((k, v) -> sb.append("  ").append(k).append("=").append(v).append("\n"));
        }

        sb.append("\nBody: ").append(body == null ? "(empty)" : body).append("\n");
        sb.append("Timeout: ").append(timeout).append("\n");
        sb.append("RetryPolicy: ").append(retryPolicy.retries).append(" retries\n");
        sb.append("AuthToken: ").append(authToken == null ? "(none)" : "***masked***").append("\n");
        sb.append("Compression Enabled: ").append(compressionEnabled).append("\n");
        sb.append("TraceId: ").append(traceId).append("\n");
        sb.append("IdempotencyKey: ").append(idempotencyKey == null ? "(none)" : idempotencyKey).append("\n");

        return sb.toString();
    }


    public static class Builder {
        private final String url;
        private final HttpMethod method;
        private Map<String, String> headers = new HashMap<>();
        private Map<String, String> queryParams = new HashMap<>();
        private String body;
        private Duration timeout = Duration.ofSeconds(30);
        private RetryPolicy retryPolicy = RetryPolicy.defaultPolicy();
        private String authToken;
        private boolean compressionEnabled;
        private String traceId = UUID.randomUUID().toString();
        private String idempotencyKey;

        public Builder(String url, HttpMethod method) {
            this.url = url;
            this.method = method;
        }

        public Builder setHeader(String key, String value) {
            Objects.requireNonNull(key);
            Objects.requireNonNull(value);
            headers.put(key, value);
            return this;
        }

        public Builder setQueryParam(String key, String value) {
            Objects.requireNonNull(key);
            Objects.requireNonNull(value);
            queryParams.put(key, value);
            return this;
        }

        public Builder setBody(String body) {
            this.body = body;
            return this;
        }

        public Builder setTimeout(Duration timeout) {
            this.timeout = timeout;
            return this;
        }

        public Builder setRetryPolicy(RetryPolicy retryPolicy) {
            this.retryPolicy = retryPolicy;
            return this;
        }

        public Builder setAuthToken(String authToken) {
            this.authToken = authToken;
            return this;
        }

        public Builder setCompression(boolean enabled) {
            this.compressionEnabled = enabled;
            return this;
        }

        public Builder setTraceId(String traceId) {
            this.traceId = traceId;
            return this;
        }

        public Builder setIdempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

        public HttpRequest build() {

            if (url == null || url.isEmpty())
                throw new IllegalStateException("URL is required");

            if (method == null)
                throw new IllegalStateException("HTTP method required");

            if (method == HttpMethod.GET && body != null)
                throw new IllegalStateException("GET request cannot have body");

            if (method == HttpMethod.POST && body == null)
                throw new IllegalStateException("POST must have body");

            if (timeout == null || timeout.isNegative())
                throw new IllegalStateException("Timeout invalid");

            return new HttpRequest(this);
        }
    }
}
