package kodlamaio.hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	List<JobAdvertisement> getByIsActiveTrueAndEmployer_CompanyName(String companyName);
	List<JobAdvertisement> getByIsActiveTrueOrderByCreatedDate();
}
