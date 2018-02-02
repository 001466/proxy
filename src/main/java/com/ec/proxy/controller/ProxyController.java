package com.ec.proxy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ec.common.model.Response;
import com.ec.proxy.model.Proxies;
import com.ec.proxy.model.ProxiesExample;
import com.ec.proxy.service.ProxyService;

@RestController
public class ProxyController {

	
	@Autowired
	ProxyService proxyService;
	
	@RequestMapping(path="/batchadd",produces = { "application/json" }, consumes = { "application/json" })
	public Response<String> batch1(@RequestBody List<Proxies> list, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return batch2(list,request,response);
	}

	@RequestMapping(path="/batchadd")
	public Response<String> batch2(@ModelAttribute List<Proxies> list, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		proxyService.insert(list);
		return new Response<String>(Response.Code.SUCCESS.getValue(),"添加成功");
	}
	
	
	@RequestMapping(path="/add",produces = { "application/json" }, consumes = { "application/json" })
	public Response<String> add1(@RequestBody Proxies proxies, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return add2(proxies,request,response);
	}

	@RequestMapping(path="/add")
	public Response<String> add2(@ModelAttribute Proxies proxies, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		proxyService.insert(proxies);
		return new Response<String>(Response.Code.SUCCESS.getValue(),"添加成功");
	}
	
	
	@RequestMapping(path="/del/{id}")
	public Response<String> del(@PathVariable(name="id") long id, HttpServletRequest request, HttpServletResponse response) throws Exception{
		ProxiesExample example=new  ProxiesExample();
		example.createCriteria().andIdEqualTo(id);
		proxyService.delete(example);
		return new Response<String>(Response.Code.SUCCESS.getValue(),"删除成功");
	}
	
	@RequestMapping(path="/get/{protl}")
	public Response<Proxies> get(@PathVariable(name="protl") String protl, HttpServletRequest request, HttpServletResponse response) throws Exception{
		ProxiesExample example=new  ProxiesExample();
		example.createCriteria().andProtlEqualTo(protl);
		example.setOrderByClause("createtime desc,errors asc,anonymous desc");
		List<Proxies> list=proxyService.select(example);
		if(list.size()>0)
			return new Response<Proxies>(Response.Code.SUCCESS.getValue(),"查询成功",list.get(0));
		else
			return new Response<Proxies>(Response.Code.FAIL.getValue(),"查询失败，没有此条件的数据",list.get(0));
	}
	
}
