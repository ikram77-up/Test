package com.example.projet_jeeMS.Repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projet_jeeMS.entites.Patients;



public interface PatientRepository extends JpaRepository<Patients, Long> {
	public Page<Patients> findByNomContains(String mc,Pageable  pageable);
	public List<Patients> findByMalade(boolean b);
	public List<Patients> findByNomContainsAndMalade(String name,boolean b);
	

}
