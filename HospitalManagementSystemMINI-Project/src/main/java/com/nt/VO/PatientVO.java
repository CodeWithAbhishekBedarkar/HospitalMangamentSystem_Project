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
public class PatientVO {

	private Long patientId;
	@NonNull
	private String patientName;
	private int  patientAge;
	@NonNull
	private String disease;
	@NonNull
	private String contact;
	@NonNull
	private String gender;
}
