package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.entity.DoctorEntity;


@Repository
public interface DoctorEntityRepo extends JpaRepository<DoctorEntity, Long> 
{
	Optional<DoctorEntity> findByDocid(String d);
	
	@Transactional
	Optional<DoctorEntity> deleteByDocid(String id);
	
	List<DoctorEntity> findByDept(String dept);
	
	
}