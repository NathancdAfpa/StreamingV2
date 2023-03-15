package fr.afpa.controller;

import fr.afpa.application.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;


import java.io.IOException;

//controller qui gère la vue login
public class ControllerLogin {
    @FXML
    private TextField tfMail;

    @FXML
    private TextField tfMdp;

    public void login() throws IOException {
        //créeation de l'alerte en cas d'erreur
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        String mail = tfMail.getText();
        String mdp = tfMdp.getText();

        //vérification de l'email avec une regex
        if (!mail.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\\.?[a-zA-Z]*$")){
            alert.setTitle("Erreur");
            alert.setHeaderText("Adresse email invalide !!!");
            alert.setContentText("L'adresse email n'est pas valide");
            alert.showAndWait();

            return;
        }

        //vérifier si les champs mdp et mail ne sont pas vide
        if (mail.isEmpty() || mdp.isEmpty()) {
            alert.setTitle("Erreur");
            alert.setHeaderText("Champs vide");
            alert.setContentText("Remplir les champs");
            alert.showAndWait();

            return;
        }
        //chargement de la vue playlist
            Stage stage = HelloApplication.stage;
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/view/playlist.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Streaming");
            stage.setScene(scene);
    }

}
