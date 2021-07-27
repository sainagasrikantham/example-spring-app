package com.example.config;

import com.example.service.SampleInterface;
import com.example.service.SampleInterfaceImpl;
import com.example.util.SampleCsvFileReaderWriter;
import com.example.util.SampleJsonFileReaderWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public SampleJsonFileReaderWriter sampleJsonFileReaderWriter() { return new SampleJsonFileReaderWriter(); }

    @Bean
    public SampleCsvFileReaderWriter sampleCsvFileReaderWriter() { return new SampleCsvFileReaderWriter(); }

    @Bean
    @Qualifier("sample")
    public SampleInterface sampleInterface() {
        return new SampleInterfaceImpl();
    }
}
