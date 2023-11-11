package com.example.coursework;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

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
    public void New_And_Update_Users(User new_user, String sender)/*String Login, String Password,
                          String Surname, String Name, String Patronymic,
                          String Birthdate, String Gender, String Phone_Number,
                          String Roles_idRoles)*/ {
        request = null;
        String error = null;
        String massag = null;
        if (sender.equals("Registratinon")) {
            request = "INSERT INTO users(Login, Password, Surname, Name, Patronymic, Birthdate, Gender, Phone_Number, Roles_idRoles) VALUE(?,?,?,?,?,?,?,?,?)";
            error = "Придумайте другой логин, этот уже занят";
            massag = "Данные добавленны";
        } else if (sender.equals("Admin")) {
            request = "INSERT INTO users(Login, Password, Surname, Name, Patronymic, Birthdate, Gender, Phone_Number, Roles_idRoles, ID_Users) VALUE(?,?,?,?,?,?,?,?,?,?)";
            error = "Поменяйте логин или ID, эти столбцы должны быть уникальны";
            massag = "Данные добавленны";
        } else if (sender.equals("Admin_Update")) {
            request = "UPDATE USERS SET Login=?, Password=?, Surname=?, Name=?, Patronymic=?, Birthdate=?, Gender=?, Phone_Number=?, Roles_idRoles=? WHERE ID_Users = ?";
            error = "Поменяйте логин этот столбец должен быть уникальным";
            massag = "Данные успешно заменены";
        }
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
            if (sender.equals("Admin") || sender.equals("Admin_Update")) {
                prSt.setString(10, String.valueOf(new_user.getID_Users()));
            }
            prSt.executeUpdate();
            Transition.Alert("Успешно", massag);
        } catch (SQLException e) {
            Transition.Alert("Ошибка", error);
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            Transition.Alert("Ошибка", error);
            //throw new RuntimeException(e);
        }
    }

    //ОТНОСИТСЯ К ПОЛЬЗОВАТЕЛЮ
    public void Get_Users(String Log_or_ID, String Pass_or_cheked) {
        ResultSet resultSet = null;
        if (Pass_or_cheked.equals("New")) {
            request = "SELECT * FROM users WHERE ID_Users = ?";
        } else {
            request = "SELECT * FROM users WHERE Login = ? AND Password = ?";
        }
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(request);
            prSt.setString(1, Log_or_ID);
            if (!Pass_or_cheked.equals("New")) {
                prSt.setString(2, Pass_or_cheked);
            }
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


    // ОТНОСИТСЯ К USER
    /*public void Update_Users(User user, ) {
        request = "UPDATE USERS SET Login=?, Password=?, Surname=?, Name=?, Patronymic=?, Birthdate=?, Gender=?, Phone_Number=?, Roles_idRoles=? WHERE ID_Users = ?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(request);
            prSt.setString(1, user.getLogin());
            prSt.setString(2, user.getPassword());
            prSt.setString(3, user.getSurname());
            prSt.setString(4, user.getName());
            prSt.setString(5, user.getPatronymic());
            prSt.setString(6, user.getBirthdate());
            prSt.setString(7, user.getGender());
            prSt.setString(8, user.getPhone_Number());
            prSt.setString(9, String.valueOf(user.getRoles_idRoles()));
            prSt.setString(10, String.valueOf(user.getID_Users()));
            prSt.executeUpdate();

            Transition.Alert("Успешно", "Данные успешно заменены");
        } catch (SQLException e) {
            Transition.Alert("Ошибка", "Такого ID нет");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            Transition.Alert("Ошибка", "Такого ID нет");
            throw new RuntimeException(e);
        }
    }*/


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

    // ОТНОСИТСЯ К ЗАКАЗАМ

    public ObservableList<Suggestion> Get_All_Suggestion(String choice, ComboBox comboBox) {
        if (choice == "Services") {
            request = "SELECT * FROM services";
        } else if (choice == "Products") {
            request = "SELECT * FROM Products";
        }
        ObservableList<Suggestion> list_suggestion = FXCollections.observableArrayList();
        List<String> Box = new ArrayList<>();
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(request);

            ResultSet resultSet = prSt.executeQuery();
            String box_strok;
            //int i =0;
            while (resultSet.next()) {
                box_strok = resultSet.getString("Title");
                list_suggestion.add(new Suggestion(resultSet.getInt("id" + choice), box_strok,
                        resultSet.getString("Approximate_Сost"), resultSet.getString("Approximate_Time_Performance")));
                if (!Box.contains(box_strok)) {
                    Box.add(box_strok);
                }
                //System.out.println(list_users.get(0).getID_Users());
                //System.out.println(list_users.get(0).getName());
                //i++;
            }
            comboBox.getItems().addAll(Box);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list_suggestion;
    }


    public void New_And_Update_Suggestion(Suggestion suggestion, String sender)/*String Login, String Password,
                          String Surname, String Name, String Patronymic,
                          String Birthdate, String Gender, String Phone_Number,
                          String Roles_idRoles)*/ {
        request = null;
        String error = null;
        String massag = null;
        if (sender.equals("Services")) {
            request = "INSERT INTO services(Title, Approximate_Сost, Approximate_Time_Performance, idServices) VALUE(?,?,?,?)";
            error = "Поменяйте Название или ID, эти столбцы должны быть уникальны";
            massag = "Данные добавленны";
        } else if (sender.equals("Products")) {
            request = "INSERT INTO products(Title, Approximate_Сost, Approximate_Time_Performance, idProducts) VALUE(?,?,?,?)";
            error = "Поменяйте Название или ID, эти столбцы должны быть уникальны";
            massag = "Данные добавленны";
        } else if (sender.equals("Services_Update")) {
            request = "UPDATE services SET Title=?, Approximate_Сost=?, Approximate_Time_Performance=? WHERE idServices = ?";
            error = "Ошибка";
            massag = "Данные успешно обнавлены";
        } else if (sender.equals("Products_Update")) {
            request = "UPDATE products SET Title=?, Approximate_Сost=?, Approximate_Time_Performance=? WHERE idProducts = ?";
            error = "Ошибка";
            massag = "Данные успешно обнавлены";
        }
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(request);
            prSt.setString(1, suggestion.getTitle());
            prSt.setString(2, suggestion.getApproximate_Сost());
            prSt.setString(3, suggestion.getApproximate_Time_Performance());
            prSt.setString(4, String.valueOf(suggestion.getIdSuggestion()));
            prSt.executeUpdate();
            Transition.Alert("Успешно", massag);
        } catch (SQLException e) {
            Transition.Alert("Ошибка", error);
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            Transition.Alert("Ошибка", error);
            throw new RuntimeException(e);
        }
    }


    //ОТНОСИТСЯ К ИСТОРИИ
    public void New_And_Update_History(HiSug hiSug, /*String Users_idUsers,
                            String Suggestion_idSuggestion, String Status, String Process,
                            String Real_Cost, String Order_Date, String Coments,*/ String choice) {
        //request = null;
        //System.out.println(choice);
        String error = null;
        String massag = null;
        if (choice.equals("Services_Users")) {
            request = "INSERT INTO History_Services(Users_idUsers, Services_idServices, Status, Process, Real_Cost, Order_Date, Coments) VALUE (?,?,?,?,?,?,?)";
        } else if (choice.equals("Products_Users")) {
            request = "INSERT INTO History_Product(Users_idUsers, Products_idProducts, Status, Process, Real_Cost, Order_Date, Coments) VALUE (?,?,?,?,?,?,?)";
        } else if (choice.equals("Services_Admin")) {
            request = "INSERT INTO History_Services(Users_idUsers, Services_idServices, Status, Process, Real_Cost, Order_Date, Coments, ID_Order) VALUE (?,?,?,?,?,?,?,?)";
            massag = "Данные успешно добавлены";
            error = "Такой ID уже существует";
        } else if (choice.equals("Product_Admin")) {
            request = "INSERT INTO History_Product(Users_idUsers, Products_idProducts, Status, Process, Real_Cost, Order_Date, Coments, ID_Order) VALUE (?,?,?,?,?,?,?,?)";
            massag = "Данные успешно добавлены";
            error = "Проверте введёные данные";
        } else if (choice.equals("Services_Update")) {
            request = "UPDATE History_Services SET Users_idUsers=?, Services_idServices=?, Status=?, Process=?, Real_Cost=?, Order_Date=?, Coments=? WHERE ID_Order = ?";
            massag = "Данные успешно обновлены";
            error = "Проверте введёные данные";
        } else if (choice.equals("Product_Update")) {
            request = "UPDATE History_Product SET Users_idUsers=?, Products_idProducts=?, Status=?, Process=?, Real_Cost=?, Order_Date=?, Coments=? WHERE ID_Order = ?";
            massag = "Данные успешно обновлены";
            error = "Проверте введёные данные";
        } else if (choice.equals("Services_Update_Refused")) {
            request = "UPDATE History_Services SET Status=? WHERE ID_Order = ?";
        }
        try {
            if (!choice.equals("Services_Update_Refused")) {
                PreparedStatement prSt = getDbConnection().prepareStatement(request);
                System.out.println(hiSug.getProcess());
                prSt.setString(1, String.valueOf(hiSug.getID_User()));
                System.out.println(hiSug.getProcess());
                prSt.setString(2, String.valueOf(hiSug.getID_Suggestion()));
                System.out.println(hiSug.getProcess());
                prSt.setString(3, hiSug.getStatus());
                prSt.setString(4, hiSug.getProcess());
                prSt.setString(5, hiSug.getCost());
                prSt.setString(6, hiSug.getDate());
                prSt.setString(7, hiSug.getComents());
                if (!choice.equals("Services_Users") && !choice.equals("Products_Users")) {
                    prSt.setString(8, String.valueOf(hiSug.getID()));
                }
                prSt.executeUpdate();
                if (!choice.equals("Services_Users") && !choice.equals("Products_Users")) {
                    Transition.Alert("Успешно", massag);
                }
            } else {

            }
        } catch (SQLException e) {
            Transition.Alert("Ошибка", "Проверте введёные данные");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            Transition.Alert("Ошибка", "Проверте введёные данные");
            throw new RuntimeException(e);
        }
    }

    public void Update_History(String ID_order, String status, String Real_Cost, String Process, String choice, String table) {
        if (choice.equals("Refused") || choice.equals("Completed")) {
            request = "UPDATE "+ table + " SET Status=? WHERE ID_Order = ?";
        } else if (choice.equals("Accepted")) {
            request = "UPDATE "+ table + " SET Status=?, Real_Cost = ? WHERE ID_Order = ?";
        } else if (choice.equals("Update")) {
            request = "UPDATE "+ table + " SET Status=?, Real_Cost = ?, Process = ? WHERE ID_Order = ?";
        }
        try {
            int i = 2;
            PreparedStatement prSt = getDbConnection().prepareStatement(request);
            prSt.setString(1, status);
            if(choice.equals("Accepted")){
                prSt.setString(i, Real_Cost);
                i++;
            }
            if(choice.equals("Update")){
                prSt.setString(i, Real_Cost);
                i++;
                prSt.setString(i, Process);
                i++;
            }
            prSt.setString(i, ID_order);
            prSt.executeUpdate();
        } catch (SQLException e) {
            Transition.Alert("Ошибка", "Проверте введёные данные");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            Transition.Alert("Ошибка", "Проверте введёные данные");
            throw new RuntimeException(e);
        }
    }

    //ОТНОСИТСЯ К ИСТОРИЯМ
    public ObservableList<HiSug> Get_All_History_Suggestion(String choice) {//, ComboBox comboBox) {
        //ResultSet resultSet = null;

        ObservableList<HiSug> list_hiSug = FXCollections.observableArrayList();
        //List<String> Box = new ArrayList<>();
        //request = null;
        String sug = null;
        if (choice.equals("Services")) {
            request = "SELECT * FROM History_Services";
            sug = "Services_idServices";
        } else if (choice.equals("Products")) {
            request = "SELECT * FROM History_Product";
            sug = "Products_idProducts";
        } else if (choice.equals("SerHan") || choice.equals("SerPro")) {
            request = "SELECT * FROM History_Services WHERE status = ?";
            sug = "Services_idServices";
        } else if (choice.equals("ProHan") || choice.equals("ProPro")) {
            request = "SELECT * FROM History_Product WHERE status = ?";
            sug = "Products_idProducts";
        }
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(request);
            if (choice.equals("SerHan") || choice.equals("ProHan")) {
                prSt.setString(1, "В обработке");
            } else if (choice.equals("SerPro") || choice.equals("ProPro")) {
                prSt.setString(1, "В работе");
            }
            ResultSet resultSet = prSt.executeQuery();
            System.out.println(resultSet);
            //String box_strok;
            //int chet=0;
            while (resultSet.next()) {
                //box_strok = resultSet.getString("Status").trim();
                list_hiSug.add(new HiSug(resultSet.getInt("ID_Order"), resultSet.getInt("Users_idUsers"),
                        resultSet.getInt(sug), resultSet.getString("Status").trim(), //box_strok,
                        resultSet.getString("Process"), resultSet.getString("Real_Cost"),
                        resultSet.getString("Order_Date"), resultSet.getString("Coments")));
                //if (!Box.contains(box_strok)) {
                //    Box.add(box_strok);
                //}
                //comboBox.getItems().add(resultSet.getString("Status"));
                //System.out.println(list_users.get(0).getID_Users());
                //System.out.println(list_users.get(0).getName());
                //i++;
            }
            //comboBox.getItems().addAll(Box);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list_hiSug;
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

    // ОТНОСИТСЯ К РОЛЯМ
    public void New_And_Update_Roles(Role role, String choice) {
        String massag = null;
        if (choice.equals("Roles_ADD")) {
            request = "INSERT INTO Roles(Name, idRoles) VALUE (?,?)";
            massag = "Данные добавлены";
        } else if (choice.equals("Roles_Update")) {
            request = "UPDATE Roles SET Name=? WHERE idRoles=?";
            massag = "Данные обновлены";
        }
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(request);
            prSt.setString(1, role.Role);
            prSt.setString(2, String.valueOf(role.ID));
            prSt.executeUpdate();
            Transition.Alert("Успешно", massag);
        } catch (SQLException e) {
            Transition.Alert("Ошибка", "Проверте введёные данные");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ;
    }

    //ОТНОСИТСЯ К РОЛЯМ

    public ObservableList<Role> Get_All_Roles() {
        ObservableList<Role> list_role = FXCollections.observableArrayList();
        request = "SELECT * FROM roles";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(request);

            ResultSet resultSet = prSt.executeQuery();
            while (resultSet.next()) {
                list_role.add(new Role(resultSet.getInt("idRoles"), resultSet.getString("Name")));
                //System.out.println(list_users.get(0).getID_Users());
                //System.out.println(list_users.get(0).getName());
                //i++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list_role;
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

    //ОТНОСИТСЯ КО ВСЕМУ
    public int Get_Max(String choice) {
        int max = 0;
        if (choice.equals("History_Services")) {
            request = "SELECT max(ID_Order) AS max FROM History_Services";
        } else if (choice.equals("History_Product")) {
            request = "SELECT max(ID_Order) AS max FROM History_Product";
        } else if (choice.equals("Users")) {
            request = "SELECT max(ID_Users) AS max FROM Users";
        } else if (choice.equals("Services")) {
            request = "SELECT max(idServices) AS max FROM Services";
        } else if (choice.equals("Products")) {
            request = "SELECT max(idProducts) AS max FROM Products";
        }
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(request);
            ResultSet resultSet = prSt.executeQuery();
            while (resultSet.next()) {
                max = resultSet.getInt("max");
            }
        } catch (SQLException e) {
            Transition.Alert("Ошибка", "Ошибка");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            Transition.Alert("Ошибка", "Ошибка");
            throw new RuntimeException(e);
        }
        return max;
    }

    // ОТНОСИТСЯ КО ВСЕМ
    public void Delete(String ID, String choice) {
        if (choice.equals("Users")) {
            request = "DELETE FROM Users WHERE ID_Users = ?";
        } else if (choice.equals("Services")) {
            request = "DELETE FROM Services WHERE idServices = ?";
        } else if (choice.equals("Products")) {
            request = "DELETE FROM Products WHERE idProducts = ?";
        } else if (choice.equals("History_Services")) {
            request = "DELETE FROM History_Services WHERE ID_Order = ?";
        } else if (choice.equals("History_Product")) {
            request = "DELETE FROM History_Product WHERE ID_Order = ?";
        } //else if (choice.equals("Roles")) {
        // request = "DELETE FROM Roles WHERE idRoles = ?";
        //}
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(request);
            prSt.setString(1, ID);
            prSt.executeUpdate();
            Transition.Alert("Успешно", "Данные успешно удалены");
        } catch (SQLException e) {
            Transition.Alert("Ошибка", "Такого ID нет");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            Transition.Alert("Ошибка", "Такого ID нет");
            throw new RuntimeException(e);
        }
    }
}
