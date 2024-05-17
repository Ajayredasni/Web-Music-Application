package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.example.demo.entitiy.PlayListEntity;

public interface PlayListRepositories extends JpaRepository<PlayListEntity, Integer>{

}
