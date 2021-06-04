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
		return new SuccessResult("CV başarıyla eklendi.");
	}

	@Override
	public DataResult<List<CurriculumVitae>> getAll() {
		return new SuccessDataResult<List<CurriculumVitae>>(this.curriculumVitaeDao.findAll(), "CV listelendi");
	}
	
	@Override
	public DataResult<CurriculumVitae> imageUpload(int curriculumVitaeId, MultipartFile multipartFile)
			throws IOException {
		CurriculumVitae curriculumVitae = this.curriculumVitaeDao.findById(curriculumVitaeId).get();
		var result = this.imageCloudinaryService.imageUpload(multipartFile);
		curriculumVitae.setPhotoLink(result.getData().get("url").toString());
		this.curriculumVitaeDao.save(curriculumVitae);
		return new SuccessDataResult<>("Fotoğrafınız başarıyla kaydedildi.");
	}

	@Override
	public DataResult<CurriculumVitae>getByCurriculumId(int id) {
		return new SuccessDataResult<CurriculumVitae>(this.curriculumVitaeDao.findById(id).get(), "CV listelendi.");
	}

}
