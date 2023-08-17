package com.example.swagger3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.swagger3.entity.SwaggerEntity;
import com.example.swagger3.service.SwaggerService;import io.swagger.models.Swagger;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("swag")
public class SwaggerController {
	
	@Autowired
	private SwaggerService swagService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<SwaggerEntity>> getAll(){
		return swagService.getAllData();
	}
	
	@PostMapping("/create")
	public ResponseEntity<SwaggerEntity> create(@RequestBody SwaggerEntity swagEntity){
		SwaggerEntity entity = swagService.post(swagEntity);
		return new ResponseEntity<>(entity, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<SwaggerEntity> update(@PathVariable Integer id, @RequestBody SwaggerEntity entity){
		SwaggerEntity swagEntity = swagService.put(id, entity);
		if(swagEntity != null) {
			return ResponseEntity.ok(swagEntity);
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}

}
