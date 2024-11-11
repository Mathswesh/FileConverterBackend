package org.example.converter.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTampletConfig {
    @Bean
    public RestTemplate RestTampletConfig() {
        return new RestTemplate();
    }
}
