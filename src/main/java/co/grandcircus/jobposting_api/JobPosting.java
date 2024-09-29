package co.grandcircus.jobposting_api;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity

public class JobPosting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne
    private Company company;
    private boolean applied;
    public Long getId() {
        return id;
    }
    public JobPosting(Long id, String title, Company company, boolean applied, LocalDate dateApplied, String result) {
        this.id = id;
        this.title = title;
        this.company = company;
        this.applied = applied;
        this.dateApplied = dateApplied;
        this.result = result;
    }
    public JobPosting() {
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Company getCompany() {
        return company;
    }
    public void setCompany(Company company) {
        this.company = company;
    }
    public boolean isApplied() {
        return applied;
    }
    public void setApplied(boolean applied) {
        this.applied = applied;
    }
    public LocalDate getDateApplied() {
        return dateApplied;
    }
    public void setDateApplied(LocalDate dateApplied) {
        this.dateApplied = dateApplied;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
    private LocalDate dateApplied;
    private String result;

}
