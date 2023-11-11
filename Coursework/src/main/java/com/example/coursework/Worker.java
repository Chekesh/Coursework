package com.example.coursework;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Worker implements Initializable {
    @FXML
    private TextField SerHan_ID_Text;
    @FXML
    private TextField SerHan_Cost_Text;
    @FXML
    private TextField ProHan_ID_Text;
    @FXML
    private Label Surname;
    @FXML
    private Label Name;
    @FXML
    private Label Patronymic;
    @FXML
    private Label Login;
    @FXML
    private TableView SerHan;
    @FXML
    private TableColumn SerHan_ID;
    @FXML
    private TableColumn SerHan_ID_User;
    @FXML
    private TableColumn SerHan_ID_Services;
    @FXML
    private TableColumn SerHan_Status;
    @FXML
    private TableColumn SerHan_Process;
    @FXML
    private TableColumn SerHan_Cost;
    @FXML
    private TableColumn SerHan_Date;
    @FXML
    private TableColumn SerHan_Coments;
    @FXML
    private TextField SerHan_ID_User_Text;
    @FXML
    private Label SerHan_Name_User;
    @FXML
    private Label SerHan_Surname_User;
    @FXML
    private Label SerHan_Patronymic_User;
    @FXML
    private Label SerHan_Phone_Number_User;
    @FXML
    private TableView SerPro;
    @FXML
    private TableColumn SerPro_ID;
    @FXML
    private TableColumn SerPro_ID_User;
    @FXML
    private TableColumn SerPro_ID_Services;
    @FXML
    private TableColumn SerPro_Status;
    @FXML
    private TableColumn SerPro_Process;
    @FXML
    private TableColumn SerPro_Cost;
    @FXML
    private TableColumn SerPro_Date;
    @FXML
    private TableColumn SerPro_Coments;
    @FXML
    private TextField SerPro_Process_Text;
    @FXML
    private TextField SerPro_ID_Text;
    @FXML
    private TextField SerPro_Cost_Text;
    @FXML
    private TableView ProHan;
    @FXML
    private TableColumn ProHan_ID;
    @FXML
    private TableColumn ProHan_ID_User;
    @FXML
    private TableColumn ProHan_ID_Products;
    @FXML
    private TableColumn ProHan_Status;
    @FXML
    private TableColumn ProHan_Process;
    @FXML
    private TableColumn ProHan_Cost;
    @FXML
    private TableColumn ProHan_Date;
    @FXML
    private TableColumn ProHan_Coments;
    @FXML
    private TextField ProHan_ID_User_Text;
    @FXML
    private Label ProHan_Name_User;
    @FXML
    private Label ProHan_Surname_User;
    @FXML
    private Label ProHan_Patronymic_User;
    @FXML
    private Label ProHan_Phone_Number_User;
    @FXML
    private TextField ProHan_Cost_Text;
    @FXML
    private TableView ProPro;
    @FXML
    private TableColumn ProPro_ID;
    @FXML
    private TableColumn ProPro_ID_User;
    @FXML
    private TableColumn ProPro_ID_Products;
    @FXML
    private TableColumn ProPro_Status;
    @FXML
    private TableColumn ProPro_Process;
    @FXML
    private TableColumn ProPro_Cost;
    @FXML
    private TableColumn ProPro_Date;
    @FXML
    private TableColumn ProPro_Coments;
    @FXML
    private TextField ProPro_Process_Text;
    @FXML
    private TextField ProPro_ID_Text;
    @FXML
    private TextField ProPro_Cost_Text;
    Database database = new Database();

    Completion completion = new Completion(database);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        completion.Completion(Login, Name, Patronymic, Surname);
        //completion.Completion_HiSug(SerHan_ID,SerHan_ID_User, SerHan_ID_Services,SerHan_Status,SerHan_Process,SerHan_Cost,SerHan_Date,SerHan_Coments, SerHan, "SerHan");
        //completion.Completion_HiSug(SerPro_ID,SerPro_ID_User, SerPro_ID_Services,SerPro_Status,SerPro_Process,SerPro_Cost,SerPro_Date,SerPro_Coments, SerPro, "SerPro");
        //completion.Completion_HiSug(ProHan_ID,ProHan_ID_User, ProHan_ID_Products,ProHan_Status,ProHan_Process,ProHan_Cost,ProHan_Date,ProHan_Coments, ProHan, "ProHan");
        //completion.Completion_HiSug(ProPro_ID,ProPro_ID_User, ProPro_ID_Products,ProPro_Status,ProPro_Process,ProPro_Cost,ProPro_Date,ProPro_Coments, ProPro, "ProPro");
    }



    public void BtnExit(MouseEvent event) {
        try {
            Transition.TransitionWindows(Name, "Authorization", 600.0, 400.0, false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void Find(TextField ID_User_Text, Label Name_User, Label Surname_User, Label Patronymic_User, Label Phone_Number_User){
        if(!ID_User_Text.getText().isEmpty()){
            database.Get_Users(ID_User_Text.getText().trim(), "New");
            Name_User.setText(Database.user.getName());
            Surname_User.setText(Database.user.getSurname());
            Patronymic_User.setText(Database.user.getPatronymic());
            Phone_Number_User.setText(Database.user.getPhone_Number());
            //completion.Completion(Name_User, Surname_User, Patronymic_User, Phone_Number_User);
        }else {Transition.Alert("Ошибка", "Введите ID пользователя");}
    }

    public void SerHan_Find(MouseEvent event) {
        Find(SerHan_ID_User_Text, SerHan_Name_User, SerHan_Surname_User, SerHan_Patronymic_User, SerHan_Phone_Number_User);
    }

    public void SerHan_Refused(MouseEvent event) {
        if(!SerHan_ID_Text.getText().isEmpty()){
            database.Update_History(SerHan_ID_Text.getText().trim(),"Отказан",null,null,"Refused","History_Services");
            completion.Completion_HiSug(SerHan_ID,SerHan_ID_User, SerHan_ID_Services,SerHan_Status,SerHan_Process,SerHan_Cost,SerHan_Date,SerHan_Coments, SerHan, "SerHan");
        } else {Transition.Alert("Ошибка", "Ввудите ID");}
    }

    public void SerHan_Accepted(MouseEvent event) {
        if(!SerHan_ID_Text.getText().isEmpty() && !SerHan_Cost_Text.getText().isEmpty()){
            System.out.println(SerHan_ID_Text.getText().trim());
            database.Update_History(SerHan_ID_Text.getText().trim(),"В работе",SerHan_Cost_Text.getText().trim(),null,"Accepted","History_Services");
            System.out.println("2");
            completion.Completion_HiSug(SerHan_ID,SerHan_ID_User, SerHan_ID_Services,SerHan_Status,SerHan_Process,SerHan_Cost,SerHan_Date,SerHan_Coments, SerHan, "SerHan");
            System.out.println("3");
        } else {Transition.Alert("Ошибка", "Введите ID и стоимость");}
    }


    public void SerPro_Update(MouseEvent event) {
        if(!SerPro_ID_Text.getText().isEmpty() && !SerPro_Cost_Text.getText().isEmpty() && !SerPro_Process_Text.getText().isEmpty()){
            if(Float.valueOf(SerPro_Process_Text.getText().trim()) >= 0.0 && Float.valueOf(SerPro_Process_Text.getText().trim()) <= 1.0 ) {
                database.Update_History(SerPro_ID_Text.getText().trim(), "В работе", SerPro_Cost_Text.getText().trim(), SerPro_Process_Text.getText().trim(), "Update", "History_Services");
                completion.Completion_HiSug(SerPro_ID, SerPro_ID_User, SerPro_ID_Services, SerPro_Status, SerPro_Process, SerPro_Cost, SerPro_Date, SerPro_Coments, SerPro, "SerPro");
            }
        } else {Transition.Alert("Ошибка", "Ввудите ID, стоимость и процесс");}
    }

    public void SerPro_Completed(MouseEvent event) {
        if(!SerPro_ID_Text.getText().isEmpty()){
            database.Update_History(SerPro_ID_Text.getText().trim(),"Выполнен",null,null,"Completed","History_Services");
            completion.Completion_HiSug(SerPro_ID,SerPro_ID_User, SerPro_ID_Services,SerPro_Status,SerPro_Process,SerPro_Cost,SerPro_Date,SerPro_Coments, SerPro, "SerPro");
        } else {Transition.Alert("Ошибка", "Ввудите ID");}
    }

    public void ProHan_Find(MouseEvent event) {
        Find(ProHan_ID_User_Text, ProHan_Name_User, ProHan_Surname_User, ProHan_Patronymic_User,ProHan_Phone_Number_User);
    }

    public void ProHan_Refused(MouseEvent event) {
        if(!ProHan_ID_Text.getText().isEmpty()){
            database.Update_History(ProHan_ID_Text.getText().trim(),"Отказан",null,null,"Refused","History_Product");
            completion.Completion_HiSug(ProHan_ID,ProHan_ID_User, ProHan_ID_Products,ProHan_Status,ProHan_Process,ProHan_Cost,ProHan_Date,ProHan_Coments, ProHan, "ProHan");
        } else {Transition.Alert("Ошибка", "Ввудите ID");}
    }

    public void ProHan_Accepted(MouseEvent event) {
        if(!ProHan_ID_Text.getText().isEmpty() && !ProHan_Cost_Text.getText().isEmpty()){
            database.Update_History(ProHan_ID_Text.getText().trim(),"В работе",ProHan_Cost_Text.getText().trim(),null,"Accepted","History_Product");
            completion.Completion_HiSug(ProHan_ID,ProHan_ID_User, ProHan_ID_Products,ProHan_Status,ProHan_Process,ProHan_Cost,ProHan_Date,ProHan_Coments, ProHan, "ProHan");
        } else {Transition.Alert("Ошибка", "Введите ID и стоимость");}
    }

    public void ProPro_Update(MouseEvent event) {
        if(!ProPro_ID_Text.getText().isEmpty() && !ProPro_Cost_Text.getText().isEmpty() && !ProPro_Process_Text.getText().isEmpty()){
            if(Float.valueOf(SerPro_Process_Text.getText().trim()) >= 0.0 && Float.valueOf(SerPro_Process_Text.getText().trim()) <= 1.0 ) {
                database.Update_History(ProPro_ID_Text.getText().trim(), "В работе", ProPro_Cost_Text.getText().trim(), ProPro_Process_Text.getText().trim(), "Update", "History_Product");
                completion.Completion_HiSug(ProPro_ID, ProPro_ID_User, ProPro_ID_Products, ProPro_Status, ProPro_Process, ProPro_Cost, ProPro_Date, ProPro_Coments, ProPro, "ProPro");
            }
        } else {Transition.Alert("Ошибка", "Ввудите ID, стоимость и процесс");}
    }

    public void ProPro_Completed(MouseEvent event) {
        if(!ProPro_ID_Text.getText().isEmpty()){
            database.Update_History(ProPro_ID_Text.getText().trim(),"Выполнен",null,null,"Completed","History_Product");
            completion.Completion_HiSug(ProPro_ID,ProPro_ID_User, ProPro_ID_Products,ProPro_Status,ProPro_Process,ProPro_Cost,ProPro_Date,ProPro_Coments, ProPro, "ProPro");
        } else {Transition.Alert("Ошибка", "Ввудите ID");}
    }

    public void BtnProPro(MouseEvent event) {
        completion.Completion_HiSug(ProPro_ID,ProPro_ID_User, ProPro_ID_Products,ProPro_Status,ProPro_Process,ProPro_Cost,ProPro_Date,ProPro_Coments, ProPro, "ProPro");
        System.out.println("4 табл");
    }

    public void BtnProHan(MouseEvent event) {
        completion.Completion_HiSug(ProHan_ID,ProHan_ID_User, ProHan_ID_Products,ProHan_Status,ProHan_Process,ProHan_Cost,ProHan_Date,ProHan_Coments, ProHan, "ProHan");
        System.out.println("3 табл");
    }

    public void BtnSerPro(MouseEvent event) {
        completion.Completion_HiSug(SerPro_ID,SerPro_ID_User, SerPro_ID_Services,SerPro_Status,SerPro_Process,SerPro_Cost,SerPro_Date,SerPro_Coments, SerPro, "SerPro");
        System.out.println("2 табл");
    }

    public void BtnSerHan(MouseEvent event) {
        completion.Completion_HiSug(SerHan_ID,SerHan_ID_User, SerHan_ID_Services,SerHan_Status,SerHan_Process,SerHan_Cost,SerHan_Date,SerHan_Coments, SerHan, "SerHan");
        System.out.println("1 табл");
    }
}
