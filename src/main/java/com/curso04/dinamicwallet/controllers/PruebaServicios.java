package com.curso04.dinamicwallet.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.curso4.dinamicwallet.modelo.Cuenta;
import com.curso4.dinamicwallet.servicios.CuentaService;

public class PruebaServicios {

	static CuentaService cuentaService = new CuentaService();
	
	public static void main(String[] args) throws SQLException {
		//pruebo la creacion de una cuenta		
		crearCuenta();
		getCuentas(cuentaService);
		updateCuenta();
		deleteCuenta();
		
	}

	private static void crearCuenta() {
		System.out.println("================CREAR CUENTA================");
		Cuenta cuenta = new Cuenta(24,"test",20);
		boolean insercion = cuentaService.insertarCuenta(cuenta);
		System.out.println("creacion de cuenta OK");
		
	}

	private static void getCuentas(CuentaService cuentaService) {
		System.out.println("=========LISTA DE CUENTAS=========");
		
		List<Cuenta> listaCuentas = cuentaService.listarCuentas();
		for (Cuenta cuenta2 : listaCuentas) {
			System.out.println(cuenta2.toString());
		}
	}
	
	private static boolean updateCuenta() throws SQLException {
		System.out.println("=========UPDATE DE CUENTAS=========");
		Cuenta cuenta = new Cuenta(24,"test_modificado",2000);
		boolean isUpdated = cuentaService.actualizarCuenta(cuenta);
		return  isUpdated;
	}
	
	
	private static boolean deleteCuenta() throws SQLException {
		System.out.println("=========DELETE DE CUENTAS=========");
		Cuenta cuenta = new Cuenta(24,"test_modificado",2000);
		boolean isDeleted = cuentaService.eliminarCuenta(cuenta);
		return  isDeleted;
	}
	

}
