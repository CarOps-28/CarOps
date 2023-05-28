package com.carops;


import java.util.ArrayList;

public class JobCatalog {
	private static ArrayList<Job> jobs = new ArrayList<Job>();
	public static ArrayList<Job> fetchJobs() {
		// TODO - implement JobCatalog.fetchJobs
		return jobs;
	}

	public static Job findJobByName (String s){
		Job jb = null;
		for ( Job job : jobs) {
			if (job.getName().equalsIgnoreCase(s))
			{
				jb = job;
				break;
			}
		}
		return jb;
	}

	public static void printData(){
		System.out.printf("\n> All Jobs in Catalog:\nn %-25s  %-10s\n", "Name", "Price");
		int i=1;
		for (Job j : jobs) {
			System.out.printf("%d|",i);
			j.printData();
			i++;
		}
	}

	public static void addJob(Job j){
		jobs.add(j);
	}

}