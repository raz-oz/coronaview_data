package com.rad.ms.corona_view.data.DB_Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.annotation.Id;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Isolations {
    @Id
    private String _id;
    private String date;
    private String isolated_today_contact_with_confirmed;
    private String isolated_today_abroad;
    private String new_contact_with_confirmed;
    private String new_from_abroad;

    public Isolations(JsonNode isolations) {
        this._id = isolations.get("_id").asText();
        this.date = isolations.get("date").asText();
        this.isolated_today_contact_with_confirmed = isolations.get("isolated_today_contact_with_confirmed").asText();
        this.isolated_today_abroad = isolations.get("isolated_today_abroad").asText();
        this.new_contact_with_confirmed = isolations.get("new_contact_with_confirmed").asText();
        this.new_from_abroad = isolations.get("new_from_abroad").asText();
    }

    public Isolations() {
    }

    @Override
    public String toString() {
        return "Isolations{" +
                "_id=" + _id +
                ", date='" + date + '\'' +
                ", isolated_today_contact_with_confirmed='" + isolated_today_contact_with_confirmed + '\'' +
                ", isolated_today_abroad='" + isolated_today_abroad + '\'' +
                ", new_contact_with_confirmed='" + new_contact_with_confirmed + '\'' +
                ", new_from_abroad='" + new_from_abroad + '\'' +
                '}';
    }

}