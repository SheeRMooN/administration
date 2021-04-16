package com.example.administration.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class PeopleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "people_home",
            joinColumns = {@JoinColumn(name = "people_id")},
            inverseJoinColumns = {@JoinColumn(name = "home_id")})
    private List<HomeEntity> home;
    public void addHome(HomeEntity homeEntity){
        this.home.add(homeEntity);
    }
}
