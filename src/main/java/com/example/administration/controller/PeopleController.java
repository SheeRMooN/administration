package com.example.administration.controller;

import com.example.administration.entity.PeopleEntity;
import com.example.administration.service.HomeService;
import com.example.administration.service.PeopleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/people")
public class PeopleController {
    private PeopleService peopleService;
    private HomeService homeService;

    @GetMapping
    public List<PeopleEntity> getAll(){
        return peopleService.getAll();
    }
    @PostMapping("/create")
    public PeopleEntity create(PeopleEntity peopleEntity){
        return peopleService.create(peopleEntity);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        peopleService.delete(id);
    }
    @GetMapping("/add/{peopleId}/{homeId}")
    public String addHome(@PathVariable Long peopleId, @PathVariable Long homeId){
        return peopleService.addHome(peopleId, homeId);
    }
}
