package com.carops;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AppointmentCatalog {

	private ArrayList<Appointment> appointments = new ArrayList<Appointment>();
	public static ArrayList<Appointment> fetchAppointments() {
		// TODO - implement AppointmentCatalog.fetchAppointments
		//Print appointments     μαλλον για την μειν?
		//for (Appointment appointment : fetchedAppointments) {
			//System.out.println("Ημερομηνία Ραντεβού: " + appointment.getDate() + ", Πινακίδα: " + appointment.getVehiclePlateNumber() + ", Ώρα Ραντεβού¨: " + appointment.getDate().getTime() + ", Κατάσταση¨: " + appointment.getRepairfile().getStatus());
		//}
		return appointments;
	}

	public static void addAppointment(Appointment appointment) {
		// TODO - implement AppointmentCatalog.addAppointment
		appointments.add(appointment);
	}

}