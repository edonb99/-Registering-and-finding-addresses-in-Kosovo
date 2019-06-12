package home;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import database.DBConnection;

import com.mysql.jdbc.PreparedStatement;

public class Objektet {

	private int idObjekti;
	private String LlojiObjektit;
	private int NumriKateve;
	private int NumriHyrjes;

	public Objektet(int idObjekti, String LlojiObjektit, int NumriKateve, int NumriHyrjes) {
		this.idObjekti = idObjekti;
		this.LlojiObjektit = LlojiObjektit;
		this.NumriKateve = NumriKateve;
		this.NumriHyrjes = NumriHyrjes;
	}

	public int getIdObjekti() {
		return idObjekti;
	}

	public void setIdObjekti(int idObjekti) {
		this.idObjekti = idObjekti;
	}

	public String getLlojiObjektit() {
		return LlojiObjektit;
	}

	public void LlojiObjektit(String LlojiObjektit) {
		this.LlojiObjektit = LlojiObjektit;
	}

	public int getNumriKateve() {
		return NumriKateve;
	}

	public void setNumriKateve(int NumriKateve) {
		this.NumriKateve = NumriKateve;
	}

	public int getNumriHyrjes() {
		return NumriHyrjes;
	}

	public void setNumriHyrjes(int NumriHyrjes) {
		this.NumriHyrjes = NumriHyrjes;
	}

	public static boolean addObjektet(String LlojiObjektit, int NumriKateve, int NumriHyrjes) {
		String query = "INSERT INTO objektet(LlojiObjektit, NumriKateve, NumriHyrjes) VALUES(?,?,?)";
		try {
			PreparedStatement preparedStatement = (PreparedStatement) DBConnection.getConnection()
					.prepareStatement(query);

			preparedStatement.setString(1, LlojiObjektit);
			preparedStatement.setInt(2, NumriKateve);
			preparedStatement.setInt(3, NumriHyrjes);

			return (preparedStatement.executeUpdate() > 0);
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static boolean deleteObjektet(int idObjekti) {
		String query = "Delete from Objektet WHERE idObjekti=?";

		try {
			PreparedStatement preparedStatement = (PreparedStatement) DBConnection.getConnection()
					.prepareStatement(query);

			preparedStatement.setInt(1, idObjekti);

			return (preparedStatement.executeUpdate() > 0);
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static boolean updateObjektet(int idObjekti, String LlojiObjektit, int NumriKateve, int NumriHyrjes) {
		String query = "UPDATE Objektet SET LlojiObjektit=?, NumriKateve=?, NumriHyrjes=? WHERE idObjekti=? ";

		try {
			PreparedStatement preparedStatement = (PreparedStatement) DBConnection.getConnection()
					.prepareStatement(query);

			preparedStatement.setString(1, LlojiObjektit);
			preparedStatement.setInt(2, NumriKateve);
			preparedStatement.setInt(3, NumriHyrjes);
			preparedStatement.setInt(4, idObjekti);

			return (preparedStatement.executeUpdate() > 0);
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static List<Objektet> getObjektet() {
		List<Objektet> ObjektetList = new ArrayList();

		String query = "Select * from objektet";

		try {
			PreparedStatement preparedStatement = (PreparedStatement) DBConnection.getConnection()
					.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Objektet Objektet = new Objektet(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3),
						resultSet.getInt(4));
				ObjektetList.add(Objektet);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return ObjektetList;
	}
}
