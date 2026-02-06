package com.nt.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.VO.ConsultationVO;
import com.nt.entity.ConsultantAdviceEntity;
import com.nt.entity.DoctorEntity;
import com.nt.entity.PatientsEntity;
import com.nt.exception.ResourceNotFoundException;
import com.nt.repository.ConsultantRepository;
import com.nt.repository.DoctorRepository;
import com.nt.repository.PatientRepository;

@Service
public class ConsultationServiceImpl implements ConsultationService {

	@Autowired
	 private ConsultantRepository consultationRepo;
	
	@Autowired
	private PatientRepository patientRepo;
	
	@Autowired
	private DoctorRepository doctorRepo;

	// ---------------- CREATE ----------------
	@Override
	public ConsultationVO createConsultation(ConsultationVO vo) {
		System.out.println("ConsultationServiceImpl.createConsultation()");
		 

	        PatientsEntity patient = patientRepo.findById(vo.getPatientId())
	                .orElseThrow(() -> new ResourceNotFoundException(
	                        "Patient not found with ID: " + vo.getPatientId()));

	        DoctorEntity doctor = doctorRepo.findById(vo.getDoctorId())
	                .orElseThrow(() -> new ResourceNotFoundException(
	                        "Doctor not found with ID: " + vo.getDoctorId()));

	        ConsultantAdviceEntity entity = new ConsultantAdviceEntity();
	        entity.setPatientEntity(patient);
	        entity.setDoctorEntity(doctor);
	        entity.setHealthIssue(vo.getHealthIssue());
	        entity.setDoctorAdvice(vo.getDoctorAdvice());

	        ConsultantAdviceEntity saved = consultationRepo.save(entity);
	        return mapToVO(saved);
	}

	@Override
	public ConsultationVO updateConsultation(Long id, ConsultationVO vo) {
		System.out.println("ConsultationServiceImpl.updateConsultation()");
		ConsultantAdviceEntity entity = consultationRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Consultation not found with ID: " + id));

        PatientsEntity patient = patientRepo.findById(vo.getPatientId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Patient not found with ID: " + vo.getPatientId()));

        DoctorEntity doctor = doctorRepo.findById(vo.getDoctorId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Doctor not found with ID: " + vo.getDoctorId()));

        entity.setPatientEntity(patient);;
        entity.setDoctorEntity(doctor);
        entity.setHealthIssue(vo.getHealthIssue());;
        entity.setDoctorAdvice(vo.getDoctorAdvice());

        return mapToVO(consultationRepo.save(entity));
	}

	@Override
	public ConsultationVO partialUpdateConsultation(Long id, Map<String, Object> fields) {
	System.out.println("ConsultationServiceImpl.partialUpdateConsultation()");
	ConsultantAdviceEntity entity = consultationRepo.findById(id)
             .orElseThrow(() -> new ResourceNotFoundException(
                     "Consultation not found with ID: " + id));

     if (fields.containsKey("problem")) {
    	 entity.setHealthIssue(fields.get("problem").toString());
     }

     if (fields.containsKey("advice")) {
    	 entity.setDoctorAdvice(fields.get("advice").toString());
     }

     if (fields.containsKey("patientId")) {
         Long patientId = Long.valueOf(fields.get("patientId").toString());
         PatientsEntity patient = patientRepo.findById(patientId)
                 .orElseThrow(() -> new ResourceNotFoundException(
                         "Patient not found with ID: " + patientId));
         entity.setPatientEntity(patient);
     }

     if (fields.containsKey("doctorId")) {
         Long doctorId = Long.valueOf(fields.get("doctorId").toString());
         DoctorEntity doctor = doctorRepo.findById(doctorId)
                 .orElseThrow(() -> new ResourceNotFoundException(
                         "Doctor not found with ID: " + doctorId));
         entity.setDoctorEntity(doctor);
     }

     return mapToVO(consultationRepo.save(entity));
	}

	@Override
	public ConsultationVO getConsultationById(Long id) {
		System.out.println("ConsultationServiceImpl.getConsultationById()");
		ConsultantAdviceEntity entity = consultationRepo.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException(
	                        "Consultation not found with ID: " + id));
	        return mapToVO(entity);
	}

	@Override
	public List<ConsultationVO> getAllConsultations() {
		System.out.println("ConsultationServiceImpl.getAllConsultations()");
		 return consultationRepo.findAll()
	                .stream()
	                .map(this::mapToVO)
	                .collect(Collectors.toList());
	}

	@Override
	public void deleteConsultationById(Long id) {
		System.out.println("ConsultationServiceImpl.deleteConsultationById()");
		ConsultantAdviceEntity entity = consultationRepo.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException(
	                        "Consultation not found with ID: " + id));
	        consultationRepo.delete(entity);
		
	}

	@Override
	public void deleteAllConsultations() {
		System.out.println("ConsultationServiceImpl.deleteAllConsultations()");
		 consultationRepo.deleteAll();
		
	}
	
	  // ---------------- ENTITY → VO ----------------
    private ConsultationVO mapToVO(ConsultantAdviceEntity entity) {
        ConsultationVO vo = new ConsultationVO();
        
        vo.setConsultantId(entity.getConsultantId());
        vo.setPatientId(entity.getPatientEntity().getPatientId());
        vo.setDoctorId(entity.getDoctorEntity().getDoctorId());
        vo.setHealthIssue(entity.getHealthIssue());
        vo.setDoctorAdvice(entity.getDoctorAdvice());
        return vo;
    }
	
	
}
