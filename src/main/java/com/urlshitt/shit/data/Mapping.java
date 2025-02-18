package com.urlshitt.shit.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.urlshitt.shit.models.URlMapping;

public interface Mapping extends JpaRepository<URlMapping, String>{
  
}
