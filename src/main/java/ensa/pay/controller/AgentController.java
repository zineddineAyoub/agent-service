package ensa.pay.controller;

import java.util.List;
import java.util.Optional;

import ensa.pay.Repository.AgencyRepository;
import ensa.pay.models.Agency;
import ensa.pay.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ensa.pay.Repository.AgentRepository;
import ensa.pay.Repository.FilesRepository;
import ensa.pay.models.Agent;
import ensa.pay.models.Files;

@RestController
@RequestMapping("agent")
public class AgentController {

	@Autowired
	private AgentService agentService;
	

	@PostMapping( consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public Agent insertAgent(Agent agent, Files file) {
		return this.agentService.saveOrUpdate(agent,file);
	}

	
	@GetMapping
	public List<Agent> listAgent(){
		return this.agentService.getAll();
	}
	
	@GetMapping("/{id_agent}")
	public Agent getAgentById(@PathVariable String id_agent)
	{
		return this.agentService.findById(id_agent);
	}
	
	@GetMapping("/get/{tel}")
	public Agent getAgentByTel(@PathVariable String tel){
		return agentService.getAgentByTel(tel);
	}
	
	@DeleteMapping("/{id_agent}")
	public String deleteAgent(@PathVariable String id_agent)
	{
		 this.agentService.delete(id_agent);
		 return "Deleted";
		
	}


}
