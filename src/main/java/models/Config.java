package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Config(
        @JsonProperty(value = "baseUrl", required = true) String baseUrl
) {
}