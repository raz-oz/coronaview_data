package com.rad.ms.corona_view.data.DB_Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Isolations {
    @Id
    private long _id;
    private String date;
    private String isolated_today_contact_with_confirmed;
    private String isolated_today_abroad;
    private String new_contact_with_confirmed;
    private String new_from_abroad;

    public Isolations(Map<String, Object> isolations) {
        this._id = (long)(int)isolations.get("_id");
        this.date = (String) isolations.get("date");
        this.isolated_today_contact_with_confirmed = (String)isolations.get("isolated_today_contact_with_confirmed");
        this.isolated_today_abroad = (String)isolations.get("isolated_today_abroad");
        this.new_contact_with_confirmed = (String)isolations.get("new_contact_with_confirmed");
        this.new_from_abroad = (String)isolations.get("new_from_abroad");
    }

    public Isolations() { }
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

    public String getIsolated_today_contact_with_confirmed() {
        return isolated_today_contact_with_confirmed;
    }

    public void setIsolated_today_contact_with_confirmed(String isolated_today_contact_with_confirmed) {
        this.isolated_today_contact_with_confirmed = isolated_today_contact_with_confirmed;
    }

    public String getIsolated_today_abroad() {
        return isolated_today_abroad;
    }

    public void setIsolated_today_abroad(String isolated_today_abroad) {
        this.isolated_today_abroad = isolated_today_abroad;
    }

    public String getNew_contact_with_confirmed() {
        return new_contact_with_confirmed;
    }

    public void setNew_contact_with_confirmed(String new_contact_with_confirmed) {
        this.new_contact_with_confirmed = new_contact_with_confirmed;
    }

    public String getNew_from_abroad() {
        return new_from_abroad;
    }

    public void setNew_from_abroad(String new_from_abroad) {
        this.new_from_abroad = new_from_abroad;
    }
}
