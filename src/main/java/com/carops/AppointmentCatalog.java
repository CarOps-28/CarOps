package com.carops;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AppointmentCatalog {

	private static ArrayList<Appointment> appointments = new ArrayList<Appointment>();
	public static ArrayList<Appointment> fetchAppointments() {
		return appointments;
	}

	public static void addAppointment(Appointment appointment) {
		appointments.add(appointment);
	}

}