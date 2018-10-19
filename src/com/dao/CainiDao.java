package com.dao;

import com.entities.Caini;

import java.util.List;

public interface CainiDao {

    void insert(Caini caine);
    Caini selectById(int id);

    List<Caini> selectAll();
    void delete(int id);
    void update(Caini caine, int id);
}

