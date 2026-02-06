package com.nt.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.VO.DoctorVO;
import com.nt.entity.DoctorEntity;
import com.nt.exception.ResourceNotFoundException;
import com.nt.repository.DoctorRepository;

@Service
public class DoctorServiceImple implements DoctorService {

	@Autowired
	private  DoctorRepository doctorRepo;

	//Register-Doctor
	@Override
	public DoctorVO createDoctor(DoctorVO vo) {
		System.out.println("DoctorServiceImple.createDoctor()");
		 DoctorEntity entity = new DoctorEntity();
	        BeanUtils.copyProperties(vo, entity);
	        DoctorEntity saved = doctorRepo.save(entity);
	        return mapToVO(saved);
	}

	//Full-updateDoctor
	@Override
	public DoctorVO updateDoctor(Long id, DoctorVO vo) {
		System.out.println("DoctorServiceImple.updateDoctor()");
		  DoctorEntity entity = doctorRepo.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with ID: " + id));

	        BeanUtils.copyProperties(vo, entity); // full replace
	        DoctorEntity updated = doctorRepo.save(entity);
	        return mapToVO(updated);
	}

	//PartialUpdate-Doctor
	@Override
	public DoctorVO partialUpdateDoctor(Long id, DoctorVO vo) {
		System.out.println("DoctorServiceImple.partialUpdateDoctor()");
		DoctorEntity entity = doctorRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with ID: " + id));

        if (vo.getDoctorName() != null)
            entity.setDoctorName(vo.getDoctorName());

        if (vo.getSpecialization() != null)
            entity.setSpecialization(vo.getSpecialization());

        if (vo.getRole() != null)
            entity.setRole(vo.getRole());

        DoctorEntity updated = doctorRepo.save(entity);
        return mapToVO(updated);
	}

	//getByID
	@Override
	public DoctorVO getDoctorById(Long id) {
		System.out.println("DoctorServiceImple.getDoctorById()");
		  DoctorEntity entity = doctorRepo.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with ID: " + id));
	        return mapToVO(entity);
	}

	//GetAll-Doctors
	@Override
	public List<DoctorVO> getAllDoctors() {
		System.out.println("DoctorServiceImple.getAllDoctors()");
		return doctorRepo.findAll()
                .stream()
                .map(this::mapToVO)
                .collect(Collectors.toList());
	}

	//DeleteDoctorById
	@Override
	public String deleteDoctorById(Long id) {
		System.out.println("DoctorServiceImple.deleteDoctorById()");
		  DoctorEntity entity = doctorRepo.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with ID: " + id));

	        doctorRepo.delete(entity);
	        return "Doctor deleted successfully with ID: " + id;
	}

	//DeleteAll-Doctors
	@Override
	public String deleteAllDoctors() {
		System.out.println("DoctorServiceImple.deleteAllDoctors()");
		 doctorRepo.deleteAll();
	        return "All doctors deleted successfully";
	}
	
	 private DoctorVO mapToVO(DoctorEntity entity) {
	        DoctorVO vo = new DoctorVO();
	        BeanUtils.copyProperties(entity, vo);
	        return vo;
	    }
}
