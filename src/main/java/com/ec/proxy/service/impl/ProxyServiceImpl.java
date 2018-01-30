package com.ec.proxy.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.proxy.dao.ProxiesMapper;
import com.ec.proxy.model.Proxies;
import com.ec.proxy.model.ProxiesExample;
import com.ec.proxy.service.ProxyService;
@Service
public class ProxyServiceImpl implements ProxyService{
	@Autowired
	private ProxiesMapper proxiesMapper;
	@Override
	public int insert(Proxies record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Collection<Proxies> record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Proxies record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Proxies> select(ProxiesExample example) {
		// TODO Auto-generated method stub
		return null;
	}

}
