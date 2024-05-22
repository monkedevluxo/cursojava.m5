package com.curso4.dinamicwallet.servicios;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.curso4.dinamicwallet.daos.CuentaDAO;
import com.curso4.dinamicwallet.modelo.Cuenta;

public class CuentaService {
	
	public boolean insertarCuenta(Cuenta cuenta) {	
		CuentaDAO cuentaDao = new CuentaDAO();
		//aca haces la logica antes de guardar...
		boolean insertoOk = cuentaDao.insertarCuenta(cuenta);
		return insertoOk;
	}
	
	public List<Cuenta> listarCuentas(){
		CuentaDAO cuentaDao = new CuentaDAO();
		List<Cuenta> cuentas = new ArrayList<>(); 
		cuentas = cuentaDao.listaCuentas();
		return cuentas;
	}
	
	public boolean actualizarCuenta(Cuenta cuenta) throws SQLException{
		//validaciones, flujos, llamadas a otros metodos.
		CuentaDAO cuentaDao = new CuentaDAO();
		boolean isUpdated = cuentaDao.actualizarCuenta(cuenta);
		return isUpdated;
	}
	
	public boolean eliminarCuenta(Cuenta cuenta) throws SQLException {
		CuentaDAO cuentaDao = new CuentaDAO();
		boolean isDeleted = cuentaDao.borrarCuenta(cuenta);
		return isDeleted;
	}
	
}
