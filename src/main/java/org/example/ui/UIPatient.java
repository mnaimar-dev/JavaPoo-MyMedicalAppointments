package org.example.ui;

import org.example.model.Doctor;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UIPatient {
    public static void showPatientMenu() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("Welcome " + UIMenu.patientLogged.getName());
            System.out.println("1. Book an Appointment");
            System.out.println("2. My Appointments");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    showBookAppointmentMenu();
                    break;
                case 2:
                    showPatientMyAppointments();
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }
        } while (response != 0);
    }
    private static void showBookAppointmentMenu() {
        int response = 0;
        do {
            System.out.println(":: Book an Appointment");
            System.out.println(":: Select a Date");
            // Queremos mostrar las fechas disponibles de los doctores
            // Numeración de la lista de fechas
            // Índice de la fecha seleccionada
            Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();

            int k = 0;
            for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointments.size(); i++) {
                ArrayList<Doctor.AvailableAppointment> availableAppointments
                        = UIDoctorMenu.doctorsAvailableAppointments.get(i).getAvailableAppointments();

                Map<Integer, Doctor> doctorAppointment = new TreeMap<>();

                for (int j = 0; j < availableAppointments.size(); j++) {
                    k++;
                    System.out.println(k + ". " + availableAppointments.get(j).getDate());
                    doctorAppointment.put(Integer.valueOf(j), UIDoctorMenu.doctorsAvailableAppointments.get(i));
                    doctors.put(Integer.valueOf(k), doctorAppointment);
                }
            }
            Scanner sc = new Scanner(System.in);
            int responseSelectedDate = Integer.valueOf(sc.nextLine());

            Map<Integer, Doctor> doctorAvailableSelected = doctors.get(responseSelectedDate);
            Integer indexDate = 0;

            Doctor selectedDoctor = new Doctor("", "");

            for (Map.Entry<Integer, Doctor> doc : doctorAvailableSelected.entrySet()) {
                indexDate = doc.getKey();
                selectedDoctor = doc.getValue();
            }

            System.out.println(selectedDoctor.getName() +
                    " .Date: " + selectedDoctor.getAvailableAppointments().get(indexDate).getDate() +
                    " .Time: " +
                    selectedDoctor.getAvailableAppointments().get(indexDate).getTime());

            System.out.println("Confirm your Appointment: \n1. Yes \n2. Change Data");
            response = Integer.valueOf(sc.nextLine());

            if (response == 1) {
                UIMenu.patientLogged.addAppointmentDoctors(
                        selectedDoctor,
                        selectedDoctor.getAvailableAppointments().get(indexDate).getDate(),
                        selectedDoctor.getAvailableAppointments().get(indexDate).getTime()
                );
                showPatientMenu();
            }
        } while(response != 0);
    }

    private static void showPatientMyAppointments() {
        int response = 0;

        do {
            System.out.println(":: My Appointments");
            if(UIMenu.patientLogged.getAppointmentDoctors().size() == 0) {
                System.out.println("You don't have appointments.");
                break;
            }

            for (int i = 0; i < UIMenu.patientLogged.getAppointmentDoctors().size(); i++) {
                int j = i + 1;
                System.out.println(j + ". " +
                        "Date: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDate() +
                        " Time: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getTime() +
                        "\n Doctor: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDoctor().getName());
            }

            System.out.println("0. Return");
        } while (response != 0);
    }
}
