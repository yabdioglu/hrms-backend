package kodlamaio.hrms.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_ad_confirms")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementConfirm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int jobAdConfirmId;
	
	@Column(name = "confirmed_date")
	private LocalDateTime confirmedDate = LocalDateTime.now();
	
	@OneToOne()
	@JoinColumn(name = "job_advertisement_id")
	private JobAdvertisement jobAdvertisement;
	
	@ManyToOne()
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
	
}
