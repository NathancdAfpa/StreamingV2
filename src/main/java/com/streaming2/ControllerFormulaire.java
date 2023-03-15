package com.streaming2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
public class ControllerFormulaire {

        @FXML
        private Button ajouter;

        @FXML
        private Label date;

        @FXML
        private Label labelFormulaire;

        @FXML
        private TextField tfDate;

        @FXML
        private TextField tfTitre;

        @FXML
        private Label titre;

        @FXML
        private TableView<Film> tableView;
        private ObservableList<Film> films = FXCollections.observableArrayList();

        @FXML
        void ajoutList(ActionEvent event) {

                Film new1 = new Film(tfTitre.getText());
                films.add(new1);
                tableView.setItems(films);
                tfTitre.clear();

        }


        public Button getAjouter() {
                return ajouter;
        }

        public void setAjouter(Button ajouter) {
                this.ajouter = ajouter;
        }

        public Label getDate() {
                return date;
        }

        public void setDate(Label date) {
                this.date = date;
        }

        public Label getLabelFormulaire() {
                return labelFormulaire;
        }

        public void setLabelFormulaire(Label labelFormulaire) {
                this.labelFormulaire = labelFormulaire;
        }

        public TextField getTfDate() {
                return tfDate;
        }

        public void setTfDate(TextField tfDate) {
                this.tfDate = tfDate;
        }

        public TextField getTfTitre() {
                return tfTitre;
        }

        public void setTfTitre(TextField tfTitre) {
                this.tfTitre = tfTitre;
        }

        public Label getTitre() {
                return titre;
        }

        public void setTitre(Label titre) {
                this.titre = titre;
        }
}


