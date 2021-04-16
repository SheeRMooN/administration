package com.example.administration.repository;

import com.example.administration.entity.PeopleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PeopleRepo extends JpaRepository<PeopleEntity, Long> {
    public List<PeopleEntity> findAllBy();
    public Optional<PeopleEntity> findById(Long id);
}
