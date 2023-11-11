package com.example.coursework;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class Client implements Initializable {
    @FXML
    private AnchorPane Pane;
    @FXML
    private ChoiceBox History_Services;
    @FXML
    private Label History_Services_Cost;
    @FXML
    private Label History_Services_Date;
    @FXML
    private ProgressIndicator History_Services_Process;
    @FXML
    private ChoiceBox History_Product;
    @FXML
    private Label History_Product_Cost;
    @FXML
    private Label History_Product_Date;
    @FXML
    private ProgressIndicator History_Product_Process;
    @FXML
    private Label Login;
    @FXML
    private Label Name;
    @FXML
    private Label Patronymic;
    @FXML
    private Label Surname;
    @FXML
    private Circle Gender;

    @FXML
    private ChoiceBox Services_Box;
    @FXML
    private Label Services_Cost;
    @FXML
    private Label Services_Time;
    @FXML
    private TextArea Services_Comments;
    @FXML
    private Button Services_Button;
    @FXML
    private ChoiceBox Products_Box;
    @FXML
    private Label Products_Cost;
    @FXML
    private Label Products_Time;
    @FXML
    private TextArea Products_Comments;
    @FXML
    private Button Products_Button;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Exit;

    Database database = new Database();

    boolean discovery = true;

    Completion completion = new Completion(database);


    @FXML
    void BtnExit(MouseEvent event) {
        try {
            Transition.TransitionWindows(Name, "Authorization", 600.0, 400.0, false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Pane.setMinHeight(300);
        //Pane.setMinWidth(300);

        completion.Completion(Login, Name, Patronymic, Surname);


        //System.out.println(database.Get_History_Suggestion("Services"));
        //System.out.println(database.Get_History_Suggestion("Products"));

        Services_Box.getItems().addAll("Оперативная полиграфия", "Сувенирная продукция", "Pos материалы, ценникодержатели", "Печать на обоях",
                "Шелкография", "Широкоформатная печать", "Вывески, наружная реклама", "Дизайн в Пензе", "Тампонная печать", "Интерьерная печать");

        Services_Box.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> Replaced_Label(newValue, Services_Cost, Services_Time, "Services"));

        Products_Box.getItems().addAll("Баннеры (печать и монтаж)", "Интерьерные вывески", "Объемные буквы и крышные установки",
                "Изготовление модульных картин", "Навигация (штендеры, таблички и указатели)", "Самоклеющаяся пленка (печать и монтаж)",
                "Световые короба", "Полиграфия", "Изделия из акрила и оргстекла", "Текстильные изделия (майки, кепки и др.)",
                "Металлоконструкции", "Оформление торговых точек в Пензе", "Пакеты с нанесением логотипа",
                "Информационные и выставочные стенды", "Сувенирная продукция", "Брендирование автотранспорта в Пензе",
                "Стеллы, доски почета, аллея славы", "Фотообои в Пензе", "#Хештеги");

        Products_Box.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> Replaced_Label(newValue, Products_Cost, Products_Time, "Products"));

        History_Services.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> Replaced_History_Label(newValue, History_Services_Cost, History_Services_Date, History_Services_Process,"Services"));

        History_Product.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> Replaced_History_Label(newValue, History_Product_Cost, History_Product_Date, History_Product_Process, "Products"));

    }


    public void Replaced_Label(Object newValue, Label Cost, Label Time, String choice) {
        //System.out.println(newValue);
        if (newValue != null) {
            String selectedValue = newValue.toString();
            //System.out.println("Выбранное значение: " + selectedValue);

            //String Сosts = "Cost";
            //String Times = "Time";



            database.Get_Suggestion(choice, selectedValue);
            String Сosts = Database.suggestion.Approximate_Сost;
            String Times = Database.suggestion.Approximate_Time_Performance;
            Cost.setText(Сosts);
            Time.setText(Times);
        }
    }

    public void Replaced_History_Label(Object newValue, Label Cost, Label Date, ProgressIndicator Process, String choice){
        //String selectedValue = newValue.toString();
        //System.out.println(newValue);
        if (newValue != null) {
            String ID_Order = "";
            Pattern pattern = Pattern.compile("\\d");
            Matcher matcher = pattern.matcher(newValue.toString());
            //System.out.println(newValue);
            while (matcher.find()) {
                ID_Order = ID_Order + (matcher.group());
            }
            //System.out.println(ID_Order);


            List<String> result = database.Get_History_Suggestion(choice, ID_Order);
            Cost.setText(result.get(0));
            Date.setText(result.get(1));
            Process.setProgress(Float.parseFloat(result.get(2)));
        }

    }


    public void Click_Services(MouseEvent event) {
        if (Services_Box.getValue() != null) {
            if (Services_Box.getValue().toString().equals(String.valueOf(Database.suggestion.Title))) {
                database.New_And_Update_History(new HiSug(1, Database.user.getID_Users(), Database.suggestion.idSuggestion, "В обработке", "0", "Неопределена", LocalDate.now().toString(), Services_Comments.getText()), "Services_Users");
                int id = database.Get_Max("History_Services");
                if(id !=0){
                    Transition.Alert("Успешно","id вашего заказа " + id);
                }
            } else {
                Transition.Alert("Ошибка","Выберете заново");
            }
        } else {
            Transition.Alert("Ошибка","Выберете услугу");
        }

    }

    public void Click_Products(MouseEvent event) {
        if (Products_Box.getValue() != null) {
            if (Products_Box.getValue().toString().equals(String.valueOf(Database.suggestion.Title))) {
                database.New_And_Update_History(new HiSug(1, Database.user.getID_Users(), Database.suggestion.idSuggestion, "В обработке", "0", "Неопределена", LocalDate.now().toString(), Products_Comments.getText()), "Products_Users");
                //database.Get_Max_History("Products");
                int id = database.Get_Max("History_Product");
                if(id !=0){
                    Transition.Alert("Успех","id вашего заказа " + id);
                }
            } else {
                Transition.Alert("Ошибка","Выберете заново");
            }
        } else {
            Transition.Alert("Ошибка","Выберете услугу");
        }
    }

    public void History_Changed(Event event) {
        if(discovery) {
            //System.out.println("Изменение");
            List<String> servis = database.Get_Title("Services");
            if(servis.isEmpty()){
                History_Services.getItems().addAll("Нет заказов");
            }
            //System.out.println(servis);
            History_Services.getItems().addAll(servis);

            List<String> products = database.Get_Title("Products");
            if(products.isEmpty()){
                History_Product.getItems().addAll("Нет заказов");
            }
            //System.out.println(products);
            History_Product.getItems().addAll(products);
            discovery=false;
        }
        else{
            History_Services.getItems().clear();
            History_Product.getItems().clear();
            discovery=true;
        }
    }
}
