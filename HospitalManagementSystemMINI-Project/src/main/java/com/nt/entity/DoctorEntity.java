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
@Table(name="HMS_Doctor")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class DoctorEntity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long doctorId;
	
	@Column(length = 55)
	@NonNull
	private String doctorName;
	
	@Column(length = 75)
	@NonNull
	private String specialization;
	
	@Column(length = 7)
	@NonNull
	private String gender;
	
	@Column(length = 11)
	@NonNull
	private String contactNumber;
	
	@Column(length = 11)
	@NonNull
	private String role;
}
