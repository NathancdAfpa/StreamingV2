package fr.afpa.controller;

import fr.afpa.dao.Dao;
import fr.afpa.dao.MoviesDao;
import fr.afpa.dao.PlaylistDao;
import fr.afpa.model.Film;
import fr.afpa.application.HelloApplication;
import fr.afpa.model.GetUserId;
import fr.afpa.model.Playlist;
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
import java.sql.SQLException;
import java.util.ArrayList;

//controller de la vue Playlist
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
    private Button btnAddMoviesBdd;
    MoviesDao moviesDao = new MoviesDao();
    PlaylistDao playlistDao = new PlaylistDao();

    // création de la methode pour aller a la page d'accueil
    @FXML
    public void returnHome() throws IOException {
        Stage stage = HelloApplication.stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/view/accueil.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Streaming");
        stage.setScene(scene);
    }
    @FXML
    public void goToFormAdd() throws IOException {
        Stage stage = HelloApplication.stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/view/ajoutFilm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Add movies");
        stage.setScene(scene);
    }

    //methode pour ajouter des film a la playlist de l'utilisateur
    @FXML
    public void addFilmPlaylist() throws SQLException {
        tableVPlaylist.setItems(movies);
        Film selectedFilm  = tableFilm.getSelectionModel().getSelectedItem();

        //si un film est déja dans le tableau, ne pas le rajoutait
        if (!tableVPlaylist.getItems().contains(selectedFilm)) {
            tableVPlaylist.getItems().add(selectedFilm);
            playlistDao.addMoviesPlaylist(selectedFilm.getId());
        }
        colPlaylist.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().getTitre()));
    }

    //afficher des film au lancement de la vue
    @FXML
    public void initialize() {
        int idUser = GetUserId.getInstance().getId();
        films.addAll(moviesDao.findAll());
        tableFilm.setItems(films);
        colTitle.setCellValueFactory(celldata -> new SimpleStringProperty(celldata.getValue().getTitre()));

        movies.addAll(playlistDao.getFilmForUser(idUser));
        tableVPlaylist.setItems(movies);
        colPlaylist.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitre()));
    }

    //suprimer les film séléctioner de la playlist utilisateur
    @FXML
    public void delete(){
        Film selectedFilm = tableVPlaylist.getSelectionModel().getSelectedItem();
        movies.remove(selectedFilm);
    }
}