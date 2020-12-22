package com.codegym.hiep.service;

import java.util.List;

public interface BaseDao<G> {

    void add(G g);

    public void edit(int id, G g);

    public void delete(int id);

    public List<G> findAll();

    public G selectById(int id);
}
