package com.example.projet_jeeMS.entites;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
 * utulisations de spring jpa
 * @author PC
 *
 */
@Entity
@Table(name="Patients")
@Data   @NoArgsConstructor @ToString @AllArgsConstructor
public class Patients  {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "Nom",length = 25)
	@NotNull
	
	private String nom;
	@DateTimeFormat(pattern= "yyyy--MM-DD")
	private Date datednaissance;
	@NotNull
	private int score;
	private boolean malade;


}
