package com.ibm.academia.apirest.services;

import java.util.Optional;
import com.ibm.academia.apirest.entities.Tarjeta;

public interface TarjetaDAO extends GenericoDAO<Tarjeta>{
	public Optional<Tarjeta> findById(Integer id);
	public Iterable<Tarjeta> findByNombreContainsIgnoreCase(String nombre);
	public Iterable<Tarjeta> traerNombreTarjeta(String pasion,int edad,int salario);

}
