package com.demo.cropdeal.cropitems.repository;

import org.bson.types.ObjectId;
import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.cropdeal.cropitems.model.Cropitem;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CropitemRepository extends MongoRepository<Cropitem, ObjectId> {
	List<Cropitem> findByIdIn(List<ObjectId> idList);
}
