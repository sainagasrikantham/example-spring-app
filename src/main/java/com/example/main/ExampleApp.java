package com.example.main;

import com.example.config.AppConfig;
import com.example.service.SampleInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class ExampleApp {

    public static void main(String args[]) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        log.info("**** Args Length={}", args.length);

        // Get sample beans
        SampleInterface sampleInterface = context.getBean(SampleInterface.class);
        log.info(sampleInterface.sampleMethod());
    }
}
