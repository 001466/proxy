package com.ec.proxy.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ec.common.util.IDGen;
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
		
		try{
			record.setId(IDGen.next());
			return proxiesMapper.insert(record);
		} catch (Exception e) {
			if (e instanceof java.sql.SQLSyntaxErrorException
					|| e.getCause() instanceof java.sql.SQLSyntaxErrorException) {
				proxiesMapper.createTable();
				return proxiesMapper.insert(record);
			}
			throw e;
		}
		
	}

	@Override
	public int insert(Collection<Proxies> record) {
		
		for(Proxies p:record){
			p.setId(IDGen.next());
		}

		try {
			return proxiesMapper.insertByList(record);
		} catch (Exception e) {
			if (e instanceof java.sql.SQLSyntaxErrorException
					|| e.getCause() instanceof java.sql.SQLSyntaxErrorException) {
				proxiesMapper.createTable();
				return proxiesMapper.insertByList(record);
			}
			throw e;
		}
	
	
	}

	@Override
	public int update(Proxies record) {

		ProxiesExample example = new ProxiesExample();
		example.createCriteria().andIdEqualTo(record.getId());

		try {
			return proxiesMapper.updateByExample(record, example);
		} catch (Exception e) {
			if (e instanceof java.sql.SQLSyntaxErrorException
					|| e.getCause() instanceof java.sql.SQLSyntaxErrorException) {
				proxiesMapper.createTable();
				return proxiesMapper.updateByExample(record, example);
			}
			throw e;
		}

	}

	@Override
	public List<Proxies> select(ProxiesExample example) {
		return proxiesMapper.selectByExample(example);
	}

	@Override
	public int delete(ProxiesExample example) {
		return proxiesMapper.deleteByExample(example);
	}

}
