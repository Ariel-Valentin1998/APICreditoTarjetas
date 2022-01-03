package com.ibm.academia.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.academia.apirest.entities.Tarjeta;
import com.ibm.academia.apirest.services.TarjetaDAOImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/tarjetas")
@Api(value = "Metodos relacionados con Tarjetas de credito", tags  = "Acciones de Tarjetas de Credito")
public class TarjetaController {
	@Autowired
	private TarjetaDAOImpl tarjetaDaoImpl;
	
	/**
	* Endpoint para el listado de las tarjetas recomendadas para el usuario deacuerdo a su perfil
	* @return Retorna una lista de tarjetas
	* @author AVDJV 25/12/2021
	*/
	@ApiOperation(value = "Buscar Tarjetas de credito relacionadas a las caracteristicas del cliente")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Ejecutado satisfactoriamente")
	})
	
	@GetMapping("/credito")
	
	public Iterable<Tarjeta> buscarTarjeta(@RequestParam String pasion, @RequestParam int edad, @RequestParam int salario){
	  
	  Iterable<Tarjeta> tarjetas = tarjetaDaoImpl.traerNombreTarjeta(pasion.toUpperCase(), edad , salario);
	  
	  return tarjetas;
	 }
	
}
