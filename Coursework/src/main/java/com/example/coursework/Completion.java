package com.example.coursework;

import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Completion {
    Database database;
    Completion(Database database){
        this.database = database;
    }


    public void Completion_Suggestion(TableColumn<Suggestion, Integer> ID, TableColumn<Suggestion, String> Name,
                                      TableColumn<Suggestion, String> Cost, TableColumn<Suggestion, String> Time, TableView<Suggestion> suggestion, ComboBox Box_Sigg, String choice){
        ObservableList<Suggestion> list_suggestion = database.Get_All_Suggestion(choice, Box_Sigg);

        ID.setCellValueFactory(new PropertyValueFactory<Suggestion, Integer>("idSuggestion"));
        Name.setCellValueFactory(new PropertyValueFactory<Suggestion, String>("Title"));
        Cost.setCellValueFactory(new PropertyValueFactory<Suggestion, String>("Approximate_Сost"));
        Time.setCellValueFactory(new PropertyValueFactory<Suggestion, String>("Approximate_Time_Performance"));

        suggestion.setItems(list_suggestion);
    }

    public void Completion(Label Login, Label Name, Label Patronymic, Label Surname){
        Login.setText(Database.user.getLogin());
        Name.setText(Database.user.getName());
        Patronymic.setText(Database.user.getPatronymic());
        Surname.setText(Database.user.getSurname());
    }

    public void Completion_HiSug(TableColumn<HiSug, Integer> ID, TableColumn<HiSug, Integer> ID_User, TableColumn<HiSug, Integer> ID_Suggestion,
                                 TableColumn<HiSug, String> Status, TableColumn<HiSug, String> Process, TableColumn<HiSug, String> Cost,
                                 TableColumn<HiSug, String> Date, TableColumn<HiSug, String> Coments, TableView<HiSug> hiSug, String choice){

        ObservableList<HiSug> list_iSug = database.Get_All_History_Suggestion(choice);

        ID.setCellValueFactory(new PropertyValueFactory<HiSug, Integer>("ID"));
        ID_User.setCellValueFactory(new PropertyValueFactory<HiSug, Integer>("ID_User"));
        ID_Suggestion.setCellValueFactory(new PropertyValueFactory<HiSug, Integer>("ID_Suggestion"));
        Status.setCellValueFactory(new PropertyValueFactory<HiSug, String>("Status"));
        Process.setCellValueFactory(new PropertyValueFactory<HiSug, String>("Process"));
        Cost.setCellValueFactory(new PropertyValueFactory<HiSug, String>("Cost"));
        Date.setCellValueFactory(new PropertyValueFactory<HiSug, String>("Date"));
        Coments.setCellValueFactory(new PropertyValueFactory<HiSug, String>("Coments"));

        hiSug.setItems(list_iSug);

    }

    public void Completion_Role(TableColumn<Role,Integer> Role_ID, TableColumn<Role, String> Role_Role, TableView<Role> Role) {
        ObservableList<Role> list_role = database.Get_All_Roles();

        Role_ID.setCellValueFactory(new PropertyValueFactory<Role,Integer>("ID"));
        Role_Role.setCellValueFactory(new PropertyValueFactory<Role, String>("Role"));

        Role.setItems(list_role);
    }


    public void Completion_User(TableColumn<User, Integer> Users_ID, TableColumn<User, String> Users_Login,
                                TableColumn<User, String> Users_Password, TableColumn<User, String> Users_Surname,
                                TableColumn<User, String> Users_Name, TableColumn<User, String> Users_Patronymic,
                                TableColumn<User, String> Users_Birthdate, TableColumn<User, String> Users_Gender,
                                TableColumn<User, String> Users_Phone_Number, TableColumn<User, Integer> Users_Role,
                                TableView<User> Users){//Object obj, String orocle){
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
}
