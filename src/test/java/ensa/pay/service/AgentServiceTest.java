package ensa.pay.service;

import ensa.pay.models.Agent;
import ensa.pay.models.Files;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AgentServiceTest {

    @Autowired
    private AgentService agentService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void saveOrUpdate() {
        Agent agent = new Agent("123","fname1","lname1","8768","89787","111",123,771,"addre","email","HJH",null,"761",null,null);
        Files files = new Files();
        files.setDescription("description");
        files.setId_agent("123");
       // when(agentService.saveOrUpdate(agent,files)).thenReturn(agent);
    }


}