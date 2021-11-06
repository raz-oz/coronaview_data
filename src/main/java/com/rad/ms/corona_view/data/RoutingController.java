package com.rad.ms.corona_view.data;

import com.rad.ms.corona_view.data.Service.IDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoutingController {

    @Autowired
    private IDataService accessService;

    /**----------------Recovered-----------------*/

    @GetMapping("/recovered/{recovered_id}")
    public String get_RecoveredByID(@PathVariable(value = "recovered_id") String _id) {
        return accessService.getRecoveredByID(_id).toString();
    }
    @GetMapping( "recovered/updatedata")
    public HttpStatus updateDbDataFromRecoveredDB() {
        return accessService.updateDbDataFromRecoveredDB();
    }

    @GetMapping("/recovered")
    public  String getAllRecovered() {
        return accessService.getAllRecovered().toString();
    }

    /**--------------Hospitalized---------------*/

    @GetMapping("/hospitalized/date={date}")
    public String getHospitalized(@PathVariable(value = "date") String date) {
        return accessService.getHospitalized(date).toString();
    }
    @GetMapping("/hospitalized/id={ID}")
    public  String getHospitalizedByID(@PathVariable(value = "ID") String ID) {
        return accessService.getHospitalizedByID(ID).toString();
    }
    @GetMapping( "hospitalized/updatedata")
    public HttpStatus updateDbDataFromHospitalizedDB() {
        return accessService.updateDbDataFromHospitalizedDB();
    }

    @GetMapping("/hospitalized")
    public  String getAllHospitalized() {
        return accessService.getAllHospitalized().toString();
    }

    /**---------------Isolations----------------*/

    @GetMapping("/isolated/date={date}")
    public  String getIsolationsByDate(@PathVariable(value = "date") String date) {
        return accessService.getIsolationsByDate(date).toString();
    }
    @GetMapping("/isolated/id={ID}")
    public String getIsolationsByID(@PathVariable(value = "ID") String ID) {
        return accessService.getIsolationsByID(ID).toString();
    }
    @GetMapping( "isolated/updatedata")
    public HttpStatus updateDbDataFromIsolationsDB() {
        return accessService.updateDbDataFromIsolationsDB();
    }
    @GetMapping("/isolated")
    public String getAllIsolations() {
        return accessService.getAllIsolations().toString();
    }

    /**------------------Covid by area------------------*/

    @GetMapping("/covidbyarea/town_code={town_code}")
    public String getCovidByArea_town_code(@PathVariable(value = "town_code") String code) {
        return accessService.getCovidByArea_town_code(code).toString();
    }
    @GetMapping("/covidbyarea/id={ID}")
    public String getCovidByArea(@PathVariable(value = "ID") String ID) {
        return accessService.getCovidByArea_id(ID).toString();
    }
    @GetMapping( "covidbyarea/updatedata")
    public HttpStatus updateDbDataFromCovidByAreaDB() {
        return accessService.updateDbDataFromCovidByAreaDB();
    }

    @GetMapping("/covidbyarea")
    public String getAllCovidbyarea() {
        return accessService.getAllCovidbyarea().toString();
    }
    /**------------------update all data------------------*/
    @GetMapping( "/updatedata")
    public HttpStatus updateDb() {
        return accessService.updateDbData();
    }
}
