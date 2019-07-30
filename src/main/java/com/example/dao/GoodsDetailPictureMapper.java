package com.example.dao;

import com.example.bean.GoodsDetailPicture;
import com.example.bean.GoodsDetailPictureExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface GoodsDetailPictureMapper {
    long countByExample(GoodsDetailPictureExample example);

    int deleteByExample(GoodsDetailPictureExample example);

    int deleteByPrimaryKey(Long goodsDetailPictureId);

    int insert(GoodsDetailPicture record);

    int insertSelective(GoodsDetailPicture record);

    List<GoodsDetailPicture> selectByExample(GoodsDetailPictureExample example);
    
    List<GoodsDetailPicture> selectWithAll(@Param("likeValue") String likeValue);

    GoodsDetailPicture selectByPrimaryKey(Long goodsDetailPictureId);

    int updateByExampleSelective(@Param("record") GoodsDetailPicture record, @Param("example") GoodsDetailPictureExample example);

    int updateByExample(@Param("record") GoodsDetailPicture record, @Param("example") GoodsDetailPictureExample example);

    int updateByPrimaryKeySelective(GoodsDetailPicture record);

    int updateByPrimaryKey(GoodsDetailPicture record);
    
    int updateGoods(Map paramMap);
}