package com.ibm.academia.apirest.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ibm.academia.apirest.entities.Pasion;
import com.ibm.academia.apirest.repositories.PasionRepository;

@Service
public class PasionDAOImpl extends GenericoDAOImpl<Pasion, PasionRepository> implements PasionDAO
{

	public PasionDAOImpl(PasionRepository repository) {
		super(repository);
		
	}

	@Override
	public Optional<Pasion> findById(Integer id) {
		
		return repository.findById(id);
	}

	@Override
	public Optional<Pasion> findByNombreContainsIgnoreCase(String nombre) {
		
		return repository.findByNombreContainsIgnoreCase(nombre);
	}

}
