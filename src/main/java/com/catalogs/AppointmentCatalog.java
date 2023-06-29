package com.catalogs;

import com.carops.Appointment;

import java.io.*;
import java.util.ArrayList;

public class AppointmentCatalog {
	private static String url = "files/appointments.ser";

	private static ArrayList<Appointment> appointments = new ArrayList<>();

	public static ArrayList<Appointment> fetchAppointments() {
		return appointments;
	}

	public static void addAppointment(Appointment appointment) {
		appointments.add(appointment);
	}

	public static void printData() {
		System.out.printf("\n> All Appointments in catalog:\n" + "n %-25s  %-15s  %-14s  %-20s  %-20s  %-20s  %-20s\n",
				"Date","Name", "Surname", "Phone number", "Vehicle Plate", "Brand", "Τype");
		int i = 1;
		for (Appointment appointment : appointments) {
			System.out.printf("%d", i);
			appointment.printData();
			i++;
		}
	}

	public static void save(){
		try {
			FileOutputStream fileOut = new FileOutputStream(url);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(appointments);
			out.close();
			fileOut.close();
		}
		catch(IOException i) {
			i.printStackTrace();
		}
	}
	public static boolean refreshDataFromFile(){
		try {
			FileInputStream fileIn = new FileInputStream(url);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			appointments = (ArrayList<Appointment>)in.readObject();
			fileIn.close();
			in.close();
		}
		catch(IOException | ClassNotFoundException exc1)
		{
			return false;
		}
		return true;
	}

	public static Appointment getAppointmentById(String id){
		for (Appointment app : appointments){
			if (app.getId().equals(id)){
				return app;
			}
		}
		return null;
	}

}