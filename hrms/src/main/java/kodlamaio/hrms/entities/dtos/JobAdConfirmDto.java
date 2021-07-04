package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JobAdConfirmDto {
	private int jobAdvertisementId;
	private int employeeId;

}
