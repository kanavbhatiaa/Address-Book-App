/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddressBookApp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author aneek
 */
public class AddressBookApp extends Application implements EventHandler<ActionEvent> {

    Button btnView, btnInsert, btnUpdate, btnClear, btnSearch, btnDelete;
    TextField tfFirstName, tfLastName, tfHomePhone, tfWorkPhone, tfHomeAddress, tfEmail, tfBirthday, tfNotes, tfCity, tfPostCode, tfProvince, tfCountry;
    private ContactManager cm = new ContactManager(10);
    Stage window;
    Scene mainScene, scene2;
    Label topLabel;
    //  TableView tableView = new TableView();

    public void init() {
        cm.add("Ava", "Markle", "000", "222", new Address("123 Street", "none", "Kingston", "N4J3E1", "Ontario", "Canada"), "ava@mail.com", "Notes Here", new MyDate(11, 05, 1992));
        cm.add("Kate", "Cindy", "111", "333", new Address("123 Street", "none", "Etobicoke", "M9R000", "Ontario", "Canada"), "kate@mail.com", "Notes Here", new MyDate(22, 07, 1990));
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        //1st scene///////
        Label lblFirstName = new Label("Firstname: ");
        tfFirstName = new TextField();
        Label lblLastName = new Label("Lastname: ");
        tfLastName = new TextField();
        Label lblHomePhone = new Label("Home Phone: ");
        tfHomePhone = new TextField();
        Label lblWorkPhone = new Label("Work Phone: ");
        tfWorkPhone = new TextField();
        Label lblHomeAddress = new Label("Home Address:");
        tfHomeAddress = new TextField();
        Label lblCity = new Label("City:");
        tfCity = new TextField();
        Label lblPostCode = new Label("Postal Code:");
        tfPostCode = new TextField();
        Label lblProvince = new Label("Province:");
        tfProvince = new TextField();
        Label lblCountry = new Label("Country:");
        tfCountry = new TextField();
        Label lblEmail = new Label("Email Address:");
        tfEmail = new TextField();
        Label lblBirthday = new Label("Date of Birth:");
        tfBirthday = new TextField();
        Label lblNotes = new Label("Notes:");
        tfNotes = new TextField();
        VBox layout = new VBox();

        this.btnView = new Button("View");
        this.btnInsert = new Button("Insert");
        this.btnUpdate = new Button("Search With Name");
        this.btnSearch = new Button("Search With City");
        this.btnClear = new Button("Clear");
        this.btnDelete = new Button("Delete");
        /* btnView= new Button("View");
        btnView.setOnAction(this);
        btnInsert= new Button("Insert");
        btnInsert.setOnAction(this);
        btnUpdate= new Button("Update");
        btnUpdate.setOnAction(this);
        btnClear= new Button("Clear");
        btnClear.setOnAction(this);
         */

        HBox hoBox = new HBox(btnView, btnInsert, btnUpdate, btnSearch, btnDelete, btnClear);
        hoBox.setAlignment(Pos.CENTER);
        hoBox.setSpacing(20);

        layout.getChildren().addAll(lblFirstName, tfFirstName, lblLastName, tfLastName, lblHomePhone, tfHomePhone, lblWorkPhone, tfWorkPhone, lblHomeAddress, tfHomeAddress, lblCity, tfCity, lblPostCode, tfPostCode, lblProvince, tfProvince, lblCountry, tfCountry, lblEmail, tfEmail, lblBirthday, tfBirthday, lblNotes, tfNotes, hoBox);
        layout.setMargin(hoBox, new Insets(20, 0, 0, 0));
        mainScene = new Scene(layout, 550, 600);
        window.setScene(mainScene);
        window.show();

        btnDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (tfFirstName.getText().trim().length() > 0) {
                    cm.deleteData(tfFirstName.getText().trim().toLowerCase());
                    clearData();
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter First Name and Last Name");
                }
            }
        });

        btnSearch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                searchWithCity();
            }
        });

        btnClear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                clearData();
            }
        });

        btnUpdate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                searchWithName();
            }
        });

        btnInsert.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String[] parts = tfBirthday.getText().trim().split("-");
                cm.addData(tfFirstName.getText().trim().toLowerCase(), tfLastName.getText().trim().toLowerCase(), tfHomePhone.getText().trim(), tfWorkPhone.getText().trim(), tfHomeAddress.getText().trim(), "", tfCity.getText().trim().toLowerCase(), tfPostCode.getText().trim(), tfProvince.getText().trim(), tfCountry.getText().trim(), tfEmail.getText().trim(), tfNotes.getText().trim(), Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                clearData();
            }
        });

        btnView.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TableView tableView = new TableView();
                Stage primaryStage = new Stage();
                TableColumn<Contact, String> column1 = new TableColumn<>("First Name");
                column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));
                TableColumn<Contact, String> column2 = new TableColumn<>("Last Name");
                column2.setCellValueFactory(new PropertyValueFactory<>("lastName"));
                TableColumn<Contact, String> column3 = new TableColumn<>("Home Phone");
                column3.setCellValueFactory(new PropertyValueFactory<>("homePhone"));
                TableColumn<Contact, String> column4 = new TableColumn<>("Work Phone");
                column4.setCellValueFactory(new PropertyValueFactory<>("workPhone"));
                TableColumn<Contact, String> column5 = new TableColumn<>("Email");
                column5.setCellValueFactory(new PropertyValueFactory<>("email"));
                TableColumn<Contact, String> column6 = new TableColumn<>("Note");
                column6.setCellValueFactory(new PropertyValueFactory<>("notes"));
                TableColumn<Contact, String> column7 = new TableColumn<>("Address");
                column7.setCellValueFactory(new PropertyValueFactory<>("homeAddress"));
                TableColumn<Contact, String> column8 = new TableColumn<>("Date Of Birth");
                column8.setCellValueFactory(new PropertyValueFactory<>("birthday"));

                tableView.getColumns().add(column1);
                tableView.getColumns().add(column2);
                tableView.getColumns().add(column3);
                tableView.getColumns().add(column4);
                tableView.getColumns().add(column5);
                tableView.getColumns().add(column6);
                tableView.getColumns().add(column7);
                tableView.getColumns().add(column8);

                setAllData(tableView);
                VBox vbox = new VBox(tableView);
                Scene scene = new Scene(vbox, 700, 500);
                primaryStage.setScene(scene);
                primaryStage.show();
            }
        });

    }

    public void handle(ActionEvent e) {
        if (e.getSource() == btnView) {
            System.out.println("hii");
            TableView tableView = new TableView();
            Stage primaryStage = new Stage();
            TableColumn<Contact, String> column1 = new TableColumn<>("First Name");
            column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));

            TableColumn<Contact, String> column2 = new TableColumn<>("Last Name");
            column2.setCellValueFactory(new PropertyValueFactory<>("lastName"));

            tableView.getColumns().add(column1);
            tableView.getColumns().add(column2);

