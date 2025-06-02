package main.controller;

import main.model.dto.JobDTO;
import main.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/job")
public class JobController {

    @Autowired
    JobService jobService;

    @GetMapping("/getAll")
    public List<JobDTO> getAllJobs(){
        return jobService.getAllJobs();
    }

    @PostMapping("/add")
    public void addJobs(@RequestBody JobDTO jobDTO){
        jobService.addjobs(jobDTO);
    }

    @GetMapping("/{job_id}")
    public JobDTO searchJobs(@PathVariable Integer job_id){
        return jobService.searchJobs(job_id);
    }

    @PutMapping("/{job_id}")
    public void updateJobs(@PathVariable Integer job_id, @RequestBody JobDTO jobDTO){
        jobDTO.setJob_id(job_id);
        jobService.updateJobs(jobDTO);
    }

    @DeleteMapping("/{job_id}")
    public void deleteJobs(@PathVariable Integer job_id){
        jobService.deleteJobs(job_id);
    }
}
