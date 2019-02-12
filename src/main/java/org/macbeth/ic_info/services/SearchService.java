package org.macbeth.ic_info.services;

import org.macbeth.ic_info.domain.Company;
import org.macbeth.ic_info.repos.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

    @Autowired
    private CompanyRepo companyRepo;


    public Iterable<Company> search(String inn,
                                    String ogrn,
                                    String name,
                                    String city,
                                    String street,
                                    String building)
    {
        Iterable<Company> companies = null;

        if(inn != null && !inn.isEmpty()){

            companies = companyRepo.findByInn(inn);
        }

        if(ogrn != null && !ogrn.isEmpty()){

            companies = companyRepo.findByOgrn(ogrn);
        }

        if(name!= null && !name.isEmpty() ||
                city!= null && !city.isEmpty() ||
                street!= null && !street.isEmpty()||
                building!= null && !building.isEmpty())
        {
            companies = companyRepo.findFaceted(name, city, street, building);
        }


        if (companies == null){

            companies = companyRepo.findAll();
        }

        return companies;
    }

}
