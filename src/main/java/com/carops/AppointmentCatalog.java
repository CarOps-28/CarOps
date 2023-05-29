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
		System.out.printf("\n> All Appointments in catalog:\nn %-25s  %-10s\n", "Customer id", "Vehicle Plate");
		int i = 1;
		for (Appointment appointment : appointments) {
			System.out.printf("%d|", i);
			appointment.printData();
			i++;
		}
	}

}