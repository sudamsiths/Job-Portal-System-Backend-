package main.controller;

import main.model.dto.JobDTO;
import main.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

    @Autowired
    JobService jobService ;

    @GetMapping("getAll-Jobs")
    public List<JobDTO>getAllJobs(){
        return jobService.getAllJobs();
    }

    @PostMapping("/add-Jobs")
    public void addjobs(@RequestBody JobDTO jobDTO ){
        jobService.addjobs(jobDTO);
    }

    @GetMapping("{job_id}")
    public JobDTO searchJobs(@PathVariable Integer job_id){
        return jobService.searchJobs(job_id);
    }
    @PutMapping
    public void updateJobs(@RequestBody JobDTO jobDTO ){
        jobService.updateJobs(jobDTO);
    }
    @DeleteMapping("{job_id}")
    public void deleteJobs(@PathVariable Integer job_id ){
        jobService.deleteJobs(job_id);
    }


}
