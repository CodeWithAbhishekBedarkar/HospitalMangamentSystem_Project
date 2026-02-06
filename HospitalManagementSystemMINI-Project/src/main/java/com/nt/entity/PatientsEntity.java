//Patients.java
package com.nt.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name="HMS_Patients")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class PatientsEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long patientId;

	@Column(length=50)
	@NonNull
	private String patientName;
	
	private int  patientAge;
	
	@Column(length = 60)
	@NonNull
	private String disease;
	
	@Column(length = 11)
	@NonNull
	private String contact;
	
	@Column(length = 6)
	@NonNull
	private String gender;
	
	@Column(length = 11)
	@NonNull
	private String role; 
}
