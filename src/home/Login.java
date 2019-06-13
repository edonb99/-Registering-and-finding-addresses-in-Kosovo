package home;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

import database.DBConnection;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Login {
	private Stage primaryStage = new Stage();
	public static Scene login_scene;
	private TextField username_text = new TextField("");
	private PasswordField password_text = new PasswordField();
	private Scene scene2 = new Scene(new Label("Mirdita"));
	public boolean x = false;

	public void open() {
		GridPane top_left_pane = new GridPane();
		ImageView menu_image = new ImageView(
				new Image("file:///C:/Users/DataProgNet/eclipse-workspace/Address_Management_System/Images/menu.png"));

		menu_image.setFitHeight(24);
		menu_image.setFitWidth(24);
		MenuButton menu_button = new MenuButton();

		MenuItem item1 = I18N.getMenu("item1"); /* Home */
		ImageView home_image2 = new ImageView(new Image(
				"file:///C:/Users/DataProgNet/eclipse-workspace/Address_Management_System/Images/homecolorful.png"));
		home_image2.setFitHeight(24);
		home_image2.setFitWidth(24);
		item1.setGraphic(home_image2);
		item1.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));

		item1.setStyle(
				"-fx-text-fill:white; -fx-padding: 5 50 5 50;  -fx-border-color: transparent;-fx-background-color: turquoise;  -fx-text-fill: white;");
		item1.setOnAction(e -> {
			primaryStage.setScene(Home.home_scene);
			primaryStage.show();
		});

		MenuItem item3 = I18N.getMenu("item3"); /* Help */
		ImageView help_image2 = new ImageView(new Image(
				"file:///C:/Users/DataProgNet/eclipse-workspace/Address_Management_System/Images/infocolorful.png"));
		item3.setGraphic(help_image2);
		item3.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));
		item3.setStyle(
				"-fx-text-fill:white; -fx-padding: 5 50 5 50;  -fx-border-color: transparent;-fx-background-color: turquoise;  -fx-text-fill: white;");
		item3.setOnAction(e -> {
			new Help().open();
		});
		
		menu_button.setOnKeyPressed(e -> {
			if (e.isControlDown() && e.getCode() == KeyCode.H) {
				new Help().open();
			}
			else if (e.isControlDown() && e.getCode() == KeyCode.O) {
				primaryStage.setScene(Home.home_scene);
				primaryStage.show();
			}
		});

		menu_button.getItems().addAll(item1, item3);

		menu_button.setGraphic(menu_image);
		menu_button.setPadding(new Insets(-1, -1, -1, -1));
		menu_button.setStyle(
				"-fx-text-fill:white; -fx-mark-color: white;-fx-border-color: transparent; -fx-background-color: transparent;");

		top_left_pane.addRow(0, menu_button);
		top_left_pane.setStyle("-fx-background-color:#40E0D0");
		top_left_pane.setMaxHeight(10);

		StackPane top_middle_pane = new StackPane();
		Label login_label = I18N.getLabel("login_label");
		login_label.setStyle("-fx-text-fill: white");
		login_label.setFont(Font.font("Serif", FontWeight.BOLD, FontPosture.REGULAR, 20));
		top_middle_pane.setStyle("-fx-background-color:#40E0D0");
		top_middle_pane.setMinHeight(45);
		top_middle_pane.getChildren().add(login_label);

		StackPane center_left_pane = new StackPane();
		ImageView admin_image = new ImageView(new Image(
				"file:///C:/Users/DataProgNet/eclipse-workspace/Address_Management_System/Images/admin1.png"));
		center_left_pane.setMinWidth(350);
		center_left_pane.setStyle(
				"-fx-background-color:white;-fx-border-color:transparent turquoise transparent transparent;-fx-border-width:2;");
		center_left_pane.getChildren().add(admin_image);

		GridPane center_right_pane = new GridPane();
		center_right_pane.setStyle("-fx-background-color:white;");
		center_right_pane.setAlignment(Pos.CENTER);
		center_right_pane.setHgap(20);
		center_right_pane.setVgap(25);

		center_right_pane.setMinHeight(500);
		center_right_pane.setMinWidth(500);
		ImageView username_image = new ImageView(new Image(
				"file:///C:/Users/DataProgNet/eclipse-workspace/Address_Management_System/Images/usericon.png"));
		username_image.setFitHeight(24);
		username_image.setFitWidth(24);
		ImageView pass_image = new ImageView(
				"file:///C:/Users/DataProgNet/eclipse-workspace/Address_Management_System/Images/password.png");
		pass_image.setFitHeight(24);
		pass_image.setFitWidth(24);
		username_text.setText(I18N.getLabel("username_text").getText());

		username_text.setStyle(
				"-fx-border-color: transparent transparent turquoise transparent ; -fx-background-color:transparent;-fx-border-width: 2px ;-fx-text-fill: grey;");
		username_text.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
			if (isNowFocused) {
				username_text.setText("");
			} else {
				username_text.setText(username_text.getText());
			}
		});
		password_text.setStyle(
				"-fx-border-color: transparent transparent turquoise transparent ; -fx-background-color:transparent;-fx-border-width: 2px ;-fx-text-fill: gray;");
		password_text.setText("*******");
		password_text.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
			if (isNowFocused) {
				password_text.setText("");
			} else {
				password_text.setText(password_text.getText());
			}
		});

