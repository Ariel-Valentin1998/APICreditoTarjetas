package com.ibm.academia.apirest.entities;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "salarios")
public class Salario implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "salario", columnDefinition = "int4range")
	private String salario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pasion_id")
	private Pasion pasion;
	
	
	
	@OneToMany(mappedBy = "salario", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<SalarioTarjetaEdades> salarioTarjetaEdades;
	
	
	
	private static final long serialVersionUID = 6383791319174361179L;
	

}
