package projekti;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.VLineTo;
import javafx.stage.Stage;

public class Login extends Application {

	public void start(Stage primaryStage) {

		BorderPane border = new BorderPane();

		//
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(15, 12, 15, 12));
		hbox.setSpacing(10);
		hbox.setStyle("-fx-background-color: #336699;");

		Button button1 = new Button("English");
		button1.setPrefSize(100, 20);

		Button button2 = new Button("Shqip");
		button2.setPrefSize(100, 20);
		hbox.getChildren().addAll(button1, button2);
		hbox.setAlignment(Pos.BOTTOM_RIGHT);

		//

		//
		GridPane gpane = new GridPane();
		gpane.setAlignment(Pos.CENTER);
		gpane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		gpane.setHgap(5.5);
		gpane.setVgap(15);

//        Pane iPane = new Pane();
//        Image image2 = new Image("http://www.visitfranklinsouthamptonva.com/media/95251/testing.jpg");
//		iPane.getChildren().add(new ImageView(image2));
		// gpane.add(iPane, 0, 0);

		gpane.add(new Label("USERNAME"), 0, 0);
		gpane.add(new TextField(), 0, 1);
		gpane.add(new Label("PASSWORD"), 0, 2);
		gpane.add(new TextField(), 0, 3);

		HBox hb = new HBox();
		hb.getChildren().addAll(new CheckBox(), new Label("Remember me"));

//		gpane.add(new CheckBox(),0,4);
//		gpane.add(new Label("Remember me"),0,4);

		gpane.add(hb, 0, 4);
		Button btn1 = new Button("LOGIN");
		gpane.add(btn1, 0, 5);
		GridPane.setHalignment(btn1, HPos.RIGHT);

		//

		//
		StackPane pane = new StackPane();
		Image image = new Image("http://www.drawingteachers.com/image-files/draw-a-human-face-14.jpg");
		ImageView imageView2 = new ImageView(image);
		imageView2.setFitHeight(100);
		imageView2.setFitWidth(150);
		pane.getChildren().add(imageView2);
		//

		/////////////////////////////////////////////////////////////
		Path path = new Path();

		// Moving to the starting point
		MoveTo moveTo = new MoveTo();
		moveTo.setX(100.0);
		moveTo.setY(200.0);

		// Instantiating the VLineTo class
		VLineTo vLineTo = new VLineTo();

		// Setting the properties of the path element vertical line
		vLineTo.setY(10.0);

		// Adding the path elements to Observable list of the Path class
		path.getElements().add(moveTo);
		path.getElements().add(vLineTo);

		// Creating a Group object
		Group root = new Group(path);
		///////////////////////////////////////////////////////////////////////////

//	    Pane lpane = new Pane();

//		Line line1 = new Line(0, 50, 0, 50);
////		line1.startXProperty();
////		line1.startYProperty();
////		line1.endXProperty();
////		line1.endYProperty();
//		line1.setStrokeWidth(5);
//		line1.setStroke(Color.GREEN);
//		lpane.getChildren().add(line1);

		// border.setTop(new CustomPane("Region in Bottom"));
		border.setBottom(hbox);
		border.setRight(gpane);
		border.setLeft(pane);
		border.setCenter(root);

		Scene scene = new Scene(border, 400, 300);
		primaryStage.setTitle("Login");
		primaryStage.setScene(scene);
		// primaryStage.setResizable(false);
		primaryStage.show();

	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
