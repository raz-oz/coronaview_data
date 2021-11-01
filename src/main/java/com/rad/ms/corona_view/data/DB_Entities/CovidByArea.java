package com.rad.ms.corona_view.data.DB_Entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CovidByArea {
    @Id
    private long _id;
    private String town_code;
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

    public CovidByArea(Map<String, Object> covid_ByArea) {
        this._id = (long) (int) covid_ByArea.get("_id");
        this.town_code = (String)covid_ByArea.get("town_code");
        this.agas_code = (String)covid_ByArea.get("agas_code");
        this.town = (String)covid_ByArea.get("town");
        this.date = (String)covid_ByArea.get("date");
        this.accumulated_cases = (String)covid_ByArea.get("accumulated_cases");
        this.new_cases_on_date = (String)covid_ByArea.get("new_cases_on_date");
        this.accumulated_recoveries = (String)covid_ByArea.get("accumulated_recoveries");
        this.new_recoveries_on_date = (String)covid_ByArea.get("new_recoveries_on_date");
        this.accumulated_hospitalized = (String)covid_ByArea.get("accumulated_hospitalized");
        this.new_hospitalized_on_date = (String)covid_ByArea.get("new_hospitalized_on_date");
        this.accumulated_deaths = (String)covid_ByArea.get("accumulated_deaths");
        this.new_deaths_on_date = (String)covid_ByArea.get("new_deaths_on_date");
        this.accumulated_diagnostic_tests = (String)covid_ByArea.get("accumulated_diagnostic_tests");
        this.new_diagnostic_tests_on_date = (String)covid_ByArea.get("new_diagnostic_tests_on_date");
        this.accumulated_vaccination_first_dose = (String)covid_ByArea.get("accumulated_vaccination_first_dose");
        this.new_vacc_first_dose_on_date = (String)covid_ByArea.get("new_vacc_first_dose_on_date");
        this.accumulated_vaccination_second_dose = (String)covid_ByArea.get("accumulated_vaccination_second_dose");
        this.new_vacc_second_dose_on_date = (String)covid_ByArea.get("new_vacc_second_dose_on_date");
        this.accumulated_vaccination_third_dose = (String)covid_ByArea.get("accumulated_vaccination_third_dose");
        this.new_vacc_third_dose_on_date = (String)covid_ByArea.get("new_vacc_third_dose_on_date");
    }

    @Override
    public String toString() {
        return "CovidByArea{" +
                "_id=" + _id +
                ", town_code='" + town_code + '\'' +
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

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getTown_code() {
        return town_code;
    }

    public void setTown_code(String town_code) {
        this.town_code = town_code;
    }

    public String getAgas_code() {
        return agas_code;
    }

    public void setAgas_code(String agas_code) {
        this.agas_code = agas_code;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAccumulated_cases() {
        return accumulated_cases;
    }

    public void setAccumulated_cases(String accumulated_cases) {
        this.accumulated_cases = accumulated_cases;
    }

    public String getNew_cases_on_date() {
        return new_cases_on_date;
    }

    public void setNew_cases_on_date(String new_cases_on_date) {
        this.new_cases_on_date = new_cases_on_date;
    }

    public String getAccumulated_recoveries() {
        return accumulated_recoveries;
    }

    public void setAccumulated_recoveries(String accumulated_recoveries) {
        this.accumulated_recoveries = accumulated_recoveries;
    }

    public String getNew_recoveries_on_date() {
        return new_recoveries_on_date;
    }

    public void setNew_recoveries_on_date(String new_recoveries_on_date) {
        this.new_recoveries_on_date = new_recoveries_on_date;
    }

    public String getAccumulated_hospitalized() {
        return accumulated_hospitalized;
    }

    public void setAccumulated_hospitalized(String accumulated_hospitalized) {
        this.accumulated_hospitalized = accumulated_hospitalized;
    }

    public String getNew_hospitalized_on_date() {
        return new_hospitalized_on_date;
    }

    public void setNew_hospitalized_on_date(String new_hospitalized_on_date) {
        this.new_hospitalized_on_date = new_hospitalized_on_date;
    }

    public String getAccumulated_deaths() {
        return accumulated_deaths;
    }

    public void setAccumulated_deaths(String accumulated_deaths) {
        this.accumulated_deaths = accumulated_deaths;
    }

    public String getNew_deaths_on_date() {
        return new_deaths_on_date;
    }

    public void setNew_deaths_on_date(String new_deaths_on_date) {
        this.new_deaths_on_date = new_deaths_on_date;
    }

    public String getAccumulated_diagnostic_tests() {
        return accumulated_diagnostic_tests;
    }

    public void setAccumulated_diagnostic_tests(String accumulated_diagnostic_tests) {
        this.accumulated_diagnostic_tests = accumulated_diagnostic_tests;
    }

    public String getNew_diagnostic_tests_on_date() {
        return new_diagnostic_tests_on_date;
    }

    public void setNew_diagnostic_tests_on_date(String new_diagnostic_tests_on_date) {
        this.new_diagnostic_tests_on_date = new_diagnostic_tests_on_date;
    }

    public String getAccumulated_vaccination_first_dose() {
        return accumulated_vaccination_first_dose;
    }

    public void setAccumulated_vaccination_first_dose(String accumulated_vaccination_first_dose) {
        this.accumulated_vaccination_first_dose = accumulated_vaccination_first_dose;
    }

    public String getNew_vacc_first_dose_on_date() {
        return new_vacc_first_dose_on_date;
    }

    public void setNew_vacc_first_dose_on_date(String new_vacc_first_dose_on_date) {
        this.new_vacc_first_dose_on_date = new_vacc_first_dose_on_date;
    }

    public String getAccumulated_vaccination_second_dose() {
        return accumulated_vaccination_second_dose;
    }

    public void setAccumulated_vaccination_second_dose(String accumulated_vaccination_second_dose) {
        this.accumulated_vaccination_second_dose = accumulated_vaccination_second_dose;
    }

    public String getNew_vacc_second_dose_on_date() {
        return new_vacc_second_dose_on_date;
    }

    public void setNew_vacc_second_dose_on_date(String new_vacc_second_dose_on_date) {
        this.new_vacc_second_dose_on_date = new_vacc_second_dose_on_date;
    }

    public String getAccumulated_vaccination_third_dose() {
        return accumulated_vaccination_third_dose;
    }

    public void setAccumulated_vaccination_third_dose(String accumulated_vaccination_third_dose) {
        this.accumulated_vaccination_third_dose = accumulated_vaccination_third_dose;
    }

    public String getNew_vacc_third_dose_on_date() {
        return new_vacc_third_dose_on_date;
    }

    public void setNew_vacc_third_dose_on_date(String new_vacc_third_dose_on_date) {
        this.new_vacc_third_dose_on_date = new_vacc_third_dose_on_date;
    }
}
