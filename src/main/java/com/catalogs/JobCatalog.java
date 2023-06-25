package com.catalogs;

import com.carops.Customer;
import com.carops.Job;

import java.io.*;
import java.util.ArrayList;

public class JobCatalog {
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

	public void save(){
		try {
			FileOutputStream fileOut = new FileOutputStream("jobs.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(jobs);
			out.close();
			fileOut.close();
		}
		catch(IOException i) {
			i.printStackTrace();
		}
	}
	public ArrayList<Job> getJobsFromFile(){
		try {
			FileInputStream fileIn = new FileInputStream("jobs.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			jobs = (ArrayList<Job>)in.readObject();
			fileIn.close();
			in.close();
		}
		catch(IOException | ClassNotFoundException exc1)
		{
			exc1.printStackTrace();
		}
		return jobs;
	}
}