package com.demo.cropdeal.cropitems.repository;

import org.bson.types.ObjectId;
import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.cropdeal.cropitems.model.Cropitem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CropitemRepository extends MongoRepository<Cropitem, ObjectId> {
	void deleteById(String id);

	Optional<Cropitem> findById(String id);
	@Query("{ 'id' : {'$in' : ?0 } }")
	Optional<List<Cropitem>> findAllById(List<String> id);
	
}
