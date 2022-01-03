package com.ibm.academia.apirest.entities;



import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "edades")
public class Edad implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "edad", columnDefinition = "int4range")
	private String edad;
	
	@OneToMany(mappedBy = "edad")
	@JsonIgnore
	private List<SalarioTarjetaEdades> salarioTarjetaEdades;
	
	private static final long serialVersionUID = 8532250238687680134L;
}
