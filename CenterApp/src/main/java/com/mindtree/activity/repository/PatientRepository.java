package com.mindtree.activity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.activity.entity.Patient;


@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {
	

}
