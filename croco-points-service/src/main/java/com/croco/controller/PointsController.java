package com.croco.controller;

import com.croco.bean.DAOUser;
import com.croco.service.api.CrocoGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PointsController {
    @Autowired
    CrocoGeneralService crocoService;

    @RequestMapping("/hellouser")
    public String getUser()
    {
        return "Hello User";
    }

    @RequestMapping("/helloadmin")
    public String getAdmin()
    {
        return "Hello Admin";
    }

    @RequestMapping("/points")
    public String getPoints()
    {
        return "Hello Points";
    }

    @PostMapping("/newuser/register")
    public ResponseEntity<DAOUser> CreateNewUser(@RequestBody DAOUser user)
    {
        return ResponseEntity.ok(crocoService.saveUser(user));
    }
}
