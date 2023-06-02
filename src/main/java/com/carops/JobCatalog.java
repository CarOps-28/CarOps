package com.carops;

import java.util.ArrayList;

public class JobCatalog {
	private static ArrayList<Job> jobs = new ArrayList<Job>();

	public static ArrayList<Job> fetchJobs() {
		return jobs;
	}

	public static void addJob(Job job) {
		jobs.add(job);
	}

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
}