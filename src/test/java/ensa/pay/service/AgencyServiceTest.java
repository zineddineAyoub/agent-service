package ensa.pay.service;

import ensa.pay.Repository.AgencyRepository;
import ensa.pay.models.Agency;
import ensa.pay.models.Agent;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AgencyServiceTest {

    @InjectMocks
    private AgencyService agencyService;

    @Mock private AgencyRepository agencyRepository;


    private Agency agency;

    @Before
    public void setUp() throws Exception {
        Agency agency = new Agency("Agence Safi","Ville Safi");
        agency.setId("111");
        Agency agency2 = new Agency("Agence Casa","Ville Casa");
        Agency agency3 = new Agency("Agence Agadir","Ville Agadir");

        agencyRepository.save(agency);
    }

    @Test
    public void testsaveOrUpdate() {
        Agency agence = new Agency("761","agence name","agence address");
        when(agencyService.saveOrUpdate(agence)).thenReturn(agence);
        Agency expected = agencyService.saveOrUpdate(agence);
        assertEquals(expected.getName(),agence.getName());
    }


/*
    @Test
    public void test_allAgencies(){
        List<Agency> agencies = new ArrayList<>();
        Agency agence = new Agency("761","agence name","agence address");
        agencies.add(agence);
        when(this.agencyService.getAll()).thenReturn(agencies);
    }*/


}
