package home;

import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Modify

{
	private Stage primaryStage = new Stage();
	public static Scene modify_scene;

// Text fields 1
	private TextField idRrugetTxt = new TextField();
	private TextField KomunaTxt = new TextField();
	private TextField FshatiTxt = new TextField();
	private TextField EmriRrugesTxt = new TextField();
	private TextField KodiRrugesTxt = new TextField();
	private TextField LlojiRrugesTxt = new TextField();

// Text fields 2
	private TextField idObjektiTxt = new TextField();
	private TextField LlojiObjektitTxt = new TextField();
	private TextField NumriKateveTxt = new TextField();
	private TextField NumriHyrjesTxt = new TextField();

// Text fields 3
	private TextField idAdresaTxt = new TextField();
	private TextField idKomunaTxt = new TextField();
	private TextField idRajoniTxt = new TextField();
	private TextField LagjjaTxt = new TextField();
	private TextField idRrugesTxt = new TextField();
	private TextField idObjektitTxt = new TextField();
	private TextField LatitudeTxt = new TextField();
	private TextField LongitudeTxt = new TextField();

// Buttons
	private Button insertBtn = new Button("Insert");
	private Button updateBtn = new Button("Update");
	private Button deleteBtn = new Button("Delete");
	private Button clearBtn = new Button("Clear");

//Buttons 2
	private Button insertBtn1 = new Button("Insert");
	private Button updateBtn1 = new Button("Update");
	private Button deleteBtn1 = new Button("Delete");
	private Button clearBtn1 = new Button("Clear");

//Buttons 3
	private Button insertBtn2 = new Button("Insert");
	private Button updateBtn2 = new Button("Update");
	private Button deleteBtn2 = new Button("Delete");
	private Button clearBtn2 = new Button("Clear");

// Table views
	private TableView AdresatTable = new TableView();

//Table views 2
	private TableView ObjektetTable = new TableView();

//Table views 3
	private TableView AddressesTable = new TableView();

	public void createStage() {

// Form pane
		Stage primaryStage = new Stage();
		HBox top_pane = new HBox();
		ImageView back_image = new ImageView(
				new Image("file:///C:/Users/DataProgNet/git/-Registering-and-finding-addresses-in-Kosovo/Images/back.png"));

		back_image.setFitHeight(24);
		back_image.setFitWidth(24);
		Button back_button = new Button();
		back_button.setGraphic(back_image);
		back_button.setPadding(new Insets(-1, -1, -1, -1));
		back_button.setStyle("-fx-text-fill:white; -fx-border-color: transparent; -fx-background-color: transparent;");
		top_pane.getChildren().add(back_button);
		top_pane.setStyle("-fx-background-color: turquoise;");
		GridPane formPane = new GridPane();
		
		back_button.setOnAction(e -> {
			primaryStage.close();
		});

		formPane.addRow(0, new Label("idRruget: "), idRrugetTxt);
		formPane.addRow(1, new Label("Komuna: "), KomunaTxt);
		formPane.addRow(2, new Label("Fshati: "), FshatiTxt);
		formPane.addRow(3, new Label("EmriRruges: "), EmriRrugesTxt);
		formPane.addRow(4, new Label("KodiRruges: "), KodiRrugesTxt);
		formPane.addRow(5, new Label("LlojiRruges: "), LlojiRrugesTxt);

		formPane.setHgap(10);
		formPane.setVgap(10);

		idRrugetTxt.setDisable(true);

// Buttons pane
		HBox buttonsPane = new HBox(10);

		buttonsPane.getChildren().addAll(insertBtn, updateBtn, deleteBtn, clearBtn);

		insertBtn.setOnAction(e -> {
			insertAdresat();
		});

		clearBtn.setOnAction(e -> {
			clearForm();
		});

		deleteBtn.setOnAction(e -> {
			removeAdresat();
		});

		updateBtn.setOnAction(e -> {
			updateAdresat();
		});

// Left Pane

		VBox leftPane = new VBox(15);

		leftPane.getChildren().addAll(formPane, buttonsPane);

// Adresat table
		TableColumn<String, Adresat> column1 = new TableColumn<>("idRruget");
		column1.setCellValueFactory(new PropertyValueFactory("idRruget"));
		column1.setPrefWidth(100);

		TableColumn<String, Adresat> column2 = new TableColumn<>("Komuna");
		column2.setCellValueFactory(new PropertyValueFactory("Komuna"));
		column2.setPrefWidth(120);

		TableColumn<String, Adresat> column3 = new TableColumn<>("Fshati");
		column3.setCellValueFactory(new PropertyValueFactory("Fshati"));
		column3.setPrefWidth(150);

		TableColumn<String, Adresat> column4 = new TableColumn<>("KodiRruges");
		column4.setCellValueFactory(new PropertyValueFactory("EmriRruges"));
		column4.setPrefWidth(150);

		TableColumn<String, Adresat> column5 = new TableColumn<>("EmriRruges");
		column5.setCellValueFactory(new PropertyValueFactory("KodiRruges"));
		column5.setPrefWidth(120);

		TableColumn<String, Adresat> column6 = new TableColumn<>("LlojiRruges");
		column6.setCellValueFactory(new PropertyValueFactory("LlojiRruges"));
		column6.setPrefWidth(120);

		AdresatTable.getColumns().add(column1);
		AdresatTable.getColumns().add(column2);
		AdresatTable.getColumns().add(column3);
		AdresatTable.getColumns().add(column4);
		AdresatTable.getColumns().add(column5);
		AdresatTable.getColumns().add(column6);

		AdresatTable.setRowFactory(tv -> {
			TableRow<Adresat> row = new TableRow<>();

			row.setOnMouseClicked(e -> {
				if (row.getItem() != null) {
					idRrugetTxt.setText(String.valueOf(row.getItem().getIdRruget()));
					KomunaTxt.setText(String.valueOf(row.getItem().getKomuna()));
					FshatiTxt.setText(String.valueOf(row.getItem().getFshati()));
					EmriRrugesTxt.setText(String.valueOf(row.getItem().getKodiRruges()));
					KodiRrugesTxt.setText(String.valueOf(row.getItem().getEmriRruges()));
					LlojiRrugesTxt.setText(String.valueOf(row.getItem().getLlojiRruges()));
				}
			});
			return row;

		});

		AdresatTable.setPrefWidth(650);
		AdresatTable.setPrefHeight(200);

// Main Pane
		HBox mainPane = new HBox(10);

//
		mainPane.getChildren().addAll(leftPane, AdresatTable);

		mainPane.setPadding(new Insets(15, 15, 15, 15));

// **************************************************************************************
// Form pane
		GridPane formPane1 = new GridPane();

		formPane1.addRow(0, new Label("idObjekti: "), idObjektiTxt);
		formPane1.addRow(1, new Label("LlojiObjektit: "), LlojiObjektitTxt);
		formPane1.addRow(2, new Label("NumriKateve: "), NumriKateveTxt);
		formPane1.addRow(3, new Label("NumriHyrjes: "), NumriHyrjesTxt);

		formPane1.setHgap(10);
		formPane1.setVgap(10);

		idObjektiTxt.setDisable(true);

// Buttons pane
		HBox buttonsPane1 = new HBox(10);

		buttonsPane1.getChildren().addAll(insertBtn1, updateBtn1, deleteBtn1, clearBtn1);

		insertBtn1.setOnAction(e -> {
			insertObjektet();
		});

		clearBtn1.setOnAction(e -> {
			clearForm1();
		});

		deleteBtn1.setOnAction(e -> {
			removeObjektet();
		});

		updateBtn1.setOnAction(e -> {
			updateObjektet();
		});

// Left Pane

		VBox leftPane1 = new VBox(15);

		leftPane1.getChildren().addAll(formPane1, buttonsPane1);

// Objektet table
		TableColumn<String, Objektet> column7 = new TableColumn<>("idObjekti");
		column7.setCellValueFactory(new PropertyValueFactory("idObjekti"));
		column7.setPrefWidth(100);

		TableColumn<String, Objektet> column8 = new TableColumn<>("LlojiObjektit");
		column8.setCellValueFactory(new PropertyValueFactory("LlojiObjektit"));
		column8.setPrefWidth(150);

		TableColumn<String, Objektet> column9 = new TableColumn<>("NumriKateve");
		column9.setCellValueFactory(new PropertyValueFactory("NumriKateve"));
		column9.setPrefWidth(150);

		TableColumn<String, Objektet> column10 = new TableColumn<>("NumriHyrjes");
		column10.setCellValueFactory(new PropertyValueFactory("NumriHyrjes"));
		column10.setPrefWidth(120);

		ObjektetTable.getColumns().add(column7);
		ObjektetTable.getColumns().add(column8);
		ObjektetTable.getColumns().add(column9);
		ObjektetTable.getColumns().add(column10);

		ObjektetTable.setRowFactory(tv -> {
			TableRow<Objektet> row = new TableRow<>();

			row.setOnMouseClicked(e -> {
				if (row.getItem() != null) {
					idObjektiTxt.setText(String.valueOf(row.getItem().getIdObjekti()));
					LlojiObjektitTxt.setText(String.valueOf(row.getItem().getLlojiObjektit()));
					NumriKateveTxt.setText(String.valueOf(row.getItem().getNumriKateve()));
					NumriHyrjesTxt.setText(String.valueOf(row.getItem().getNumriHyrjes()));
				}
			});

			return row;
		});

		ObjektetTable.setPrefWidth(650);
		ObjektetTable.setPrefHeight(200);

// Main Pane
		HBox mainPane1 = new HBox(10);

		mainPane1.getChildren().addAll(leftPane1, ObjektetTable);

		mainPane1.setPadding(new Insets(15, 15, 15, 15));

// ******************************************************************

// **--**--**--**--**-**--**--**--**-**--***--**--**--**-**--**--**--**--**--**--**--**

// Form pane
		GridPane formPane2 = new GridPane();

		formPane2.addRow(0, new Label("idAdresa: "), idAdresaTxt);
		formPane2.addRow(1, new Label("idKomuna: "), idKomunaTxt);
		formPane2.addRow(2, new Label("idRajoni: "), idRajoniTxt);
		formPane2.addRow(3, new Label("Lagjja: "), LagjjaTxt);
		formPane2.addRow(4, new Label("idRruges: "), idRrugesTxt);
		formPane2.addRow(5, new Label("idObjektit: "), idObjektitTxt);
		formPane2.addRow(6, new Label("Latitude: "), LatitudeTxt);
		formPane2.addRow(7, new Label("Longitude: "), LongitudeTxt);

		formPane2.setHgap(10);
		formPane2.setVgap(10);

		idAdresaTxt.setDisable(true);

// Buttons pane
		HBox buttonsPane2 = new HBox(10);

		buttonsPane2.getChildren().addAll(insertBtn2, updateBtn2, deleteBtn2, clearBtn2);

		insertBtn2.setOnAction(e -> {
			insertAddresses();
		});

		clearBtn2.setOnAction(e -> {
			clearForm2();
		});

		deleteBtn2.setOnAction(e -> {
			removeAddresses();
		});

		updateBtn2.setOnAction(e -> {
			updateAddresses();
		});

// Left Pane

		VBox leftPane2 = new VBox(15);

		leftPane2.getChildren().addAll(formPane2, buttonsPane2);

// Addresses table
		TableColumn<String, Addresses> column11 = new TableColumn<>("idAdresa");
		column11.setCellValueFactory(new PropertyValueFactory("idAdresa"));
		column11.setPrefWidth(100);

		TableColumn<String, Addresses> column12 = new TableColumn<>("idRajoni");
		column12.setCellValueFactory(new PropertyValueFactory("idRajoni"));
		column12.setPrefWidth(150);

		TableColumn<String, Addresses> column13 = new TableColumn<>("idKomuna");
		column13.setCellValueFactory(new PropertyValueFactory("idKomuna"));
		column13.setPrefWidth(150);
		TableColumn<String, Addresses> column14 = new TableColumn<>("Lagjja");
		column14.setCellValueFactory(new PropertyValueFactory("Lagjja"));
		column14.setPrefWidth(120);

		TableColumn<String, Addresses> column15 = new TableColumn<>("idRruges");
		column15.setCellValueFactory(new PropertyValueFactory("idRruges"));
		column15.setPrefWidth(120);

		TableColumn<String, Addresses> column16 = new TableColumn<>("idObjektit");
		column16.setCellValueFactory(new PropertyValueFactory("idObjektit"));
		column16.setPrefWidth(120);

		TableColumn<String, Addresses> column17 = new TableColumn<>("Latitude");
		column17.setCellValueFactory(new PropertyValueFactory("Latitude"));
		column17.setPrefWidth(120);

		TableColumn<String, Addresses> column18 = new TableColumn<>("Longitude");
		column18.setCellValueFactory(new PropertyValueFactory("Longitude"));
		column18.setPrefWidth(120);

		AddressesTable.getColumns().add(column11);
		AddressesTable.getColumns().add(column12);
		AddressesTable.getColumns().add(column13);
		AddressesTable.getColumns().add(column14);
		AddressesTable.getColumns().add(column15);
		AddressesTable.getColumns().add(column16);
		AddressesTable.getColumns().add(column17);
		AddressesTable.getColumns().add(column18);

		AddressesTable.setRowFactory(tv -> {
			TableRow<Addresses> row = new TableRow<>();

			row.setOnMouseClicked(e -> {
				if (row.getItem() != null) {
					idAdresaTxt.setText(String.valueOf(row.getItem().getIdAdresa()));
					idKomunaTxt.setText(String.valueOf(row.getItem().getIdKomuna()));
					idRajoniTxt.setText(String.valueOf(row.getItem().getIdRajoni()));
					LagjjaTxt.setText(String.valueOf(row.getItem().getLagjja()));
					idRrugesTxt.setText(String.valueOf(row.getItem().getIdRruges()));
					idObjektitTxt.setText(String.valueOf(row.getItem().getIdObjektit()));
					LatitudeTxt.setText(String.valueOf(row.getItem().getLatitude()));
					LongitudeTxt.setText(String.valueOf(row.getItem().getLongitude()));
				}

			});

			return row;
		});

		AddressesTable.setPrefWidth(650);
		AddressesTable.setPrefHeight(200);

// Main Pane
		HBox mainPane2 = new HBox(10);

		mainPane2.getChildren().addAll(leftPane2, AddressesTable);

		mainPane2.setPadding(new Insets(15, 15, 15, 15));

// ******************************************************************

// ***--**--**--**--**--**--**--**--**--**--**--***---**--*--**--**--**-**-***--**-**--**--***-

		VBox mainPPPane = new VBox();
		mainPPPane.getChildren().addAll(mainPane, mainPane1, mainPane2);

		ScrollPane scroll_pane = new ScrollPane();
		scroll_pane.setPrefSize(1000, 700);
		scroll_pane.setContent(mainPPPane);
		VBox final_pane = new VBox();
		final_pane.getChildren().addAll(top_pane, scroll_pane);

		modify_scene = new Scene(final_pane, 860, 420);

		primaryStage.setTitle("Adresat");
		primaryStage.setScene(modify_scene);

		showAdresat();
		showObjektet();
		showAddresses();

		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void showAdresat() {
		List<Adresat> adresat = Adresat.getRruget();

		ObservableList<Adresat> AdresatList = FXCollections.observableArrayList();

		for (int i = 0; i < adresat.size(); i++) {
			AdresatList.add(adresat.get(i));
		}

		AdresatTable.setItems(AdresatList);
	}

// 2
	public void showObjektet() {
		List<Objektet> objektet = Objektet.getObjektet();

		ObservableList<Objektet> ObjektetList = FXCollections.observableArrayList();

		for (int j = 0; j < objektet.size(); j++) {
			ObjektetList.add(objektet.get(j));
		}

		ObjektetTable.setItems(ObjektetList);
	}

//

// 
	public void showAddresses() {
		List<Addresses> addresses = Addresses.getAddresses();

		ObservableList<Addresses> AddressesList = FXCollections.observableArrayList();

		for (int k = 0; k < addresses.size(); k++) {
			AddressesList.add(addresses.get(k));
		}

		AddressesTable.setItems(AddressesList);
	}

//

	public void insertAdresat() {

		if (Adresat.addRruget(KomunaTxt.getText(), FshatiTxt.getText(), EmriRrugesTxt.getText(),
				Integer.parseInt(KodiRrugesTxt.getText()), LlojiRrugesTxt.getText())) {
			showAdresat();
			clearForm();
		}
	}

//
	public void insertObjektet() {

		if (Objektet.addObjektet(LlojiObjektitTxt.getText(), Integer.parseInt(NumriKateveTxt.getText()),
				Integer.parseInt(NumriHyrjesTxt.getText()))) {
			showObjektet();
			clearForm1();
		}
	}

//

//
	public void insertAddresses() {

		if (Addresses.addAddresses(Integer.parseInt(idKomunaTxt.getText()), Integer.parseInt(idRajoniTxt.getText()),
				LagjjaTxt.getText(), Integer.parseInt(idRrugesTxt.getText()), Integer.parseInt(idObjektitTxt.getText()),
				Double.parseDouble(LatitudeTxt.getText()), Double.parseDouble(LongitudeTxt.getText()))) {
			showAddresses();
			clearForm2();
		}
	}

//

	public void removeAdresat() {

		if (Adresat.deleteAdresat(Integer.parseInt(idRrugetTxt.getText()))) {
			showAdresat();
			clearForm();
		}
	}

	public void removeObjektet() {

		if (Objektet.deleteObjektet(Integer.parseInt(idObjektiTxt.getText()))) {
			showObjektet();
			clearForm1();
		}
	}

//

	public void removeAddresses() {

		if (Addresses.deleteAddresses(Integer.parseInt(idAdresaTxt.getText()))) {
			showAddresses();
			clearForm2();
		}
	}

//

	public void updateAdresat() {
		if (Adresat.updateAdresat(Integer.parseInt(idRrugetTxt.getText()), KomunaTxt.getText(), FshatiTxt.getText(),
				EmriRrugesTxt.getText(), KodiRrugesTxt.getText(), LlojiRrugesTxt.getText())) {
			showAdresat();
			clearForm();
		}
	}

	public void updateObjektet() {
		if (Objektet.updateObjektet(Integer.parseInt(idObjektiTxt.getText()), LlojiObjektitTxt.getText(),
				Integer.parseInt(NumriKateveTxt.getText()), Integer.parseInt(NumriHyrjesTxt.getText()))) {
			showObjektet();
			clearForm1();
		}
	}

	public void updateAddresses() {
		if (Addresses.updateAddresses(Integer.parseInt(idAdresaTxt.getText()), Integer.parseInt(idKomunaTxt.getText()),
				Integer.parseInt(idRajoniTxt.getText()), LagjjaTxt.getText(), Integer.parseInt(idRrugesTxt.getText()),
				Integer.parseInt(idObjektitTxt.getText()), Double.parseDouble(LatitudeTxt.getText()),
				Double.parseDouble(LongitudeTxt.getText()))) {
			showAddresses();
			clearForm2();
		}
	}

	public void clearForm() {
		idRrugetTxt.setText("");
		KomunaTxt.setText("");
		FshatiTxt.setText("");
		EmriRrugesTxt.setText("");
		KodiRrugesTxt.setText("");
		LlojiRrugesTxt.setText("");
	}

//
	public void clearForm1() {
		idObjektiTxt.setText("");
		LlojiObjektitTxt.setText("");
		NumriKateveTxt.setText("");
		NumriHyrjesTxt.setText("");
	}

//
	public void clearForm2() {
		idAdresaTxt.setText("");
		idKomunaTxt.setText("");
		idRajoniTxt.setText("");
		LagjjaTxt.setText("");
		idRrugesTxt.setText("");
		idObjektitTxt.setText("");
		LatitudeTxt.setText("");
		LongitudeTxt.setText("");

	}

}
