package kodlamaio.hrms.core.services.cloudinary;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;

public interface ImageCloudinaryService {
	DataResult<Map> imageUpload(MultipartFile multipartFile) throws IOException;

}
