package fr.afpa.dao;

import fr.afpa.model.ConnectionBdd;
import fr.afpa.model.Film;
import fr.afpa.model.Playlist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MoviesDao extends Dao<Film> {

    private final Connection connection;

    public MoviesDao(){
        connection = ConnectionBdd.getInstance().connection;
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

/*    public ArrayList<Film> findById(ArrayList<Integer> moviesId){

        int listLengt = moviesId.size();
        ArrayList<Playlist> playlists = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from movies where id in (" + listLengt + ")");
            while(resultSet.next()){
                int movieId = resultSet.getInt("id");

                Playlist playlist = new Playlist(movieId);
                playlists.add(playlist);
                System.out.println(playlist);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return playlists;
    }*/


}
