package org.macbeth.ic_info;

import org.macbeth.ic_info.domain.Company;
import org.macbeth.ic_info.repos.CompanyRepo;
import org.macbeth.ic_info.services.CompanyService;
import org.macbeth.ic_info.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    private CompanyRepo companyRepo;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private SearchService searchService;

    @GetMapping
    public String main(Model model){

        Iterable<Company> companies = companyRepo.findAll();

        model.addAttribute("companies", companies);
        return "main";
    }

    @PostMapping
    public String addCompany(
            @Valid Company company,
            BindingResult bindingResult,
            Model model)
    {
        companyService.save(bindingResult, company);

        Iterable<Company> companies = companyRepo.findAll();
        model.addAttribute("companies", companies);

        return "main";
    }

    @PostMapping("search")
    public String search(
            @RequestParam String inn,
            @RequestParam String ogrn,
            @RequestParam String name,
            @RequestParam String city,
            @RequestParam String street,
            @RequestParam String building,
            Model model
    ){
        Iterable<Company> companies = searchService.search(inn, ogrn, name, city, street, building);

        model.addAttribute("companies", companies);

        return "main";
    }

    @RequestMapping("delete")
    public String deleteCompany(@RequestParam Long id, Model model){

        companyService.delete(id);

        Iterable<Company> companies = companyRepo.findAll();
        model.addAttribute("companies", companies);
        return "redirect:/";
    }
}
