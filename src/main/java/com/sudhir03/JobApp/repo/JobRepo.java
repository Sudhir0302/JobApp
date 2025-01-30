package com.sudhir03.JobApp.repo;

import com.sudhir03.JobApp.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JobRepo {

    List<JobPost> jobs = new ArrayList<>(Arrays.asList(
            new JobPost(
                    1,
                    "Software Engineer",
                    "Responsible for developing and maintaining applications.",
                    3,
                    Arrays.asList("Java", "Spring Boot", "MySQL")
            ),
            new JobPost(
                    2,
                    "Frontend Developer",
                    "Develop interactive web pages and user interfaces.",
                    2,
                    Arrays.asList("HTML", "CSS", "JavaScript", "React")
            ),
            new JobPost(
                    3,
                    "Data Analyst",
                    "Analyze data trends and generate actionable insights.",
                    1,
                    Arrays.asList("Python", "SQL", "Tableau", "Power BI")
            )
    ));

    public List<JobPost> getAllJobs(){
        return jobs;
    }

    public void addJob(JobPost job){
        jobs.add(job);
        System.out.println("added jobs "+jobs);
    }

}
