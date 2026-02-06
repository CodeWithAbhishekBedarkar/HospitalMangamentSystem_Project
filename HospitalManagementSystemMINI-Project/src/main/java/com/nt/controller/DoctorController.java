package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.VO.DoctorVO;
import com.nt.service.DoctorService;

@RestController
@RequestMapping("/doctor-api")
public class DoctorController  {

	@Autowired
	private DoctorService dService;
	
	//Register
    @PostMapping("/Register")
    public ResponseEntity<DoctorVO> createDoctor(@RequestBody DoctorVO vo) {
    	System.out.println("DoctorController.createDoctor()");
        DoctorVO saved = dService.createDoctor(vo);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
    
      //FULL UPDATE
    @PutMapping("/updateAll/{id}")
    public ResponseEntity<DoctorVO> updateDoctor(
            @PathVariable Long id,
            @RequestBody DoctorVO vo) {
    	System.out.println("DoctorController.updateDoctor()");
        return ResponseEntity.ok(dService.updateDoctor(id, vo));
    }
    
    
    //PARTIAL UPDATE
    @PatchMapping("/updatedById/{id}")
    public ResponseEntity<DoctorVO> partialUpdateDoctor(
            @PathVariable Long id,
            @RequestBody DoctorVO vo) {
    	System.out.println("DoctorController.partialUpdateDoctor()");
        return ResponseEntity.ok(dService.partialUpdateDoctor(id, vo));
    }
    
    //GET BY ID 
    @GetMapping("/showById/{id}")
    public ResponseEntity<DoctorVO> getDoctorById(@PathVariable Long id) {
    	System.out.println("DoctorController.getDoctorById()");
        return ResponseEntity.ok(dService.getDoctorById(id));
    }
    
    //GET All
    @GetMapping("/showAll")
    public ResponseEntity<List<DoctorVO>> getAllDoctors() {
    	System.out.println("DoctorController.getAllDoctors()");
        return ResponseEntity.ok(dService.getAllDoctors());
    }
    
     //DELETEBYID
    @DeleteMapping("/DeleteById/{id}")
    public ResponseEntity<String> deleteDoctorById(@PathVariable Long id) {
    	System.out.println("DoctorController.deleteDoctorById()");
        return ResponseEntity.ok(dService.deleteDoctorById(id));
    }
    
    //DELETE ALL
    @DeleteMapping("/DeleteAll")
    public ResponseEntity<String> deleteAllDoctors() {
    	System.out.println("DoctorController.deleteAllDoctors()");
        return ResponseEntity.ok(dService.deleteAllDoctors());
    }
}
