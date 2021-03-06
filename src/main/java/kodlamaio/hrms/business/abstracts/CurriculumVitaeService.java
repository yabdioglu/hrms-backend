package kodlamaio.hrms.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;

public interface CurriculumVitaeService {
	Result add(CurriculumVitae curriculumVitae);
	DataResult<List<CurriculumVitae>> getAll();
	DataResult<CurriculumVitae> imageUpload(int curriculumVitaeId, MultipartFile multipartFile) throws IOException;
	DataResult<CurriculumVitae> getByCurriculumId(int id);
	Result updateSummary(String summary, int cvId);
	Result updateGithub(String github, int cvId);
	Result updateLinkedIn(String linkedin, int cvId);

}
