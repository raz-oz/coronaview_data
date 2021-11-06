package com.rad.ms.corona_view.data.DB_Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.annotation.Id;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Recovered {
    @Id
    private String _id;
    private String DaysBetweenPosAndRecovery;
    private String _total_tests_count;
    private String _age_group;
    private String _gender;
    private String _test_indication;


    public Recovered() {
    }

    public Recovered(JsonNode recovered) {
        this._id = recovered.get("_id").asText();
        this.DaysBetweenPosAndRecovery = recovered.get("days_between_pos_and_recovery").asText();
        this._total_tests_count = recovered.get("total_tests_count").asText();
        this._age_group = recovered.get("age_group").asText();
        this._gender = recovered.get("gender").asText();
        this._test_indication = recovered.get("test_indication").asText();
    }

    @Override
    public String toString() {
        return "Recovered{" +
                "_id=" + _id +
                "days_between_pos_and_recovery=" + DaysBetweenPosAndRecovery + '\'' +
                "total_tests_count=" + _total_tests_count + '\'' +
                "age_group=" + _age_group + '\'' +
                "gender=" + _gender + '\'' +
                "test_indication=" + _test_indication;
    }
}
