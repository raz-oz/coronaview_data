package com.rad.ms.corona_view.data;

import java.net.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.context.event.*;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.*;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpStatus;

@SpringBootApplication
public class CoronaViewDataApplication implements ApplicationListener<ApplicationReadyEvent> {

	enum status {
		successes,
		failure
	}

	public status hospitalized_status = status.failure;
	public status recovered_status = status.failure;
	public status covidByArea_status = status.failure;
	public status Isolations_status=status.failure;


	private static final Logger log = LoggerFactory.getLogger(CoronaViewDataApplication.class);

	@Autowired
	private HospitalizedRepository hospitalizedRepository;

	@Autowired
	private RecoveredsRepository recoveredsRepository;

	@Autowired
	private CovidByAreaRepository covidByAreaRepository;

	@Autowired
	private IsolationRepository isolationRepository;


	@Autowired
    private ApplicationContext applicationContext;
    
	public static void main(String[] args) {
		SpringApplication.run(CoronaViewDataApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			try {
				hospitalized_status = extractInfoFromHospitalizedDB(restTemplate);
				recovered_status = extractInfoFromRecoveredDB(restTemplate);
				covidByArea_status = extractInfoFromCovidByAreaDB(restTemplate);
				Isolations_status = extractInfoFromIsolationsDB(restTemplate);
				log.info("---------- Finished Build / update all DB records ----------");

			}
			catch(Exception e) {
				if(hospitalized_status==status.failure){
					log.info("There is a problem with hospitalized repository" );
				}
				else if(recovered_status==status.failure){
					log.info("There is a problem with recovered repository");
				}
				else if(covidByArea_status==status.failure){
					log.info("There is a problem with covidByArea repository");
				}
				else if(Isolations_status==status.failure){
					log.info("There is a problem with Isolations repository");
				}
			}
		};
	}
	/**
	 * ---------------extractInfoFromRecoveredDB---------------
	 * The function receives raw information from a GET requests,
	 * then she extracts the relevant information from it and stores it in the relevant DB.
	 * @param restTemplate - Auxiliary variable of the platform which executes the request for us.
	 * @return Success status if everything went well and error + failure otherwise
	 */
	public status extractInfoFromRecoveredDB(RestTemplate restTemplate){
		try {
			log.info("---------- start RecoveredDB extraction----------");
			String recoveredURL = "https://data.gov.il/api/3/action/datastore_search?resource_id=8455d49f-ce32-4f8f-b1d4-1d764660cca3";
			ArrayList<LinkedHashMap<String, Object>> records_map = extractInfoFromDBHelpFunc(restTemplate, recoveredURL);
			ArrayList<Recovered> recovered_list = new ArrayList<>();
			records_map.forEach(r -> recovered_list.add(new Recovered(r)));

			recoveredsRepository.deleteAll();

			log.info("---------- Saving RecoveredDB records ----------");

			recoveredsRepository.saveAll(recovered_list);// save all isolations records
		}
		catch(Exception e) {
			log.info(e.toString());
			throw e;
		}
		return status.successes;
	}

	/**
	 * ---------------extractInfoFromIsolationsDB---------------
	 * The function receives raw information from a GET requests,
	 * then she extracts the relevant information from it and stores it in the relevant DB.
	 * @param restTemplate - Auxiliary variable of the platform which executes the request for us.
	 * @return Success status if everything went well and error + failure otherwise
	 */
	public status extractInfoFromIsolationsDB(RestTemplate restTemplate){
		try {
			log.info("---------- start RecoveredDB extraction----------");

			String insulationURL = "https://data.gov.il/api/3/action/datastore_search?resource_id=9eedd26c-019b-433a-b28b-efcc98de378d";
			ArrayList<LinkedHashMap<String, Object>> records_map = extractInfoFromDBHelpFunc(restTemplate, insulationURL);
			ArrayList<Isolations> Isolations_list = new ArrayList<>();
			records_map.forEach(r -> Isolations_list.add(new Isolations(r)));

			isolationRepository.deleteAll();

			log.info("---------- Saving RecoveredDB records ----------");

			isolationRepository.saveAll(Isolations_list);// save all isolations records
		}
		catch(Exception e) {
			log.info(e.toString());
			throw e;
		}
		return status.successes;
	}

