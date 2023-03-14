package com.streaming2;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.control.TableView;


import java.io.IOException;

public class ControllerLogin {
    @FXML
    private Button btnForget;

    @FXML
    private Button btnLog;

    @FXML
    private Label labelLog;

    @FXML
    private Label labelMail;

    @FXML
    private Label labelMdp;

    @FXML
    private TextField tfMail;

    @FXML
    private TextField tfMdp;

    public void login(ActionEvent event) throws IOException {
        String mail = tfMail.getText();
        String mdp = tfMdp.getText();
        if (mail.isEmpty() || mdp.isEmpty()) {
            labelLog.setText("Remplir les champs");
        } else {
            Stage stage = HelloApplication.stage;
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("playlist.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Streaming");
            stage.setScene(scene);
        }
    }

}
