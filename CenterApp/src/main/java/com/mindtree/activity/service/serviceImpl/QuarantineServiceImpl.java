package com.mindtree.activity.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.mindtree.activity.entity.Patient;
import com.mindtree.activity.entity.QuarantineCenter;
import com.mindtree.activity.exception.ServiceException;
import com.mindtree.activity.repository.PatientRepository;
import com.mindtree.activity.repository.QuarantineCenterRepository;
import com.mindtree.activity.service.QuarantineService;

@Service
public class QuarantineServiceImpl implements QuarantineService {

	
	@Autowired
	PatientRepository repoP;
	
	@Autowired
	QuarantineCenterRepository repoQ;
	
	
	
	@Override
	public void save(QuarantineCenter newactivity) throws ServiceException {
		
		// TODO Auto-generated method stub
		if(repoQ.findByName(newactivity.getPlaceName())==null) {
			repoQ.save(newactivity);
		}
		else {
			throw new ServiceException("duplicate name present");
		}	
		
	}


	@Override
	public void save(Patient parti) {
		repoP.save(parti);
		// TODO Auto-generated method stub
		
	}


	@Override
	public QuarantineCenter display(String activity) {
	QuarantineCenter activities=new QuarantineCenter();
  	activities=repoQ.findByName(activity);
	   return activities;
		
	}


	@Override
	public List<Patient> displayParticipant() {
		// TODO Auto-generated method stub
		List<Patient> p=new ArrayList<>();
		List<String> p2=new ArrayList<>();
		p=repoP.findAll();
//p2=p.stream().map(n->n.getName()).collect(Collectors.toList());
		return p;
	}




	public List<QuarantineCenter> getAllQuarantineCenter() {
		// TODO Auto-generated method stub
		return repoQ.findAll();
	}


	@Override
	public void updateCenter(QuarantineCenter qc) {
		// TODO Auto-generated method stub
		QuarantineCenter qcenter = repoQ.findById(qc.getQuarantineID()).orElse(null);

		if (qcenter != null) {
			qcenter.setPlaceName(qc.getPlaceName());
			qcenter.setStrength(qc.getStrength());
			repoQ.save(qcenter);
		}
		
	}

	@Override
	public void deleteCenter(int id) {
		// TODO Auto-generated method stub
		System.out.println(id);
		repoQ.deleteById(id);	
		
	}


	public List<Patient> getAllPatient() {
		// TODO Auto-generated method stub
		return repoP.findAll();
	}


	public void updateCenter2(Patient pc) {
		// TODO Auto-generated method stub
		Patient p=repoP.findById(pc.getPatientId()).orElse(null);
		if(p!=null) {
	
			p.setPatientName(pc.getPatientName());
			p.setAge(pc.getAge());
			repoP.save(p);
		}
		
	}


	public QuarantineCenter display2(int id3) {
		QuarantineCenter activities=new QuarantineCenter();
		activities= repoQ.findById(id3).get();
		// TODO Auto-generated method stub
		return activities;
	}


	public void deletePatient(int pId) {
		repoP.deleteById(pId);
		// TODO Auto-generated method stub
		
	}


	

	public void updateCenterDetails(Patient c, int id) {
		// TODO Auto-generated method stub
		Patient pe=repoP.findById(id).get();
      //  pe.setPatientName(c.);		
	}



}
