package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.JobAdConfirmDto;

public interface JobAdvertisementConfirmService {
	Result confirm(JobAdConfirmDto jobAdvertisementConfirm);
}
