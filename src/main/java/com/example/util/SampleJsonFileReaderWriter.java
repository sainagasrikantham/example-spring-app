package com.example.util;

import com.example.model.Car;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class SampleJsonFileReaderWriter {
    @SuppressWarnings("unchecked")
    public List<Car> readCars() {
        List<Car> cars = null;
        JSONParser jsonParser = new JSONParser();

        try {
            URL resource = getClass().getClassLoader().getResource("cars.json");
            log.debug("Resource URL : {}", resource.toString());
            File file = new File(resource.toURI());

            FileReader reader = new FileReader(file);
            Object obj = jsonParser.parse(reader);

            JSONArray orderList = (JSONArray) obj;
            cars = (List<Car>) orderList.stream()
                    .map(o -> parseObject((JSONObject) o))
                    .collect(Collectors.toList());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return cars;
    }

    public void writeCars(List<Car> cars) {
        JSONArray jsonArray = new JSONArray();
        for (Car car: cars) {
            jsonArray.add(mapCarToJsonObject(car));
        }

        //Write JSON file
        try {
            String path = "src/test/resources";
            FileWriter fileWriter = new FileWriter(new File(path, "cars_new.json"));
            fileWriter.write(jsonArray.toJSONString());
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private JSONObject mapCarToJsonObject(Car car) {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("id", car.getId());
        jsonObject.put("make", car.getMake());
        jsonObject.put("model", car.getModel());
        jsonObject.put("range", car.getRange());

        return jsonObject;
    }

    private Car parseObject(JSONObject object) {
        return Car.builder()
                .id((String) object.get("id"))
                .make((String) object.get("make"))
                .model((String) object.get("model"))
                .range(((Long) object.get("range")).intValue())
                .build();
    }
}
