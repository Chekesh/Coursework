package com.example.coursework;

public class User {
    private int ID_Users;
    private String Login;
    private String Password;
    private String Surname;
    private String Name;
    private String Patronymic;
    private String Birthdate;
    private String Gender;
    private String Phone_Number;
    private int Roles_idRoles;
    User(int ID_Users,String Login, String Password,
         String Surname, String Name, String Patronymic,
         String Birthdate, String Gender, String Phone_Number,
         int Roles_idRoles){
        this.ID_Users=ID_Users;
        this.Login=Login;
        this.Password=Password;
        this.Surname=Surname;
        this.Name=Name;
        this.Patronymic=Patronymic;
        this.Birthdate=Birthdate;
        this.Gender=Gender;
        this.Phone_Number=Phone_Number;
        this.Roles_idRoles=Roles_idRoles;
    }

    User() {}

    public void setID_Users(int ID_Users) {
        this.ID_Users = ID_Users;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPatronymic(String patronymic) {
        Patronymic = patronymic;
    }

    public void setBirthdate(String birthdate) {
        Birthdate = birthdate;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public void setPhone_Number(String phone_Number) {
        Phone_Number = phone_Number;
    }

    public void setRoles_idRoles(int roles_idRoles) {
        Roles_idRoles = roles_idRoles;
    }

    public int getID_Users() {
        return ID_Users;
    }

    public String getLogin() {
        return Login;
    }

    public String getPassword() {
        return Password;
    }

    public String getSurname() {
        return Surname;
    }

    public String getName() {
        return Name;
    }

    public String getPatronymic() {
        return Patronymic;
    }

    public String getBirthdate() {
        return Birthdate;
    }

    public String getGender() {
        return Gender;
    }

    public String getPhone_Number() {
        return Phone_Number;
    }

    public int getRoles_idRoles() {
        return Roles_idRoles;
    }
}
