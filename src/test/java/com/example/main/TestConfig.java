package com.example.main;

import com.example.util.SampleCsvFileReaderWriter;
import com.example.util.SampleJsonFileReaderWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class TestConfig {
    @Primary
    @Bean
    public SampleJsonFileReaderWriter jsonFileReaderWriter() {
        return new SampleJsonFileReaderWriter();
    }

    @Primary
    @Bean
    public SampleCsvFileReaderWriter csvFileReaderWriter() {
        return new SampleCsvFileReaderWriter();
    }
}
