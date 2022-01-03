package com.ibm.academia.apirest.datos;

import com.ibm.academia.apirest.entities.Pasion;
import com.ibm.academia.apirest.entities.Tarjeta;

public class DatosDummy {

	
	public static Tarjeta tarjeta01()
	{
		return new Tarjeta(null, "B+Smart");
	}
	public static Tarjeta tarjeta02()
	{
		return new Tarjeta(null, "Afinity Card");
	}
	public static Pasion pasion01()
	{
		return new Pasion(null, "Shoping");
	}
	public static Pasion pasion02()
	{
		return new Pasion(null, "Travels");
	}
	
	/*public static SalarioTarjetaEdades salarioTarjetaEdades01() {
		return new SalarioTarjetaEdades(DatosDummy.salario01(), DatosDummy.tarjeta01(),DatosDummy.edad01());
	}
	public static SalarioTarjetaEdades salarioTarjetaEdades02() {
		return new SalarioTarjetaEdades(DatosDummy.salario01(), DatosDummy.tarjeta02(),DatosDummy.edad01());
	}*/
	/*public static SalarioTarjetaEdades salarioTarjetaEdades01() {
		return new SalarioTarjetaEdades(SalarioTarjetaEdadesId.builder().id(SalarioTarjetaEdadesId.builder().salarioId(1).tarjetaId(1).edadId(1)), null, null, null)
	}*/
	/*public static SalarioTarjetaEdades salarioTarjetaEdades01() {
		return new SalarioTarjetaEdades(SalarioTarjetaEdadesId.builder()..edadId(1), SalarioTarjetaEdadesId.builder().tarjetaId(1),SalarioTarjetaEdadesId.builder().edadId(1));
	}*/
}
