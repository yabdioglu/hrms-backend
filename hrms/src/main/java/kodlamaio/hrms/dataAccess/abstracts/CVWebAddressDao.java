package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CVWebAddress;

public interface CVWebAddressDao extends JpaRepository<CVWebAddress, Integer> {

}
