package kodlamaio.hrms.core.services.cloudinary;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;

@Service
public class ImageCloudinaryManager implements  ImageCloudinaryService{

	Cloudinary cloudinary;
	
	private Map<String, String> valuesMap = new HashMap<>();
	
	public ImageCloudinaryManager() {
		
		valuesMap.put("cloud_name", "duvi6miib");
		valuesMap.put("api_key", "175277957118925");
		valuesMap.put("api_secret", "zxLf9y9bmwcfJQ9od3T829XXh7s");
		cloudinary = new Cloudinary(valuesMap);
	}
	
	@Override
	public DataResult<Map> imageUpload(MultipartFile multipartFile) throws IOException {
		
		File file = fileConvert(multipartFile);
		Map resultMap = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
		file.delete();
		return new SuccessDataResult<>(resultMap);
	}
	
	private File fileConvert(MultipartFile multipartFile) throws IOException {
		
		File file = new File(multipartFile.getOriginalFilename());
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		fileOutputStream.write(multipartFile.getBytes());
		fileOutputStream.close();
		return file;
	}

}
