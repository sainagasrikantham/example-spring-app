package com.foodie.main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.config.AppConfig;
import com.example.model.Car;
import com.example.service.SampleInterface;
import com.example.util.SampleFileReader;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfig.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SampleIT {

    @Autowired
    SampleFileReader sampleFileReader;

    @Autowired
    @Qualifier("sample")
    SampleInterface sampleInterface;

    @Test
    // @org.junit.jupiter.api.Order(1) // Uncomment to specify sequence to tests
    public void testSample() {
        assertEquals("sample", sampleInterface.sampleMethod());
    }

    @Test
    public void testFileReader() {
       List<Car> cars = sampleFileReader.fetchCars();
       assertEquals(3, cars.size());
       assertEquals("Tesla", cars.get(0).getMake());
       assertEquals("Model S", cars.get(0).getModel());
    }
}
