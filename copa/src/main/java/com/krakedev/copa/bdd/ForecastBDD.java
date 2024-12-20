package com.krakedev.copa.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.krakedev.copa.entidades.Country;
import com.krakedev.copa.entidades.FootballMatch;
import com.krakedev.copa.entidades.Forecast;
import com.krakedev.copa.entidades.User;
import com.krakedev.copa.excepciones.KrakedevExceptions;
import com.krakedev.copa.utils.ConexionBDD;

public class ForecastBDD {

	public void registraPronostico(Forecast pronostico) throws KrakedevExceptions {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement(
					"insert into forecast (user_id, match_id, country_code_t1, score_t1, country_code_t2, score_t2) values "
							+ "(?, ?, ?, ?, ?, ?);");

			ps.setInt(1, pronostico.getUser().getUserId());
			ps.setInt(2, pronostico.getMatch().getMatchId());
			ps.setInt(3, pronostico.getTeam1().getCountryCode());
			ps.setInt(4, pronostico.getScoreT1());
			ps.setInt(5, pronostico.getTeam2().getCountryCode());
			ps.setInt(6, pronostico.getScoreT2());

			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new KrakedevExceptions("Error al registrar el pronóstico");
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

	public ArrayList<Forecast> pronosticoUsuario(String cedula) throws KrakedevExceptions {

		ArrayList<Forecast> pronosticos = new ArrayList<Forecast>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Forecast pronostico = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("SELECT " + " u.cedula, u.user_name, u.user_last_name, "
					+ "c1.country_name AS team1, f.score_t1, c2.country_name AS team2, f.score_t2, fm.match_date "
					+ "FROM forecast f " + "JOIN users u ON f.user_id = u.user_id "
					+ "JOIN country c1 ON f.country_code_t1 = c1.country_code "
					+ "JOIN country c2 ON f.country_code_t2 = c2.country_code "
					+ "JOIN football_match fm ON f.match_id = fm.match_id " + "WHERE u.cedula = ?;");

			ps.setString(1, cedula);
			rs = ps.executeQuery();

			while (rs.next()) {
				String ced = rs.getString("cedula");
				String nombre = rs.getString("user_name");
				String apellido = rs.getString("user_last_name");
				String equipo1 = rs.getString("team1");
				int golest1 = rs.getInt("score_t1");
				String equipo2 = rs.getString("team2");
				int golest2 = rs.getInt("score_t2");
				Timestamp timestamp = rs.getTimestamp("match_date");
				long milis = timestamp.getTime();
				String fechaFormateada = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(milis));
				User user = new User(ced, nombre, apellido);
				Country team1 = new Country(equipo1);
				Country team2 = new Country(equipo2);
				FootballMatch match = new FootballMatch(team1, team2, fechaFormateada);
				pronostico = new Forecast(user, match, team1, golest1, team2, golest2);
				pronosticos.add(pronostico);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new KrakedevExceptions("Erro al buscar el prónostico del usuario " + cedula);
		} catch (KrakedevExceptions e) {
			throw e;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO: handle exception
				throw new KrakedevExceptions("Error al cerra la conexíon " + e.getMessage());
			}
		}

		return pronosticos;
	}

}
