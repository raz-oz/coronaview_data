package com.rad.ms.corona_view.data.DB_Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Hospitalized {
    @Id
    private String _id;
    private String date;
    private String total_hospitalized;
    private String hospitalized_females_percent;
    private String hospitalized_avg_age;
    private String hospitalized_mean_age;
    private String respirators;
    private String respirators_females_percent;
    private String respirators_avg_age;
    private String respirators_mean_age;
    private String  mild_condition_Patients;
    private String  mild_condition_females_percent;
    private String  mild_condition_avg_age;
    private String  mild_condition_mean_age;
    private String  moderate_condition_Patients;
    private String  moderate_condition_females_percent;
    private String  moderate_condition_avg_age;
    private String  moderate_condition_mean_age;
    private String  severe_condition_Patients;
    private String  severe_condition_females_percent;
    private String  severe_condition_avg_age;
    private String  severe_condition_mean_age;
    private String severe_condition_Patients_counter;

    public Hospitalized() {}

    public Hospitalized(JsonNode hospitalized) {
        this._id =  hospitalized.get("_id").asText();
        this.date =  hospitalized.get("תאריך").asText().substring(0,10);
        this.total_hospitalized =hospitalized.get("מאושפזים").asText();
        this.hospitalized_females_percent =hospitalized.get("אחוז נשים מאושפזות").asText();
        this.hospitalized_avg_age =  ( hospitalized.get("גיל ממוצע מאושפזים")).asText();
        this.hospitalized_mean_age =(hospitalized.get("סטיית תקן גיל מאושפזים")).asText();
        this.respirators =hospitalized.get("מונשמים").asText();
        this.respirators_females_percent =(hospitalized.get("אחוז נשים מונשמות")).asText();
        this.respirators_avg_age = (hospitalized.get("גיל ממוצע מונשמים")).asText();
        this.respirators_mean_age = (hospitalized.get("סטיית תקן גיל מונשמים")).asText();
        this.mild_condition_Patients = (hospitalized.get("חולים קל")).asText();
        this.mild_condition_females_percent =(hospitalized.get("אחוז נשים חולות קל")).asText();
        this.mild_condition_avg_age = (hospitalized.get("גיל ממוצע חולים קל")).asText();
        this.mild_condition_mean_age =(hospitalized.get("סטיית תקן גיל חולים קל")).asText();
        this.moderate_condition_Patients = (hospitalized.get("חולים בינוני")).asText();
        this.moderate_condition_females_percent =(hospitalized.get("אחוז נשים חולות בינוני")).asText();
        this.moderate_condition_avg_age = (hospitalized.get("גיל ממוצע חולים בינוני")).asText();
        this.moderate_condition_mean_age = (hospitalized.get("סטיית תקן גיל חולים בינוני")).asText();
        this.severe_condition_Patients =(hospitalized.get("חולים קשה")).asText();
        this.severe_condition_females_percent = (hospitalized.get("אחוז נשים חולות קשה")).asText();
        this.severe_condition_avg_age = (hospitalized.get("גיל ממוצע חולים קשה")).asText();
        this.severe_condition_mean_age =(hospitalized.get("סטיית תקן גיל חולים קשה")).asText();
        this.severe_condition_Patients_counter = (hospitalized.get("חולים קשה מצטבר")).asText();
    }

    public String dbHandler(Object x){
        if (x ==null)
            return "null";
        else if (x instanceof Integer){
          return x.toString();
        }
        else if (x instanceof Double){
            return x.toString();
        }
        else
            return (String)x;
    }

    @Override
    public String toString() {
        return "hospitalized{" +'\n' +
                "_id=" + _id +'\n' +
                ", date='" + date + '\n' +
                ", total_hospitalized='" + total_hospitalized + '\n' +
                ", hospitalized_females_percent='" + hospitalized_females_percent + '\n' +
                ", hospitalized_avg_age='" + hospitalized_avg_age + '\n' +
                ", hospitalized_mean_age='" + hospitalized_mean_age + '\n' +
                ", respirators='" + respirators + '\n' +
                ", respirators_females_percent='" + respirators_females_percent + '\n' +
                ", respirators_avg_age='" + respirators_avg_age + '\n' +
                ", respirators_mean_age='" + respirators_mean_age + '\n' +
                ", mild_condition_Patients='" + mild_condition_Patients + '\n' +
                ", mild_condition_females_percent='" + mild_condition_females_percent + '\n' +
                ", mild_condition_avg_age='" + mild_condition_avg_age + '\n' +
                ", mild_condition_mean_age='" + mild_condition_mean_age + '\n' +
                ", moderate_condition_Patients='" + moderate_condition_Patients + '\n' +
                ", moderate_condition_females_percent='" + moderate_condition_females_percent + '\n' +
                ", moderate_condition_avg_age='" + moderate_condition_avg_age + '\n' +
                ", moderate_condition_mean_age='" + moderate_condition_mean_age + '\n' +
                ", severe_condition_Patients='" + severe_condition_Patients + '\n' +
                ", severe_condition_females_percent='" + severe_condition_females_percent + '\n' +
                ", severe_condition_avg_age='" + severe_condition_avg_age + '\n' +
                ", severe_condition_avg_age='" + severe_condition_mean_age + '\n' +
                ", severe_condition_avg_age='" + severe_condition_Patients_counter + '\n' +
                '}';
    }


}
