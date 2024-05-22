package com.curso04.dinamicwallet.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso4.dinamicwallet.modelo.Cuenta;
import com.curso4.dinamicwallet.servicios.CuentaService;

/**
 * Servlet implementation class CuentaServlet
 */
@WebServlet("/cuenta")
public class CuentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static CuentaService cuentaService = new CuentaService();
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperar los datos del formulario
		int numeroCuenta = Integer.parseInt(request.getParameter("numeroCuenta"));
		String titular = request.getParameter("titular");
		double saldo = Double.parseDouble(request.getParameter("saldo"));
		Cuenta cuenta = new Cuenta(numeroCuenta,titular,saldo);
		
		boolean insercion = cuentaService.insertarCuenta(cuenta);
		
		if(insercion) {
			response.sendRedirect("mostrarCuentas.jsp");
		}else {
			response.sendRedirect("error.jsp");
		}
		
	}

}
