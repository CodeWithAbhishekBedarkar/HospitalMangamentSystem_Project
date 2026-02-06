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
public class DoctorVO {

	private Long doctorId;
	@NonNull
	private String doctorName;
	@NonNull
	private String specialization;
	@NonNull
	private String gender;
	@NonNull
	private String contactNumber;
	@NonNull
	private String role;
}
