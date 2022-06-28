package com.spring.springordersecuritydemo.restapi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserApi {
    @RequestMapping(method = RequestMethod.GET)
    public HttpStatus login() {
        return HttpStatus.OK;
    }
}
