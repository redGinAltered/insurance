package org.macbeth.ic_info.repos;

import org.macbeth.ic_info.domain.Company;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface CompanyRepo extends CrudRepository<Company, Long> {


    Set<Company> findByInn(String inn);
    Set<Company> findByOgrn(String ogrn);


    //YES I KNOW HOW IT LOOKS LIKE
    //TERRIBLE MAXIMALE
    Set<Company> findByNameIgnoreCaseContainingAndCityIgnoreCaseContainingAndStreetIgnoreCaseContainingAndBuildingIgnoreCaseContaining(String name, String city, String street, String building);

    default Set<Company> findFaceted(String name, String city, String street, String building){

        return findByNameIgnoreCaseContainingAndCityIgnoreCaseContainingAndStreetIgnoreCaseContainingAndBuildingIgnoreCaseContaining(name, city, street, building);
    }


}
