package com.demo.cropdeal.cropitems.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.cropdeal.cropitems.exception.ResourceNotFoundException;
import com.demo.cropdeal.cropitems.model.Cropitem;
import com.demo.cropdeal.cropitems.repository.CropitemRepository;
import com.demo.cropdeal.cropitems.service.CropitemService;
import com.demo.cropdeal.cropitems.service.EmailSenderService;


@Service
public class CropitemServiceImpl implements CropitemService {

	private CropitemRepository cropitemRepository;
	
	@Autowired
	EmailSenderService emailsenderService;

	public CropitemServiceImpl(CropitemRepository cropitemRepository) {
		super();
		this.cropitemRepository = cropitemRepository;
	}

	@Override
	public Cropitem savecropItem(Cropitem cropitem) {
		 emailsenderService.sendSimpleEmail("divyathorat2255@gmail.com",cropitem.getName() +"     "+cropitem.getType()+"     "+cropitem.getQnt()+"     "+cropitem.getPrice(),"This is the new crop added in the list please check......");
		 return cropitemRepository.save(cropitem);
	}

	@Override
	public List<Cropitem> getAllcropItems() {
		return cropitemRepository.findAll();
	}

	@Override
	public Cropitem getcropItemById(String id) {
	/*	Optional<cropItem> cropitem=cropitemRepository.findById(cropid);
		
		if(cropitem.isPresent()) {
			return cropitem.get();
		}else {
			throw new ResourceNotFoundException("cropItem","cropId",cropid);
		}*/
		
		return cropitemRepository.findById(id).orElseThrow(() -> 
		                      new ResourceNotFoundException("cropItem","cropId",id));
	}

	@Override
	public Cropitem updatecropItem(Cropitem cropitem, String id) {
		// we need to check whether cropitem with given id is exist in DB or not
		Cropitem existingcropItem=cropitemRepository.findById(id).orElseThrow(
				() ->new ResourceNotFoundException("cropItem","cropId",id));
		
		existingcropItem.setName(cropitem.getName());
		existingcropItem.setType(cropitem.getType());
		existingcropItem.setQnt(cropitem.getQnt());
		existingcropItem.setPrice(cropitem.getPrice());
		
		cropitemRepository.save(existingcropItem);
		return existingcropItem;
	}

	@Override
	public void deletecropItem(String id) {
		// check whether a cropitem exist in a DB or not
		cropitemRepository.findById(id).orElseThrow(()->
		        new ResourceNotFoundException("cropItem","cropId",id));
		cropitemRepository.deleteById(id);
		
	}

    /*    public User getCropByFarmerId(String Id,User user){
		
		List<String> list=cropitemRepository.getById(cropId).getUserId();
		String url="http://localhost:8082/user/get-user/{userId}";
		System.out.println(user);
		User users=restTemplate.postForObject(url,user,User.class);
		if(users!=null) {
			list.add(users.getId());
			System.out.println("user id is "+users.getId());
			System.out.println("crop is : "+users);
			User user=userRepository.getById(Id);
			user.setCropIds(list);
			user=userRepository.save(crop); 
			System.out.println(crop);
			return users;
			
		}
		else
			return new Cropitem();
	}
	
//	CropItem [id=null, name=tomato, type=veg, qnt=25Kg, price=40]
//	crop id is 6325b244008022651a7786ec
//	crop is : CropItem [id=6325b244008022651a7786ec, name=tomato, type=veg, qnt=25Kg, price=40]
//	User [id=6324e2a86879610ec04cdc37, fullName=798ghjgjj, roles=FARMER, userName=xyz123, password=rsb006, phoneNumber=900090, email=hjj, active=null, bank=Bank [accountNo=22222654321, accountHolderName=ggggggg, bankName=Bank of Maharashtra, bankBranch=Jalochi, bankIFSC=BOMH26155799], address=Address [Id=6324e2a86879610ec04cdc36, houseNo=2, streetName=ABCxyz street, localityName=abc colony, pincode=413110, city=Baramati, state=Maharashtra, country=India], cropIds=[6325b244008022651a7786ec]]
//
//	
	
	public List<String> getUserCropIdList(String userId){
		User user=userRepository.getById(userId);
		if(user.getCropIds()!=null) {
			return user.getCropIds();
		}
		else 
			return new ArrayList<>();
	}
	*/
	@Override
	public List<Cropitem> findByIdInList(List<String> idList) {
		// exception
		if(idList == null || idList.size() == 0) return null;
		
		// working
		Optional<List<Cropitem>> cropList = cropitemRepository.findAllById(idList);
		
		// exception
		if(cropList.isEmpty()) return null;
		
		return cropList.get();
	}
	
}
