package com.foodie.main;

import com.example.util.SampleFileReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class TestConfig {
    @Primary
    @Bean
    public SampleFileReader orderFileReader() {
        return new SampleFileReader();
    }
}
