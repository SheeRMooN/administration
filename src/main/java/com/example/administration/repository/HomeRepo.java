package com.example.administration.repository;

import com.example.administration.entity.HomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HomeRepo extends JpaRepository<HomeEntity, Long> {
    public Optional<HomeEntity> findById(Long id);
    public List<HomeEntity> findAllBy();
}
