package com.krakedev.copa.utils;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.krakedev.copa.excepciones.KrakedevExceptions;

public class ConexionBDD {
	public static Connection obtenerConexion() throws KrakedevExceptions {

		Context ctx = null;
		DataSource ds = null;
		Connection con = null;

		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/ConexionPG");
			con = ds.getConnection();
		} catch (Exception e) {
			// TODO: handle exception
			throw new KrakedevExceptions("Error al conectar a la base de datos");
		}
		return con;
	}
}
