package com.rad.ms.corona_view.data.DB_Entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document
public class CovidByArea {
    @Id
    private String _id;
    private String townCode;
    private String agas_code;
    private String town;
    private String date;
    private String accumulated_cases;
    private String new_cases_on_date;
    private String accumulated_recoveries;
    private String new_recoveries_on_date;
    private String accumulated_hospitalized;
    private String new_hospitalized_on_date;
    private String accumulated_deaths;
    private String new_deaths_on_date;
    private String accumulated_diagnostic_tests;
    private String new_diagnostic_tests_on_date;
    private String accumulated_vaccination_first_dose;
    private String new_vacc_first_dose_on_date;
    private String accumulated_vaccination_second_dose;
    private String new_vacc_second_dose_on_date;
    private String accumulated_vaccination_third_dose;
    private String new_vacc_third_dose_on_date;

    public CovidByArea() {
    }

    public CovidByArea(JsonNode covid_ByArea) {
        this._id = covid_ByArea.get("_id").asText();
        this.townCode = covid_ByArea.get("town_code").asText();
        this.agas_code = covid_ByArea.get("agas_code").asText();
        this.town = covid_ByArea.get("town").asText();
        this.date = covid_ByArea.get("date").asText();
        this.accumulated_cases = covid_ByArea.get("accumulated_cases").asText();
        this.new_cases_on_date = covid_ByArea.get("new_cases_on_date").asText();
        this.accumulated_recoveries = covid_ByArea.get("accumulated_recoveries").asText();
        this.new_recoveries_on_date = covid_ByArea.get("new_recoveries_on_date").asText();
        this.accumulated_hospitalized = covid_ByArea.get("accumulated_hospitalized").asText();
        this.new_hospitalized_on_date = covid_ByArea.get("new_hospitalized_on_date").asText();
        this.accumulated_deaths = covid_ByArea.get("accumulated_deaths").asText();
        this.new_deaths_on_date = covid_ByArea.get("new_deaths_on_date").asText();
        this.accumulated_diagnostic_tests = covid_ByArea.get("accumulated_diagnostic_tests").asText();
        this.new_diagnostic_tests_on_date = covid_ByArea.get("new_diagnostic_tests_on_date").asText();
        this.accumulated_vaccination_first_dose = covid_ByArea.get("accumulated_vaccination_first_dose").asText();
        this.new_vacc_first_dose_on_date = covid_ByArea.get("new_vacc_first_dose_on_date").asText();
        this.accumulated_vaccination_second_dose = covid_ByArea.get("accumulated_vaccination_second_dose").asText();
        this.new_vacc_second_dose_on_date = covid_ByArea.get("new_vacc_second_dose_on_date").asText();
        this.accumulated_vaccination_third_dose = covid_ByArea.get("accumulated_vaccination_third_dose").asText();
        this.new_vacc_third_dose_on_date = covid_ByArea.get("new_vacc_third_dose_on_date").asText();
    }

    public String get_id() {
        return _id;
    }

    public String getTownCode() {
        return townCode;
    }

    public String getAgas_code() {
        return agas_code;
    }

    public String getTown() {
        return town;
    }

    public String getDate() {
        return date;
    }

    public String getAccumulated_cases() {
        return accumulated_cases;
    }

    public String getNew_cases_on_date() {
        return new_cases_on_date;
    }

    public String getAccumulated_recoveries() {
        return accumulated_recoveries;
    }

    public String getNew_recoveries_on_date() {
        return new_recoveries_on_date;
    }

    public String getAccumulated_hospitalized() {
        return accumulated_hospitalized;
    }

    public String getNew_hospitalized_on_date() {
        return new_hospitalized_on_date;
    }

    public String getAccumulated_deaths() {
        return accumulated_deaths;
    }

    public String getNew_deaths_on_date() {
        return new_deaths_on_date;
    }

    public String getAccumulated_diagnostic_tests() {
        return accumulated_diagnostic_tests;
    }

    public String getNew_diagnostic_tests_on_date() {
        return new_diagnostic_tests_on_date;
    }

    public String getAccumulated_vaccination_first_dose() {
        return accumulated_vaccination_first_dose;
    }

    public String getNew_vacc_first_dose_on_date() {
        return new_vacc_first_dose_on_date;
    }

    public String getAccumulated_vaccination_second_dose() {
        return accumulated_vaccination_second_dose;
    }

    public String getNew_vacc_second_dose_on_date() {
        return new_vacc_second_dose_on_date;
    }

    public String getAccumulated_vaccination_third_dose() {
        return accumulated_vaccination_third_dose;
    }

    public String getNew_vacc_third_dose_on_date() {
        return new_vacc_third_dose_on_date;
    }

    @Override
    public String toString() {
        return "CovidByArea{" +
                "_id=" + _id +
                ", town_code='" + townCode + '\'' +
                ", agas_code='" + agas_code + '\'' +
                ", town='" + town + '\'' +
                ", date='" + date + '\'' +
                ", accumulated_cases='" + accumulated_cases + '\'' +
                ", new_cases_on_date='" + new_cases_on_date + '\'' +
                ", accumulated_recoveries='" + accumulated_recoveries + '\'' +
                ", new_recoveries_on_date='" + new_recoveries_on_date + '\'' +
                ", accumulated_hospitalized='" + accumulated_hospitalized + '\'' +
                ", new_hospitalized_on_date='" + new_hospitalized_on_date + '\'' +
                ", accumulated_deaths='" + accumulated_deaths + '\'' +
                ", new_deaths_on_date='" + new_deaths_on_date + '\'' +
                ", accumulated_diagnostic_tests='" + accumulated_diagnostic_tests + '\'' +
                ", new_diagnostic_tests_on_date='" + new_diagnostic_tests_on_date + '\'' +
                ", accumulated_vaccination_first_dose='" + accumulated_vaccination_first_dose + '\'' +
                ", new_vacc_first_dose_on_date='" + new_vacc_first_dose_on_date + '\'' +
                ", accumulated_vaccination_second_dose='" + accumulated_vaccination_second_dose + '\'' +
                ", new_vacc_second_dose_on_date='" + new_vacc_second_dose_on_date + '\'' +
                ", accumulated_vaccination_third_dose='" + accumulated_vaccination_third_dose + '\'' +
                ", new_vacc_third_dose_on_date='" + new_vacc_third_dose_on_date + '\'' +
                '}';
    }


}
