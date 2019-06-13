package home;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DBConnection;

public class Addresses {

	private int idAdresa;
	private int idKomuna;
	private int idRajoni;
	private String Lagjja;
	private int idRruges;
	private int idObjektit; // alt shift s
	private double Latitude;
	private double Longitude; // alt shift a ->

	public Addresses(int idAdresa, int idKomuna, int idRajoni, String Lagjja, int idRruges, int idObjektit,
			double Latitude, double Longitude) {
		this.idAdresa = idAdresa;
		this.Lagjja = Lagjja;
		this.idRajoni = idRajoni;
		this.idKomuna = idKomuna;
		this.idRruges = idRruges;
		this.idObjektit = idObjektit;
		this.Latitude = Latitude;
		this.Longitude = Longitude;
	}

	public int getIdAdresa() {
		return idAdresa;
	}

	public void setIdAdresa(int idAdresa) {
		this.idAdresa = idAdresa;
	}

	public String getLagjja() {
		return Lagjja;
	}

	public void setLagjja(String Lagjja) {
		this.Lagjja = Lagjja;
	}

	public int getIdRajoni() {
		return idRajoni;
	}

	public void setIdRajoni(int idRajoni) {
		this.idRajoni = idRajoni;
	}

	public int getIdKomuna() {
		return idKomuna;
	}

	public void setIdKomuna(int idKomuna) {
		this.idKomuna = idKomuna;
	}

	public int getIdRruges() {
		return idRruges;
	}

	public void setIdRruges(int idRruges) {
		this.idRruges = idRruges;
	}

	public int getIdObjektit() {
		return idObjektit;
	}

	public void setIdObjektit(int idObjektit) {
		this.idObjektit = idObjektit;
	}

	public double getLatitude() {
		return Latitude;
	}

	public void setLatitude(double Latitude) {
		this.Latitude = Latitude;
	}

	public double getLongitude() {
		return Longitude;
	}

	public void setLongitude(double Longitude) {
		this.Longitude = Longitude;
	}

	public static boolean addAddresses(int idKomuna, int idRajoni, String Lagjja, int idRruges, int idObjektit,
			double Latitude, double Longitude) {
		String query = "INSERT INTO adresat(idKomuna, idRajoni, Lagjja,  idRruges, idObjektit, Latitude, Longitude) VALUES(?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = (PreparedStatement) DBConnection.getConnection()
					.prepareStatement(query);

			preparedStatement.setInt(1, idKomuna);
			preparedStatement.setInt(2, idRajoni);
			preparedStatement.setString(3, Lagjja);
			preparedStatement.setInt(4, idRruges);
			preparedStatement.setInt(5, idObjektit);
			preparedStatement.setDouble(6, Latitude);
			preparedStatement.setDouble(7, Longitude);

			return (preparedStatement.executeUpdate() > 0);
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static boolean deleteAddresses(int idAdresa) {
		String query = "Delete from adresat WHERE idAdresa=? ";

		try {
			PreparedStatement preparedStatement = (PreparedStatement) DBConnection.getConnection()
					.prepareStatement(query);

			preparedStatement.setInt(1, idAdresa);

			return (preparedStatement.executeUpdate() > 0);
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static boolean updateAddresses(int idAdresa, int idKomuna, int idRajoni, String Lagjja, int idRruges,
			int idObjektit, double Latitude, double Longitude) {
		String query = "UPDATE adresat SET idKomuna=?,  idRajoni=?, Lagjja=?, idRruges=?, idObjektit=?, Latitude=?, Longitude=? WHERE idAdresa=? ";

		try {
			PreparedStatement preparedStatement = (PreparedStatement) DBConnection.getConnection()
					.prepareStatement(query);

			preparedStatement.setInt(1, idKomuna);
			preparedStatement.setInt(2, idRajoni);
			preparedStatement.setString(3, Lagjja);
			preparedStatement.setInt(4, idRruges);
			preparedStatement.setInt(5, idObjektit);
			preparedStatement.setDouble(6, Latitude);
			preparedStatement.setDouble(7, Longitude);
			preparedStatement.setInt(8, idAdresa);

			return (preparedStatement.executeUpdate() > 0);
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static List<Addresses> getAddresses() {
		List<Addresses> AddressesList = new ArrayList();

		String query = "Select * from adresat";

		try {
			PreparedStatement preparedStatement = (PreparedStatement) DBConnection.getConnection()
					.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Addresses Addresses = new Addresses(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3),
						resultSet.getString(4), resultSet.getInt(5), resultSet.getInt(6), resultSet.getDouble(7),
						resultSet.getDouble(8));
				AddressesList.add(Addresses);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return AddressesList;
	}
}
