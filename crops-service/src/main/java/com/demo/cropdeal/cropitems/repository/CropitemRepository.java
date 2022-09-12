package com.demo.cropdeal.cropitems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.cropdeal.cropitems.model.Cropitem;

public interface CropitemRepository extends JpaRepository<Cropitem, Long> {

}
