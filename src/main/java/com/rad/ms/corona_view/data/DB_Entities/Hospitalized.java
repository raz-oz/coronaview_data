package com.rad.ms.corona_view.data.DB_Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Hospitalized {
    @Id
    private long _id;
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

    public Hospitalized(Map<String, Object> hospitalized) {
        this._id = (long) (Integer) hospitalized.get("_id");
        this.date =  dbHandler(hospitalized.get("תאריך").toString().substring(0, 10));
        this.total_hospitalized = dbHandler(hospitalized.get("מאושפזים"));
        this.hospitalized_females_percent =dbHandler(hospitalized.get("אחוז נשים מאושפזות"));
        this.hospitalized_avg_age =  dbHandler( hospitalized.get("גיל ממוצע מאושפזים"));
        this.hospitalized_mean_age =dbHandler(hospitalized.get("סטיית תקן גיל מאושפזים"));
        this.respirators =dbHandler( hospitalized.get("מונשמים"));
        this.respirators_females_percent =dbHandler(hospitalized.get("אחוז נשים מונשמות"));
        this.respirators_avg_age = dbHandler(hospitalized.get("גיל ממוצע מונשמים"));
        this.respirators_mean_age = dbHandler(hospitalized.get("סטיית תקן גיל מונשמים"));
        this.mild_condition_Patients = dbHandler(hospitalized.get("חולים קל"));
        this.mild_condition_females_percent =dbHandler(hospitalized.get("אחוז נשים חולות קל"));
        this.mild_condition_avg_age = dbHandler(hospitalized.get("גיל ממוצע חולים קל"));
        this.mild_condition_mean_age =dbHandler(hospitalized.get("סטיית תקן גיל חולים קל"));
        this.moderate_condition_Patients = dbHandler(hospitalized.get("חולים בינוני"));
        this.moderate_condition_females_percent =dbHandler(hospitalized.get("אחוז נשים חולות בינוני"));
        this.moderate_condition_avg_age = dbHandler(hospitalized.get("גיל ממוצע חולים בינוני"));
        this.moderate_condition_mean_age = dbHandler(hospitalized.get("סטיית תקן גיל חולים בינוני"));
        this.severe_condition_Patients =dbHandler(hospitalized.get("חולים קשה"));
        this.severe_condition_females_percent = dbHandler(hospitalized.get("אחוז נשים חולות קשה"));
        this.severe_condition_avg_age = dbHandler(hospitalized.get("גיל ממוצע חולים קשה"));
        this.severe_condition_mean_age =dbHandler(hospitalized.get("סטיית תקן גיל חולים קשה"));
        this.severe_condition_Patients_counter = dbHandler(hospitalized.get("חולים קשה מצטבר"));
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


    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotal_hospitalized() {
        return total_hospitalized;
    }

    public void setTotal_hospitalized(String total_hospitalized) {
        this.total_hospitalized = total_hospitalized;
    }

    public String getHospitalized_females_percent() {
        return hospitalized_females_percent;
    }

    public void setHospitalized_females_percent(String hospitalized_females_percent) {
        this.hospitalized_females_percent = hospitalized_females_percent;
    }

    public String getHospitalized_avg_age() {
        return hospitalized_avg_age;
    }

    public void setHospitalized_avg_age(String hospitalized_avg_age) {
        this.hospitalized_avg_age = hospitalized_avg_age;
    }

    public String getHospitalized_mean_age() {
        return hospitalized_mean_age;
    }

    public void setHospitalized_mean_age(String hospitalized_mean_age) {
        this.hospitalized_mean_age = hospitalized_mean_age;
    }

    public String getRespirators() {
        return respirators;
    }

    public void setRespirators(String respirators) {
        this.respirators = respirators;
    }

    public String getRespirators_females_percent() {
        return respirators_females_percent;
    }

    public void setRespirators_females_percent(String respirators_females_percent) {
        this.respirators_females_percent = respirators_females_percent;
    }

    public String getRespirators_avg_age() {
        return respirators_avg_age;
    }

    public void setRespirators_avg_age(String respirators_avg_age) {
        this.respirators_avg_age = respirators_avg_age;
    }

    public String getRespirators_mean_age() {
        return respirators_mean_age;
    }

    public void setRespirators_mean_age(String respirators_mean_age) {
        this.respirators_mean_age = respirators_mean_age;
    }

    public String getMild_condition_Patients() {
        return mild_condition_Patients;
    }

    public void setMild_condition_Patients(String mild_condition_Patients) {
        this.mild_condition_Patients = mild_condition_Patients;
    }

    public String getMild_condition_females_percent() {
        return mild_condition_females_percent;
    }

    public void setMild_condition_females_percent(String mild_condition_females_percent) {
        this.mild_condition_females_percent = mild_condition_females_percent;
    }

    public String getMild_condition_avg_age() {
        return mild_condition_avg_age;
    }

    public void setMild_condition_avg_age(String mild_condition_avg_age) {
        this.mild_condition_avg_age = mild_condition_avg_age;
    }

    public String getMild_condition_mean_age() {
        return mild_condition_mean_age;
    }

    public void setMild_condition_mean_age(String mild_condition_mean_age) {
        this.mild_condition_mean_age = mild_condition_mean_age;
    }

    public String getModerate_condition_Patients() {
        return moderate_condition_Patients;
    }

    public void setModerate_condition_Patients(String moderate_condition_Patients) {
        this.moderate_condition_Patients = moderate_condition_Patients;
    }

    public String getModerate_condition_females_percent() {
        return moderate_condition_females_percent;
    }

    public void setModerate_condition_females_percent(String moderate_condition_females_percent) {
        this.moderate_condition_females_percent = moderate_condition_females_percent;
    }

    public String getModerate_condition_avg_age() {
        return moderate_condition_avg_age;
    }

    public void setModerate_condition_avg_age(String moderate_condition_avg_age) {
        this.moderate_condition_avg_age = moderate_condition_avg_age;
    }

    public String getModerate_condition_mean_age() {
        return moderate_condition_mean_age;
    }

    public void setModerate_condition_mean_age(String moderate_condition_mean_age) {
        this.moderate_condition_mean_age = moderate_condition_mean_age;
    }

    public String getSevere_condition_Patients() {
        return severe_condition_Patients;
    }

    public void setSevere_condition_Patients(String severe_condition_Patients) {
        this.severe_condition_Patients = severe_condition_Patients;
    }

    public String getSevere_condition_females_percent() {
        return severe_condition_females_percent;
    }

    public void setSevere_condition_females_percent(String severe_condition_females_percent) {
        this.severe_condition_females_percent = severe_condition_females_percent;
    }

    public String getSevere_condition_avg_age() {
        return severe_condition_avg_age;
    }

    public void setSevere_condition_avg_age(String severe_condition_avg_age) {
        this.severe_condition_avg_age = severe_condition_avg_age;
    }

    public String getSevere_condition_mean_age() {
        return severe_condition_mean_age;
    }

    public void setSevere_condition_mean_age(String severe_condition_mean_age) {
        this.severe_condition_mean_age = severe_condition_mean_age;
    }

    public String getSevere_condition_Patients_counter() {
        return severe_condition_Patients_counter;
    }

    public void setSevere_condition_Patients_counter(String severe_condition_Patients_counter) {
        this.severe_condition_Patients_counter = severe_condition_Patients_counter;
    }

}
