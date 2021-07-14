package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CVExperience;

public interface CVExperienceDao extends JpaRepository<CVExperience, Integer>{
	List<CVExperience> getByCurriculumVitaeId(int curriculumId);
}
