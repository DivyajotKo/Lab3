package com.example.hrmangagementdivya;

public class AdData {


    private int Id;
    private String Name;
    private String Email;
    private int Password;

    public AdData(int Id, String Name, String Email, int Password) {
        this.Id = Id;
        this.Name = Name;
        this.Email = Email;
        this.Password = Password;
    }

        public int getId() {
            return Id;
        }

        public void setId(int id) {
            Id = id;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String email) {
            Email = email;
        }

    public int getPassword() {
        return Password;
    }

    public void setPassword(int password) {
        Password = password;
    }
}

