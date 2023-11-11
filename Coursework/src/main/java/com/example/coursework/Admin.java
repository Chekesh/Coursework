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
    private TableView<Role> Role;
    @FXML
    private TableColumn<Role, Integer> Role_ID;
    @FXML
    private TableColumn<Role, String> Role_Role;
    @FXML
    private TextField Role_ID_Text;
    @FXML
    private TextField Role_Role_Text;
    @FXML
    private TableColumn<HiSug, Integer> HiSer_ID;
    @FXML
    private TableColumn<HiSug, Integer> HiSer_ID_User;
    @FXML
    private TableColumn<HiSug, Integer> HiSer_ID_Services;
    @FXML
    private TableColumn<HiSug, String> HiSer_Status;
    @FXML
    private TableColumn<HiSug, String> HiSer_Process;
    @FXML
    private TableColumn<HiSug, String> HiSer_Cost;
    @FXML
    private TableColumn<HiSug, String> HiSer_Date;
    @FXML
    private TableColumn<HiSug, String> HiSer_Coments;
    @FXML
    private TableView<HiSug> HiSer;
    @FXML
    private TextField HiSer_ID_Text;
    @FXML
    private TextField HiSer_ID_Services_Text;
    @FXML
    private TextField HiSer_Process_Text;
    @FXML
    private DatePicker HiSer_Date_Text;
    @FXML
    private TextField HiSer_ID_User_Text;
    @FXML
    private ComboBox HiSer_Status_Text;
    @FXML
    private TextField HiSer_Cost_Text;
    @FXML
    private TextArea HiSer_Coments_Text;
    @FXML
    private TableColumn<HiSug, Integer> HiProd_ID;
    @FXML
    private TableColumn<HiSug, Integer> HiProd_ID_User;
    @FXML
    private TableColumn<HiSug, Integer> HiProd_ID_Products;
    @FXML
    private TableColumn<HiSug, String> HiProd_Status;
    @FXML
    private TableColumn<HiSug, String> HiProd_Process;
    @FXML
    private TableColumn<HiSug, String> HiProd_Cost;
    @FXML
    private TableColumn<HiSug, String> HiProd_Date;
    @FXML
    private TableColumn<HiSug, String> HiProd_Coments;
    @FXML
    private TableView<HiSug> HiProd;
    @FXML
    private TextField HiProd_ID_Text;
    @FXML
    private TextField HiProd_ID_Products_Text;
    @FXML
    private TextField HiProd_Process_Text;
    @FXML
    private DatePicker HiProd_Date_Text;
    @FXML
    private TextField HiProd_ID_User_Text;
    @FXML
    private ComboBox HiProd_Status_Text;
    @FXML
    private TextField HiProd_Cost_Text;
    @FXML
    private TextArea HiProd_Coments_Text;
    @FXML
    private TableView<Suggestion> Products;
    @FXML
    private TextField Services_ID_Text;
    @FXML
    private ComboBox Services_Name_Text;
    @FXML
    private TextField Services_Cost_Text;
    @FXML
    private TextField Services_Time_Text;
    @FXML
    private TextField Products_ID_Text;
    @FXML
    private ComboBox Products_Name_Text;
    @FXML
    private TextField Products_Cost_Text;
    @FXML
    private TextField Products_Time_Text;
    @FXML
    private TableColumn<Suggestion, Integer> Products_ID;
    @FXML
    private TableColumn<Suggestion, String> Products_Name;
    @FXML
    private TableColumn<Suggestion, String> Products_Cost;
    @FXML
    private TableColumn<Suggestion, String> Products_Time;
    @FXML
    private TableView<Suggestion> Services;
    @FXML
    private TableColumn<Suggestion, Integer> Services_ID;
    @FXML
    private TableColumn<Suggestion, String> Services_Name;
    @FXML
    private TableColumn<Suggestion, String> Services_Cost;
    @FXML
    private TableColumn<Suggestion, String> Services_Time;
    @FXML
    private TextField Users_ID_Text;
    @FXML
    private TextField Users_Password_Text;
    @FXML
    private TextField Users_Name_Text;
    @FXML
    private DatePicker Users_Birthdate_Text;
    @FXML
    private TextField Users_Phone_Number_Text;
    @FXML
    private TextField Users_Login_Text;
    @FXML
    private TextField Users_Surname_Text;
    @FXML
    private TextField Users_Patronymic_Text;
    @FXML
    private ComboBox Users_Gender_Text;
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
    Completion completion = new Completion(database);

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

    //ObservableList<?> list_users;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        completion.Completion(Login, Name, Patronymic, Surname);

        Users_Gender_Text.getItems().addAll("Мужской", "Женский");

        HiSer_Status_Text.getItems().addAll("Отказан", "В обработке", "Принят", "В работе", "Выполнен");

        HiProd_Status_Text.getItems().addAll("Отказан", "В обработке", "Принят", "В работе", "Выполнен");





        // Заменить
        /*Services_Name_Text.getItems().addAll("Оперативная полиграфия", "Сувенирная продукция", "Pos материалы, ценникодержатели", "Печать на обоях",
                "Шелкография", "Широкоформатная печать", "Вывески, наружная реклама", "Дизайн в Пензе", "Тампонная печать", "Интерьерная печать");
        // Заменить
        Products_Name_Text.getItems().addAll("Баннеры (печать и монтаж)", "Интерьерные вывески", "Объемные буквы и крышные установки",
                "Изготовление модульных картин", "Навигация (штендеры, таблички и указатели)", "Самоклеющаяся пленка (печать и монтаж)",
                "Световые короба", "Полиграфия", "Изделия из акрила и оргстекла", "Текстильные изделия (майки, кепки и др.)",
                "Металлоконструкции", "Оформление торговых точек в Пензе", "Пакеты с нанесением логотипа",
                "Информационные и выставочные стенды", "Сувенирная продукция", "Брендирование автотранспорта в Пензе",
                "Стеллы, доски почета, аллея славы", "Фотообои в Пензе", "#Хештеги");*/





        completion.Completion_User(Users_ID,Users_Login,Users_Password,Users_Surname,Users_Name,
                Users_Patronymic,Users_Birthdate,Users_Gender,Users_Phone_Number,Users_Role,Users);

        completion.Completion_Suggestion(Services_ID, Services_Name, Services_Cost, Services_Time, Services, Services_Name_Text,"Services");

        completion.Completion_Suggestion(Products_ID, Products_Name, Products_Cost, Products_Time, Products, Products_Name_Text, "Products");

        completion.Completion_HiSug(HiSer_ID, HiSer_ID_User, HiSer_ID_Services, HiSer_Status, HiSer_Process, HiSer_Cost, HiSer_Date, HiSer_Coments, HiSer, "Services");

        completion.Completion_HiSug(HiProd_ID, HiProd_ID_User, HiProd_ID_Products, HiProd_Status, HiProd_Process, HiProd_Cost, HiProd_Date, HiProd_Coments, HiProd, "Products");

        completion.Completion_Role(Role_ID, Role_Role, Role);

        /*ObservableList<Suggestion> list_services = database.Get_All_Suggestion("Services");

        Services_ID.setCellValueFactory(new PropertyValueFactory<Suggestion, Integer>("idSuggestion"));
        Services_Name.setCellValueFactory(new PropertyValueFactory<Suggestion, String>("Title"));
        Services_Cost.setCellValueFactory(new PropertyValueFactory<Suggestion, String>("Approximate_Сost"));
        Services_Time.setCellValueFactory(new PropertyValueFactory<Suggestion, String>("Approximate_Time_Performance"));

        Services.setItems(list_services);

        ObservableList<Suggestion> list_products = database.Get_All_Suggestion("Products");

        Products_ID.setCellValueFactory(new PropertyValueFactory<Suggestion, Integer>("idSuggestion"));
        Products_Name.setCellValueFactory(new PropertyValueFactory<Suggestion, String>("Title"));
        Products_Cost.setCellValueFactory(new PropertyValueFactory<Suggestion, String>("Approximate_Сost"));
        Products_Time.setCellValueFactory(new PropertyValueFactory<Suggestion, String>("Approximate_Time_Performance"));

        Products.setItems(list_products);*/



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
        //Completion_User();
    }
    /*public void Completion_Suggestion(TableColumn<Suggestion, Integer> ID, TableColumn<Suggestion, String> Name,
    TableColumn<Suggestion, String> Cost, TableColumn<Suggestion, String> Time,TableView<Suggestion> suggestion, ComboBox Box_Sigg, String choice){
        ObservableList<Suggestion> list_suggestion = database.Get_All_Suggestion(choice, Box_Sigg);

        ID.setCellValueFactory(new PropertyValueFactory<Suggestion, Integer>("idSuggestion"));
        Name.setCellValueFactory(new PropertyValueFactory<Suggestion, String>("Title"));
        Cost.setCellValueFactory(new PropertyValueFactory<Suggestion, String>("Approximate_Сost"));
        Time.setCellValueFactory(new PropertyValueFactory<Suggestion, String>("Approximate_Time_Performance"));

        suggestion.setItems(list_suggestion);
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

    public void Completion_Role() {
        ObservableList<Role> list_role = database.Get_All_Roles();

        Role_ID.setCellValueFactory(new PropertyValueFactory<Role,Integer>("ID"));
        Role_Role.setCellValueFactory(new PropertyValueFactory<Role, String>("Role"));

        Role.setItems(list_role);
    }


    public void Completion_User(){//Object obj, String orocle){
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

    }*/

    public boolean Check_User() {
        boolean chek = false;
        if (!Users_Surname_Text.getText().isEmpty() && !Users_Name_Text.getText().isEmpty() && !Users_Patronymic_Text.getText().isEmpty()
                && !Users_Birthdate_Text.getValue().toString().isEmpty()) {
            if (Users_Password_Text.getText().trim().length() >= 5) {
                if (Users_Phone_Number_Text.getText().trim().matches("^((\\+7|7|8)+([0-9]){10})$")) {
                    if (Users_Gender_Text.getValue() != null) {
                        chek = true;
                    } else {
                        Transition.Alert("Ошибка", "Выберете пол");
                    }
                } else {
                    Transition.Alert("Ошибка", "Телефон введен не правильно");
                }
            } else {
                Transition.Alert("Ошибка", "Пароль должен содержать 5 и больше символов");
            }
        } else {
            Transition.Alert("Ошибка", "Заполните поля");
        }
        return chek;
    }

    public boolean Check_HiSug(TextField ID_Text, TextField ID_User_Text, TextField ID_Sugg_Text, ComboBox Status_Text,
                          TextField Process_Text, TextField Cost_Text, DatePicker Date_Text  ) {
        boolean chek = false;
        if (!ID_Text.getText().isEmpty() && !ID_User_Text.getText().isEmpty() && !ID_Sugg_Text.getText().isEmpty()
                && !Status_Text.getValue().toString().isEmpty() && !Process_Text.getText().isEmpty() && !Cost_Text.getText().isEmpty()
        && !Date_Text.getValue().toString().isEmpty()) {
            System.out.println(Process_Text.getText().trim());
            if (Float.valueOf(Process_Text.getText().trim()) >= 0.0 && Float.valueOf(Process_Text.getText().trim()) <= 1.0 ) {
                chek = true;
            } else {
                Transition.Alert("Ошибка", "Процесс дожет содержать число: 0<=число<=1");
            }
        } else {
            Transition.Alert("Ошибка", "Заполните поля");
        }
        return chek;
    }


    public void User_Delete(MouseEvent event) {
        //System.out.println("хай");
        //System.out.println(Users_ID_Text.getText().trim());
        if(!Users_ID_Text.getText().isEmpty()) {
            database.Delete(Users_ID_Text.getText().trim(), "Users");
            completion.Completion_User(Users_ID,Users_Login,Users_Password,Users_Surname,Users_Name,
                    Users_Patronymic,Users_Birthdate,Users_Gender,Users_Phone_Number,Users_Role,Users);
        }else {Transition.Alert("Ошибка"," Заполните поле ID");}
    }

    public void User_Update(MouseEvent event) {
        if (Check_User()) {
            User new_user = new User(Integer.valueOf(Users_ID_Text.getText().trim()), Users_Login_Text.getText().trim(),
                    Users_Password_Text.getText().trim(), Users_Surname_Text.getText().trim(),
                    Users_Name_Text.getText().trim(), Users_Patronymic_Text.getText().trim(),
                    Users_Birthdate_Text.getValue().toString().trim(), Users_Gender_Text.getValue().toString(),
                    Users_Phone_Number_Text.getText().trim(), Integer.valueOf(Users_Role_Text.getText().trim()));
            database.New_And_Update_Users(new_user, "Admin_Update");
            completion.Completion_User(Users_ID,Users_Login,Users_Password,Users_Surname,Users_Name,
                    Users_Patronymic,Users_Birthdate,Users_Gender,Users_Phone_Number,Users_Role,Users);
        }
    }

    public void User_Add(MouseEvent event) {
        if (Check_User()) {
            User new_user = new User(Integer.valueOf(Users_ID_Text.getText().trim()), Users_Login_Text.getText().trim(),
                    Users_Password_Text.getText().trim(), Users_Surname_Text.getText().trim(),
                    Users_Name_Text.getText().trim(), Users_Patronymic_Text.getText().trim(),
                    Users_Birthdate_Text.getValue().toString().trim(), Users_Gender_Text.getValue().toString(),
                    Users_Phone_Number_Text.getText().trim(), Integer.valueOf(Users_Role_Text.getText().trim()));
            database.New_And_Update_Users(new_user, "Admin");
            completion.Completion_User(Users_ID,Users_Login,Users_Password,Users_Surname,Users_Name,
                    Users_Patronymic,Users_Birthdate,Users_Gender,Users_Phone_Number,Users_Role,Users);
        }
    }

    public void Services_Delete(MouseEvent event) {
        if(!Services_ID_Text.getText().isEmpty()) {
            database.Delete(Services_ID_Text.getText().trim(), "Services");
            completion.Completion_Suggestion(Services_ID, Services_Name, Services_Cost, Services_Time, Services, Services_Name_Text,"Services");
        }else {Transition.Alert("Ошибка","Заполните поле ID");}
    }

    public void Services_Update(MouseEvent event) {
        if (!Services_ID_Text.getText().isEmpty() && !Services_Name_Text.getValue().toString().isEmpty() && !Services_Cost_Text.getText().isEmpty() && !Services_Time_Text.getText().isEmpty()) {
            Suggestion suggestion = new Suggestion(Integer.valueOf(Services_ID_Text.getText().trim()), Services_Name_Text.getValue().toString().trim(),
                    Services_Cost_Text.getText().trim(), Services_Time_Text.getText().trim());
            database.New_And_Update_Suggestion(suggestion, "Services_Update");
            completion.Completion_Suggestion(Services_ID, Services_Name, Services_Cost, Services_Time, Services, Services_Name_Text, "Services");
        }else {Transition.Alert("Ошибка","Заполните все поля");}
        System.out.println(Services_Name_Text.getValue().toString());

    }

    public void Services_Add(MouseEvent event) {
        if (!Services_ID_Text.getText().isEmpty() && !Services_Name_Text.getValue().toString().isEmpty() && !Services_Cost_Text.getText().isEmpty() && !Services_Time_Text.getText().isEmpty()) {
            Suggestion suggestion = new Suggestion(Integer.valueOf(Services_ID_Text.getText().trim()), Services_Name_Text.getValue().toString().trim(),
                    Services_Cost_Text.getText().trim(), Services_Time_Text.getText().trim());
            database.New_And_Update_Suggestion(suggestion, "Services");
            completion.Completion_Suggestion(Services_ID, Services_Name, Services_Cost, Services_Time, Services, Services_Name_Text,"Services");
        }
    }

    public void Products_Delete(MouseEvent event) {
        if(!Products_ID_Text.getText().isEmpty()) {
            database.Delete(Products_ID_Text.getText().trim(), "Products");
            completion.Completion_Suggestion(Products_ID, Products_Name, Products_Cost, Products_Time, Products, Products_Name_Text, "Products");
        }else {Transition.Alert("Ошибка","Заполните поле ID");}
    }

    public void Products_Update(MouseEvent event) {
        if (!Products_ID_Text.getText().isEmpty() && !Products_Name_Text.getValue().toString().isEmpty() && !Products_Cost_Text.getText().isEmpty() && !Products_Time_Text.getText().isEmpty()) {
            Suggestion suggestion = new Suggestion(Integer.valueOf(Products_ID_Text.getText().trim()), Products_Name_Text.getValue().toString().trim(),
                    Products_Cost_Text.getText().trim(), Products_Time_Text.getText().trim());
            database.New_And_Update_Suggestion(suggestion, "Products_Update");
            completion.Completion_Suggestion(Products_ID, Products_Name, Products_Cost, Products_Time, Products, Products_Name_Text,"Products");
        }else {Transition.Alert("Ошибка","Заполните все поля");}
    }

    public void Products_Add(MouseEvent event){
        if (!Products_ID_Text.getText().isEmpty() && !Products_Name_Text.getValue().toString().isEmpty() && !Products_Cost_Text.getText().isEmpty() && !Products_Time_Text.getText().isEmpty()) {
            Suggestion suggestion = new Suggestion(Integer.valueOf(Products_ID_Text.getText().trim()), Products_Name_Text.getValue().toString().trim(),
                    Products_Cost_Text.getText().trim(), Products_Time_Text.getText().trim());
            database.New_And_Update_Suggestion(suggestion, "Products");
            completion.Completion_Suggestion(Products_ID, Products_Name, Products_Cost, Products_Time, Products, Products_Name_Text,"Products");
        }else {Transition.Alert("Ошибка","Заполните все поля");}
    }

    public void HiSer_Delete(MouseEvent event) {
        if(!HiSer_ID_Text.getText().isEmpty()) {
            database.Delete(HiSer_ID_Text.getText().trim(), "History_Services");
            completion.Completion_HiSug(HiSer_ID, HiSer_ID_User, HiSer_ID_Services, HiSer_Status, HiSer_Process, HiSer_Cost, HiSer_Date, HiSer_Coments, HiSer,"Services");
        }else {Transition.Alert("Ошибка","Заполните поле ID");}
        System.out.println("Удаление услуг");
    }

    public void HiSer_Update(MouseEvent event) {
        if(Check_HiSug(HiSer_ID_Text, HiSer_ID_User_Text, HiSer_ID_Services_Text, HiSer_Status_Text, HiSer_Process_Text, HiSer_Cost_Text, HiSer_Date_Text)){
            HiSug hiSug = new HiSug(Integer.valueOf(HiSer_ID_Text.getText().trim()),
                    Integer.valueOf(HiSer_ID_User_Text.getText().trim()), Integer.valueOf(HiSer_ID_Services_Text.getText().trim()),
                    HiSer_Status_Text.getValue().toString().trim(), HiSer_Process_Text.getText().trim(),
                    HiSer_Cost_Text.getText().trim(), HiSer_Date_Text.getValue().toString().trim(),
                    HiSer_Coments_Text.getText().trim());
            database.New_And_Update_History(hiSug,"Services_Update");
            completion.Completion_HiSug(HiSer_ID, HiSer_ID_User, HiSer_ID_Services, HiSer_Status, HiSer_Process, HiSer_Cost, HiSer_Date, HiSer_Coments, HiSer,"Services");
        }
    }

    public void HiSer_Add(MouseEvent event) {
        if(Check_HiSug(HiSer_ID_Text, HiSer_ID_User_Text, HiSer_ID_Services_Text, HiSer_Status_Text, HiSer_Process_Text, HiSer_Cost_Text, HiSer_Date_Text)){
            HiSug hiSug = new HiSug(Integer.valueOf(HiSer_ID_Text.getText().trim()),
                    Integer.valueOf(HiSer_ID_User_Text.getText().trim()), Integer.valueOf(HiSer_ID_Services_Text.getText().trim()),
                    HiSer_Status_Text.getValue().toString().trim(), HiSer_Process_Text.getText().trim(),
                    HiSer_Cost_Text.getText().trim(), HiSer_Date_Text.getValue().toString().trim(),
                    HiSer_Coments_Text.getText().trim());
            database.New_And_Update_History(hiSug,"Services_Admin");
            completion.Completion_HiSug(HiSer_ID, HiSer_ID_User, HiSer_ID_Services, HiSer_Status, HiSer_Process, HiSer_Cost, HiSer_Date, HiSer_Coments, HiSer, "Services");
        }
    }

    public void HiProd_Delete(MouseEvent event) {
        if(!HiProd_ID_Text.getText().isEmpty()) {
            database.Delete(HiProd_ID_Text.getText().trim(), "History_Product");
            completion.Completion_HiSug(HiProd_ID, HiProd_ID_User, HiProd_ID_Products, HiProd_Status, HiProd_Process, HiProd_Cost, HiProd_Date, HiProd_Coments, HiProd, "Products");
        }else {Transition.Alert("Ошибка","Заполните поле ID");}
    }

    public void HiProd_Update(MouseEvent event) {
        if(Check_HiSug(HiProd_ID_Text, HiProd_ID_User_Text, HiProd_ID_Products_Text, HiProd_Status_Text,
                HiProd_Process_Text, HiProd_Cost_Text, HiProd_Date_Text)) {
            HiSug hiSug = new HiSug(Integer.valueOf(HiProd_ID_Text.getText().trim()),
                    Integer.valueOf(HiProd_ID_User_Text.getText().trim()), Integer.valueOf(HiProd_ID_Products_Text.getText().trim()),
                    HiProd_Status_Text.getValue().toString().trim(), HiProd_Process_Text.getText().trim(),
                    HiProd_Cost_Text.getText().trim(), HiProd_Date_Text.getValue().toString().trim(),
                    HiProd_Coments_Text.getText().trim());
            database.New_And_Update_History(hiSug, "Product_Update");
            completion.Completion_HiSug(HiProd_ID, HiProd_ID_User, HiProd_ID_Products, HiProd_Status, HiProd_Process, HiProd_Cost, HiProd_Date, HiProd_Coments, HiProd, "Products");
        }
    }

    public void HiProd_Add(MouseEvent event) {
        if(Check_HiSug(HiProd_ID_Text, HiProd_ID_User_Text, HiProd_ID_Products_Text, HiProd_Status_Text,
                HiProd_Process_Text, HiProd_Cost_Text, HiProd_Date_Text)){
            HiSug hiSug = new HiSug(Integer.valueOf(HiProd_ID_Text.getText().trim()),
                    Integer.valueOf(HiProd_ID_User_Text.getText().trim()), Integer.valueOf(HiProd_ID_Products_Text.getText().trim()),
                    HiProd_Status_Text.getValue().toString().trim(), HiProd_Process_Text.getText().trim(),
                    HiProd_Cost_Text.getText().trim(), HiProd_Date_Text.getValue().toString().trim(),
                    HiProd_Coments_Text.getText().trim());
            database.New_And_Update_History(hiSug,"Product_Admin");
            completion.Completion_HiSug(HiProd_ID, HiProd_ID_User, HiProd_ID_Products, HiProd_Status, HiProd_Process, HiProd_Cost, HiProd_Date, HiProd_Coments, HiProd, "Products");
        }
    }

    public void Role_Delete(MouseEvent event) {
        if (!Role_ID_Text.getText().isEmpty()){
            database.Delete(Role_ID_Text.getText().trim(), "Roles");
            completion.Completion_Role(Role_ID, Role_Role, Role);
        }else {Transition.Alert("Ошибка","Заполните поле ID");}
    }

    public void Role_Update(MouseEvent event) {
        if (!Role_ID_Text.getText().isEmpty() && !Role_Role_Text.getText().isEmpty()){
            Role role = new Role(Integer.valueOf(Role_ID_Text.getText().trim()),Role_Role_Text.getText().trim());
            database.New_And_Update_Roles(role,"Roles_Update");
            completion.Completion_Role(Role_ID, Role_Role, Role);
        } else {Transition.Alert("Oшибка", "Заполните поля");}
    }

    public void Role_Add(MouseEvent event) {
        if (!Role_ID_Text.getText().isEmpty() && !Role_Role_Text.getText().isEmpty()){
            Role role = new Role(Integer.valueOf(Role_ID_Text.getText().trim()),Role_Role_Text.getText().trim());
            database.New_And_Update_Roles(role,"Roles_ADD");
            completion.Completion_Role(Role_ID, Role_Role, Role);
        } else {Transition.Alert("Oшибка", "Заполните поля");}
    }
}
