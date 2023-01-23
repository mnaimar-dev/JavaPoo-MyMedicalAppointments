package org.example.model;

public class Nurse extends User{
    // Attributes
    private String speciality;

    // Constructors
    public Nurse(String name, String email) {
        super(name, email);
    }

    @Override
    public void showDataUser() {
        System.out.println("Enfermera: " + getName());
        System.out.println("Centro Médico: Hospital Privado");
        System.out.println("Departamentos: Pediatría, Oncología");
    }

    // Getters & Setters
    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
