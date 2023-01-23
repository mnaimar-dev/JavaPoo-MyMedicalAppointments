package org.example.model;

import java.util.ArrayList;
import java.util.Date;

public class Patient extends User {
    // Attributes
    private String age;
    private double weight;
    private double height;
    private String blood;

    private ArrayList<AppointmentDoctor> appointmentDoctors = new ArrayList<>();
    private ArrayList<AppointmentNurse> appointmentNurses = new ArrayList<>();

    public ArrayList<AppointmentDoctor> getAppointmentDoctors() {
        return appointmentDoctors;
    }

    public void addAppointmentDoctors(Doctor doctor, Date date, String time) {
        AppointmentDoctor appointmentDoctor = new AppointmentDoctor(this, doctor);
        appointmentDoctor.schedule(date, time);
        appointmentDoctors.add(appointmentDoctor);
    }

    public ArrayList<AppointmentNurse> getAppointmentNurses() {
        return appointmentNurses;
    }

    public void setAppointmentNurses(ArrayList<AppointmentNurse> appointmentNurses) {
        this.appointmentNurses = appointmentNurses;
    }

    // Constructors
    public Patient(String name, String email) {
        super(name, email); // name & email no son atributos de esta clase, por eso se pasan a super
    }

    // Getters and Setters
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getWeight() {
        return this.weight + " Kg"; // Devuelve el peso y le concatena la unidad Kg
    }

    public String getHeight() {
        return height + " m";
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    @Override
    public String toString() {
        return super.toString() +
                "age: " + age + '\n' +
                "weight: " + getWeight() + '\n' +// va getWeight en vez de weight pq modificamos su formato en el getter
                "height: " + getHeight() + '\n' +// va getHeight en vez de height pq modificamos su formato en el getter
                "blood: " + blood + '\n';
    }

    @Override
    public void showDataUser() {
        System.out.println("Paciente: " + getName());
        if (age != null) {
            System.out.println("Edad: " + getAge());
        }
        System.out.println("Historia Clínica: Completa.");
    }
}
