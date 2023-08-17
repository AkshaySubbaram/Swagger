package com.example.swagger3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.swagger3.entity.SwaggerEntity;

@Repository
public interface SwaggerRepo extends JpaRepository<SwaggerEntity, Integer> {

}
