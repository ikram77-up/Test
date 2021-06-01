package com.example.projet_jeeMS.web;

import java.util.List;

import javax.transaction.Transactional;

//import org.sid.ProjetSpringMVC.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.projet_jeeMS.Repositories.PatientRepository;
import com.example.projet_jeeMS.entites.Patients;

import javaax.validation.Valid;

@Controller
public class PatientController {
	@Autowired
	// injection de dependence
	private PatientRepository patientRepository;

	@GetMapping(path = "/home")
	public String home() {
		return "home";
	}

	@GetMapping(path = "/patients")
	public String list(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "5") int size,
			@RequestParam(name = "keyword", defaultValue = "") String mc) {
		 //List<Patients>patients = patientRepository.findAll();

		Page<Patients> pagePatients = patientRepository.findByNomContains(mc,PageRequest.of(page, size));
		model.addAttribute("patients", pagePatients.getContent());
		model.addAttribute("page", new int[pagePatients.getTotalPages()]); 
		model.addAttribute("currentPage", page); 
		model.addAttribute("size", size);
		model.addAttribute("Keyword", mc);
		return "patients"; 
	}

	/*
	 * @GetMapping(path="/deletePatient1") public String delete(Long id,String
	 * keyword,int page,int size ) { patientRepository.deleteById(id); return
	 * "redirect:/patients?/page="+page+"&size="+size+"&keyword="+keyword;
	 */

	@GetMapping(path = "/deletePatient")
	public String delete(Long id, String keyword, int page, int size, Model model) {
		patientRepository.deleteById(id);
		return list(model, page, size, keyword);
	}

	@GetMapping(path = "/formPatient")
	public String formPatient(Model model) {
		model.addAttribute("patients", new Patients());
		return "formPatient"; 
	}

	@PostMapping(path = "/savePatient")
	public String savePatient( Model model ,@Valid Patients patient, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "formPatient";
		}
		patientRepository.save(patient);
		model.addAttribute("Patients", patient);
		return "confirmation";  
	}

	@GetMapping(path = "/editPatient")
	public String editPatient(Model model, Long id) {
		Patients patient = patientRepository.findById(id).get();
		model.addAttribute("mode", "edit");
		model.addAttribute("patients", patient);
		return "formPatient"; 
	}

	@GetMapping(path="/listPatients")
	@ResponseBody
	public List<Patients> list(){
		return patientRepository.findAll(); 
	}
	
	@GetMapping(path="/patients/{id}")
	@ResponseBody
	public Patients getOne(@PathVariable  Long id){
		return patientRepository.findById(id).get();
	}
}
