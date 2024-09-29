package co.grandcircus.jobposting_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;
@RestController
public class CompanyApiController {
    @Autowired
    private CompanyRepository companyRepo;
     @GetMapping("/companies")
    public List<Company> GetAll( @RequestParam(required = false) Optional<String> name ){
        if(name.isPresent()){
            return companyRepo.findByName(name);
        }
        return this.companyRepo.findAll();
    }
    @GetMapping("/companies/{id}")
    public Company GetById(@PathVariable("id") Long id){
        return this.companyRepo.findById(id).orElse(null);
    }
    @PostMapping("/companies")
    public Company AddPost(@RequestBody Company newC) {
        newC.setId(null);
        this.companyRepo.save(newC);
        return newC;
    }
    
    @DeleteMapping("/companies/{id}")
    public void DeletePost(@PathVariable ("id") Long id){
        companyRepo.deleteById(id);
    }

    @PutMapping("/companies/{id}")
    public Company UpdatePost(@PathVariable("id") Long id, @RequestBody Company updated){
        companyRepo.save(updated);
        return updated;
    }

}
