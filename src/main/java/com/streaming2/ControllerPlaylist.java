package com.streaming2;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private final ObservableList<Film> films = FXCollections.observableArrayList();
    private final ObservableList<Film> movies = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Film, String> colTitle = null;
    @FXML
    private TableColumn<Film, String> colPlaylist = null;

    @FXML
    public void returnHome() throws IOException {
        Stage stage = HelloApplication.stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("accueil.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Streaming");
        stage.setScene(scene);
    }

    @FXML
    public void addFilmPlaylist() {
        tableVPlaylist.setItems(movies);
        Film selectedFilm  = tableFilm.getSelectionModel().getSelectedItem();
        if (!tableVPlaylist.getItems().contains(selectedFilm)) {
            tableVPlaylist.getItems().add(selectedFilm);
        }
        colPlaylist.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().getTitre()));
    }

    @FXML
    public void initialize() {
        tableFilm.setItems(films);
        films.add(new Film("Titanic", "07/12/2003"));
        films.add(new Film("Fast and furious", "07/12/1809"));
        films.add(new Film("le voyageur du passer", "07/12/1909"));
        colTitle.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().getTitre()));
    }

    @FXML
    public void delete(){
        Film selectedFilm = tableVPlaylist.getSelectionModel().getSelectedItem();
        movies.remove(selectedFilm);
    }
}