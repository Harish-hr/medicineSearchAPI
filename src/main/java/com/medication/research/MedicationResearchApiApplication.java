package com.medication.research;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.medication.research.model.Drug;
import com.medication.research.model.Root;
import com.medication.research.service.DrugService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MedicationResearchApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicationResearchApiApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(DrugService drugService) {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            try {
                File resource = new ClassPathResource("json/dataSet.json").getFile();
                String data = new String(Files.readAllBytes(resource.toPath()));
                Root root = mapper.readValue(data, Root.class);
                List<Root> drugList = new ArrayList(Arrays.asList(root));
                if (!drugList.isEmpty()) {
                    List<Drug> drug = drugList.get(0).getDrugs();
                    drugService.saveAll(drug);
                }
                System.out.println("Data Saved!");
            } catch (IOException e) {
                System.out.println("Unable to save users: " + e.getMessage());
            }
        };
    }
}
