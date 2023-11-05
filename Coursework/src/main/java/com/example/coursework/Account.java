package com.example.coursework;

import javafx.scene.Parent;

public class Account {

    private static int ID;

    private static String Name;

    private static String Surname;

    private static String Patronymic;

    private static String Login;

    private static String Password;

    private static String DateBirth;

    private static String Gender;

    private static String PhoneNamber;

    private static int Role;

    public Account(int ID, String name, String surname, String patronymic,
                   String login, String password, String dateBirth, String gender,
                   String phoneNamber, int role) {
        this.ID = ID;
        Name = name;
        Surname = surname;
        Patronymic = patronymic;
        Login = login;
        Password = password;
        DateBirth = dateBirth;
        Gender = gender;
        PhoneNamber = phoneNamber;
        Role = role;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public String getPatronymic() {
        return Patronymic;
    }

    public String getLogin() {
        return Login;
    }

    public String getPassword() {
        return Password;
    }

    public String getDateBirth() {
        return DateBirth;
    }

    public String getGender() {
        return Gender;
    }

    public String getPhoneNamber() {
        return PhoneNamber;
    }

    public int getRole() {
        return Role;
    }
}
