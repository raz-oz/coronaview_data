package com.rad.ms.corona_view.data.Service;


import com.rad.ms.corona_view.data.DB_Entities.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpStatus;
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

    @Override
    public List<Hospitalized> getHospitalized() {
        return null;
    }

    @Override
    public List<Isolations> getIsolationsByDate() {
        return null;
    }

    @Override
    public List<CovidByArea> getCovidByArea() {
        return null;
    }

    @Override
    public List<Recovered> getRecoveredByDate() {
        return null;
    }

    @Override
    public Recovered getRecoveredByID(long ID) {
        return recoveredRepository.findBy_id(ID);
    }

    @Override
    public List<Recovered> getRecoveredByFirstName() {
        return null;
    }

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
    public HttpStatus updateDbDataFromRecoveredDB() {
        return null;
    }

    @Override
    public HttpStatus updateDbDataFromIsolationsDB() {
        return null;
    }

    @Override
    public HttpStatus updateDbDataFromCovidByAreaDB() {
        return null;
    }

    @Override
    public HttpStatus updateDbDataFromHospitalizedDB() {
        return null;
    }


    public HttpStatus extractInfoFromRecoveredDB(RestTemplate restTemplate) {
        try {
            log.info("---------- start RecoveredDB extraction----------");
            String recoveredURL = "https://data.gov.il/api/3/action/datastore_search?resource_id=8455d49f-ce32-4f8f-b1d4-1d764660cca3";
            ArrayList<LinkedHashMap<String, Object>> records_map = extractInfoFromDBHelpFunc(restTemplate, recoveredURL);
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

    public HttpStatus extractInfoFromIsolationsDB(RestTemplate restTemplate ) {
        try {
            log.info("---------- start IsolationsDB extraction----------");

            String insulationURL = "https://data.gov.il/api/3/action/datastore_search?resource_id=9eedd26c-019b-433a-b28b-efcc98de378d";
            ArrayList<LinkedHashMap<String, Object>> records_map = extractInfoFromDBHelpFunc(restTemplate, insulationURL);
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

    public HttpStatus extractInfoFromCovidByAreaDB(RestTemplate restTemplate ) {
        try{
            log.info("---------- start CovidByAreaDB extraction----------");

            String covid19ByAreaURL = "https://data.gov.il/api/3/action/datastore_search?resource_id=d07c0771-01a8-43b2-96cc-c6154e7fa9bd";
            ArrayList<LinkedHashMap<String, Object>> records_map = extractInfoFromDBHelpFunc(restTemplate, covid19ByAreaURL);
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

    public HttpStatus extractInfoFromHospitalizedDB(RestTemplate restTemplate ) {
        try {
            log.info("---------- start HospitalizedDB extraction----------");

            String hospitalizedURL = "https://data.gov.il/api/3/action/datastore_search?resource_id=e4bf0ab8-ec88-4f9b-8669-f2cc78273edd";
            ArrayList<LinkedHashMap<String, Object>> records_map = extractInfoFromDBHelpFunc(restTemplate, hospitalizedURL);
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
    public ArrayList<LinkedHashMap<String, Object>> extractInfoFromDBHelpFunc(RestTemplate restTemplate, String URL){
        try {
            Map<?, ?> AllInfo_map = restTemplate.getForObject(URL, Map.class);
            assert AllInfo_map != null;
            LinkedHashMap<String, Object> result_map = (LinkedHashMap<String, Object>) AllInfo_map.get("result");
            return (ArrayList<LinkedHashMap<String, Object>>) result_map.get("records");
        }
        catch(Exception e) {
            log.info(e.toString());
            throw e;
        }
    }
}
