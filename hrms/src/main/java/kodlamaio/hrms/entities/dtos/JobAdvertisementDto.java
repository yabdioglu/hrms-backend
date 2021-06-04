package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {
	private String companyName;
	private String jobTitleName;
	private int numberOfOpenPositions;
	private LocalDateTime createdDate;
	private LocalDate applicationDeadline;

}
