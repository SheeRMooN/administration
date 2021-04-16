package com.example.administration.controller;

import com.example.administration.entity.HomeEntity;
import com.example.administration.service.HomeService;
import com.example.administration.service.PeopleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/home")
public class HomeController {
    private HomeService homeService;
    private PeopleService peopleService;

    @GetMapping
    public List<HomeEntity> getAll(Long id){
        return homeService.getAll();
    }
    @PostMapping("/create")
    public HomeEntity create(@RequestBody HomeEntity homeEntity){
        return homeService.create(homeEntity);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        homeService.delete(id);
    }
    @GetMapping("/add/{homeId}/{peopleId}")
    public String addPeople(@PathVariable Long homeId, @PathVariable Long peopleId){
        return homeService.addPeople(homeId, peopleId);
    }
}
