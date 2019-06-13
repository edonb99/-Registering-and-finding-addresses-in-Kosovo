package home;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DBConnection;

public class Adresat {

	private int idRruget;
	private String Fshati;
	private String EmriRruges;
	private String KodiRruges;
	private String komuna;
	private String LlojiRruges;// alt shift s
//alt shift a -> 

	public Adresat(int idRruget, String komuna, String Fshati, String EmriRruges, String KodiRruges,
			String LlojiRruges) {
		this.idRruget = idRruget;
		this.Fshati = Fshati;
		this.EmriRruges = EmriRruges;
		this.KodiRruges = KodiRruges;
		this.komuna = komuna;
		this.LlojiRruges = LlojiRruges;
	}

	public int getIdRruget() {
		return idRruget;
	}

	public void setIdRruget(int idRruget) {
		this.idRruget = idRruget;
	}

	public String getFshati() {
		return Fshati;
	}

	public void Fshati(String Fshati) {
		this.Fshati = Fshati;
	}

	public String getEmriRruges() {
		return EmriRruges;
	}

	public void setEmriRruges(String EmriRruges) {
		this.EmriRruges = EmriRruges;
	}

	public String getKodiRruges() {
		return KodiRruges;
	}

	public void setKodiRruges(String KodiRruges) {
		this.KodiRruges = KodiRruges;
	}

	public String getKomuna() {
		return komuna;
	}

	public void setKomuna(String komuna) {
		this.komuna = komuna;
	}

	public String getLlojiRruges() {
		return LlojiRruges;
	}

	public void setLlojiRruges(String LlojiRruges) {
		this.LlojiRruges = LlojiRruges;
	}

	public static boolean addRruget(String komuna, String Fshati, String EmriRruges, int KodiRruges,
			String LlojiRruges) {
		String query = "INSERT INTO rruget(komuna, Fshati, EmriRruges, KodiRruges,  LlojiRruges) VALUES(?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = (PreparedStatement) DBConnection.getConnection()
					.prepareStatement(query);

			preparedStatement.setString(1, komuna);
			preparedStatement.setString(2, Fshati);
			preparedStatement.setString(3, EmriRruges);
			preparedStatement.setInt(4, KodiRruges);
			preparedStatement.setString(5, LlojiRruges);

			return (preparedStatement.executeUpdate() > 0);
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static boolean deleteAdresat(int idRruget) {
		String query = "Delete from rruget WHERE idRruget=? ";

		try {
			PreparedStatement preparedStatement = (PreparedStatement) DBConnection.getConnection()
					.prepareStatement(query);

			preparedStatement.setInt(1, idRruget);

			return (preparedStatement.executeUpdate() > 0);
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static boolean updateAdresat(int idRruget, String komuna, String Fshati, String EmriRruges,
			String KodiRruges, String LlojiRruges) {
		String query = "UPDATE rruget SET  komuna=?, Fshati=?, EmriRruges=?, KodiRruges=?, LlojiRruges=? WHERE idRruget=? ";

		try {
			PreparedStatement preparedStatement = (PreparedStatement) DBConnection.getConnection()
					.prepareStatement(query);

			preparedStatement.setString(1, komuna);
			preparedStatement.setString(2, Fshati);
			preparedStatement.setString(3, EmriRruges);
			preparedStatement.setString(4, KodiRruges);
			preparedStatement.setString(5, LlojiRruges);
			preparedStatement.setInt(6, idRruget);

			return (preparedStatement.executeUpdate() > 0);
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static List<Adresat> getRruget() {
		List<Adresat> adresatList = new ArrayList();

		String query = "Select * from rruget";

		try {
			PreparedStatement preparedStatement = (PreparedStatement) DBConnection.getConnection()
					.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Adresat adresat = new Adresat(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
				adresatList.add(adresat);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return adresatList;
	}
}
