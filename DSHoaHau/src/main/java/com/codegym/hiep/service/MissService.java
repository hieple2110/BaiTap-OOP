package com.codegym.hiep.service;

import com.codegym.hiep.model.Miss;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MissService implements BaseDao<Miss> {

    private static Map<Integer, Miss> listMiss;

    static {
        listMiss = new HashMap<>();
        listMiss.put(1, new Miss("Han", "Han", "Han", "Han", "Han", 1, "Han", "Han", "Han", "Han", 170, 49, "Han", "Han", "Pending","Thua thien hue"));
    }

    @Override
    public void add(Miss miss) {
        listMiss.put(miss.getPassport(), miss);
    }

    @Override
    public void edit(int passport, Miss miss) {
        listMiss.put(passport, miss);
    }

    @Override
    public void delete(int passport) {
        listMiss.remove(passport);
    }

    @Override
    public List<Miss> findAll() {
        return new ArrayList<>(listMiss.values());
    }

    @Override
    public Miss selectById(int passport) {
        return listMiss.get(passport);
    }

    public boolean checkMiss(int passport, String phone, String email){
        List<Miss> list = this.findAll();
        for (Miss miss : list){
            if (passport == miss.getPassport()  || phone.equals(miss.getNumberPhone()) || email.equals(miss.getEmail())){
                return true;
            }
        }
        return false;
    }
}
