package com.chengmo.service.impl;

import com.chengmo.entity.Suit;
import com.chengmo.mapper.SuitMapper;
import com.chengmo.service.SuitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SuitServiceImpl implements SuitService {

    @Resource
    private SuitMapper suitMapper;

    @Override
    public List<Suit> findAll(Suit suit) {
        return suitMapper.findAll(suit);
    }

    @Override
    public boolean addSuit(Suit suit) {
        return suitMapper.addSuit(suit);
    }

    @Override
    public boolean updateSuit(Suit suit) {
        return suitMapper.updateSuit(suit);
    }

    @Override
    public boolean deleteSuitByIds(Integer[] ids) {
        return false;
    }
}
