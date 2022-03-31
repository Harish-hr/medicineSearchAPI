package com.medication.research.repository;

import com.medication.research.model.Drug;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DrugRepository extends CrudRepository<Drug, String> {
    @Query(value = "SELECT d FROM Drug d LEFT JOIN d.diseases ds WHERE ds IN :dsList")
    List<Drug> findDrugsInfo(@Param("dsList") List<String> diseases);

    List<Drug> findByName(String name);
}
