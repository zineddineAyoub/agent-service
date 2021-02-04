package ensa.pay.controller;

import java.util.List;

import ensa.pay.models.Agent;
import ensa.pay.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ensa.pay.models.Agency;


@RestController
@RequestMapping("agency")
@CrossOrigin(origins = "*")
public class AgencyController {

	@Autowired
	private AgencyService agencyService;

	@GetMapping
	public List<Agency> listAgence(){
		return this.agencyService.getAll();
	}

	@GetMapping("/{id}")
	public Agency getAgencyById(@PathVariable String id){
		return agencyService.findById(id);
	}

	@GetMapping("/agent/{phone_number}")
	public Agency getAgencyByPhoneNumber(@PathVariable String phone_number){
		return agencyService.findByPhoneNumber(phone_number);
	}

	@PostMapping
	public Agency insertAgence(@RequestBody Agency agency) {
		return agencyService.saveOrUpdate(agency);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		this.agencyService.delete(id);

	}
	
}
