package kodlamaio.hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	

	List<JobAdvertisement> getByIsActiveTrueAndEmployer_CompanyName(String companyName);
	List<JobAdvertisement> getByIsActiveTrueOrderByCreatedDate();
	
	@Query("select new kodlamaio.hrms.entities.dtos.JobAdvertisementDto(e.companyName,j.jobTitle.title, j.numberOfOpenPositions, j.createdDate, j.applicationDeadline )"
			+ "from Employer e inner join e.jobAdvertisements j where j.isActive = true ")
	List<JobAdvertisementDto> getAdvertisementWithEmployerDetails();
}
