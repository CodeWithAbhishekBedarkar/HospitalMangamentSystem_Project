package com.nt.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name="HMS_Consultanat")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class ConsultantAdviceEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long consultantId;
	
	@ManyToOne
	private PatientsEntity patientEntity;
	
	@ManyToOne
	private DoctorEntity doctorEntity;
	
	@Column(length = 75)
	@NonNull
	private String healthIssue;
	
	@Column(length = 75)
	@NonNull
	private String doctorAdvice;
	
}