//            tableView.getItems().add();
//            tableView.getItems().add();
            VBox vbox = new VBox(tableView);

            Scene scene = new Scene(vbox, 500, 500);

            primaryStage.setScene(scene);

            primaryStage.show();

        }
        if (e.getSource() == btnUpdate) {
            //here will be button handeler code for event
            window.setScene(mainScene);
            window.show();
        }
        if (e.getSource() == btnInsert) {
            //here will be button handeler code for event
            window.setScene(mainScene);
        }

        if (e.getSource() == btnClear) {
            //here will be button handeler code for event
            window.setScene(mainScene);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void searchWithName() {
        TableView tableView = new TableView();
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        Label lblFirstName = new Label("Firstname: ");
        TextField txtFirstName = new TextField();
        Label lblLastName = new Label("Lastname: ");
        TextField txtLastName = new TextField();
        Button btnSearch = new Button("Search");
        hBox.getChildren().addAll(lblFirstName, txtFirstName, lblLastName, txtLastName, btnSearch);

        Stage primaryStage = new Stage();
        TableColumn<Contact, String> column1 = new TableColumn<>("First Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        TableColumn<Contact, String> column2 = new TableColumn<>("Last Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        TableColumn<Contact, String> column3 = new TableColumn<>("Home Phone");
        column3.setCellValueFactory(new PropertyValueFactory<>("homePhone"));
        TableColumn<Contact, String> column4 = new TableColumn<>("Work Phone");
        column4.setCellValueFactory(new PropertyValueFactory<>("workPhone"));
        TableColumn<Contact, String> column5 = new TableColumn<>("Email");
        column5.setCellValueFactory(new PropertyValueFactory<>("email"));
        TableColumn<Contact, String> column6 = new TableColumn<>("Note");
        column6.setCellValueFactory(new PropertyValueFactory<>("notes"));
        TableColumn<Contact, String> column7 = new TableColumn<>("Address");
        column7.setCellValueFactory(new PropertyValueFactory<>("homeAddress"));
        TableColumn<Contact, String> column8 = new TableColumn<>("Date Of Birth");
        column8.setCellValueFactory(new PropertyValueFactory<>("birthday"));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);
        tableView.getColumns().add(column5);
        tableView.getColumns().add(column6);
        tableView.getColumns().add(column7);
        tableView.getColumns().add(column8);

        VBox vbox = new VBox(hBox, tableView);
        vbox.setMargin(hBox, new Insets(10, 5, 5, 5));

        Scene scene = new Scene(vbox, 500, 500);

        primaryStage.setScene(scene);

        primaryStage.show();

        btnSearch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (txtFirstName.getText().trim().toString().length() > 0 && txtLastName.getText().trim().toString().length() > 0) {
                    tableView.getItems().clear();
                    cm.findContact(txtFirstName.getText().trim().toLowerCase(), txtLastName.getText().trim().toLowerCase(), tableView);
                } else {
                    JOptionPane.showMessageDialog(null, "Please fill FirstName and LastName");
                }
            }
        });

    }

    public void searchWithCity() {
        TableView tableView = new TableView();
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        Label lblFirstName = new Label("City Name: ");
        TextField txtFirstName = new TextField();
        Button btnSearch = new Button("Search");
        hBox.getChildren().addAll(lblFirstName, txtFirstName, btnSearch);

        Stage primaryStage = new Stage();
        TableColumn<Contact, String> column1 = new TableColumn<>("First Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        TableColumn<Contact, String> column2 = new TableColumn<>("Last Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        TableColumn<Contact, String> column3 = new TableColumn<>("Home Phone");
        column3.setCellValueFactory(new PropertyValueFactory<>("homePhone"));
        TableColumn<Contact, String> column4 = new TableColumn<>("Work Phone");
        column4.setCellValueFactory(new PropertyValueFactory<>("workPhone"));
        TableColumn<Contact, String> column5 = new TableColumn<>("Email");
        column5.setCellValueFactory(new PropertyValueFactory<>("email"));
        TableColumn<Contact, String> column6 = new TableColumn<>("Note");
        column6.setCellValueFactory(new PropertyValueFactory<>("notes"));
        TableColumn<Contact, String> column7 = new TableColumn<>("Address");
        column7.setCellValueFactory(new PropertyValueFactory<>("homeAddress"));
        TableColumn<Contact, String> column8 = new TableColumn<>("Date Of Birth");
        column8.setCellValueFactory(new PropertyValueFactory<>("birthday"));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);
        tableView.getColumns().add(column4);
        tableView.getColumns().add(column5);
        tableView.getColumns().add(column6);
        tableView.getColumns().add(column7);
        tableView.getColumns().add(column8);

        VBox vbox = new VBox(hBox, tableView);
        vbox.setMargin(hBox, new Insets(10, 5, 5, 5));

        Scene scene = new Scene(vbox, 500, 500);

        primaryStage.setScene(scene);

        primaryStage.show();

        btnSearch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (txtFirstName.getText().trim().toString().length() > 0) {
                    tableView.getItems().clear();
                    cm.viewContactsInCity(txtFirstName.getText().trim().toLowerCase(), tableView);
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter City");
                }
            }
        });

    }

    public void setAllData(TableView tableView) {
        try {
            File file = new File("User.txt");
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                int i = 0;
                while ((line = br.readLine()) != null) {
                    String[] vec = line.split(",");
                    tableView.getItems().add(new Contact(vec[0], vec[1], vec[2], vec[3], new Address(vec[4], vec[5], vec[6], vec[7], vec[8], vec[9]), vec[10], vec[11], new MyDate(Integer.parseInt(vec[12]), Integer.parseInt(vec[13]), Integer.parseInt(vec[14]))));
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void clearData() {
        tfBirthday.setText("");
        tfCity.setText("");
        tfEmail.setText("");
        tfFirstName.setText("");
        tfHomeAddress.setText("");
        tfHomePhone.setText("");
        tfLastName.setText("");
        tfNotes.setText("");
        tfWorkPhone.setText("");
        tfProvince.setText("");
        tfPostCode.setText("");
        tfCountry.setText("");
    }
}
