package com.example.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SampleCsvFileReaderWriter {
    public List<String> readFile(String fileName) {
        List<String> fileContents = new ArrayList<>();

        try {
            URL resource = getClass().getClassLoader()
                    .getResource(fileName);
            log.debug("Resource URL : {}", resource.toString());
            File file = new File(resource.toURI());

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    fileContents.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return fileContents;
    }

    public void writeFile(List<String> fileContents, String fileName) {
        String path = "src/test/resources";
        try {
            FileWriter fileWriter = new FileWriter(new File(path, fileName));
            for (String line: fileContents) {
                fileWriter.write(line);
                fileWriter.write("\n");
            }
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
