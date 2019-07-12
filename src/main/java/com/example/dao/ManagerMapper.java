package com.example.dao;

import com.example.bean.Manager;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ManagerMapper {
    
    List<Manager> getManager(@Param("name") String name);
    
    void updateManagerByName(Manager manager);

}