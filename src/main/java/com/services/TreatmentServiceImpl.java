package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.dao.TreatmentDao;
import com.entities.Treatment;

@Service
@Primary
public class TreatmentServiceImpl implements TreatmentService {

	
	@Autowired
	private TreatmentDao treatmentDao;
	
	public void setTreatmentDao(TreatmentDao treatmentDao) {
		this.treatmentDao= treatmentDao;
	}

	public void add(Treatment t) {
		// TODO Auto-generated method stub
		treatmentDao.add(t);
		
	}

	public List<Treatment> get_pat_treatment(int pid) {
		// TODO Auto-generated method stub
		return treatmentDao.get_pat_treatment(pid);
	}

	public Treatment get(int id) {
		// TODO Auto-generated method stub
		return treatmentDao.get(id);
	}

	public Treatment latest(int pid) {
		// TODO Auto-generated method stub
		List<Treatment> treatment= get_pat_treatment(pid);
		if(treatment.size()==0) {
			return null;
		}
		Treatment t= treatment.get(treatment.size()-1);
		return t;
	}
}
