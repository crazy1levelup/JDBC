package com.dao;

import com.entities.Pisici;

import java.util.List;

public interface PisiciDao {

    void insert(Pisici pisici);

    Pisici selectById(int id);

    List<Pisici> selectAll();

    void deleteById(int id);

    void update(Pisici pisici, int id);
}
