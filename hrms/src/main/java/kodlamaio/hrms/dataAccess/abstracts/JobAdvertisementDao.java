package kodlamaio.hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	
	@Query("select new kodlamaio.hrms.entities.dtos.JobAdvertisementDto(e.companyName,j.jobTitle.title, j.numberOfOpenPositions, j.createdDate, j.applicationDeadline )"
			+ "from Employer e inner join e.jobAdvertisements j")
	List<JobAdvertisementDto> getAll();
	
	@Query("select new kodlamaio.hrms.entities.dtos.JobAdvertisementDto(e.companyName,j.jobTitle.title, j.numberOfOpenPositions, j.createdDate, j.applicationDeadline )"
			+ "from Employer e inner join e.jobAdvertisements j where j.isActive = true and e.companyName=:companyName ")
	List<JobAdvertisementDto> getByIsActiveTrueAndCompanyName(String companyName);
	
	@Query("select new kodlamaio.hrms.entities.dtos.JobAdvertisementDto(e.companyName,j.jobTitle.title, j.numberOfOpenPositions, j.createdDate, j.applicationDeadline )"
			+ "from Employer e inner join e.jobAdvertisements j where j.isActive = true order by j.createdDate ")
	List<JobAdvertisementDto> getByIsActiveTrueOrderByCreatedDate();
	
	@Query("select new kodlamaio.hrms.entities.dtos.JobAdvertisementDto(e.companyName,j.jobTitle.title, j.numberOfOpenPositions, j.createdDate, j.applicationDeadline )"
			+ "from Employer e inner join e.jobAdvertisements j where j.isActive = true ")
	List<JobAdvertisementDto> getAdvertisementWithEmployerDetails();
}
