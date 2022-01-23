package drivers.controllers;

import drivers.database.DbHandler;
import drivers.entities.Driver;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.sql.SQLException;

public class DriverControl {
    public TextField createGuid;
    public TextField createLastname;
    public TextField createName;
    public TextField createSecondname;
    public TextField createPassport;
    public TextField createRegistration;
    public TextField createHome;
    public TextField createWork;
    public TextField createPosition;
    public TextField createPhoneNumber;
    public TextField createEmail;
    public TextField createPhoto;
    public TextField createNotes;
    public TextField update;
    public Button createButton;
    public Label createLabel;
    public Button updateButton;


    public void onCreate(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        DbHandler dbHandler = new DbHandler();
        if (!(createGuid.getText().isEmpty() && createLastname.getText().isEmpty() &&
                createName.getText().isEmpty() && createSecondname.getText().isEmpty() && createPassport.getText().isEmpty() &&
                createEmail.getText().isEmpty() && createRegistration.getText().isEmpty() && createHome.getText().isEmpty() &&
                createPhoto.getText().isEmpty() && createWork.getText().isEmpty() && createPosition.getText().isEmpty() &&
                createNotes.getText().isEmpty() && createPhoneNumber.getText().isEmpty())) {
            Driver driver = new Driver();
            driver.setId(Integer.parseInt(createGuid.getText()));
            driver.setName(createName.getText());
            driver.setMiddlename(createSecondname.getText());
            driver.setPassport_serial(createPassport.getText());
            driver.setAddress(createRegistration.getText());
            driver.setAddress_life(createHome.getText());
            driver.setPassport_number(createPassport.getText());
            driver.setPostcode(Integer.parseInt(createGuid.getText()));
            driver.setCompany(createWork.getText());
            driver.setJobname(createPosition.getText());
            driver.setPhone(createPhoneNumber.getText());
            driver.setEmail(createEmail.getText());
            driver.setPhoto(createPhoto.getText());
            driver.setDescription(createNotes.getText());

            dbHandler.createDriver(driver);
            createLabel.setText("создано");
            createLabel.setVisible(true);
        } else {
            createLabel.setText("ошибка");
            createLabel.setVisible(true);
        }
    }

    public void onAddPhotoButton(ActionEvent actionEvent) {
        JFileChooser.getDefaultLocale();
    }

    public void onUpdate(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        DbHandler dbHandler = new DbHandler();
        if (!(createGuid.getText().isEmpty() && createLastname.getText().isEmpty() &&
                createName.getText().isEmpty() && createSecondname.getText().isEmpty() && createPassport.getText().isEmpty() &&
                createEmail.getText().isEmpty() && createRegistration.getText().isEmpty() && createHome.getText().isEmpty() &&
                createPhoto.getText().isEmpty() && createWork.getText().isEmpty() && createPosition.getText().isEmpty() &&
                createNotes.getText().isEmpty() && createPhoneNumber.getText().isEmpty())) {
            Driver driver = new Driver();
            driver.setId(Integer.parseInt(createGuid.getText()));
            driver.setName(createName.getText());
            driver.setMiddlename(createSecondname.getText());
            driver.setPassport_serial(createPassport.getText());
            driver.setAddress(createRegistration.getText());
            driver.setAddress_life(createHome.getText());
            driver.setPassport_number(createPassport.getText());
            driver.setPostcode(Integer.parseInt(createGuid.getText()));
            driver.setCompany(createWork.getText());
            driver.setJobname(createPosition.getText());
            driver.setPhone(createPhoneNumber.getText());
            driver.setEmail(createEmail.getText());
            driver.setPhoto(createPhoto.getText());
            driver.setDescription(createNotes.getText());

            dbHandler.updateDriver(Integer.parseInt(update.getText()), driver);
            createLabel.setText("создано");
            createLabel.setVisible(true);
        } else {
            createLabel.setText("ошибка");
            createLabel.setVisible(true);
        }
    }
}
