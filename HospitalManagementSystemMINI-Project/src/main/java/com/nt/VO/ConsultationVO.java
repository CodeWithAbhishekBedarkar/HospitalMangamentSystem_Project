package com.nt.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class ConsultationVO {

	private Long patientId;
    private Long doctorId;
	
    private Long consultantId;
	@NonNull
	private String healthIssue;
	@NonNull
	private String doctorAdvice;
}
