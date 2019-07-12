package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.Kind;
import com.example.bean.KindExample;
import com.example.dao.KindMapper;

@Service
public class KindService {
	@Autowired
	private KindMapper kindMapper;
	
	public List<Kind> getKind(KindExample kindExample){
		return kindMapper.selectByExample(kindExample);
	}
	
	public void insertKind(Kind kind) {
		kindMapper.insert(kind);
	}
	
	public void deleteKind(long kindId) {
		kindMapper.deleteByPrimaryKey(kindId);
	}
	
	public long getCount() {
		return kindMapper.countByExample(null);
	}

}
