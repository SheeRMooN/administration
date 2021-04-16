package com.example.administration.service;

import com.example.administration.entity.HomeEntity;
import com.example.administration.entity.PeopleEntity;
import com.example.administration.repository.HomeRepo;
import com.example.administration.repository.PeopleRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HomeService {
    private HomeRepo homeRepo;
    private PeopleRepo peopleRepo;

    public Optional<HomeEntity> getById(Long id){
        return homeRepo.findById(id);
    }
    public HomeEntity create(HomeEntity homeEntity){
        return homeRepo.save(homeEntity);
    }
    public void delete(Long id){
        homeRepo.deleteById(id);
    }
    public List<HomeEntity> getAll(){
        return homeRepo.findAllBy();
    }

    //=====================================================================
    public String addPeople(Long homeId, Long peopleId){
        HomeEntity homeEntity = homeRepo.findById(homeId).get();
        PeopleEntity peopleEntity = peopleRepo.findById(peopleId).get();
        peopleEntity.addHome(homeEntity);
        peopleRepo.save(peopleEntity);
        return "home :"+homeEntity.getId() + ", people :" +peopleEntity.getId();
    }
}
