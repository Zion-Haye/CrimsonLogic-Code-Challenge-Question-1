package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class AppointmentSystemApplication {
    public static void main(String[] args) {

        AppointmentSystem appointmentSystem = new AppointmentSystem();
        initialiseOffices(appointmentSystem);

        Scanner input = new Scanner(System.in);
        String userInput = "";

        while (!userInput.equals("X")) {

            displayMainMenu();
            userInput = input.nextLine();

            switch (userInput) {
                case "":
                    break;
                case "1":
                    addOffice(appointmentSystem);
                    break;
                case "2":
                    removeOffice(appointmentSystem);
                    break;
                case "3":
                    displayOfficeList(appointmentSystem);
                    break;
                case "4":
                    setlunchShedule(appointmentSystem);
                    break;
                case "5":
                    setAvailableInterviewSlotsByHourRange(appointmentSystem);
                    break;
                case "6":
                    setUnavailableInterviewSlotsByHourRange(appointmentSystem);
                    break;
                case "7":
                    viewOfficeSchedule(appointmentSystem);
                    break;
                case "X":
                    break;
                default:
                    System.out.println("Invalid Entry\n");
                    break;
            }

        }
        System.out.println("System Terminated\n");

    }

    public static void displayMainMenu() {
        System.out.println("Welcome to CrimsonLogic's Appointment System\n");
        System.out.println("Please select an option:");
        System.out.println("1 - Add Office");
        System.out.println("2 - Remove Office");
        System.out.println("3 - View Office List");
        System.out.println("4 - Set Office Lunch Hour");
        System.out.println("5 - Set Available Interview Slots In Range");
        System.out.println("6 - Set Unavailable Interview Slots In Range");
        System.out.println("7 - View Office Schedule");
        System.out.println("X - Exit Appointment System");
        System.out.println("Enter Option:");

    }

    public static void initialiseOffices(AppointmentSystem appointmentSystem) {
        appointmentSystem.addOffice(new Office("North"));
        appointmentSystem.addOffice(new Office("South"));
        appointmentSystem.addOffice(new Office("West"));
        appointmentSystem.addOffice(new Office("East"));
    }

    public static void displayOfficeList(AppointmentSystem appointmentSystem) {
        System.out.println(appointmentSystem.viewListOfOffices());
    }

    public static void addOffice(AppointmentSystem appointmentSystem) {

        Scanner input = new Scanner(System.in);
        String userInput;
        boolean officeExists;

        System.out.println("Please enter the Office: ");
        userInput = input.nextLine();

        if (appointmentSystem.getOffice(userInput) == null) {
            appointmentSystem.addOffice(new Office(userInput));
        } else {
            System.out.println("Office Already Exists");
        }
    }

    public static void removeOffice(AppointmentSystem appointmentSystem) {
        displayOfficeList(appointmentSystem);
        Scanner input = new Scanner(System.in);
        String userInput;

        System.out.println("Please enter the Office: ");
        userInput = input.nextLine();

        appointmentSystem.removeOffice(userInput);

    }

    public static void setlunchShedule(AppointmentSystem appointmentSystem) {
        displayOfficeList(appointmentSystem);
        Office office;
        Scanner input = new Scanner(System.in);
        String userInput;
        int startingHour;

        System.out.println("Please enter the office:");
        userInput = input.nextLine();

        office = appointmentSystem.getOffice(userInput);
        if (office != null) {

            System.out.println("Please enter starting hour of the lunch period:");
            try {
                startingHour = input.nextInt();

                if (InputValidator.validateHour(startingHour)) {
                    office.setLunchStartingHour(startingHour);
                }

            } catch (Exception e) {
                System.out.println("Invalid Hour Value.");
            }

        } else {
            System.out.println("Office Not Found.");
        }

    }

    public static void setAvailableInterviewSlotsByHourRange(AppointmentSystem appointmentSystem) {
        displayOfficeList(appointmentSystem);
        Office office;
        Scanner input = new Scanner(System.in);
        String userInput, day;
        int startingHour, endingHour;

        System.out.println("Please enter the office:");
        userInput = input.nextLine();

        office = appointmentSystem.getOffice(userInput);
        if (office != null) {

            System.out.println("Please enter the Day:");
            day = input.nextLine();

            if (InputValidator.validateDay(day)) {
                System.out.println("Please enter the starting hour:");

                try {
                    startingHour = input.nextInt();

                    if (InputValidator.validateHour(startingHour)) {
                        System.out.println("Please enter the ending hour:");
                        try {
                            endingHour = input.nextInt();

                            if (InputValidator.validateHour(endingHour)) {
                                office.setAvailableInterviewSlotsByHourRange(day, startingHour, endingHour);
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid Hour Value.");
                        }

                    }
                } catch (Exception e) {
                    System.out.println("Invalid Hour Value.");
                }
            }
        } else {
            System.out.println("Office Not Found.");
        }
    }

    public static void setUnavailableInterviewSlotsByHourRange(AppointmentSystem appointmentSystem) {
        displayOfficeList(appointmentSystem);
        Office office;
        Scanner input = new Scanner(System.in);
        String userInput, day;
        int startingHour, endingHour;

        System.out.println("Please enter the office:");
        userInput = input.nextLine();

        office = appointmentSystem.getOffice(userInput);
        if (office != null) {

            System.out.println("Please enter the Day:");
            day = input.nextLine();

            if (InputValidator.validateDay(day)) {
                System.out.println("Please enter the starting hour:");

                try {
                    startingHour = input.nextInt();

                    if (InputValidator.validateHour(startingHour)) {
                        System.out.println("Please enter the ending hour:");
                        try {
                            endingHour = input.nextInt();

                            if (InputValidator.validateHour(endingHour)) {
                                office.setUnavailableInterviewSlotsByHourRange(day, startingHour, endingHour);
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid Hour Value.");
                        }

                    }
                } catch (Exception e) {
                    System.out.println("Invalid Hour Value.");
                }
            }
        } else {
            System.out.println("Office Not Found.");
        }
    }

    public static void viewOfficeSchedule(AppointmentSystem appointmentSystem) {
        displayOfficeList(appointmentSystem);
        Office office;
        Scanner input = new Scanner(System.in);
        String userInput;

        System.out.println("Please enter the office:");
        userInput = input.nextLine();

        office = appointmentSystem.getOffice(userInput);
        if (office != null) {
            office.viewSchedule();
        } else {
            System.out.println("Office Not Found.");
        }

    }

}
