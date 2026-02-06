package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.ConsultantAdviceEntity;

public interface ConsultantRepository extends JpaRepository<ConsultantAdviceEntity, Long> {

}
