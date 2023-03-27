package fr.afpa.dao;

import fr.afpa.model.ConnectionBdd;
import fr.afpa.model.GetUserId;
import fr.afpa.model.Playlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlaylistDao extends Dao<Playlist> {
    private final Connection connection;

    public PlaylistDao(){
        connection = ConnectionBdd.getInstance().connection;
    }

    public void addMoviesPlaylist(int moviesId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("insert into playlist(moviesId, userId) values (?,?);");
        int idUser = GetUserId.getInstance().getId();
        statement.setInt(1 , idUser);
        statement.setInt(2, moviesId);
        ResultSet resultSet = statement.executeQuery();
    }

    @Override
    public Playlist find(int id) {
        return null;
    }

    @Override
    public ArrayList<Playlist> findAll() {
        return null;
    }
}
