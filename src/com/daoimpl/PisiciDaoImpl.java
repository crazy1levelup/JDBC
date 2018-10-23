package com.daoimpl;

import com.dao.PisiciDao;
import com.entities.Pisici;
import com.javatosql.ed.ConnectionConfiguration;
import com.mysql.cj.xdevapi.SqlDataResult;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PisiciDaoImpl implements PisiciDao {

    @Override
    public void insert(Pisici pisici) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO Pisici (Id,Name,Race,SoftnessScale) " +
                    "VALUES (?,?,?,?)");
            preparedStatement.setInt(1, pisici.getId());
            preparedStatement.setString(2, pisici.getName());
            preparedStatement.setString(3, pisici.getRace());
            preparedStatement.setInt(4, pisici.getSoftnessScale());
            preparedStatement.executeUpdate();
            System.out.println("INSERT INTO Pisici (Id,Name,Race,SoftnessScale VALUES (?,?,?,?)");

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
    public Pisici selectById(int id) {
        Pisici pisici = new Pisici();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM Pisici WHERE Id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                pisici.setId(resultSet.getInt("Id"));
                pisici.setName(resultSet.getString("Name"));
                pisici.setRace(resultSet.getString("Race"));
                pisici.setSoftnessScale(resultSet.getInt("SoftnessScale"));
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
        return pisici;
    }

    @Override
    public List<Pisici> selectAll() {
        List<Pisici> pisici = new ArrayList<Pisici>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Pisici");

            while (resultSet.next()) {
                Pisici pisica = new Pisici();
                pisica.setId(resultSet.getInt("Id"));
                pisica.setName(resultSet.getString("Name"));
                pisica.setRace(resultSet.getString("Race"));
                pisica.setSoftnessScale(resultSet.getInt("SoftnessScale"));

                pisici.add(pisica);
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

        return pisici;
    }

    @Override
    public void deleteById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;


        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM Pisici WHERE Id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("DELETE FROM Pisici WHERE Id = ?");

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
    public void update(Pisici pisici, int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE Pisici SET " +
                    " Name = ?, Race = ?, SoftnessScale = ? WHERE Id = ?");

            preparedStatement.setString(1, pisici.getName());
            preparedStatement.setString(2, pisici.getRace());
            preparedStatement.setInt(3, pisici.getSoftnessScale());
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
            System.out.println("UPDATE Pisici SET Id = ?, Name = ?, Race = ?, SoftnessScale = ? WHERE id = ?");
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
