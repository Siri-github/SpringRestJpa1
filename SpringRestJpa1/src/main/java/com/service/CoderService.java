package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Coder;
import com.repository.CoderRepository;

@Service
public class CoderService {
	
	@Autowired
	CoderRepository coderrepo;
	
	public List<Coder> getCoders()
	{
		List<Coder> lc = coderrepo.findAll();
		return lc;
	}
	
	public Coder addCoder(Coder c)
	{
		Coder c1= coderrepo.save(c);
		return c1;
	}

	public List<Coder> addCoders(List<Coder> lc) {
		List<Coder> lc1=coderrepo.saveAll(lc);
		return lc1;
	}
	
	public String deleteCoderById(int cid) {
		
		coderrepo.deleteById(cid);
		return "Deleted";
	}
	public String deleteCoder(Coder c) {
		coderrepo.delete(c);
		return "Deleted";
	}
	public Coder updateCoder(Coder c) {
		int id = c.getCid();
		
		Coder c1 = coderrepo.findById(id).orElseThrow();
		
		c1.setCname(c.getCname());
		c1.setTech(c.getTech());
		coderrepo.save(c1);
		return c1;
	}

	public Coder getCoderById(int cid) {
		Coder c1 = coderrepo.findById(cid).orElseThrow();
		return c1;
	}
	
	public Coder getCoderByCname(String cname)
	{
		Coder c2 = coderrepo.getCoderByCname(cname);
		return c2;
	}
	
	public List<Coder> getCoderByTechSorted(String tech)
	{
		List<Coder> lc=coderrepo.getCoderByTechSorted(tech);
		return lc;
	}
}
