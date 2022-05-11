package com.sumo.server.Apis.Competition;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sumo.server.Database.CompetitionData.Competition.Competition;
import com.sumo.server.Database.CompetitionData.Competition.CompetitionService;
import com.sumo.server.apis.Competitions.CompetitionController;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CompetitionControllerTest {
    @Mock
    private CompetitionService competitionService;

    @InjectMocks
    private CompetitionController competitionController;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders
            .webAppContextSetup(context)
            .apply(SecurityMockMvcConfigurers.springSecurity())
            .build();
    }

    @Test
    public void testGetCompetitions() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        List<Competition> competitions = objectMapper.readValue(
            new File("src/main/resources/testing/Competition/CompetitionsList.json"), objectMapper.getTypeFactory().constructCollectionType(List.class, Competition.class));
        when(competitionService.getAllCompetitions()).thenReturn(competitions);
        ResponseEntity<List<Competition>> competitionList = competitionController.getCompetitions();
        Assertions.assertEquals(competitionList.getStatusCode(), HttpStatus.OK);
        List<Competition> responseBody = competitionList.getBody();
        assert responseBody != null;
        Iterator<Competition> firstIterator = responseBody.stream().iterator();
        assert competitions.stream().allMatch(o -> firstIterator.hasNext() && o.equals(firstIterator.next())) && !firstIterator.hasNext();
    }





}




