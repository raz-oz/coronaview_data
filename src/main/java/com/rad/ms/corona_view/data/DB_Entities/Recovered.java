package com.rad.ms.corona_view.data.DB_Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Recovered {
    @Id
    private long _id;
    private String _days_between_pos_and_recovery;
    private String _total_tests_count;
    private String _age_group;
    private String _gender;
    private String _test_indication;


    public Recovered() {
    }

    public Recovered(Map<String, Object> recovered) {
        this._id = (long)(int) recovered.get("_id");
        this._days_between_pos_and_recovery = (String) recovered.get("days_between_pos_and_recovery");
        this._total_tests_count = (String) recovered.get("total_tests_count");
        this._age_group = (String) recovered.get("age_group");
        this._gender = (String) recovered.get("gender");
        this._test_indication = (String) recovered.get("test_indication");
    }

    @Override
    public String toString() {
        return "Recovered{" +
                "_id=" + _id +
                "days_between_pos_and_recovery=" + _days_between_pos_and_recovery + '\'' +
                "total_tests_count=" + _total_tests_count + '\'' +
                "age_group=" + _age_group + '\'' +
                "gender=" + _gender + '\'' +
                "test_indication=" + _test_indication;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String get_days_between_pos_and_recovery() {
        return _days_between_pos_and_recovery;
    }

    public void set_days_between_pos_and_recovery(String _days_between_pos_and_recovery) {
        this._days_between_pos_and_recovery = _days_between_pos_and_recovery;
    }

    public String get_total_tests_count() {
        return _total_tests_count;
    }

    public void set_total_tests_count(String _total_tests_count) {
        this._total_tests_count = _total_tests_count;
    }

    public String get_age_group() {
        return _age_group;
    }

    public void set_age_group(String _age_group) {
        this._age_group = _age_group;
    }

    public String get_gender() {
        return _gender;
    }

    public void set_gender(String _gender) {
        this._gender = _gender;
    }

    public String get_test_indication() {
        return _test_indication;
    }

    public void set_test_indication(String _test_indication) {
        this._test_indication = _test_indication;
    }
}

