package com.chengmo.mapper;

import com.chengmo.entity.Suit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SuitMapper {

    List<Suit> findAll(Suit suit);

    boolean addSuit(Suit suit);

    boolean updateSuit(Suit suit);

    boolean deleteSuitByIds(Integer[] ids);
}
