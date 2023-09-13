package com.chengmo.service;

import com.chengmo.entity.Suit;

import java.util.List;

public interface SuitService {

    List<Suit> findAll(Suit suit);

    boolean addSuit(Suit suit);

    boolean updateSuit(Suit suit);

    boolean deleteSuitByIds(Integer[] ids);
}
