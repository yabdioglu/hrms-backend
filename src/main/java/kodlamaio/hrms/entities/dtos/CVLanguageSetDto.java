package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.entities.concretes.Language;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CVLanguageSetDto {
	private int curriculumVitaeId;
	private Language language;
	private short level;

}
