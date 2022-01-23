package drivers.controllers;

import drivers.database.DbHandler;
import drivers.entities.Driver;
import drivers.entities.TS;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NewOwnerControl {
    public TextField findPhone;
    public TextField findNote;
    public TextField findFIO;
    public TextField findGUID;
    public Label createLabel;
    public TextField findVIN;
    public TextField findTS;
    public TextField findNewOwnerGUID;
    public TextField newOwnerFIO;
    public TextField newOwnerPhone;
    public TextField newOwnerNote;

    ObservableList<Driver> driversData = FXCollections.observableArrayList();
    ObservableList<TS> tsData = FXCollections.observableArrayList();

    /**
     * изменяет данные о владельце тс
     */
    public void onPassOn(ActionEvent actionEvent) {
        DbHandler dbHandler = new DbHandler();

        if (!findGUID.getText().isEmpty()) {
            for (TS ts : tsData) {
                if (findVIN.getText().equals(ts.getVin())) {
                    if (!findNewOwnerGUID.getText().isEmpty()) {
                        for (TS tss : tsData) {
                            if (findNewOwnerGUID.getText().equals(ts.getVin())) {
                                dbHandler.updateDriver(ts.getOwner(), tss.getOwner());
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * отображает данные о владельце тс
     */
    public void onFindOwner(ActionEvent actionEvent) {
        if (!findGUID.getText().isEmpty()) {
            for (Driver driver : driversData) {
                if (Integer.parseInt(String.valueOf(findGUID)) == driver.getId()) {
                    findFIO.setText(driver.getName() + " " + driver.getMiddlename());
                    findPhone.setText(driver.getPhone());
                    findNote.setText(driver.getDescription());
                }
            }
        }
    }

    /**
     * отображает данные о новом(потенциальном) владельце тс
     */
    public void onFindNewOwner(ActionEvent actionEvent) {
        if (!findNewOwnerGUID.getText().isEmpty()) {
            for (Driver driver : driversData) {
                if (Integer.parseInt(String.valueOf(findNewOwnerGUID)) == driver.getId()) {
                    newOwnerFIO.setText(driver.getName() + " " + driver.getMiddlename());
                    newOwnerPhone.setText(driver.getPhone());
                    newOwnerNote.setText(driver.getDescription());
                }
            }
        }
    }

    /**
     * отображает данные о транспортном средстве
     */
    public void onFindTS(ActionEvent actionEvent) {
        if (!findVIN.getText().isEmpty()) {
            for (TS ts : tsData) {
                if (findVIN.getText().equals(ts.getVin())) {
                    findTS.setText(ts.getModel() + " " + ts.getMarka());
                    findNote.setText(ts.getNotes());
                }
            }
        }
    }
}
