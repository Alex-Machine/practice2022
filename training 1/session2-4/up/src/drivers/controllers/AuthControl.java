package drivers.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class AuthControl {

    private final String auth = "login";

    @FXML
    public TextField loginTextField;
    @FXML
    public Button authButton;
    @FXML
    public TextField passwordTextField;
    @FXML
    public Label messageLabel;

    @FXML
    public void onClickAuth() throws IOException {
        messageLabel.setText("");
        if (loginTextField.getText().equals(auth) && passwordTextField.getText().equals(auth)) {
            Stage stage = (Stage) authButton.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/drivers/views/inspector.fxml"));
            Parent root = fxmlLoader.load();
            stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root, 590, 400));
            stage.setTitle("Inspector");
            stage.setResizable(false);
            stage.show();
        } else {
            messageLabel.setText("Неверный логин или пароль");
        }
    }
}