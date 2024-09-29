package co.grandcircus.jobposting_api;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;


public interface JobRepository extends JpaRepository<JobPosting,Long> {
List<JobPosting> findByapplied(Optional<Boolean> applied);
List<JobPosting> findByCompanyName(Optional<String> company);
}
