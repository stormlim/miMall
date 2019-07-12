package com.example.dao;

import com.example.bean.GoodsDetail;
import com.example.bean.GoodsDetailExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface GoodsDetailMapper {
    long countByExample(GoodsDetailExample example);

    int deleteByExample(GoodsDetailExample example);

    int deleteByPrimaryKey(Long goodsDetailId);

    int insert(GoodsDetail record);

    int insertSelective(GoodsDetail record);

    List<GoodsDetail> selectByExample(GoodsDetailExample example);
    
    List<GoodsDetail> selectWithAll(@Param("likeValue") String likeValue);
    
    List<GoodsDetail> selectWithNoPicture();

    GoodsDetail selectByPrimaryKey(Long goodsDetailId);

    int updateByExampleSelective(@Param("record") GoodsDetail record, @Param("example") GoodsDetailExample example);

    int updateByExample(@Param("record") GoodsDetail record, @Param("example") GoodsDetailExample example);

    int updateByPrimaryKeySelective(GoodsDetail record);

    int updateByPrimaryKey(GoodsDetail record);
}