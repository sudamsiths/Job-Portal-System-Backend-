package main.controller;

import main.model.dto.CompanyDTO;
import main.model.dto.JobDTO;
import main.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    CompanyService companyService ;


    @GetMapping("/getAll-Companys")
    public List<CompanyDTO>getAllCompany(){
        return companyService.getAllCompany();
    }
    @PostMapping("/add-Company")
    public void addjobs(@RequestBody CompanyDTO companyDTO ){
        companyService.addCompany(companyDTO);
    }

    @GetMapping("{company_id}")
    public CompanyDTO searchCompany(@PathVariable Integer company_id){
        return companyService.searchCompany(company_id);
    }

    @PutMapping
    public void updateCompany(@RequestBody CompanyDTO companyDTO ){
        companyService.updateCompany(companyDTO);
    }

    @DeleteMapping("{company_id}")
    public void deleteCompany(@PathVariable Integer company_id){
        companyService.deleteCompany(company_id);
    }

}
