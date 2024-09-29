package co.grandcircus.jobposting_api;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long>{
    List<Company> findByName(Optional<String> name);
}
