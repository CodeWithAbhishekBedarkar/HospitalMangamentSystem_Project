package com.nt.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import com.nt.VO.PatientVO;
import com.nt.entity.PatientsEntity;
import com.nt.exception.ResourceNotFoundException;
import com.nt.repository.PatientRepository;

@Service
public class PatientServiceImple implements PatientService {

	@Autowired
	private PatientRepository patientRepo;

	
	private PatientVO toVO(PatientsEntity e) {
		
		PatientVO vo=new PatientVO();
		BeanUtils.copyProperties(e, vo);
		return vo;
	}
	
	private PatientsEntity toEntity(PatientVO vo){
		PatientsEntity e = new PatientsEntity();
		BeanUtils.copyProperties(vo, e);
		e.setRole("PATIENT");
		return e;
	 }

	//Register Patient
	@Override
	public PatientVO registerPatients(PatientVO VO) {
		System.out.println("PatientServiceImple.registerPatients()");
		return toVO(patientRepo.save(toEntity(VO)));
	}

	@Override
	public PatientVO update(Long id, PatientVO vo) {
		System.out.println("PatientServiceImple.update()");
		PatientsEntity e = toEntity(vo);
		e.setPatientId(id);
		return toVO(patientRepo.save(e));
	}

	@Override
	public PatientVO partialUpdate(Long id, Map<String, Object> fields) {
		System.out.println("PatientServiceImpl.partialUpdate()");

		PatientsEntity entity = patientRepo.findById(id)
		        .orElseThrow(() -> new ResourceNotFoundException("Patient Not Found"));

		fields.forEach((key, value) -> {

		    
		    Field field = ReflectionUtils.findField(PatientsEntity.class, key);

		    if (field != null) {
		        field.setAccessible(true);
		        ReflectionUtils.setField(field, entity, value);
		    }
		});
	    return toVO(patientRepo.save(entity));
	}

	@Override
	public PatientVO getById(Long id) {
		System.out.println("PatientServiceImple.getById()");
		
		return toVO(patientRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Patient Not Found")));
	}

	@Override
	public List<PatientVO> getAll() {
		System.out.println("PatientServiceImple.getAll()");
		return patientRepo.findAll().stream().map(this::toVO).toList();
	}

	@Override
	public void deleteById(Long id) {
		System.out.println("PatientServiceImple.deleteById()");
		patientRepo.deleteById(id);
		
	}

	@Override
	public void deleteAll() {
	System.out.println("PatientServiceImple.deleteAll()");
	    patientRepo.deleteAll();
	}
	
	
}
