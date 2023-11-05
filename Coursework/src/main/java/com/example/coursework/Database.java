package com.example.coursework;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Database {
    protected String dbHost = "localhost";
    protected String dbPort = "3306";
    protected String dbUser = "root";
    protected String dbPass = "1234";
    protected String dbName = "artsite58";

    protected static User user = new User();

    protected static Suggestion suggestion = new Suggestion();

    Connection dbConnection = null;

    String request;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

    //ОТНОСИТСЯ К ПОЛЬЗОВАТЕЛЮ
    public void New_Users(User new_user)/*String Login, String Password,
                          String Surname, String Name, String Patronymic,
                          String Birthdate, String Gender, String Phone_Number,
                          String Roles_idRoles)*/ {

        request = "INSERT INTO users(Login, Password, Surname, Name, Patronymic, Birthdate, Gender, Phone_Number, Roles_idRoles) VALUE(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(request);
            prSt.setString(1, new_user.getLogin());
            prSt.setString(2, new_user.getPassword());
            prSt.setString(3, new_user.getSurname());
            prSt.setString(4, new_user.getName());
            prSt.setString(5, new_user.getPatronymic());
            prSt.setString(6, new_user.getBirthdate());
            prSt.setString(7, new_user.getGender());
            prSt.setString(8, new_user.getPhone_Number());
            prSt.setString(9, String.valueOf(new_user.getRoles_idRoles()));

            prSt.executeUpdate();
        } catch (SQLException e) {
            Transition.Alert("Ошибка", "Придумайте другой логин, этот уже занят");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            Transition.Alert("Ошибка", "Придумайте другой логин, этот уже занят");
            //throw new RuntimeException(e);
        }
    }

    //ОТНОСИТСЯ К ПОЛЬЗОВАТЕЛЮ
    public void Get_Users(String Login, String Password) {
        ResultSet resultSet = null;

        request = "SELECT * FROM users WHERE Login = ? AND Password = ?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(request);
            prSt.setString(1, Login);
            prSt.setString(2, Password);
            resultSet = prSt.executeQuery();
            while (resultSet.next()) {
                user.setID_Users(resultSet.getInt("ID_Users"));
                user.setLogin(resultSet.getString("Login"));
                user.setPassword(resultSet.getString("Password"));
                user.setSurname(resultSet.getString("Surname"));
                user.setName(resultSet.getString("Name"));
                user.setPatronymic(resultSet.getString("Patronymic"));
                user.setBirthdate(resultSet.getString("Birthdate"));
                user.setGender(resultSet.getString("Gender"));
                user.setPhone_Number(resultSet.getString("Phone_Number"));
                user.setRoles_idRoles(resultSet.getInt("Roles_idRoles"));
            }
        } catch (SQLException e) {
            Transition.Alert("Ошибка", "Ошибка");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            Transition.Alert("Ошибка", "Ошибка");
            throw new RuntimeException(e);
        }
        //return resultSet;
    }

    // ОТНОСИТСЯ К ПОЛЬЗОВАТЕЛЮ

    public ObservableList<User> Get_All_Users() {
        request = "SELECT * FROM users";
        ObservableList<User> list_users = FXCollections.observableArrayList();

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(request);

            ResultSet resultSet = prSt.executeQuery();
            //int i =0;
            while (resultSet.next()) {
                list_users.add(new User(resultSet.getInt("ID_Users"), resultSet.getString("Login"),
                        resultSet.getString("Password"), resultSet.getString("Surname"),
                        resultSet.getString("Name"), resultSet.getString("Patronymic"),
                        resultSet.getString("Birthdate"), resultSet.getString("Gender"),
                        resultSet.getString("Phone_Number"), resultSet.getInt("Roles_idRoles")));
                //System.out.println(list_users.get(0).getID_Users());
                //System.out.println(list_users.get(0).getName());
                //i++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list_users;
    }


    //ОТНОСИТСЯ К ИСТОРИИ
    public void New_History(String Users_idUsers,
                            String Suggestion_idSuggestion, String Status, String Process,
                            String Real_Cost, String Order_Date, String Coments, String choice) {
        //request = null;
        System.out.println(choice);
        if (choice.equals("Services")) {
            request = "INSERT INTO History_Services(Users_idUsers, Services_idServices, Status, Process, Real_Cost, Order_Date, Coments) VALUE (?,?,?,?,?,?,?)";
        } else if (choice.equals("Products")) {
            request = "INSERT INTO History_Product(Users_idUsers, Products_idProducts, Status, Process, Real_Cost, Order_Date, Coments) VALUE (?,?,?,?,?,?,?)";
        }
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(request);
            prSt.setString(1, Users_idUsers);
            prSt.setString(2, Suggestion_idSuggestion);
            prSt.setString(3, Status);
            prSt.setString(4, Process);
            prSt.setString(5, Real_Cost);
            prSt.setString(6, Order_Date);
            prSt.setString(7, Coments);

            prSt.executeUpdate();
        } catch (SQLException e) {
            Transition.Alert("Ошибка", "Ошибка");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            Transition.Alert("Ошибка", "Ошибка");
            throw new RuntimeException(e);
        }
    }

    //ОТНОСИТСЯ К ИСТОРИИ
    public int Get_Max_History(String choice) {
        int max = 0;
        if (choice.equals("Services")) {
            request = "SELECT max(ID_Order) FROM History_Services";
        } else if (choice.equals("Products")) {
            request = "SELECT max(ID_Order) FROM History_Product";
        }
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(request);
            ResultSet resultSet = prSt.executeQuery();
            while (resultSet.next()) {
                max = resultSet.getInt("max(ID_Order)");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return max;
    }


    //ОТНОСИТСЯ К ЗАКАЗАМ
    public void Get_Suggestion(String choice, String Title) {
        //ResultSet resultSet = null;
        request = "SELECT * FROM " + choice + " WHERE Title = ?";
        //System.out.println(Title);
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(request);
            prSt.setString(1, Title);
            ResultSet resultSet = prSt.executeQuery();

            while (resultSet.next()) {
                suggestion.idSuggestion = resultSet.getInt("id" + choice);
                suggestion.Title = resultSet.getString("Title");
                suggestion.Approximate_Сost = resultSet.getString("Approximate_Сost");
                suggestion.Approximate_Time_Performance = resultSet.getString("Approximate_Time_Performance");
            }


        } catch (SQLException e) {
            Transition.Alert("Ошибка", "Ошибка");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            Transition.Alert("Ошибка", "Ошибка");
            throw new RuntimeException(e);
        }
    }

    //ОТДЕЛЬНЫЙ
    public List<String> Get_Title(String choice) {
        //ResultSet resultSet = null;
        //List<String> Title = new ArrayList<>();
        //List<String> ID_Order = new ArrayList<>();
        List<String> list = new ArrayList<>();//(Arrays.asList(Title, ID_Order));

        //request = null;
        if (choice.equals("Services")) {
            request = "SELECT ID_Order, Title FROM History_Services INNER JOIN Services on History_Services.Services_idServices=Services.idServices WHERE users_idusers = ? ORDER BY id_order";
        } else if (choice.equals("Products")) {
            request = "SELECT ID_Order, Title FROM History_Product INNER JOIN Products on History_Product.Products_idProducts=Products.idProducts WHERE users_idusers = ? ORDER BY id_order";
        }
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(request);
            prSt.setString(1, String.valueOf(user.getID_Users()));
            ResultSet resultSet = prSt.executeQuery();
            //System.out.println(resultSet);
            while (resultSet.next()) {
                list.add(resultSet.getString("ID_Order") + " - " + (resultSet.getString("Title")));
                //Title.add(resultSet.getString("Title"));
                //ID_Order.add(resultSet.getString("ID_Order"));
                //list.get(0).add(resultSet.getString("Title"));
                //list.get(1).add(resultSet.getString("ID_Order"));
            }
            return list;
        } catch (SQLException e) {
            Transition.Alert("Ошибка", "Ошибка");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            Transition.Alert("Ошибка", "Ошибка");
            throw new RuntimeException(e);
        }

    }

    //ОТНОСИТСЯ К ИСТОРИЯМ
    public List<String> Get_History_Suggestion(String choice, String Id_order) {
        //ResultSet resultSet = null;

        List<String> list = new ArrayList<>();

        //request = null;
        if (choice.equals("Services")) {
            request = "SELECT * FROM History_Services WHERE Id_order=?";
        } else if (choice.equals("Products")) {
            request = "SELECT * FROM History_Product WHERE Id_order=?";
        }
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(request);
            prSt.setString(1, String.valueOf(Id_order));
            ResultSet resultSet = prSt.executeQuery();
            System.out.println(resultSet);
            while (resultSet.next()) {
                list.add(resultSet.getString("Real_Cost"));
                list.add(resultSet.getString("Order_Date"));
                list.add(resultSet.getString("Process"));
            }
            return list;
        } catch (SQLException e) {
            Transition.Alert("Ошибка", "Ошибка");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            Transition.Alert("Ошибка", "Ошибка");
            throw new RuntimeException(e);
        }
    }
}
