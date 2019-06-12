package home;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Help{
	private Stage primaryStage;
	public static Scene help_scene;
	public void open() {
		Stage primaryStage = new Stage();
		GridPane top_left_pane = new GridPane();
		ImageView menu_image = new ImageView(
				new Image("file:///C:/Users/DataProgNet/eclipse-workspace/Address_Management_System/Images/menu.png"));
		menu_image.setFitHeight(24);
		menu_image.setFitWidth(24);
MenuButton menu_button = new MenuButton();
        
		MenuItem item1 = new MenuItem("Home       ");
		ImageView home_image2 = new ImageView(
				new Image("file:///C:/Users/DataProgNet/eclipse-workspace/Address_Management_System/Images/homecolorful.png"));
		home_image2.setFitHeight(24);
		home_image2.setFitWidth(24);
		item1.setGraphic(home_image2);
		 item1.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));
		item1.setStyle(
				"-fx-text-fill:white; -fx-padding: 5 50 5 50;  -fx-border-color: transparent;-fx-background-color: turquoise;  -fx-text-fill: white;");
		
		
		MenuItem item3 = new MenuItem("Help         ");
		ImageView help_image2 = new ImageView(
				new Image("file:///C:/Users/DataProgNet/eclipse-workspace/Address_Management_System/Images/infocolorful.png"));		
		item3.setGraphic(help_image2);
		 item3.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));
		item3.setStyle(
				"-fx-text-fill:white;-fx-padding: 5 50 5 50;  -fx-border-color: transparent;-fx-background-color: turquoise;  -fx-text-fill: white;");
		menu_button.getItems().addAll(item1,item3);
		
		menu_button.setGraphic(menu_image);
		menu_button.setPadding(new Insets(-1, -1, -1, -1));
		menu_button.setStyle("-fx-text-fill:white; -fx-mark-color: white;-fx-border-color: transparent; -fx-background-color: transparent;");
		top_left_pane.addRow(0, menu_button);
		top_left_pane.setStyle("-fx-background-color:#40E0D0");
		top_left_pane.setMaxHeight(10);
		

		StackPane top_middle_pane = new StackPane();
		Label help_label = new Label("Help");
		help_label.setStyle("-fx-text-fill: white");
		help_label.setFont(Font.font("Serif", FontWeight.BOLD, FontPosture.REGULAR, 20));
		top_middle_pane.setStyle("-fx-background-color:#40E0D0");
		top_middle_pane.setMinHeight(45);
		top_middle_pane.setMinWidth(790);
		top_middle_pane.getChildren().add(help_label);

		HBox center_bottom_pane = new HBox(25);
		ImageView homeinfo_image = new ImageView(new Image(
				"file:///C:/Users/DataProgNet/eclipse-workspace/Address_Management_System/Images/homecolorful.png"));

		Button homeinfo_button = new Button();
		homeinfo_button.setGraphic(homeinfo_image);
		homeinfo_button.setPadding(new Insets(2.5, 2.5, 2.5, 2.5));
		homeinfo_button
				.setStyle("-fx-text-fill:white; -fx-border-color:#40E0D0;-fx-border-width:2.5; -fx-background-color: transparent;");
		
		
		ImageView modifyinfo_image = new ImageView(new Image(
				"file:///C:/Users/DataProgNet/eclipse-workspace/Address_Management_System/Images/edit.png"));

		Button modifyinfo_button = new Button();
		modifyinfo_button.setGraphic(modifyinfo_image);
		modifyinfo_button.setPadding(new Insets(2.5, 2.5, 2.5, 2.5));
		modifyinfo_button
				.setStyle("-fx-text-fill:white; -fx-border-color:#40E0D0;-fx-border-width:2.5; -fx-background-color: transparent;");
		
		ImageView logininfo_image = new ImageView(new Image(
				"file:///C:/Users/DataProgNet/eclipse-workspace/Address_Management_System/Images/usericon.png"));

		Button logininfo_button = new Button();
		logininfo_button.setGraphic(logininfo_image);
		logininfo_button.setPadding(new Insets(2.5, 2.5, 2.5, 2.5));
		logininfo_button
				.setStyle("-fx-text-fill:white; -fx-border-color:#40E0D0;-fx-border-width:2.5; -fx-background-color: transparent;");
		center_bottom_pane.setAlignment(Pos.CENTER);
		center_bottom_pane.getChildren().addAll(homeinfo_button,modifyinfo_button,logininfo_button);
		center_bottom_pane.setMinHeight(449);
		center_bottom_pane.setMinWidth(856);
		StackPane center_top_pane = new StackPane();
		Label help_text = new Label("You can ask for help about :");
		help_text.setPadding(new Insets(8,8,8,8));
		help_text.setFont(Font.font("Serif", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 18));
		help_text.setStyle("-fx-text-fill:white; -fx-background-color:#40E0D0;");
		center_top_pane.setPadding(new Insets(15,0,0,0));
		
		
	
		center_top_pane.getChildren().add(help_text);
		
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
		Button albanian_button = new Button("Shqip");
		albanian_button.setFont(Font.font("Serif", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 12));
		albanian_button
				.setStyle("-fx-text-fill:white; -fx-border-color: transparent; -fx-background-color: transparent;");
		language_pane.setAlignment(Pos.BOTTOM_RIGHT);
		language_pane.setMaxHeight(20);
		language_pane.setMinWidth(600);
		language_pane.getChildren().addAll(uk_flag,english_button,ks_flag,albanian_button);
		language_pane.setStyle("-fx-background-color:#40E0D0");
		
		VBox help_pane = new VBox();
		help_pane.getChildren().addAll(top_left_pane,top_middle_pane,center_top_pane,center_bottom_pane,language_pane);
		

		 help_scene = new Scene(help_pane);
		 primaryStage.setScene(help_scene);
		 primaryStage.show();
	}


}