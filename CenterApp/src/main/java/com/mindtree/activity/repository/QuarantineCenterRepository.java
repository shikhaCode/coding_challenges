package com.mindtree.activity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.activity.entity.QuarantineCenter;


@Repository
public interface QuarantineCenterRepository  extends JpaRepository<QuarantineCenter,Integer> {

	
	@Query("select c.placeName from QuarantineCenter c where c.placeName=?1")
	QuarantineCenter findByName(String activity);

}
