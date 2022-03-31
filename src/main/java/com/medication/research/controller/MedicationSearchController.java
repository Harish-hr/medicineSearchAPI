package com.medication.research.controller;

import com.medication.research.model.Drug;
import com.medication.research.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MedicationSearchController {

    @Autowired private DrugService drugService;

    public MedicationSearchController(DrugService drugService) {
        this.drugService = drugService;
    }

    @GetMapping("/home")
    public ModelAndView getSearchPage() {
        return new ModelAndView("healthSearchForm");
    }

    @PostMapping("/searchMedicine")
    public ModelAndView getAllMedicationSearchResults(
            @RequestParam("searchText") String searchStr, ModelMap modelMap) {
        List<Drug> drugs = drugService.findByDiseaseOrMedicineName(searchStr);
        ModelAndView model = new ModelAndView("getDrugs");
        model.addObject("drugs", drugs);
        return model;
    }
}