//		CheckBox remember_me = new CheckBox("Remember me");
//		remember_me.setStyle("-fx-text-fill: turquoise;-fx-font-size: 14;");

		Button user_login_button = I18N.getButton("user_login_button");
		user_login_button.setFont(Font.font("Serif", FontWeight.BOLD, FontPosture.REGULAR, 16));
		user_login_button
				.setStyle("-fx-text-fill:white; -fx-border-color: transparent; -fx-background-color: turquoise;");
		user_login_button.setPadding(new Insets(5, 15, 5, 15));
		user_login_button.setOnAction(e -> {
			loginUser();
		});
//		Hyperlink link = new Hyperlink();
//		link.setText("Forgot password?");
//		link.setStyle("-fx-text-fill: turquoise;-fx-font-size: 14;");

		center_right_pane.add(username_image, 0, 0);
		center_right_pane.add(username_text, 1, 0);
		center_right_pane.add(pass_image, 0, 1);
		center_right_pane.add(password_text, 1, 1);
//		center_right_pane.add(remember_me, 0, 3);
		center_right_pane.add(user_login_button, 1, 2);
//		center_right_pane.add(link, 2, 3);
		center_right_pane.setHalignment(user_login_button, HPos.CENTER);
		center_right_pane.setHalignment(username_image, HPos.RIGHT);
		center_right_pane.setHalignment(pass_image, HPos.RIGHT);
//		center_right_pane.setHalignment(remember_me, HPos.RIGHT);
//		center_right_pane.setHalignment(link, HPos.LEFT);

		HBox login_center_pane = new HBox();
		login_center_pane.getChildren().addAll(center_left_pane, center_right_pane);
		HBox language_pane = new HBox(5);
		ImageView uk_flag = new ImageView(new Image(
				"file:///C:/Users/DataProgNet/eclipse-workspace/Address_Management_System/Images/united-kingdom.png"));
		ImageView ks_flag = new ImageView(new Image(
				"file:///C:/Users/DataProgNet/eclipse-workspace/Address_Management_System/Images/kosovo.png"));
		uk_flag.setFitHeight(24);
		uk_flag.setFitWidth(24);
		ks_flag.setFitHeight(24);
		ks_flag.setFitWidth(24);

		Button english_button = new Button("English");
		english_button.setFont(Font.font("Serif", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 12));
		english_button
				.setStyle("-fx-text-fill:white; -fx-border-color: transparent; -fx-background-color: transparent;");
		english_button.setOnAction(e -> {
			I18N.setLocale(new Locale("en"));
		});

		Button albanian_button = new Button("Shqip");
		albanian_button.setFont(Font.font("Serif", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 12));
		albanian_button
				.setStyle("-fx-text-fill:white; -fx-border-color: transparent; -fx-background-color: transparent;");
		albanian_button.setOnAction(e -> {
			I18N.setLocale(new Locale("al"));
		});

		language_pane.setAlignment(Pos.BOTTOM_RIGHT);
		language_pane.setMaxHeight(20);
		language_pane.setMinWidth(400);
		language_pane.getChildren().addAll(uk_flag, english_button, ks_flag, albanian_button);
		language_pane.setStyle("-fx-background-color:#40E0D0");

		VBox login_pane = new VBox();
		login_pane.getChildren().addAll(top_left_pane, top_middle_pane, login_center_pane, language_pane);

		login_scene = new Scene(login_pane);
	}

	public void loginUser() {
		String query = "Select * from perdoruesit where Username = ? AND Password = ?";

		try {
			PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
			//
			preparedStatement.setString(1, username_text.getText());
			preparedStatement.setString(2, HASH.SHA1(password_text.getText()));

			ResultSet result = preparedStatement.executeQuery();

			if (result.next()) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Logged in");
				alert.setHeaderText(null);
				alert.setContentText("You are log in!");
				x = true;

				alert.showAndWait();

				new Modify().createStage();

			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("User not found");
				alert.setHeaderText(null);
				alert.setContentText("Username or password not found!");

				alert.showAndWait();

			}

		} catch (SQLException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Database problem!");
			alert.setHeaderText(null);
			alert.setContentText("Cannot connect to database!");

			alert.showAndWait();

			System.exit(1);
		}
	}
}
