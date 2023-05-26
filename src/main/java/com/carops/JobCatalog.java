package com.carops;

import java.util.ArrayList;

public class JobCatalog {
	private static ArrayList<Job> jobs = new ArrayList<Job>();
	public static ArrayList<Job> fetchJobs() {
		return jobs;
	}
}