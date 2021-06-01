package com.example.projet_jeeMS;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.example.projet_jeeMS.Repositories.PatientRepository;
import com.example.projet_jeeMS.entites.Patients;



@SpringBootApplication
public class ProjetJeeMsApplication  implements CommandLineRunner{
	@Autowired
	private PatientRepository patientRepository;
	public static void main(String[] args) {
		SpringApplication.run(ProjetJeeMsApplication.class, args); 
	}
	@Override
	public void run(String... args) throws Exception {
		
		/*
		 * patientRepository.save(new Patients(null, "elif", new Date(), 2300, false));
		 * patientRepository.save(new Patients(null, "umar", new Date(), 2350, false));
		 * patientRepository.save(new Patients(null, "ikram", new Date(), 2500, false));
		 * patientRepository.save(new Patients(null, "polat", new Date(), 2400, false));
		 * patientRepository.save(new Patients(null, "ozan", new Date(), 23060, true));
		 */
		 
		  System.out.println("**********************************");
			patientRepository.findAll().forEach(p -> {
				System.out.println(p.toString()); 
			});
			
	} 
	}


