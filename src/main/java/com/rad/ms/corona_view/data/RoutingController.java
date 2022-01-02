package com.rad.ms.corona_view.data;

import com.rad.ms.corona_view.data.DB_Entities.CovidByArea;
import com.rad.ms.corona_view.data.DB_Entities.Hospitalized;
import com.rad.ms.corona_view.data.DB_Entities.Isolations;
import com.rad.ms.corona_view.data.DB_Entities.Recovered;
import com.rad.ms.corona_view.data.Service.IDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RoutingController {

    @Autowired
    private IDataService accessService;

    /**----------------Recovered-----------------
     * @return*/

    @GetMapping("/recovered/{recovered_id}")
    public Recovered get_RecoveredByID(@PathVariable(value = "recovered_id") String _id) {
        return accessService.getRecoveredByID(_id);
    }
    @GetMapping( "recovered/updatedata")
    public HttpStatus updateDbDataFromRecoveredDB() {
        return accessService.updateDbDataFromRecoveredDB();
    }

    @GetMapping("/recovered")
    public List<Recovered> getAllRecovered() {
        return accessService.getAllRecovered();
    }

    /**--------------Hospitalized---------------
     * @return*/

    @GetMapping("/hospitalized/date={date}")
    public Hospitalized getHospitalized(@PathVariable(value = "date") String date) {
        return accessService.getHospitalized(date);
    }
    @GetMapping("/hospitalized/id={ID}")
    public Hospitalized getHospitalizedByID(@PathVariable(value = "ID") String ID) {
        return accessService.getHospitalizedByID(ID);
    }
    @GetMapping( "hospitalized/updatedata")
    public HttpStatus updateDbDataFromHospitalizedDB() {
        return accessService.updateDbDataFromHospitalizedDB();
    }

    @GetMapping("/hospitalized")
    public List<Hospitalized> getAllHospitalized() {
        return accessService.getAllHospitalized();
    }

    /**---------------Isolations----------------
     * @return*/

    @GetMapping("/isolated/date={date}")
    public Isolations getIsolationsByDate(@PathVariable(value = "date") String date) {
        return accessService.getIsolationsByDate(date);
    }
    @GetMapping("/isolated/id={ID}")
    public Isolations getIsolationsByID(@PathVariable(value = "ID") String ID) {
        return accessService.getIsolationsByID(ID);
    }
    @GetMapping( "isolated/updatedata")
    public HttpStatus updateDbDataFromIsolationsDB() {
        return accessService.updateDbDataFromIsolationsDB();
    }

    @GetMapping("/isolated")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<Isolations> getAllIsolations() {
        List<Isolations> isolations = accessService.getAllIsolations();
         return isolations;
    }

    /**------------------Covid by area------------------
     * @return*/

    @GetMapping("/covidbyarea/town_code={town_code}")
    public List<CovidByArea> getCovidByArea_town_code(@PathVariable(value = "town_code") String code) {
        return accessService.getCovidByArea_town_code(code);
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
    public List<CovidByArea> getAllCovidbyarea() {
        return accessService.getAllCovidbyarea();
    }
    /**------------------update all data------------------*/
    @GetMapping( "/updatedata")
    public HttpStatus updateDb() {
        return accessService.updateDbData();
    }

    @GetMapping(value="/login/oauth2")
    public Map<String, String> oauth2Login(){
        Map<String,String> response = new HashMap<>();
        response.put("login with github","http://localhost:8404/oauth2/authorization/github");
        response.put("login with google", "http://localhost:8404/oauth2/authorization/google");
        return response;
    }

    @GetMapping(value="/")
    public String goHome(Principal user){
        String name = "guest";
        if (user!=null) {
            if (user.toString().contains("OAuth2AuthenticationToken")) {
                OAuth2AuthenticationToken oAuth2AuthenticationToken = (OAuth2AuthenticationToken) user;
                OAuth2User oAuth2User = oAuth2AuthenticationToken.getPrincipal();
                name = (String) oAuth2User.getAttributes().get("name");
            }
            else {
                name = user.getName();
            }
        }
        return "Hello "+name;
    }
}
