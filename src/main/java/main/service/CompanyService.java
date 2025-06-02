package main.service;


import main.model.dto.CompanyDTO;
import main.model.dto.JobDTO;
import main.model.entity.CompanyEntity;
import main.model.entity.JobEntity;
import main.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {


    @Autowired
    CompanyRepository companyRepository ;

    public List<CompanyDTO>getAllCompany(){
        List<CompanyEntity> companyEntities = companyRepository.findAll();
        List<CompanyDTO> companyDTOS =new ArrayList<>();

        for (CompanyEntity companyEntity : companyEntities ){
            CompanyDTO companyDTO =new CompanyDTO();;
            companyDTO.setCompany_id(companyEntity.getCompany_id());
            companyDTO.setName(companyEntity.getName());
            companyDTO.setLocation(companyEntity.getLocation());
            companyDTO.setIndustry(companyEntity.getIndustry());

            companyDTOS.add(companyDTO);
        }
        return companyDTOS;
    }

    public void addCompany(CompanyDTO companyDTO ){
        CompanyEntity companyEntity =new CompanyEntity();
        companyEntity.setCompany_id(companyDTO.getCompany_id());
        companyEntity.setName(companyDTO.getName());
        companyEntity.setLocation(companyDTO.getLocation());
        companyEntity.setIndustry(companyDTO.getIndustry());

        companyRepository.save(companyEntity);
    }

    public CompanyDTO searchCompany(Integer company_id){
        Optional<CompanyEntity> companyEntity = companyRepository.findById(company_id);
        if (companyEntity.isPresent()) {
            CompanyEntity companyEntity1 = companyEntity.get();
            CompanyDTO companyDTO = new CompanyDTO();
            companyDTO.setCompany_id(companyEntity1.getCompany_id());
            companyDTO.setName(companyEntity1.getName());
            companyDTO.setLocation(companyEntity1.getLocation());
            companyDTO.setIndustry(companyEntity1.getIndustry());

            return companyDTO;
        }
        return null;
    }

    public void updateCompany(CompanyDTO companyDTO){
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setCompany_id(companyDTO.getCompany_id());
        companyEntity.setName(companyDTO.getName());
        companyEntity.setLocation(companyDTO.getLocation());
        companyEntity.setIndustry(companyDTO.getIndustry());

        companyRepository.save(companyEntity);
    }

    public void deleteCompany(Integer company_id){
        companyRepository.deleteById(company_id);
    }
}
