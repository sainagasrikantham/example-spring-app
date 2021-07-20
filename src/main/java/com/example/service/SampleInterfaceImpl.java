package com.example.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Qualifier("sample")
public class SampleInterfaceImpl implements SampleInterface {
    @Override
    public String sampleMethod() {
        return "sample";
    }
}
