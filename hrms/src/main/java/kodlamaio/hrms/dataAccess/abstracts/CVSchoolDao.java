package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CVSchool;

public interface CVSchoolDao extends JpaRepository<CVSchool, Integer> {
	List<CVSchool> getByCurriculumVitaeId(int curriculumId);

}
