package ensa.pay.service;

import ensa.pay.Repository.AgencyRepository;
import ensa.pay.Repository.AgentRepository;
import ensa.pay.Repository.FilesRepository;
import ensa.pay.models.Agency;
import ensa.pay.models.Agent;
import ensa.pay.models.Files;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentService {

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private FilesRepository filesRepository;

    @Autowired
    private AgencyRepository agencyRepository;

    public Agent saveOrUpdate(Agent agent, Files file){
        Agent new_agent = this.agentRepository.save(agent);
        String id_agent = new_agent.getId();
        file.setId_agent(id_agent);
        this.filesRepository.save(file);
        return agent;
    }

    public List<Agent> getAll(){
        List<Agent> listAgents =  this.agentRepository.findAll();
        for(Agent agent : listAgents) {
            List<Files> listFiles = this.filesRepository.findById_agent(agent.getId());
            agent.setFiles(listFiles);
            if(agent.getId_agence() != null){
                Agency agency = (this.agencyRepository.findById(agent.getId_agence()).orElse(null));
                if(agency != null){
                    agent.setAgency(agency);
                }
            }
        }
        return listAgents;
    }

    public Agent findById(String id_agent){
        Agent agent = this.agentRepository.findById(id_agent).orElse(null);
        if(agent==null) { return null; }
        List<Files> listFiles = this.filesRepository.findById_agent(id_agent);
        agent.setFiles(listFiles);
        return agent;
    }

    public void delete(String id_agent){
        this.filesRepository.deleteById_agent(id_agent);
        this.agentRepository.deleteById(id_agent);

    }

}
