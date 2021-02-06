package ensa.pay.service;

import ensa.pay.Repository.AgencyRepository;
import ensa.pay.Repository.AgentRepository;
import ensa.pay.Repository.FilesRepository;
import ensa.pay.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgentService {

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private FilesRepository filesRepository;

    @Autowired
    private AgencyRepository agencyRepository;

    @Autowired
    private OauthService oauthService;

    public Agent saveOrUpdate(Agent agent, Files file){
        User user = new User();
        user.setTel(agent.getPhone_number());
        user.setPassword("123");

        Role role = new Role();
        role.setName("Agent");
        role.setDescription("Responsible for creating users");
        List<Role> listRole = new ArrayList<>();
        listRole.add(role);
        user.setRoles(listRole);

        //oauthService.createUser(user);
        //System.out.println(oauthService.getAll());

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

    public Agent getAgentByTel(String tel){
        Agent agent = agentRepository.findByPhoneNumber(tel);
        Agency agency = agencyRepository.findById(agent.getId_agence()).orElse(null);
        agent.setAgency(agency);
        return agent;
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

    public void deleteFile(String id_file){
        this.filesRepository.deleteById(id_file);
    }

}
