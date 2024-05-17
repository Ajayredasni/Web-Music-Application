package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entitiy.PlayListEntitiyCustomer;
public interface PlayListCustomerRepository extends JpaRepository<PlayListEntitiyCustomer, Integer> {

}
