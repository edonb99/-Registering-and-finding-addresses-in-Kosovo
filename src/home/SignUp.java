package home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class SignUp extends Application {
	private Stage primaryStage;
	private Scene scene;
	private TextField Emri;
	private TextField Mbiemri;
	private TextField Username;
	private PasswordField  Password;
	private Label resultLabel;
//	private TextField Password;
	private TextField Email;
	

	private Connection dbConnection;

	@Override
	public void start(Stage primaryStage) {
		setConnection();
		FlowPane pane = new FlowPane();
		Emri = new TextField("Email");
		Mbiemri = new TextField();
		Username = new TextField("Username");
		Password = new PasswordField();
		Email = new TextField("Email");
		resultLabel = new Label();
		Button submit = new Button("Submit");
		submit.setOnAction((e) -> {
			insert();
		});
		pane.getChildren().addAll(Emri, Mbiemri, Username, Password, Email, submit,resultLabel);
		scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public void setConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			dbConnection = DriverManager.getConnection("jdbc:mysql://localhost/knk?useSSL=false", "root", "1234");

		} catch (Exception ex) {
			ex.printStackTrace();

		}
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	private void insert() {
		try {
			String query = "INSERT INTO perdoruesit(Emri,Mbiemri,Username,Password,Email) VALUES(?,?,?,?,?)";
			PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.setString(1, Emri.getText());
			preparedStatement.setString(2, Mbiemri.getText());
			preparedStatement.setString(3, Username.getText());
			//preparedStatement.setString(4, Password.getText());
			preparedStatement.setString(4, HASH.SHA1(Password.getText()));
			preparedStatement.setString(5, Email.getText());
			if (preparedStatement.executeUpdate() > 0) {
				resultLabel.setText("Admin added");
			} else {
				resultLabel.setText("Admin not added!");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();

		}
	}

}
