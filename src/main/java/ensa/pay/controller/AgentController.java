package ensa.pay.controller;

import java.util.List;

import ensa.pay.models.Files;
import ensa.pay.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import ensa.pay.models.Agent;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("agent")
public class AgentController {

	@Autowired
	private AgentService agentService;
	

	@PostMapping( consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public Agent insertAgent(Agent agent,Files files) {

		/*if(files==null){
			System.out.println("this is null");
					return null;
		}*/
			//System.out.println("not null haha");
			//System.out.println(files);
		//return files;
		return this.agentService.saveOrUpdate(agent,files);
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
	public void deleteAgent(@PathVariable String id_agent)
	{
		 this.agentService.delete(id_agent);
		
	}

	@DeleteMapping("/file/{id_file}")
	public void deletefile(@PathVariable String id_file){
		this.agentService.deleteFile(id_file);
	}

}
