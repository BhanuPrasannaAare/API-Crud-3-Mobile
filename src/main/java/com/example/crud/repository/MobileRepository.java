package com.example.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.entity.Mobile;

public interface MobileRepository extends JpaRepository<Mobile, Long> {

}
