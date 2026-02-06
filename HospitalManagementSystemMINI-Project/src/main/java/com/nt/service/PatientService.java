package com.nt.service;

import java.util.List;
import java.util.Map;

import com.nt.VO.PatientVO;

public interface PatientService {

	public PatientVO registerPatients(PatientVO VO);
	PatientVO update(Long id, PatientVO vo);
	PatientVO partialUpdate(Long id, Map<String,Object> fields);
	PatientVO getById(Long id);
	List<PatientVO> getAll();
	void deleteById(Long id);
	void deleteAll();
}
