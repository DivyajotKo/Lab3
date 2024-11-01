package com.example.hrmangagementdivya;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;
import java.sql.*;

public class AdminController implements Initializable {
    public TextField iid;
    public TextField iname;
    public TextField imail;
    public TextField ipassword;
    @FXML
    private TableView<AdData> tableView;
    @FXML
    private TableColumn<AdData,Integer > Id;
    @FXML
    private TableColumn<AdData, String> Name;
    @FXML
    private TableColumn<AdData,String> Email;
    @FXML
    private TableColumn<AdData,Integer> Password;
    ObservableList<AdData> list = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Id.setCellValueFactory(new
                PropertyValueFactory<AdData,Integer>("Id"));
        Name.setCellValueFactory(new
                PropertyValueFactory<AdData,String>("Name"));
        Email.setCellValueFactory(new
                PropertyValueFactory<AdData,String>("Email"));
        Password.setCellValueFactory(new
                PropertyValueFactory<AdData,Integer>("Password"));
        tableView.setItems(list);
    }
    @FXML
    protected void onHelloButtonClick() {
        list.clear();tableView.setItems(list);
        populateTable();
    }
    public void populateTable() {
        // Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/employeedata";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM admin";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int Id = resultSet.getInt("Id");
                String Name = resultSet.getString("Name");
                String Email = resultSet.getString("Email");
                int Password = resultSet.getInt("Password");
                tableView.getItems().add(new AdData(Id, Name, Email,
                        Password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void updatedata(ActionEvent actionEvent) {
        String getid = iid.getText();
        String getName = iname.getText();
        String getEmail = imail.getText();
        String getPassword = ipassword.getText();


        String jdbcUrl = "jdbc:mysql://localhost:3306/employeedata";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "UPDATE `admin` SET `Name`='"+getName+"',`Email`='"+getEmail+"',`Password`='"+getPassword+"' WHERE `Id` = '"+getid+"'";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertdata(ActionEvent actionEvent) {
        String getid = iid.getText();
        String getName = iname.getText();
        String getEmail = imail.getText();
        String getPassword = ipassword.getText();


        String jdbcUrl = "jdbc:mysql://localhost:3306/employeedata";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "INSERT INTO `admin`(`name`, `email`, `password`) VALUES ('"+getName+"','"+getEmail+"','"+getPassword+"')";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void deletedata(ActionEvent actionEvent) {
        String getid = iid.getText();


        String jdbcUrl = "jdbc:mysql://localhost:3306/employeedata";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "DELETE FROM admin WHERE `iid`= '"+getid+"' ";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewdata(ActionEvent actionEvent) {
        String getid = iid.getText();


        String jdbcUrl = "jdbc:mysql://localhost:3306/employeedata";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM admin WHERE `iid`= '"+getid+"' ";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int Id = resultSet.getInt("id");
                String Name = resultSet.getString("name");
                String Email = resultSet.getString("mail");
                int Password = resultSet.getInt("password");


                iname.setText(Name);
                imail.setText(Email);
                ipassword.setText(String.valueOf(Password));



            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}