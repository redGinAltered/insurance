package org.macbeth.ic_info.services;

import org.macbeth.ic_info.domain.Company;
import org.macbeth.ic_info.repos.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Set;

@Service
public class CompanyService{

    @Autowired
    private CompanyRepo companyRepo;

    public void save(BindingResult bindingResult, Company company){
        if(!bindingResult.hasErrors()){

            Set<Company> innListFromDb = companyRepo.findByInn(company.getInn());
            Set<Company> ogrnListFromDb = companyRepo.findByOgrn(company.getOgrn());

            if(innListFromDb.isEmpty() && ogrnListFromDb.isEmpty()){
                companyRepo.save(company);
            }
        }
    }

    public void delete(Long companyId){
        companyRepo.deleteById(companyId);
    }

}
