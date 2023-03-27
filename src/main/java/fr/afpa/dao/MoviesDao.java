package fr.afpa.dao;

import fr.afpa.model.ConnectionBdd;
import fr.afpa.model.Film;

import java.sql.*;
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
                film.setDateSortie(result.getDate("dateDeSortie"));
                films.add(film);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return films;
    }

    public void addMovies(String title, Date publiDate){
        try{
            PreparedStatement statement = connection.prepareStatement("insert into movies (title, publiDate) values (?,?)");
            statement.setString(1, title);
            statement.setDate(2, publiDate);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Film find(int id) {
        return null;
    }

    @Override
    public ArrayList<Film> findAll() {
        ArrayList<Film> films = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from movies");
            while (result.next()){
                String title = result.getString("title");
                Date publiDate = result.getDate("publiDate");
                int id = result.getInt("id");

                Film film = new Film(title, publiDate, id);
                films.add(film);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return films;

    }


}
