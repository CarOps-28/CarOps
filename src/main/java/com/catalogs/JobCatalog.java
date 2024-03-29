package com.catalogs;

import com.carops.Customer;
import com.carops.Job;

import java.io.*;
import java.util.ArrayList;

public class JobCatalog {
	private static String url = "files/jobs.ser";

	private static ArrayList<Job> jobs = new ArrayList<Job>();

	public static ArrayList<Job> fetchJobs() {
		return jobs;
	}

	public static void addJob(Job job) { jobs.add(job); }

	public static void printData() {
		System.out.printf("\n> All Jobs in catalog:\nn %-25s   %-10s\n", "Name", "Price");
		int i = 1;
		for (Job job : jobs) {
			System.out.printf("%d", i);
			job.printData();
			i++;
		}
	}

	public static Job findJobByName(String jobName) {
		for (Job job : jobs) {
			if (job.getName().equalsIgnoreCase(jobName)) {
				return job;
			}
		}
		return null;
	}

	public static void save(){
		try {
			FileOutputStream fileOut = new FileOutputStream(url);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(jobs);
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
			jobs = (ArrayList<Job>)in.readObject();
			fileIn.close();
			in.close();
		}
		catch(IOException | ClassNotFoundException exc1)
		{
			return false;
		}
		return true;
	}
}