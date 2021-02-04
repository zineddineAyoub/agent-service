package ensa.pay.Repository;

import ensa.pay.models.Agency;
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
public class AgencyRepositoryTest {

    @Autowired
    private AgencyRepository agencyRepository;

    @Before
    public void setUp() throws Exception {
        System.out.println("SET UP AGENCY REPO");
        Agency agency = new Agency("Agence Safi","Ville Safi");
        agency.setId("111");
        Agency agency2 = new Agency("Agence Casa","Ville Casa");
        Agency agency3 = new Agency("Agence Agadir","Ville Agadir");

        agencyRepository.save(agency);
        agencyRepository.save(agency2);
        agencyRepository.save(agency3);

    }

    @Test
    public void test_findAll(){
        List<Agency> agencies  = agencyRepository.findAll();
        assertTrue(agencies.size()>0);
        assertEquals(agencies.get(0).getName(),"Agence Safi");
    }

    @Test
    public void test_save(){
        Agency agency = new Agency("Agence Rabat","Ville Rabat");
        Agency expected= agencyRepository.save(agency);
        
        assertNotNull(expected);
        assertEquals(agency.getName(),expected.getName());

    }

    @Test
    public void testFindById(){
         Agency agency = new Agency("Agence Safi","Ville Safi");
         agency.setId("111");
        Optional<Agency>  optional = Optional.of(agency);

        assertEquals(optional,agencyRepository.findById("111"));
    }
     @Test
    public void testDeleteById(){
            String id = "111";
            agencyRepository.deleteById(id);
            List<Agency> agencies = agencyRepository.findAll();
            assertTrue(agencies.size()>=2);
    }
}