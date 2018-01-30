package com.ec.proxy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ResourceProperties.Strategy;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ec.common.model.Response;
import com.ec.proxy.model.ProxiesExample;
import com.ec.proxy.service.ProxyService;

@RestController
@RequestMapping(value = "/proxy")
public class ProxyController {

	
	@Autowired
	ProxyService proxyService;

	

	 
	
	
	
	@RequestMapping(path="/add",produces = { "application/json" }, consumes = { "application/json" })
	public Response post1(@RequestBody Strategy strategy, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return post2(strategy, request, response);
	}

	@RequestMapping(path="/add")
	public Response post2(@ModelAttribute Strategy strategy, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
	}
	
	@RequestMapping(path="/del")
	public Response del(@RequestParam(name="strategy",required=true) int strategy, HttpServletRequest request, HttpServletResponse response) throws Exception{
		strategyService.del(strategy);
		return new Response(Response.Code.SUCCESS);
	}
	
	@RequestMapping(path="/get")
	public Response get(@RequestParam(name="screenId",required=true) String screenId, HttpServletRequest request, HttpServletResponse response) throws Exception{
		Response res= new Response();
		res.put("data",strategyService.get(screenId));
		return res;
	}
	 

	@RequestMapping(path="/getScreenWarp")
	public Response getScreenWarp(@RequestParam(name="screenId",required=true) String screenId, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Response res= new Response();
		res.put("data",((RegisterStrategyServiceImpl)strategyService).getScreenWarp(screenId));
		return res;
	}
	

	
	 
	
}
