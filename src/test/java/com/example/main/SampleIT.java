package com.example.main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.config.AppConfig;
import com.example.model.Car;
import com.example.service.SampleInterface;
import com.example.util.SampleFileReaderWriter;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfig.class})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SampleIT {

    @Autowired
    SampleFileReaderWriter sampleFileReaderWriter;

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
       List<Car> cars = sampleFileReaderWriter.readCars();
       assertEquals(3, cars.size());
       assertEquals("Tesla", cars.get(0).getMake());
       assertEquals("Model S", cars.get(0).getModel());
       assertEquals(402, cars.get(0).getRange());
    }

    @Test
    public void testFileWriter() throws URISyntaxException {
        Car taycan = Car.builder()
                .id(RandomStringUtils.randomAlphanumeric(16))
                .make("Porsche")
                .model("Taycan")
                .range(310)
                .build();
        // Write the file
        sampleFileReaderWriter.writeCars(List.of(taycan));

        // Verify it exists
        URL resource = getClass().getClassLoader().getResource("cars_new.json");
        File file = new File(resource.toURI());
        assertTrue(file.exists());
    }
}
