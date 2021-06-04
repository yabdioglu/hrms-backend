package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CVLanguage;

public interface CVLanguageDao extends JpaRepository<CVLanguage, Integer>{

}
