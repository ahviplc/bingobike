package com.bingo.service;

import com.bingo.model.Bike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class BikeServiceImpl implements BikeService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void save(Bike bike) {
        // 将bike数据添加到mongodb中的bikes collection中
        mongoTemplate.insert(bike);
    }
}
