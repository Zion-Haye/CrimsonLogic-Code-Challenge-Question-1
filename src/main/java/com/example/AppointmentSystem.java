package com.example;

import java.util.ArrayList;

public class AppointmentSystem {

    private ArrayList<Office> offices;

    public AppointmentSystem() {
        offices = new ArrayList<Office>();
    }

    public void addOffice(Office office) {
        offices.add(office);
        System.out.println("Office Successfully Added.");
    }

    public void removeOffice(String officeLocation) {
        Office office = getOffice(officeLocation);

        if (office != null) {
            offices.remove(office);
            System.out.println("Office Successfully Removed.");
        } else {
            System.out.println("Office Not Found.");
        }
    }

    public Office getOffice(String officeLocation) {
        for (Office office : offices) {
            if (office.getOfficeLocation().equalsIgnoreCase(officeLocation)) {
                return office;
            }
        }
        return null;
    }

    public boolean officeExists(String officeLocation) {
        Office office = getOffice(officeLocation);
        if (office != null) {
            return true;
        }

        return false;
    }

    public String viewListOfOffices() {
        if (offices.isEmpty()) {
            return "There are no offices";
        } else {
            return toString();
        }
    }

    public String toString() {
        String officelist = "Offices:\n";
        for (Office office : offices) {
            officelist += office.getOfficeLocation() + "\n";
        }
        return officelist;
    }

}
