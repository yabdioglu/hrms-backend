package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CVTalent;

public interface CVTalentDao extends JpaRepository<CVTalent, Integer>{

}
