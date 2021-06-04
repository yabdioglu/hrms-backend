//package kodlamaio.hrms.api.controllers;
//
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import kodlamaio.hrms.business.abstracts.CVWebAddressService;
//import kodlamaio.hrms.core.utilities.results.DataResult;
//import kodlamaio.hrms.entities.concretes.CVWebAddress;
//
//@RestController
//@RequestMapping("/api/CVWebAddress")
//public class CVWebAddressesController {
//private CVWebAddressService cvWebAddressService;
//	
//	@Autowired
//	public CVWebAddressesController(CVWebAddressService cvWebAddressService) {
//		super();
//		this.cvWebAddressService = cvWebAddressService;
//	}
//	
//	@PostMapping("/addCurriculumVitae")
//	public ResponseEntity<?> addCurriculumVitae(@Valid @RequestBody CVWebAddress cvWebAddress) {
//		return ResponseEntity.ok(this.cvWebAddressService.add(cvWebAddress));
//	}
//	
//	@GetMapping("/getall")
//	public DataResult<List<CVWebAddress>> getAll(){
//		return this.cvWebAddressService.getAll();
//	}
//
//}
