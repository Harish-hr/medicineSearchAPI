package com.medication.research.service;

import com.medication.research.model.Drug;
import com.medication.research.repository.DrugRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DrugService {

    private DrugRepository drugRepository;

    public DrugService(DrugRepository drugRepository) {
        this.drugRepository = drugRepository;
    }

    public Iterable<Drug> findByName(String name) {
        return drugRepository.findByName(name);
    }

    public List<Drug> findByDiseaseOrMedicineName(String diseaseOrMedicineName) {
        List<Drug> disease = (List<Drug>) findByDisease(diseaseOrMedicineName);
        List<Drug> medicineName = (List<Drug>) findByName(diseaseOrMedicineName);
        disease.addAll(medicineName);
        return disease;
    }

    public Iterable<Drug> findByDisease(String diseases) {
        List<String> li = new ArrayList<>();
        li.add(diseases);
        return drugRepository.findDrugsInfo(li);
    }

    public List<Drug> saveAll(List<Drug> drugs) {
        List<Drug> response = (List<Drug>) drugRepository.saveAll(drugs);
        return response;
    }

    public Drug save(Drug drug) {
        return drugRepository.save(drug);
    }

    public Iterable<Drug> listAll() {
        return drugRepository.findAll();
    }
}
