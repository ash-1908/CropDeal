package com.demo.cropdeal.cropitems.repository;

import org.bson.types.ObjectId;
import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.cropdeal.cropitems.model.Cropitem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CropitemRepository extends MongoRepository<Cropitem, ObjectId> {

}
