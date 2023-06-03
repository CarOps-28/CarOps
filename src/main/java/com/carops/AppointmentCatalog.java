package com.carops;

import java.util.ArrayList;

public class AppointmentCatalog {

	private static ArrayList<Appointment> appointments = new ArrayList<Appointment>();

	public static ArrayList<Appointment> fetchAppointments() {
		return appointments;
	}

	public static void addAppointment(Appointment appointment) {
		appointments.add(appointment);
	}

	public static void printData() {
		System.out.printf("\n> All Appointments in catalog:\n" +
						"n %-25s  %-15s  %-14s  %-20s  %-20s  %-20s  %-20s\n",
				"Date","Name", "Surname", "Phone number", "Vehicle Plate", "Brand", "Τype");
		int i = 1;
		for (Appointment appointment : appointments) {
			System.out.printf("%d", i);
			appointment.printData();
			i++;
		}
	}

}