package com.medication.research.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Drug {
    @Id public String id;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "diseases")
    public List<String> diseases;

    @Column(name = "description", length = 1000)
    public String description;

    public String name;
    public String released;
}
