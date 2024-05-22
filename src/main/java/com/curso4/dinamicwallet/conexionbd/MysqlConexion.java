package com.curso4.dinamicwallet.conexionbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.curso04.dinamicwallet.constantes.Constants;


public class MysqlConexion {
	
	private static MysqlConexion instancia;
	private Connection connection;
	
	private MysqlConexion() throws SQLException {
		try {
			Class.forName(Constants.DRIVER_MYSQL);
			connection = DriverManager.getConnection(Constants.URL, Constants.USUARIO, Constants.PASSWORD);
		}catch(ClassNotFoundException ex){
			throw new SQLException(ex);
		}
	}
	
	/*
	 * Crear un método de creación estático que actúe como constructor. 
	 * Tras bambalinas, este método invoca al constructor privado para crear un objeto 
	 * y lo guarda en un campo estático.
	 * */
	public static MysqlConexion getInstancia() throws SQLException {
		if(instancia == null) {
			instancia = new MysqlConexion();
		}
		return instancia;
	}
	
	public Connection getConnection() {
		return connection;
	}
	
}
