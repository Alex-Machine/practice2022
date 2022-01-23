package drivers.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class InspectorControl {

    @FXML
    public Button driversDBButton;

    @FXML
    public void onClickEditDriver() throws IOException {
        Stage stage = (Stage) driversDBButton.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/drivers/views/driver.fxml"));
        Parent root = fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root, 590, 400));
        stage.setTitle("Редактирование водителя");
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    public void onClickDriverDB() throws IOException {
        Stage stage = (Stage) driversDBButton.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/drivers/views/driverDB.fxml"));
        Parent root = fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root, 590, 400));
        stage.setTitle("Driver Data Base Table");
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    public void onClickCreateDriver() throws IOException {
        Stage stage = (Stage) driversDBButton.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/drivers/views/driver.fxml"));
        Parent root = fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root, 590, 400));
        stage.setTitle("Создание водителя");
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    public void onClickNewOwner() throws IOException {
        Stage stage = (Stage) driversDBButton.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/drivers/views/new_owner.fxml"));
        Parent root = fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root, 590, 400));
        stage.setTitle("Передача ТС");
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    public void onClickEditTS() throws IOException {
        Stage stage = (Stage) driversDBButton.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/drivers/views/ts.fxml"));
        Parent root = fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root, 590, 400));
        stage.setTitle("Создание ТС");
        stage.setResizable(false);
        stage.show();
    }
}