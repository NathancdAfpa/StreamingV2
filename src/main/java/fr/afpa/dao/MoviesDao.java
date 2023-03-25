package fr.afpa.dao;

import fr.afpa.model.ConnectionBdd;
import fr.afpa.model.Film;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MoviesDao extends Dao<Film> {

    private final Connection connection;

    public MoviesDao(){
        connection = ConnectionBdd.getInstance().connection;
    }

    public List<Film> findByUserID(int userId){
        List<Film> films = new ArrayList<>();

        try{
            PreparedStatement movieStatement = connection.prepareStatement("select * from film where user_id = ?");
            movieStatement.setInt(1, userId);

            ResultSet result = movieStatement.executeQuery();
            while (result.next()){
                Film film = new Film();
                film.setTitre(result.getString("titre"));
                film.setDateSortie(result.getString("dateDeSortie"));
                films.add(film);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return films;
    }

    @Override
    public Film find(int id) {
        return null;
    }

    @Override
    public ArrayList<Film> findAll() {
        return null;
    }


}
