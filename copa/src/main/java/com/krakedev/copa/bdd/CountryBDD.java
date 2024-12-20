package com.krakedev.copa.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.krakedev.copa.entidades.Country;
import com.krakedev.copa.excepciones.KrakedevExceptions;
import com.krakedev.copa.utils.ConexionBDD;

public class CountryBDD {

	public void registraEquipo(Country country) throws KrakedevExceptions {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement(
					"insert into country (country_name, country_code, country_iso3) values" + "(?, ?, ?)");

			ps.setString(1, country.getCountryName());
			ps.setInt(2, country.getCountryCode());
			ps.setString(3, country.getCountryIso3());

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new KrakedevExceptions("Error al registrar el equipo");
		} catch (KrakedevExceptions e) {
			throw e;
		} finally {

			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();

			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
				throw new KrakedevExceptions("Error al cerra la conexión");
			}
		}

	}
}
