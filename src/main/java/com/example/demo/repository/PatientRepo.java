package com.example.demo.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient , Long>
{
	Optional<Patient> findByUnameAndPass(String u,String p);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update Patient set bdname = :docname , dno = :mob ,demail = :em where id =:did" )
	void update(@Param("docname")String docname,@Param( "mob")String mbo,@Param("em") String email,@Param("did")long did);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update Patient set date=:d where id=:id")
	void dateUpdate(@Param("d")String date,@Param("id")long id);
	
}
