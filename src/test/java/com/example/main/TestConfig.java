package com.example.main;

import com.example.util.SampleFileReaderWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class TestConfig {
    @Primary
    @Bean
    public SampleFileReaderWriter orderFileReader() {
        return new SampleFileReaderWriter();
    }
}
