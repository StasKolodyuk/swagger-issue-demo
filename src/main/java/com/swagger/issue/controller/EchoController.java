package com.swagger.issue.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Api
@RestController
public class EchoController {

    @RequestMapping(value = "/echo", method = POST, consumes = "text/plain", produces = "text/plain")
    public String echo(@RequestBody String str) {
        return str;
    }
}
