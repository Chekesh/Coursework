package com.example.coursework;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class Admin implements Initializable {

    @FXML
    private TextField Users_ID_Text;
    @FXML
    private TextField Users_Password_Text;
    @FXML
    private TextField Users_Name_Text;
    @FXML
    private TextField Users_Birthdate_Text;
    @FXML
    private TextField Users_Phone_Number_Text;
    @FXML
    private TextField Users_Login_Text;
    @FXML
    private TextField Users_Surname_Text;
    @FXML
    private TextField Users_Patronymic_Text;
    @FXML
    private TextField Users_Gender_Text;
    @FXML
    private TextField Users_Role_Text;
    @FXML
    private TableView<User> Users;

    @FXML
    private TableColumn<User, String> Users_Birthdate;

    @FXML
    private TableColumn<User, String> Users_Gender;

    @FXML
    private TableColumn<User, Integer> Users_ID;

    @FXML
    private TableColumn<User, String> Users_Login;

    @FXML
    private TableColumn<User, String> Users_Name;

    @FXML
    private TableColumn<User, String> Users_Password;

    @FXML
    private TableColumn<User, String> Users_Patronymic;

    @FXML
    private TableColumn<User, String> Users_Phone_Number;

    @FXML
    private TableColumn<User, Integer> Users_Role;

    @FXML
    private TableColumn<User, String> Users_Surname;

    @FXML
    private Button Exit;

    @FXML
    private Label Login;

    @FXML
    private Label Name;

    @FXML
    private Label Patronymic;

    @FXML
    private Label Surname;

    Database database = new Database();

    @FXML
    void BtnExit(MouseEvent event) {
        try {
            Transition.TransitionWindows(Name, "Authorization", 600.0, 400.0, false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*ObservableList<Account> list = FXCollections.observableArrayList(
            new Account(1, "Никита", "Чекушин \n ппп \n gg", "Сергеевич", "Chekesh", "1234", "20.09.2005", "М", "89273885180", 1),
            new Account(1, "Никита", "Чекушин", "Сергеевич", "Chekesh", "1234", "20.09.2005", "М", "89273885180", 1),
            new Account(1, "Никита", "Чекушин", "Сергеевич", "Chekesh", "1234", "20.09.2005", "М", "89273885180", 1),
            new Account(1, "Никита", "Чекушин", "Сергеевич", "Chekesh", "1234", "20.09.2005", "М", "89273885180", 1),
            new Account(1, "Никита", "Чекушин", "Сергеевич", "Chekesh", "1234", "20.09.2005", "М", "89273885180", 1),
            new Account(1, "Никита", "Чекушин", "Сергеевич", "Chekesh", "1234", "20.09.2005", "М", "89273885180", 1),
            new Account(1, "Никита", "Чекушин", "Сергеевич", "Chekesh", "1234", "20.09.2005", "М", "89273885180", 1),
            new Account(1, "Никита", "Чекушин", "Сергеевич", "Chekesh", "1234", "20.09.2005", "М", "89273885180", 1),
            new Account(1, "Никита", "Чекушин", "Сергеевич", "Chekesh", "1234", "20.09.2005", "М", "89273885180", 1),
            new Account(1, "Никита", "Чекушин", "Сергеевич", "Chekesh", "1234", "20.09.2005", "М", "89273885180", 1),
            new Account(1, "Никита", "Чекушин", "Сергеевич", "Chekesh", "1234", "20.09.2005", "М", "89273885180", 1),
            new Account(1, "Никита", "Чекушин", "Сергеевич", "Chekesh", "1234", "20.09.2005", "М", "89273885180", 1)
            );*/

    ObservableList<?> list_users;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Login.setText(Database.user.getLogin());
        Name.setText(Database.user.getName());
        Patronymic.setText(Database.user.getPatronymic());
        Surname.setText(Database.user.getSurname());



        /*Users_ID.setCellValueFactory(new PropertyValueFactory<User, Integer>("ID_Users"));
        Users_Login.setCellValueFactory(new PropertyValueFactory<User, String>("Login"));
        Users_Password.setCellValueFactory(new PropertyValueFactory<User, String>("Password"));
        Users_Surname.setCellValueFactory(new PropertyValueFactory<User, String>("Surname"));
        Users_Name.setCellValueFactory(new PropertyValueFactory<User, String>("Name"));
        Users_Patronymic.setCellValueFactory(new PropertyValueFactory<User, String>("Patronymic"));
        Users_Birthdate.setCellValueFactory(new PropertyValueFactory<User, String>("Birthdate"));
        Users_Gender.setCellValueFactory(new PropertyValueFactory<User, String>("Gender"));
        Users_Phone_Number.setCellValueFactory(new PropertyValueFactory<User, String>("Phone_Number"));
        Users_Role.setCellValueFactory(new PropertyValueFactory<User, Integer>("Roles_idRoles"));

        Users.setItems(list_users);*/


    }

    public void Accounts_Click(MouseEvent event) {
        ObservableList<User> list_users = database.Get_All_Users();

        Users_ID.setCellValueFactory(new PropertyValueFactory<User, Integer>("ID_Users"));
        Users_Login.setCellValueFactory(new PropertyValueFactory<User, String>("Login"));
        Users_Password.setCellValueFactory(new PropertyValueFactory<User, String>("Password"));
        Users_Surname.setCellValueFactory(new PropertyValueFactory<User, String>("Surname"));
        Users_Name.setCellValueFactory(new PropertyValueFactory<User, String>("Name"));
        Users_Patronymic.setCellValueFactory(new PropertyValueFactory<User, String>("Patronymic"));
        Users_Birthdate.setCellValueFactory(new PropertyValueFactory<User, String>("Birthdate"));
        Users_Gender.setCellValueFactory(new PropertyValueFactory<User, String>("Gender"));
        Users_Phone_Number.setCellValueFactory(new PropertyValueFactory<User, String>("Phone_Number"));
        Users_Role.setCellValueFactory(new PropertyValueFactory<User, Integer>("Roles_idRoles"));

        Users.setItems(list_users);
    }

    public void User_Delete(MouseEvent event) {

    }

    public void User_Update(MouseEvent event) {

    }

    public void User_Add(MouseEvent event) {
        //Users_
    }
    
}
