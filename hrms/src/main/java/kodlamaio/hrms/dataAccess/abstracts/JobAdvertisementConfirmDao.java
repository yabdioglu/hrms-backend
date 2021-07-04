package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobAdvertisementConfirm;

public interface JobAdvertisementConfirmDao extends JpaRepository<JobAdvertisementConfirm, Integer> {

}
