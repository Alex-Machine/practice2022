package drivers.controllers;

import drivers.database.DbHandler;
import drivers.entities.Driver;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

public class DriverDBControl {

    ObservableList<Driver> driversData = FXCollections.observableArrayList();

    @FXML
    public TableView<Driver> driverTableView;
    @FXML
    public TableColumn<Driver, Integer> idColumn;
    @FXML
    public TableColumn<Driver, String> nameColumn;
    @FXML
    public TableColumn<Driver, String> middlenameColumn;
    @FXML
    public TableColumn<Driver, String> passportSerialColumn;
    @FXML
    public TableColumn<Driver, String> passportNumberColumn;
    @FXML
    public TableColumn<Driver, Integer> postcodeColumn;
    @FXML
    public TableColumn<Driver, String> addressColumn;
    @FXML
    public TableColumn<Driver, String> addressLifeColumn;
    @FXML
    public TableColumn<Driver, String> companyColumn;
    @FXML
    public TableColumn<Driver, String> jobnameColumn;
    @FXML
    public TableColumn<Driver, String> phoneColumn;
    @FXML
    public TableColumn<Driver, String> emailColumn;
    @FXML
    public TableColumn<Driver, String> photoColumn;
    @FXML
    public TableColumn<Driver, String> descriptionColumn;

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        middlenameColumn.setCellValueFactory(new PropertyValueFactory<>("middlename"));
        passportSerialColumn.setCellValueFactory(new PropertyValueFactory<>("passport_serial"));
        passportNumberColumn.setCellValueFactory(new PropertyValueFactory<>("passport_number"));
        postcodeColumn.setCellValueFactory(new PropertyValueFactory<>("postcode"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        addressLifeColumn.setCellValueFactory(new PropertyValueFactory<>("address_life"));
        companyColumn.setCellValueFactory(new PropertyValueFactory<>("company"));
        jobnameColumn.setCellValueFactory(new PropertyValueFactory<>("jobname"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        photoColumn.setCellValueFactory(new PropertyValueFactory<>("photo"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        showDrivers();
    }

    private void showDrivers() throws SQLException, ClassNotFoundException {
        DbHandler handler = new DbHandler();
        driversData = handler.getDriver();
        driverTableView.setItems(driversData);
    }
}