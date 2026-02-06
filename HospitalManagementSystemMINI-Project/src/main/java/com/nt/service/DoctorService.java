package com.nt.service;

import java.util.List;

import com.nt.VO.DoctorVO;

public interface DoctorService {

	 DoctorVO createDoctor(DoctorVO vo);
	 DoctorVO updateDoctor(Long id, DoctorVO vo);          // Full Update
	 DoctorVO partialUpdateDoctor(Long id, DoctorVO vo);   // Partial Update
	 DoctorVO getDoctorById(Long id);
	 List<DoctorVO> getAllDoctors();
	 String deleteDoctorById(Long id);
	 String deleteAllDoctors();
}
