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

public class ControllerPlaylist {
    @FXML
    private TableView<Film> tableFilm;

    @FXML
    private TableView<Film> tableVPlaylist;
    private ObservableList<Film> films = FXCollections.observableArrayList();

    @FXML
    private Button btnAjouter;

    @FXML
    private Label btnCreate;

    @FXML
    private Button btnRetour;

    @FXML
    private Button btnSupprimer;

    @FXML
    private Label labelList;

    @FXML
    private Label labelNom;

    @FXML
    private Label labelPlaylist;

    @FXML
    private Label labelPrenom;
    @FXML
    private TableColumn<Film, String> colTitle = null;

    public void returnHome(ActionEvent envent) throws IOException {
        Stage stage = HelloApplication.stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("accueil.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Streaming");
        stage.setScene(scene);
    }

    @FXML
    public void addFilmPlaylist(ActionEvent event) {
/*        TableVPlaylist.setItems(films);
        Film titre = TableVList.getSelectionModel().getSelectedItem();
        films.add(new Film(titre));*/
/*        tableFilm.setItems(films);
        films.add(new Film("Titanic", "07/12/2003"));
        colTitle.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().getTitre()));*/
    }

    @FXML
    public void initialize() {
        tableFilm.setItems(films);
        films.add(new Film("Titanic", "07/12/2003"));
        colTitle.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().getTitre()));
    }
}