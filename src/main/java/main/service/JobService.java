package main.service;

import main.model.dto.JobDTO;
import main.model.entity.JobEntity;
import main.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    JobRepository jobRepository;


    public List<JobDTO>getAllJobs(){
        List<JobEntity> jobEntities = jobRepository.findAll();
        List<JobDTO>jobDTOS =new ArrayList<>();

        for (JobEntity jobEntity : jobEntities){
            JobDTO jobDTO =new JobDTO();
            jobDTO.setJob_id(jobEntity.getJob_id());
            jobDTO.setTitle(jobEntity.getTitle());
            jobDTO.setDescription(jobEntity.getDescription());
            jobDTO.setSalary(jobEntity.getSalary());
            jobDTO.setSalary_date(jobEntity.getSalary_date());

            jobDTOS.add(jobDTO);
        }
        return jobDTOS;
    }
    public void addjobs(JobDTO jobDTO ){
        JobEntity jobEntity =new JobEntity();
        jobEntity.setJob_id(jobDTO.getJob_id());
        jobEntity.setTitle(jobDTO.getTitle());
        jobEntity.setDescription(jobDTO.getDescription());
        jobEntity.setSalary(jobDTO.getSalary());
        jobEntity.setSalary_date(jobDTO.getSalary_date());

        jobRepository.save(jobEntity);
    }

    public JobDTO searchJobs(Integer job_id ){
        Optional<JobEntity> jobEntity = jobRepository.findById(job_id);
        if (jobEntity.isPresent()){
            JobEntity jobEntity1 = jobEntity.get();
            JobDTO jobDTO=new JobDTO();
            jobDTO.setJob_id(jobEntity1.getJob_id());
            jobDTO.setTitle(jobEntity1.getTitle());
            jobDTO.setDescription(jobEntity1.getDescription());
            jobDTO.setSalary(jobEntity1.getSalary());
            jobDTO.setSalary_date(jobEntity1.getSalary_date());

            return jobDTO;
        }
        return null;
    }

    public void updateJobs(JobDTO jobDTO){
        JobEntity jobEntity = new JobEntity();
        jobEntity.setJob_id(jobDTO.getJob_id());
        jobEntity.setTitle(jobDTO.getTitle());
        jobEntity.setDescription(jobDTO.getDescription());
        jobEntity.setSalary(jobDTO.getSalary());
        jobEntity.setSalary_date(jobDTO.getSalary_date());

        jobRepository.save(jobEntity);
    }

    public void deleteJobs(Integer job_id ){
        jobRepository.deleteById(job_id);
    }
}
