package kodlamaio.hrms.business.concretes;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CVExperienceService;
import kodlamaio.hrms.business.abstracts.CVLanguageService;
import kodlamaio.hrms.business.abstracts.CVSchoolService;
import kodlamaio.hrms.business.abstracts.CVTalentService;
import kodlamaio.hrms.business.abstracts.CVWebAddressService;
import kodlamaio.hrms.business.abstracts.CurriculumVitaeService;
import kodlamaio.hrms.core.services.cloudinary.ImageCloudinaryService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import kodlamaio.hrms.entities.concretes.CVExperience;
import kodlamaio.hrms.entities.concretes.CVLanguage;
import kodlamaio.hrms.entities.concretes.CVSchool;
import kodlamaio.hrms.entities.concretes.CVTalent;
import kodlamaio.hrms.entities.concretes.CVWebAddress;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;

@Component
public class CurriculumVitaeManager implements CurriculumVitaeService {

	private CurriculumVitaeDao curriculumVitaeDao;
	private CVExperienceService cvExperienceService;
	private CVLanguageService cvLanguageService;
	private CVSchoolService cvSchoolService;
	private CVTalentService cvTalentService;
	private CVWebAddressService cvWebAddressService;
	private ImageCloudinaryService imageCloudinaryService;
	
	@Autowired
	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao, CVExperienceService cvExperienceService, CVLanguageService cvLanguageService, 
			 CVSchoolService cvSchoolService, CVTalentService cvTalentService, CVWebAddressService cvWebAddressService, ImageCloudinaryService imageCloudinaryService) {
		super();
		this.curriculumVitaeDao = curriculumVitaeDao;
		this.cvExperienceService = cvExperienceService;
		this.cvLanguageService = cvLanguageService;
		this.cvSchoolService = cvSchoolService;
		this.cvTalentService = cvTalentService;
		this.cvWebAddressService = cvWebAddressService;
		this.imageCloudinaryService = imageCloudinaryService;
	}
	
	@Override
	public Result add(CurriculumVitae curriculumVitae) {
		this.curriculumVitaeDao.save(curriculumVitae);
		for(CVExperience cvExperience:curriculumVitae.getCvExperiences()){
			cvExperience.setCurriculumVitae(curriculumVitae);
			cvExperienceService.add(cvExperience);
	        }
		for(CVLanguage cvLanguage:curriculumVitae.getCvLanguages()){
			cvLanguage.setCurriculumVitae(curriculumVitae);
			cvLanguageService.add(cvLanguage);
	        }
		for(CVSchool cvSchool:curriculumVitae.getCvSchools()){
			cvSchool.setCurriculumVitae(curriculumVitae);
			cvSchoolService.add(cvSchool);
	        }
		for(CVTalent cvTalent:curriculumVitae.getCvTalents()){
			cvTalent.setCurriculumVitae(curriculumVitae);
		   	cvTalentService.add(cvTalent);
	        }
		for(CVWebAddress cvWebAddress:curriculumVitae.getCvWebAddresses()){
		   cvWebAddress.setCurriculumVitae(curriculumVitae);
		   cvWebAddressService.add(cvWebAddress);
	        }
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
