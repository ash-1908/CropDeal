package com.demo.cropdeal.cropitems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.demo.cropdeal.cropitems.repository.CropitemRepository;

@DataJpaTest
public class cropItemTest {

	@Autowired 
	private CropitemRepository repo;
	
	
}
