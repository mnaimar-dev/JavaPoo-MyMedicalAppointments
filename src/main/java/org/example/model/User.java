package org.example.model;

public abstract class User {
    // Attributes
    private int id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    // Constructors
        // Este constructor tiene los datos mínimos necesarios para que un usuario exista ⬇️
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber.length() > 10) {
            System.out.println("El número debe tenér máximo diez dígitos.");
        } else if(phoneNumber.length() == 8) {
            this.phoneNumber = phoneNumber;
        }
    }

    @Override
    public String toString() {
        return "User: " + name + '\n'+
                "email: " + email + '\n' +
                "address: " + address + '\n' +
                "phoneNumber: " + phoneNumber + '\n';
    }

    public abstract void showDataUser();
}
