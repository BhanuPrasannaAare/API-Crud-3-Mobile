package com.example.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.crud.entity.Mobile;
import com.example.crud.service.MobileService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/mobile")
public class MobileController {
	@Autowired
	private MobileService studentService;

	// http://localhost:8082/api/mobile
	@PostMapping()
	public ResponseEntity<Mobile> saveEmployee(@RequestBody Mobile student) {
		return new ResponseEntity<Mobile>(studentService.saveMobile(student), HttpStatus.CREATED);
	}

	// http://localhost:8082/api/mobile
	@GetMapping
	public List<Mobile> getAllEmployees() {
		return studentService.getAllMobiles();
	}

	// http://localhost:8082/api/mobile/1
	@GetMapping("{id}") 
	public ResponseEntity<Mobile> getEmployeeById(@PathVariable("id") long id) {
		return new ResponseEntity<Mobile>(studentService.getMobileById(id), HttpStatus.OK);
	}

	// http://localhost:8082/api/mobile/1
	@PutMapping("{id}") 
	public ResponseEntity<Mobile> updateEmployee(@PathVariable("id") long id, @RequestBody Mobile student) {
		return new ResponseEntity<Mobile>(studentService.updateMobile(student, id), HttpStatus.OK);
	}

	// http://localhost:8082/api/mobile/1
	@DeleteMapping("{id}") 
	public ResponseEntity<String> deleteStudent(@PathVariable("id") long id) {
		studentService.deleteMobile(id);
		return new ResponseEntity<String>("sucessfully deleted", HttpStatus.OK);
	}
}
