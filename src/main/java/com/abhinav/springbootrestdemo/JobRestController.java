package com.abhinav.springbootrestdemo;

import com.abhinav.springbootrestdemo.model.JobPost;
import com.abhinav.springbootrestdemo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobRestController {

    @Autowired
    JobService service;

    @GetMapping(path="jobs", produces="application/json")
//    @ResponseBody
    public List<JobPost> getJobs(){
        return service.getAllJobs();
    }

    @GetMapping("job/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId){
        return service.getJob(postId);
    }

    @PostMapping(path="job", consumes = "application/xml")
    public JobPost postJob(@RequestBody JobPost job){
        service.addJob(job);
        return service.getJob(job.getPostId());
    }

    @PutMapping("job")
    public JobPost updateJob(@RequestBody JobPost job){
        service.updateJob(job);
        return service.getJob(job.getPostId());
    }

    @DeleteMapping("job/{postId}")
    public String deleteJob(@PathVariable int postId){
        service.deleteJob(postId);
        return "Deleted";
    }

    @GetMapping("load")
    public String loadData(){
        service.loadData();
        return "success";
    }

    @GetMapping("jobs/keyword/{keyword}")
    List<JobPost> searchKeyword(@PathVariable String keyword){
        return service.search(keyword);
    }

}
