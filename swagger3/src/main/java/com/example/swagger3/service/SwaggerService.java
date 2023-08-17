package com.example.swagger3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.swagger3.entity.SwaggerEntity;
import com.example.swagger3.repository.SwaggerRepo;

@Service
public class SwaggerService {

	@Autowired
	private SwaggerRepo swagRepo;

	public ResponseEntity<List<SwaggerEntity>> getAllData() {
		List<SwaggerEntity> swagEntity = swagRepo.findAll();
		return ResponseEntity.ok(swagEntity);
	}

	public SwaggerEntity post(SwaggerEntity swagEntity) {
		return swagRepo.save(swagEntity);
	}

	public SwaggerEntity put(Integer id, SwaggerEntity entity) {
		Optional<SwaggerEntity> swag = swagRepo.findById(id);
		if (swag.isPresent()) {
			SwaggerEntity update = swag.get();
			update.setId(id);
			update.setAddress(entity.getAddress());
			update.setFirstName(entity.getFirstName());
			update.setLastName(entity.getLastName());
			update.setPhone(entity.getPhone());
			return swagRepo.save(update);
		} else {
			return null;
		}
	}

}
