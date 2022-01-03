package com.ibm.academia.apirest.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.entities.Tarjeta;

@DataJpaTest
public class TarjetaRepositoryTest {
	@Autowired
	private TarjetaRepository tarjetaRepository;
	
	
	@Test
	@DisplayName("Test :1 buscar por nombre")
	void findByNombre(){
		
		tarjetaRepository.save(DatosDummy.tarjeta01());
		
		Iterable<Tarjeta> expected = tarjetaRepository.findByNombreContainsIgnoreCase(DatosDummy.tarjeta01().getNombre());
		String nombreTarjeta = "B+Smart";
		assertThat(expected.equals(nombreTarjeta) == true);
	}
	
	@Test
	@DisplayName("Test :2 buscar por id")
	void findById(){
		
		tarjetaRepository.save(DatosDummy.tarjeta01());
		
		Optional<Tarjeta> expected = tarjetaRepository.findById(1);
		if(!expected.isPresent());
		assertThat(expected.get().equals(expected) == true);
	}

}
