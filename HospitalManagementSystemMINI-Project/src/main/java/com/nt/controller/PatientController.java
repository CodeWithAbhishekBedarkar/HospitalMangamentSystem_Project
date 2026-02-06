package com.nt.controller;

import java.util.List;
import java.util.Map;

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

import com.nt.VO.PatientVO;
import com.nt.service.PatientService;

@RestController
@RequestMapping("/patients-api")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	
	//RegisterPatient-api
	@PostMapping("/Register")
	public ResponseEntity<PatientVO> registerPatients(@RequestBody PatientVO VO){
		System.out.println("PatientController.registerPatients()");
		 PatientVO registerPatients = patientService.registerPatients(VO);
		 return new ResponseEntity<>(registerPatients,HttpStatus.CREATED);
	}
	
	 //FullUpdate
    @PutMapping("/updateAll/{id}")
    public ResponseEntity<PatientVO> update(
            @PathVariable Long id,
            @RequestBody PatientVO vo) {
        return ResponseEntity.ok(patientService.update(id, vo));
    }
	
	 //PartialUpdate
	@PatchMapping("/updatedById/{id}")
    public ResponseEntity<?> partialUpdate(@PathVariable Long id,
                                                   @RequestBody Map<String, Object> fields){
             System.out.println("PatientController.partialUpdate()");
             return ResponseEntity.ok(patientService.getById(id));
    }
	
	 //GetAll
    @GetMapping("/showAll")
    public ResponseEntity<List<PatientVO>> getAll() {
        return ResponseEntity.ok(patientService.getAll());
    }
    
    //GetById
    @GetMapping("/showById/{id}")
    public ResponseEntity<PatientVO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.getById(id));
    }
	
    //DeleteById
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        patientService.deleteById(id);
        return ResponseEntity.ok("Patient deleted successfully with ID : " + id);
    }
    
    
     //DeleteAll
    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAll() {
        patientService.deleteAll();
        return ResponseEntity.ok("All patients deleted successfully");
    }
}
