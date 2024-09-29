package co.grandcircus.jobposting_api;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class JobPostingApiController {

    @Autowired
    private JobRepository jobRepo;

    @GetMapping("/")
    public String getDefault() {
        return "Hello";
    }

    @GetMapping("/JobPostings")
    public List<JobPosting> GetAll(@RequestParam(required = false)Optional <Boolean> applied,
                                    @RequestParam(required = false) Optional<String> company) {
        if(applied.isPresent()){
            return jobRepo.findByapplied(applied);
        }
        if (company.isPresent()) {
            return jobRepo.findByCompanyName(company);
        }
        return this.jobRepo.findAll();
    }
     @GetMapping("/JobPostings/{id}")
    public JobPosting GetById(@PathVariable ("id") Long id){
        return this.jobRepo.findById(id).orElse(null);
    }

    @PostMapping("/JobPostings")
    public JobPosting AddUser(@RequestBody JobPosting newJ){
        newJ.setId(null);
        this.jobRepo.save(newJ);
        return newJ;
    }  
    @DeleteMapping("/JobPostings/{id}")
    public void DeleteUser(@PathVariable ("id") Long id){
        jobRepo.deleteById(id);
    }

    @PutMapping("/JobPostings/{id}")
    public JobPosting UpdateUser(@PathVariable ("id") Long id, @RequestBody JobPosting updated){
       jobRepo.save(updated);
       return updated;
    }
   
    

}
