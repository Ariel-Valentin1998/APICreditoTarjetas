package com.ibm.academia.apirest.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ibm.academia.apirest.entities.Tarjeta;

@Repository
public interface TarjetaRepository extends CrudRepository<Tarjeta, Integer>{
	public Optional<Tarjeta> findById(Integer id);
	public Iterable<Tarjeta> findByNombreContainsIgnoreCase(String nombre);
	@Query(value="select * from tarjetas t "
			+ "inner join edad_salario_tarjeta esd on esd.tarjeta_id= t.id "
			+ "inner join salarios s on s.id= esd.salario_id "
			+ "inner join edades e on e.id = esd.edad_id "
			+ "inner join pasiones p on p.id = s.pasion_id "
			+ "where upper(p.nombre) like %:pasion% "
			+ "and range_contains_elem(e.edad, :edad) "
			+ "and range_contains_elem(s.salario, :sueldo)", nativeQuery = true)
	public Iterable<Tarjeta> traerNombreTarjeta(@Param("pasion")String pasion,@Param("edad")int edad,@Param("sueldo") int sueldo);
	
}


