package com.rad.ms.corona_view.data.Service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rad.ms.corona_view.data.DB_Entities.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Service
public class DataService implements IDataService {
    private static final Logger log = LoggerFactory.getLogger(DataService.class);

    /**--------------------Repository---------------------**/
    @Autowired
    private HospitalizedRepository hospitalizedRepository;

    @Autowired
    private RecoveredRepository recoveredRepository;

    @Autowired
    private CovidByAreaRepository covidByAreaRepository;

    @Autowired
    private IsolationRepository isolationRepository;
    /**---------------------------------------------------**/

    @Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}


    /**------------------Covid by area function------------------*/
    @Override
    public List<CovidByArea> getCovidByArea_town_code(String town_code) {
        return covidByAreaRepository.findByTownCode(town_code);

    }
    @Override
    public CovidByArea getCovidByArea_id(String id) {
        return covidByAreaRepository.findBy_id(id);
    }

    /**---------------Isolations function----------------*/
    @Override
    public Isolations getIsolationsByDate(String date) {
        return isolationRepository.findBydate(date);
    }
    @Override
    public Isolations getIsolationsByID(String ID) {
        return isolationRepository.findBy_id(ID);
    }

    /**--------------Hospitalized function---------------*/
    @Override
    public Hospitalized getHospitalized(String date) {
        return hospitalizedRepository.findBydate(date);
    }
    @Override
    public Hospitalized getHospitalizedByID(String ID) {
        return hospitalizedRepository.findBy_id(ID);
    }

    /**----------------Recovered function----------------*/
    @Override
    public Recovered getRecoveredByID(String ID) {
        return recoveredRepository.findBy_id(ID);
    }


    /**-----------------------update Db Data From x DB function--------------------------**/
    @Override
    public HttpStatus updateDbData() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpStatus recoveredDBStatus = extractInfoFromRecoveredDB(restTemplate);
            HttpStatus IsolationsDBStatus = extractInfoFromIsolationsDB(restTemplate);
            HttpStatus CovidByAreaDBStatus = extractInfoFromCovidByAreaDB(restTemplate);
            HttpStatus HospitalizedDBStatus = extractInfoFromHospitalizedDB(restTemplate);
        }
        catch(Exception e) {
            log.info(e.toString());
            return HttpStatus.NOT_FOUND;
        }
        return HttpStatus.OK;
    }

    @Override
    public HttpStatus updateDbDataFromIsolationsDB() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpStatus IsolationsDBStatus = extractInfoFromIsolationsDB(restTemplate);

        }
        catch(Exception e) {
            log.info(e.toString());
            return HttpStatus.NOT_FOUND;
        }
        return HttpStatus.OK;
    }

    @Override
    public HttpStatus updateDbDataFromCovidByAreaDB() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpStatus CovidByAreaDBStatus = extractInfoFromCovidByAreaDB(restTemplate);
        }
        catch(Exception e) {
            log.info(e.toString());
            return HttpStatus.NOT_FOUND;
        }
        return HttpStatus.OK;
    }

    @Override
    public HttpStatus updateDbDataFromHospitalizedDB() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpStatus HospitalizedDBStatus = extractInfoFromHospitalizedDB(restTemplate);
        }
        catch(Exception e) {
            log.info(e.toString());
            return HttpStatus.NOT_FOUND;
        }
        return HttpStatus.OK;
    }

    @Override
    public HttpStatus updateDbDataFromRecoveredDB() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpStatus recoveredDBStatus = extractInfoFromRecoveredDB(restTemplate);
        }
        catch(Exception e) {
            log.info(e.toString());
            return HttpStatus.NOT_FOUND;
        }
        return HttpStatus.OK;
    }


    /**-----------------------get All x function--------------------------**/
    @Override
    public List<Hospitalized> getAllHospitalized() {
        return hospitalizedRepository.findAll();
    }

    @Override
    public List<Recovered> getAllRecovered() {
        return recoveredRepository.findAll();
    }

    @Override
    public List<Isolations> getAllIsolations() {
        return isolationRepository.findAll();
    }

    @Override
    public List<CovidByArea> getAllCovidbyarea() {
        return covidByAreaRepository.findAll();
    }


    /**
     * ---------------extractInfoFromRecoveredDB---------------
     * The function receives raw information from a GET requests,
     * then she extracts the relevant information from it and stores it in the relevant DB.
     * @param restTemplate - Auxiliary variable of the platform which executes the request for us.
     * @return Success status if everything went well and error + failure otherwise
     */
    public HttpStatus extractInfoFromRecoveredDB(RestTemplate restTemplate) throws JsonProcessingException {
        try {
            log.info("---------- start RecoveredDB extraction----------");
            String recoveredURL = "https://data.gov.il/api/3/action/datastore_search?resource_id=8455d49f-ce32-4f8f-b1d4-1d764660cca3";
            JsonNode records_map = extractInfoFromDBHelpFunc(restTemplate, recoveredURL);
            ArrayList<Recovered> recovered_list = new ArrayList<>();
            records_map.forEach(r -> recovered_list.add(new Recovered(r)));

            recoveredRepository.deleteAll();

            log.info("---------- Saving RecoveredDB records ----------");

            recoveredRepository.saveAll(recovered_list);// save all isolations records
        }
        catch(Exception e) {
            log.info(e.toString());
            throw e;
        }
        return HttpStatus.OK;
    }

    /**
     * ---------------extractInfoFromIsolationsDB---------------
     * The function receives raw information from a GET requests,
     * then she extracts the relevant information from it and stores it in the relevant DB.
     * @param restTemplate - Auxiliary variable of the platform which executes the request for us.
     * @return Success status if everything went well and error + failure otherwise
     */
    public HttpStatus extractInfoFromIsolationsDB(RestTemplate restTemplate ) throws JsonProcessingException {
        try {
            log.info("---------- start IsolationsDB extraction----------");

            String insulationURL = "https://data.gov.il/api/3/action/datastore_search?resource_id=9eedd26c-019b-433a-b28b-efcc98de378d";
            JsonNode records_map = extractInfoFromDBHelpFunc(restTemplate, insulationURL);
            ArrayList<Isolations> Isolations_list = new ArrayList<>();
            records_map.forEach(r -> Isolations_list.add(new Isolations(r)));

            isolationRepository.deleteAll();

            log.info("---------- Saving IsolationsDB records ----------");

            isolationRepository.saveAll(Isolations_list);// save all isolations records
        }
        catch(Exception e) {
            log.info(e.toString());
            throw e;
        }
        return HttpStatus.OK;
    }

    /**
     * ---------------extractInfoFromCovidByAreaDB---------------
     * The function receives raw information from a GET requests,
     * then she extracts the relevant information from it and stores it in the relevant DB.
     * @param restTemplate - Auxiliary variable of the platform which executes the request for us.
     * @return Success status if everything went well and error + failure otherwise
     */
    public HttpStatus extractInfoFromCovidByAreaDB(RestTemplate restTemplate ) throws JsonProcessingException {
        try{
            log.info("---------- start CovidByAreaDB extraction----------");

            String covid19ByAreaURL = "https://data.gov.il/api/3/action/datastore_search?resource_id=d07c0771-01a8-43b2-96cc-c6154e7fa9bd";
            JsonNode records_map = extractInfoFromDBHelpFunc(restTemplate, covid19ByAreaURL);
            ArrayList<CovidByArea> covidByArea_list = new ArrayList<>();
            records_map.forEach(r -> covidByArea_list.add(new CovidByArea(r)));

            covidByAreaRepository.deleteAll();

            log.info("---------- Saving CovidByAreaDB records ----------");

            covidByAreaRepository.saveAll(covidByArea_list);// save all isolations records
        }
        catch(Exception e) {
            log.info(e.toString());
            throw e;
        }
        return HttpStatus.OK;
    }

    /**
     * ---------------extractInfoFromHospitalizedDB---------------
     * The function receives raw information from a GET requests,
     * then she extracts the relevant information from it and stores it in the relevant DB.
     * @param restTemplate - Auxiliary variable of the platform which executes the request for us.
     * @return Success status if everything went well and error + failure otherwise
     */
    public HttpStatus extractInfoFromHospitalizedDB(RestTemplate restTemplate ) throws JsonProcessingException {
        try {
            log.info("---------- start HospitalizedDB extraction----------");

            String hospitalizedURL = "https://data.gov.il/api/3/action/datastore_search?resource_id=e4bf0ab8-ec88-4f9b-8669-f2cc78273edd";
            JsonNode records_map = extractInfoFromDBHelpFunc(restTemplate, hospitalizedURL);
            ArrayList<Hospitalized> hospitalized_list = new ArrayList<>();
            records_map.forEach(r ->hospitalized_list.add(new Hospitalized(r)));

            hospitalizedRepository.deleteAll();

            log.info("---------- Saving HospitalizedDB records ----------");

            hospitalizedRepository.saveAll(hospitalized_list);// save all isolations records
        }
        catch(Exception e) {
            log.info(e.toString());
            throw e;
        }
        return HttpStatus.OK;
    }

    /**
     *---------------extractInfoFromDBHelpFunc---------------
     * @param restTemplate - Auxiliary variable of the platform which executes the request for us.
     * @param URL - The GET request of the API we are working with
     * @return The information of the current database without any information surrounding it
     */
    public JsonNode extractInfoFromDBHelpFunc(RestTemplate restTemplate, String URL) throws JsonProcessingException {
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.getBody());
            JsonNode result = root.path("result");
            return result.path("records");
        }
        catch(Exception e) {
            log.info(e.toString());
            throw e;
        }
    }


    @Bean
    CommandLineRunner initDatabase() {
        return args -> updateDbData();
    }
}
