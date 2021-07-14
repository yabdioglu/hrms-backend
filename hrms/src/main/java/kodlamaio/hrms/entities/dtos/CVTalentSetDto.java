package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.entities.concretes.Talent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CVTalentSetDto {
	private int curriculumVitaeId;
	private Talent talent;

}
