package com.curso4.dinamicwallet.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.curso4.dinamicwallet.conexionbd.MysqlConexion;
import com.curso4.dinamicwallet.modelo.Cuenta;


public class CuentaDAO {
	
	private Connection connection;
	
	public CuentaDAO() {
		try {
			//connection = MysqlConexion.getInstancia().getConnection();
			MysqlConexion mysqlConexion = MysqlConexion.getInstancia();
			connection = mysqlConexion.getConnection();
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public boolean insertarCuenta(Cuenta cuenta){
		String sentencia_sql = "INSERT INTO cuenta (numeroCuenta, titular, saldo) VALUE (?,?,?)";
		try(PreparedStatement statement = connection.prepareStatement(sentencia_sql)){
				statement.setInt(1, cuenta.getNumeroCuenta());
				statement.setString(2,cuenta.getTitular());
				statement.setDouble(3, cuenta.getSaldo());
				int filasInsertadas =  statement.executeUpdate();
				return filasInsertadas > 0;
			}catch(SQLException ex) {
				ex.printStackTrace();
				return false;
			}
	}
	
	// implementar un 'read', o sea un Select
	public List<Cuenta> listaCuentas()
	{
		List<Cuenta> cuentas = new ArrayList<>();
		String sentencia_sql = "select * from cuenta";
		try(PreparedStatement statement = connection.prepareStatement(sentencia_sql)){			
				
			ResultSet rs =  statement.executeQuery();
			 while (rs.next()) {
	                int numeroCuenta = rs.getInt("numeroCuenta");
	                String nombre = rs.getString("titular");
	                double saldo = rs.getDouble("saldo");
	                Cuenta cuenta = new Cuenta(numeroCuenta, nombre, saldo);
	                cuentas.add(cuenta);
	            }
				return cuentas;
			}catch(SQLException ex) {
				ex.printStackTrace();
				return cuentas;
			}
	}
	
	//
	public  List<Cuenta>  mostarCuenta(Cuenta cuenta) {	
		   List<Cuenta>  cuentas = new ArrayList<>();
			String sql = "SELECT * FROM Cuenta WHERE numeroCuenta = ? AND titular = ? AND saldo = ?";
			try(PreparedStatement statement = connection.prepareStatement(sql) ){
				statement.setInt(1, cuenta.getNumeroCuenta());
				statement.setString(2, cuenta.getTitular());
				statement.setDouble(3, cuenta.getSaldo());
				try(ResultSet result = statement.executeQuery()){
					while (result.next()) {
		                int numeroCuenta = result.getInt("numeroCuenta");
		                String nombre = result.getString("titular");
		                double saldo = result.getDouble("saldo");
		                Cuenta cuentadb = new Cuenta(numeroCuenta, nombre, saldo);
		                cuentas.add(cuentadb);
		            }
					
				}	
			}catch(SQLException ex){
				ex.printStackTrace();
			}
			return cuentas;
	}
	
	//update
	public boolean actualizarCuenta(Cuenta cuenta) throws SQLException {
		boolean actualizo = false;
		String sql = "UPDATE cuenta SET titular = ?, saldo = ? where numeroCuenta = ?";
		try(PreparedStatement statement = connection.prepareStatement(sql) ){
			statement.setString(1, cuenta.getTitular());
			statement.setDouble(2, cuenta.getSaldo());
			statement.setInt(3, cuenta.getNumeroCuenta());
			
			int filasModificadas =  statement.executeUpdate();
			if(filasModificadas > 0){
				actualizo = true;
			}
		}
		return actualizo;
	}
	
	public boolean borrarCuenta(Cuenta cuenta) throws SQLException{
		boolean isDelete = false;
		String sql = "DELETE FROM cuenta WHERE numeroCuenta= ?";
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setInt(1, cuenta.getNumeroCuenta());
			
			int filasDelete = statement.executeUpdate();
			
			if(filasDelete > 0) {
				isDelete = true;
			}
		}
		return isDelete;	
	}
	
	
	
	
	
	
	
	
}
