package com.sudhir03.JobApp;

import com.sudhir03.JobApp.model.JobPost;
import com.sudhir03.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController //To send data as json,not as pages...
@CrossOrigin(origins = "http://localhost:3000")
public class JobController {

    @Autowired
    private JobService service;

    @GetMapping("data")
    public List<JobPost> rest(){
        System.out.println("data send");
        return service.getAllJobs();
    }
    @GetMapping({"/","home"})
    public String home(){
        return "home";
    }

    @GetMapping("addjob")
    public String addJob(){
        return "addjob";
    }

    @PostMapping("handleForm")
    public String handleForm(JobPost jobPost){
        service.addJob(jobPost);
        return "success";
    }

    @GetMapping("viewalljobs")
    public String viewJobs(Model m){
        List<JobPost> jobs=service.getAllJobs();
        m.addAttribute("jobPosts",jobs);
        return "viewalljobs";
    }

//    @CrossOrigin
//    @GetMapping("/api")
//    public void call(){
//        System.out.print("hello world!!!");
//    }
}
