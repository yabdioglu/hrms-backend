package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_advertisements")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int jobAdvertisementId;
	
	@Column(name = "job_description")
	private String jobDescription;
	
	@Column(name = "min_salary")
	private double minSalary;
	
	@Column(name = "max_salary")
	private double maxSalary;
	
	@Column(name = "number_of_open_positions")
	private int numberOfOpenPositions;
	
	@Column(name = "application_deadline")
	private LocalDate applicationDeadline;
	
	
	@Column(name = "created_date")
	private LocalDate createdDate = LocalDate.now();
	
	@JsonIgnore
	@Column(name = "is_active")
	private boolean isActive = true;
	
	@JsonIgnore
	@Column(name = "is_deleted")
	private boolean isDeleted;
	
	
	@Column(name = "is_confirmed")
	private boolean isConfirmed = false;
	
	@ManyToOne()
	@JoinColumn(name = "city_id", referencedColumnName = "city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name = "work_place_id", referencedColumnName = "place_id")
	private WorkPlace workPlace;
	
	@ManyToOne()
	@JoinColumn(name = "work_time_id", referencedColumnName = "time_id")
	private WorkTime workTime;
	
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name = "job_title_id")
	private JobTitle jobTitle;
	
	@JsonIgnore
	@OneToOne(mappedBy = "jobAdvertisement")
	private JobAdvertisementConfirm jobAdvertisementConfirm;

}
