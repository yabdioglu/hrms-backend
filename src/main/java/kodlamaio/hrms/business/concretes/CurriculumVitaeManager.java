package kodlamaio.hrms.business.concretes;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


import kodlamaio.hrms.business.abstracts.CurriculumVitaeService;
import kodlamaio.hrms.core.services.cloudinary.ImageCloudinaryService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;
@Component
public class CurriculumVitaeManager implements CurriculumVitaeService {

	private CurriculumVitaeDao curriculumVitaeDao;
	private ImageCloudinaryService imageCloudinaryService;
	
	@Autowired
	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao, ImageCloudinaryService imageCloudinaryService) {
		super();
		this.curriculumVitaeDao = curriculumVitaeDao;
		this.imageCloudinaryService = imageCloudinaryService;
	}
	
	@Override
	public Result add(CurriculumVitae curriculumVitae) {
		this.curriculumVitaeDao.save(curriculumVitae);
		return new SuccessResult("CV successfully added.");
	}

	@Override
	public DataResult<List<CurriculumVitae>> getAll() {
		return new SuccessDataResult<List<CurriculumVitae>>(this.curriculumVitaeDao.findAll(), "CV listed.");
	}
	
	@Override
	public DataResult<CurriculumVitae> imageUpload(int curriculumVitaeId, MultipartFile multipartFile)
			throws IOException {
		CurriculumVitae curriculumVitae = this.curriculumVitaeDao.findById(curriculumVitaeId).get();
		var result = this.imageCloudinaryService.imageUpload(multipartFile);
		curriculumVitae.setPhotoLink(result.getData().get("url").toString());
		this.curriculumVitaeDao.save(curriculumVitae);
		return new SuccessDataResult<>("Your photo was successfully saved.");
	}

	@Override
	public DataResult<CurriculumVitae>getByCurriculumId(int id) {
		return new SuccessDataResult<CurriculumVitae>(this.curriculumVitaeDao.findById(id).get(), "CV listed.");
	}

	@Override
	public Result updateSummary(String summary, int curriculumVitaeId) {
		CurriculumVitae curriculumVitae = this.curriculumVitaeDao.findById(curriculumVitaeId).get();
		curriculumVitae.setSummary(summary);
		this.curriculumVitaeDao.save(curriculumVitae);
		return new SuccessResult("Summary updated");
	}
	
	@Override
	public Result updateGithub(String github, int curriculumVitaeId) {
		CurriculumVitae curriculumVitae = this.curriculumVitaeDao.findById(curriculumVitaeId).get();
		curriculumVitae.setGithubLink(github);
		this.curriculumVitaeDao.save(curriculumVitae);
		return new SuccessResult("Github updated");
	}
	
	@Override
	public Result updateLinkedIn(String linkedin, int curriculumVitaeId) {
		CurriculumVitae curriculumVitae = this.curriculumVitaeDao.findById(curriculumVitaeId).get();
		curriculumVitae.setLinkedInLink(linkedin);
		this.curriculumVitaeDao.save(curriculumVitae);
		return new SuccessResult("LinkedIn updated");
	}

}
