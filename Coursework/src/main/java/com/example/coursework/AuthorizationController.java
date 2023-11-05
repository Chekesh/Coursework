package com.example.coursework;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AuthorizationController {
    @FXML
    public Label Heading;
    @FXML
    public Button BtnAuthorization;
    @FXML
    private TextField login;

    @FXML
    private TextField password;

     static Database database; // = new Database();



    @FXML
    protected void ClickAuthorization(MouseEvent event) throws SQLException, IOException {

        //Database database = new Database();

        String log = login.getText().trim();
        String pas = password.getText().trim();

        database = new Database();

        if(!log.equals("") && !pas.equals("")) {

            database.Get_Users(log,pas);

            if(database.user.getRoles_idRoles() == 1){
                Transition.TransitionWindows(Heading, "Admin", 900.0, 650.0, true);
            }
            else if(database.user.getRoles_idRoles() == 2){
                Transition.TransitionWindows(Heading, "Worker", 900.0, 650.0, true);
            }
            else if (database.user.getRoles_idRoles() == 3) {
                Transition.TransitionWindows(Heading, "Client", 750.0, 600.0, true);
                //Client.getdatabase(database);
            }
            else{
                Shake shakeLogin = new Shake(login);
                Shake shakePassword = new Shake(password);
                shakeLogin.playAnim();
                shakePassword.playAnim();
            }
        }
        else {
            Transition.Alert("Ошибка","Введите логин и пароль");
        }
    }

    @FXML
    protected void ClickRegistration(MouseEvent event) throws IOException {
        Transition.TransitionWindows(Heading, "Registratinon", 400.0,550.0, false);
    }
}