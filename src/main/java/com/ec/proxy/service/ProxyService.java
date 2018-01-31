package com.ec.proxy.service;

import java.util.Collection;
import java.util.List;

import com.ec.proxy.model.Proxies;
import com.ec.proxy.model.ProxiesExample;

public interface ProxyService {

	public int insert(Proxies record);
	
	public int insert(Collection<Proxies> record);

	public int update(Proxies record);
	
	public int delete(ProxiesExample example);

	public List<Proxies> select(ProxiesExample example);
	

}
