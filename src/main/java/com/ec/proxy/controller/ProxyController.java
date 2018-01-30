package com.ec.proxy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ec.proxy.service.ProxyService;

@RestController
@RequestMapping(value = "/proxy")
public class ProxyController {

	
	@Autowired
	ProxyService proxyService;
	
	
	 
	
}
