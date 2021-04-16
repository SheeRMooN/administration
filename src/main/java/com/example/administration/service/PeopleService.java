package com.example.administration.service;

import com.example.administration.entity.HomeEntity;
import com.example.administration.entity.PeopleEntity;
import com.example.administration.repository.HomeRepo;
import com.example.administration.repository.PeopleRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PeopleService {
    private PeopleRepo peopleRepo;
    private HomeRepo homeRepo;

    public List<PeopleEntity> getAll(){
        return peopleRepo.findAllBy();
    }
    public PeopleEntity create(PeopleEntity peopleEntity){
        return peopleRepo.save(peopleEntity);
    }
    public void delete(Long id){
        peopleRepo.deleteById(id);
    }
    //===========================================================
    public String addHome(Long peopleId, Long homeId){
        PeopleEntity peopleEntity = peopleRepo.findById(peopleId).get();
        HomeEntity homeEntity = homeRepo.findById(homeId).get();
        peopleEntity.addHome(homeEntity);
        peopleRepo.save(peopleEntity);
        return "home :"+homeEntity.getId() + ", people :" +peopleEntity.getId();
    }
}
