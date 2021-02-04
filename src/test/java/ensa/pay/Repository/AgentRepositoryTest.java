package ensa.pay.Repository;

import ensa.pay.models.Agency;
import ensa.pay.models.Agent;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataMongoTest
public class AgentRepositoryTest {

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private AgencyRepository agencyRepository;

    @Before
    public void setUp() throws Exception {
        Agency agence = new Agency("761","agence name","agence address");
        Agent agent = new Agent("123","fname1","lname1","8768","89787","111",123,771,"addre","email","HJH",null,"761",null,null);
        Agent agent2 = new Agent("124","fname2","lname2","8768","89787","222",123,771,"addre","email2","HJH",null,"761",null,null);
        Agent agent3 = new Agent("125","fname3","lname3","8768","89787","333",123,771,"addre","email3","HJH",null,"761",null,null);

        agencyRepository.save(agence);
        agentRepository.save(agent);
        agentRepository.save(agent2);
        agentRepository.save(agent3);
    }

    @Test
    public void test_findAll(){
        List<Agent> agents = agentRepository.findAll();
        assertTrue(agents.size()>0);
        assertEquals(agents.get(0).getPhone_number(),"111");
    }

    @Test
    public void testFindClientById(){
        Agent agent = new Agent("124","fname2","lname2","8768","89787","222",123,771,"addre","email2","HJH",null,"761",null,null);

        assertEquals(agent,agentRepository.findById("124"));

    }

    @Test
    public void test_save(){
        Agent agent = new Agent("1200","fname1","lname1","8768","89787","111",123,771,"addre","email","HJH",null,"761",null,null);
        Agent expect = agentRepository.save(agent);
        assertNotNull(expect);
        assertEquals(expect.getPhone_number(),agent.getPhone_number());
    }

    @Test
    public void test_findByPhoneNumber(){
        Agent agent = new Agent("125","fname3","lname3","8768","89787","333",123,771,"addre","email3","HJH",null,"761",null,null);


        assertEquals(agent,agentRepository.findByPhoneNumber("333"));
    }

    @Test
    public void testDelete(){
        agentRepository.deleteById("123");
        List<Agent> agents = agentRepository.findAll();
        System.out.println(agents.size());
        assertTrue(agents.size()==2);
    }


}