package drivers.controllers;

import drivers.database.DbHandler;
import drivers.entities.TS;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public class TsControl {
    public TextField vin;
    public TextField marka;
    public TextField model;
    public TextField type;
    public TextField category;
    public TextField numberDvigatel;
    public TextField modelDvigatel;
    public TextField yesrDvigatel;
    public TextField colorNumber;
    public TextField powerDvigatel;
    public TextField powerDvigatelHorse;
    public TextField maxPressure;
    public TextField weight;
    public TextField typeDvigatel;
    public TextField weightKG;
    public TextField typePrivoda;
    public TextField notes;
    public TextField owner;
    public Button createButton;
    public Label createLabel;
    public Button addOwner;

    ObservableList<TS> tsData = FXCollections.observableArrayList();

    /**
     * создание нового тс
     */
    public void onCreate(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        DbHandler dbHandler = new DbHandler();
        if (!(vin.getText().isEmpty() && marka.getText().isEmpty() &&
                model.getText().isEmpty() && type.getText().isEmpty() && category.getText().isEmpty() &&
                numberDvigatel.getText().isEmpty() && modelDvigatel.getText().isEmpty() && yesrDvigatel.getText().isEmpty() &&
                colorNumber.getText().isEmpty() && powerDvigatel.getText().isEmpty() && maxPressure.getText().isEmpty() &&
                weight.getText().isEmpty() && owner.getText().isEmpty())) {
            TS ts = new TS();
            ts.setVin(Integer.parseInt(vin.getText()));
            ts.setMarka(marka.getText());
            ts.setModel(model.getText());
            ts.setType(type.getText());
            ts.setCategory(category.getText());
            ts.setNumberDvigatel(numberDvigatel.getText());
            ts.setModelDvigatel(modelDvigatel.getText());
            ts.setYesrDvigatel(yesrDvigatel.getText());
            ts.setColorNumber(colorNumber.getText());
            ts.setPowerDvigatel(Double.parseDouble(powerDvigatel.getText()));
            ts.setPowerDvigatelHorse(Double.parseDouble(powerDvigatelHorse.getText()));
            ts.setMaxPressure(Double.parseDouble(maxPressure.getText()));
            ts.setWeight(Double.parseDouble(weight.getText()));
            ts.setTypeDvigatel(typeDvigatel.getText());
            ts.setWeightKG(Double.parseDouble(weightKG.getText()));
            ts.setTypePrivoda(typePrivoda.getText());
            ts.setNotes(notes.getText());
            ts.setOwner(owner.getText());

            dbHandler.createTS(ts);
            createLabel.setText("создано");
            createLabel.setVisible(true);
        } else {
            createLabel.setText("ошибка");
            createLabel.setVisible(true);
        }
    }

    /**
     * добавление фото
     */
    public void onAddPhoto(ActionEvent actionEvent) {
        JFileChooser.getDefaultLocale();
    }

    /**
     * открытие окна создания водителя
     */
    public void onAddOwner(ActionEvent actionEvent) throws IOException {

        Stage stage = (Stage) addOwner.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/drivers/views/vodila.fxml"));
        Parent root = fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root, 590, 400));
        stage.setTitle("Inspector");
        stage.setResizable(false);
        stage.show();
    }
}
