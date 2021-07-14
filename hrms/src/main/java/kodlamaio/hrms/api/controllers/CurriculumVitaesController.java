package kodlamaio.hrms.api.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CurriculumVitaeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;

@RestController
@RequestMapping("/api/curriculumVitae")
@CrossOrigin
public class CurriculumVitaesController {
	
	private CurriculumVitaeService curriculumVitaeService;
	
	@Autowired
	public CurriculumVitaesController(CurriculumVitaeService curriculumVitaeService) {
		super();
		this.curriculumVitaeService = curriculumVitaeService;
	}
	
	@PostMapping("/addCurriculumVitae")
	public ResponseEntity<?> addCurriculumVitae(@Valid @RequestBody CurriculumVitae curriculumVitae) {
		return ResponseEntity.ok(this.curriculumVitaeService.add(curriculumVitae));
	}
	
	@GetMapping("/getall")
	public DataResult<List<CurriculumVitae>> getAll(){
		return this.curriculumVitaeService.getAll();
	}
	
	@PostMapping("/imageUpload")
	public ResponseEntity<?> imageUpload(@RequestParam int curriculumVitaeId, @RequestParam MultipartFile multipartFile) throws IOException {
		return new ResponseEntity<>(this.curriculumVitaeService.imageUpload(curriculumVitaeId, multipartFile),HttpStatus.OK);
	}
	
	@GetMapping("/getByCurriculumId")
	public DataResult<CurriculumVitae> getByCurriculumId(@RequestParam int curriculumId){
		return this.curriculumVitaeService.getByCurriculumId(curriculumId);
	}
	
	@PutMapping("/updateSummary")
	public ResponseEntity<?> updateSummary(@RequestParam String summary, @RequestParam int cvId){
		return new ResponseEntity<>(this.curriculumVitaeService.updateSummary(summary, cvId),HttpStatus.OK);
	}
	
	@PutMapping("/updateGithub")
	public ResponseEntity<?> updateGithub(@RequestParam String github, @RequestParam int cvId){
		return new ResponseEntity<>(this.curriculumVitaeService.updateGithub(github, cvId),HttpStatus.OK);
	}
	
	@PutMapping("/updateLinkedIn")
	public ResponseEntity<?> updateLinkedIn(@RequestParam String linkedin, @RequestParam int cvId){
		return new ResponseEntity<>(this.curriculumVitaeService.updateLinkedIn(linkedin, cvId),HttpStatus.OK);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		Map<String, String> validationErrors = new HashMap<String, String>();
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Validation errors");
		return errors;
	}

}
