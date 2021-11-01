package com.rad.ms.corona_view.data;

import com.rad.ms.corona_view.data.Service.IDataService;
import com.rad.ms.corona_view.data.DB_Entities.Recovered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;

@RestController
public class RoutingController {

    @Autowired
    private IDataService accessService;

    @GetMapping("/recovered/{recovered_id}")
    public Recovered get_RecoveredByID(@PathVariable(value = "recovered_id") String _id) {
        return accessService.getRecoveredByID(Long.parseLong(_id));
    }

    @GetMapping( "/updatedata")
    public HttpStatus updateDb() {
        return accessService.updateDbData();
    }
}
