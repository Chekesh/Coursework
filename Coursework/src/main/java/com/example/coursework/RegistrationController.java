package com.example.coursework;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class RegistrationController {

    @FXML
    public Label Back;

    @FXML
    private DatePicker Birth_Date;

    @FXML
    private TextField Patronymic;

    @FXML
    private RadioButton Gender_Man;

    @FXML
    private RadioButton Gender_Woman;

    @FXML
    private TextField Login;

    @FXML
    private TextField Name;

    @FXML
    private TextField Password_First;

    @FXML
    private TextField Password_Second;

    @FXML
    private TextField Surname;

    @FXML
    private TextField Phone_Number;

    private String gender = null;

    @FXML
    void ClickAuthorization(MouseEvent event) {
        if(!Surname.getText().isEmpty() && !Name.getText().isEmpty() && !Patronymic.getText().isEmpty()
                && !Birth_Date.getValue().toString().isEmpty()){
            if(Password_First.getText().trim().length()>=5) {
                if (Password_First.getText().trim().equals(Password_Second.getText().trim())) {
                    if (Phone_Number.getText().trim().matches("^((\\+7|7|8)+([0-9]){10})$")){
                        if(Gender_Man.isSelected()){
                            gender = "Мужской";
                            databasesAndTransition();
                        }
                        else if(Gender_Woman.isSelected()){
                            gender = "Женский";
                            databasesAndTransition();
                        }
                        else{ Transition.Alert("Ошибка","Выберете пол");}
                    }
                    else{ Transition.Alert("Ошибка","Телефон введен не правильно");}
                }
                else{ Transition.Alert("Ошибка","Пароли не совпадают");}
            }
            else{ Transition.Alert("Ошибка","Пароль должен содержать 5 и больше символов");}
        }
        else{ Transition.Alert("Ошибка","Заполните поля");}
    }

    void databasesAndTransition(){
        Database database = new Database();
        User new_user = new User(1, Login.getText().trim(), Password_Second.getText().trim(), Surname.getText().trim(),
                Name.getText().trim(), Patronymic.getText().trim(), Birth_Date.getValue().toString().trim(), gender,
                Phone_Number.getText().trim(), 3);

        database.New_Users(new_user);

        try {
            Transition.TransitionWindows(Back, "Authorization", 600.0, 400.0, false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void ClickBack(MouseEvent event) throws IOException {
        Transition.TransitionWindows(Back, "Authorization", 600.0, 400.0, false);
    }

}
