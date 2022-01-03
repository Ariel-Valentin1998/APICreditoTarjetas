package com.ibm.academia.apirest.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.academia.apirest.entities.Pasion;
import com.ibm.academia.apirest.entities.Tarjeta;
import com.ibm.academia.apirest.exceptions.NotFoundException;
import com.ibm.academia.apirest.repositories.TarjetaRepository;
@Service
public class TarjetaDAOImpl extends GenericoDAOImpl<Tarjeta, TarjetaRepository>implements TarjetaDAO{

	public TarjetaDAOImpl(TarjetaRepository repository) {
		super(repository);
	}

	@Override
	public Optional<Tarjeta> findById(Integer id) {
		
		return repository.findById(id);
	}

	@Autowired
	private PasionDAO pasionDAO;
	@Override
	@Transactional(readOnly = true)
	public Iterable<Tarjeta> traerNombreTarjeta(String pasion, int edad, int salario) {
		Optional<Pasion> oPasion = pasionDAO.findByNombreContainsIgnoreCase(pasion);
		if (!oPasion.isPresent())
			throw new NotFoundException(String.format("Por el momento no contamos con esa Pasión", oPasion));
			if(edad <0 || salario <0)
				throw new NotFoundException(String.format("No se permiten numeros negativos", edad));
			if(edad <18)
				throw new NotFoundException(String.format("Para solicitar una tarjeta de credito debes de ser mayor de edad", edad));
			if(edad >75)
				throw new NotFoundException(String.format("La edad introducida no debe de ser mayor a 75 años", edad));
			if(salario <7000)
			    throw new NotFoundException(String.format("Lo sentimos el salario debe de ser mayor de $7000 ", salario));
			if(salario >100000)
			    throw new NotFoundException(String.format("Lo sentimos el salario debe de ser manor de $100000 ", salario));
		return repository.traerNombreTarjeta(pasion, edad, salario);
	}

	@Override
	public Iterable<Tarjeta> findByNombreContainsIgnoreCase(String nombre) {
		return repository.findByNombreContainsIgnoreCase(nombre);
	}

}
