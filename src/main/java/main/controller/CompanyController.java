package main.controller;

import main.model.dto.CompanyDTO;
import main.model.dto.JobDTO;
import main.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping("/getAll")
    public List<CompanyDTO> getAllCompany(){
        return companyService.getAllCompany();
    }

    @PostMapping("/add")
    public void addCompany(@RequestBody CompanyDTO companyDTO){
        companyService.addCompany(companyDTO);
    }

    @GetMapping("/{company_id}")
    public CompanyDTO searchCompany(@PathVariable Integer company_id){
        return companyService.searchCompany(company_id);
    }

    @PutMapping("/{company_id}")
    public void updateCompany(@PathVariable Integer company_id, @RequestBody CompanyDTO companyDTO){
        companyDTO.setCompany_id(company_id);
        companyService.updateCompany(companyDTO);
    }

    @DeleteMapping("/{company_id}")
    public void deleteCompany(@PathVariable Integer company_id){
        companyService.deleteCompany(company_id);
    }
}
