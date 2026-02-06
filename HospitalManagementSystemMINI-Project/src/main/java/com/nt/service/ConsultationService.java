package com.nt.service;

import java.util.List;
import java.util.Map;

import com.nt.VO.ConsultationVO;

public interface ConsultationService {

	 ConsultationVO createConsultation(ConsultationVO vo);
	 ConsultationVO updateConsultation(Long id, ConsultationVO vo);   // Full update
	 ConsultationVO partialUpdateConsultation(Long id, Map<String, Object> fields);
	 ConsultationVO getConsultationById(Long id);
	 List<ConsultationVO> getAllConsultations();
	 void deleteConsultationById(Long id);
	 void deleteAllConsultations();
}
