package com.anubhavtrainings.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anubhavtrainings.entities.Address;

public interface IAddressPersistence extends JpaRepository<Address,Long> {
  
}