	/**
	 * ---------------extractInfoFromCovidByAreaDB---------------
	 * The function receives raw information from a GET requests,
	 * then she extracts the relevant information from it and stores it in the relevant DB.
	 * @param restTemplate - Auxiliary variable of the platform which executes the request for us.
	 * @return Success status if everything went well and error + failure otherwise
	 */
	public status extractInfoFromCovidByAreaDB(RestTemplate restTemplate){
		try {
			log.info("---------- start RecoveredDB extraction----------");

			String covid19ByAreaURL = "https://data.gov.il/api/3/action/datastore_search?resource_id=d07c0771-01a8-43b2-96cc-c6154e7fa9bd";
			ArrayList<LinkedHashMap<String, Object>> records_map = extractInfoFromDBHelpFunc(restTemplate, covid19ByAreaURL);
			ArrayList<CovidByArea> covidByArea_list = new ArrayList<>();
			records_map.forEach(r -> covidByArea_list.add(new CovidByArea(r)));

			covidByAreaRepository.deleteAll();

			log.info("---------- Saving RecoveredDB records ----------");

			covidByAreaRepository.saveAll(covidByArea_list);// save all isolations records
		}
		catch(Exception e) {
			log.info(e.toString());
			throw e;
		}
		return status.successes;
	}

	/**
	 * ---------------extractInfoFromHospitalizedDB---------------
	 * The function receives raw information from a GET requests,
	 * then she extracts the relevant information from it and stores it in the relevant DB.
	 * @param restTemplate - Auxiliary variable of the platform which executes the request for us.
	 * @return Success status if everything went well and error + failure otherwise
	 */
	public status extractInfoFromHospitalizedDB(RestTemplate restTemplate){
		try {
			log.info("---------- start RecoveredDB extraction----------");

			String hospitalizedURL = "https://data.gov.il/api/3/action/datastore_search?resource_id=e4bf0ab8-ec88-4f9b-8669-f2cc78273edd";
			ArrayList<LinkedHashMap<String, Object>> records_map = extractInfoFromDBHelpFunc(restTemplate, hospitalizedURL);
			ArrayList<Hospitalized> hospitalized_list = new ArrayList<>();
			records_map.forEach(r ->hospitalized_list.add(new Hospitalized(r)));

			hospitalizedRepository.deleteAll();

			log.info("---------- Saving RecoveredDB records ----------");

			hospitalizedRepository.saveAll(hospitalized_list);// save all isolations records
		}
		catch(Exception e) {
			log.info(e.toString());
			throw e;
		}
		return status.successes;
	}

	/**
	 *---------------extractInfoFromDBHelpFunc---------------
	 * @param restTemplate - Auxiliary variable of the platform which executes the request for us.
	 * @param URL - The GET request of the API we are working with
	 * @return The information of the current database without any information surrounding it
	 */
	public ArrayList<LinkedHashMap<String, Object>> extractInfoFromDBHelpFunc(RestTemplate restTemplate, String URL){
		try {
			Map<String, Object> AllInfo_map = restTemplate.getForObject(URL, Map.class);
			LinkedHashMap<String, Object> result_map = ((LinkedHashMap<String, Object>) AllInfo_map.get("result"));
			return (ArrayList<LinkedHashMap<String, Object>>) result_map.get("records");
		}
		catch(Exception e) {
			log.info(e.toString());
			throw e;
		}
	}

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event)
	{
		try
		{
			String ip       = InetAddress.getLocalHost().getHostAddress();
			String hostName = InetAddress.getLocalHost().getHostName();
			int port        = applicationContext.getBean(Environment.class).getProperty("server.port", Integer.class, 0);

			System.out.println("*****************************************************");
			System.out.println("* Coronaview Data is UP and Ready ");
			System.out.println("* Host=" + hostName + ", IP=" + ip + ", Port=" + port);
			System.out.println("*****************************************************");
		}
		catch (UnknownHostException e)
		{
			e.printStackTrace();
		}
	}
}
