package com.daoimpl;

import com.dao.CainiDao;
import com.entities.Caini;
import com.javatosql.ed.ConnectionConfiguration;
import com.mysql.cj.xdevapi.SqlDataResult;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CainiDaoImpl implements CainiDao {
    @Override
    public void insert(Caini caine) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO Caini(Id, Name, Race, AngerScale) VALUES (?,?,?,?)");
            preparedStatement.setInt(1, caine.getId());
            preparedStatement.setString(2, caine.getName());
            preparedStatement.setString(3, caine.getRace());
            preparedStatement.setInt(4, caine.getAngerScale());
            preparedStatement.executeUpdate();
            System.out.println("INSERT INTO Caini(Id, Name, Race, AngerScale) VALUES (?,?,?,?)");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public Caini selectById(int id) {
        Caini caini = new Caini();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM Caini WHERE Id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                caini.setId(resultSet.getInt("Id"));
                caini.setName(resultSet.getString("Name"));
                caini.setRace(resultSet.getString("Race"));
                caini.setAngerScale(resultSet.getInt("AngerScale"));

            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return caini;
    }

    @Override
    public List<Caini> selectAll() {
        List<Caini> caini = new ArrayList<Caini>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Caini");

            while (resultSet.next()) {
                Caini caine = new Caini();
                caine.setId(resultSet.getInt("Id"));
                caine.setName(resultSet.getString("Name"));
                caine.setRace(resultSet.getString("Race"));
                caine.setAngerScale(resultSet.getInt("AngerScale"));

                caini.add(caine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return caini;
    }

    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM Caini WHERE Id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("DELETE FROM Caini WHERE id = ?");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void update(Caini caine, int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE Caini SET " +
                    "Name = ?, Race = ?, AngerScale = ? WHERE Id = ?");
            preparedStatement.setString(1, caine.getName());
            preparedStatement.setString(2, caine.getRace());
            preparedStatement.setInt(3, caine.getAngerScale());
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();

            System.out.println("UPDATE Caini SET " +
                    "Name = ?, Race = ? WHERE Id = ?");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
