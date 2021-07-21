package com.example.config;

import com.example.service.SampleInterface;
import com.example.service.SampleInterfaceImpl;
import com.example.util.SampleFileReaderWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public SampleFileReaderWriter sampleFileReader() { return new SampleFileReaderWriter(); }

    @Bean
    @Qualifier("sample")
    public SampleInterface sampleInterface() {
        return new SampleInterfaceImpl();
    }
}
