package com.codegym.hiep.service;

import com.codegym.hiep.model.Province;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProvinceService implements BaseDao<Province> {
    private static Map<Integer, Province> listProvince;

    static {
        listProvince = new HashMap<>();
        listProvince.put(1, new Province(1, "An Giang"));
        listProvince.put(2, new Province(2, "Bà Rịa – Vũng Tàu"));
        listProvince.put(3, new Province(3, "Bắc Giang"));
        listProvince.put(4, new Province(4, "Bắc Kạn"));
        listProvince.put(5, new Province(5, "Bạc Liêu"));
        listProvince.put(6, new Province(6, "Bắc Ninh"));
        listProvince.put(7, new Province(7, "Bến Tre"));
        listProvince.put(8, new Province(8, "Bình Định"));
        listProvince.put(9, new Province(9, "Bình Dương"));
        listProvince.put(10, new Province(10, "Bình Phước"));
        listProvince.put(11, new Province(11, "Bình Thuận"));
        listProvince.put(12, new Province(12, "Cà Mau"));
        listProvince.put(13, new Province(13, "Cần Thơ"));
        listProvince.put(14, new Province(14, "Cao Bằng"));
        listProvince.put(15, new Province(15, "Đà Nẵng"));
        listProvince.put(16, new Province(16, "Đắk Lắk"));
        listProvince.put(17, new Province(17, "Đắk Nông"));
        listProvince.put(18, new Province(18, "Điện Biên"));
        listProvince.put(19, new Province(19, "Đồng Nai"));
        listProvince.put(20, new Province(20, "Đồng Tháp"));
        listProvince.put(21, new Province(21, "Gia Lai"));
        listProvince.put(22, new Province(22, "Hà Giang"));
        listProvince.put(23, new Province(23, "Hà Nam"));
        listProvince.put(24, new Province(24, "Hà Nội"));
        listProvince.put(25, new Province(25, "Hà Tĩnh"));
        listProvince.put(26, new Province(26, "Hải Dương"));
        listProvince.put(27, new Province(27, "Hải Phòng"));
        listProvince.put(28, new Province(28, "Hậu Giang"));
        listProvince.put(29, new Province(29, "Hòa Bình"));
        listProvince.put(30, new Province(30, "Hưng Yên"));
        listProvince.put(31, new Province(31, "Khánh Hòa"));
        listProvince.put(32, new Province(32, "Kiên Giang"));
        listProvince.put(33, new Province(33, "Kon Tum"));
        listProvince.put(34, new Province(34, "Lai Châu"));
        listProvince.put(35, new Province(35, "Lâm Đồng"));
        listProvince.put(36, new Province(36, "Lạng Sơn"));
        listProvince.put(37, new Province(37, "Lào Cai"));
        listProvince.put(38, new Province(38, "Long An"));
        listProvince.put(39, new Province(39, "Nam Định"));
        listProvince.put(40, new Province(40, "Nghệ An"));
        listProvince.put(41, new Province(41, "Ninh Bình"));
        listProvince.put(42, new Province(42, "Ninh Thuận"));
        listProvince.put(43, new Province(43, "Phú Thọ"));
        listProvince.put(44, new Province(44, "Phú Yên"));
        listProvince.put(45, new Province(45, "Quảng Bình"));
        listProvince.put(46, new Province(46, "Quảng Nam"));
        listProvince.put(47, new Province(47, "Quảng Ngãi"));
        listProvince.put(48, new Province(48, "Quảng Ninh"));
        listProvince.put(49, new Province(49, "Quảng Trị"));
        listProvince.put(50, new Province(50, "Sóc Trăng"));
        listProvince.put(51, new Province(51, "Sơn La"));
        listProvince.put(52, new Province(52, "Tây Ninh"));
        listProvince.put(53, new Province(53, "Thái Bình"));
        listProvince.put(54, new Province(54, "Thái Nguyên"));
        listProvince.put(55, new Province(55, "Thanh Hóa"));
        listProvince.put(56, new Province(56, "Thừa Thiên Huế"));
        listProvince.put(57, new Province(57, "Tiền Giang"));
        listProvince.put(58, new Province(58, "TP Hồ Chí Minh"));
        listProvince.put(59, new Province(59, "Trà Vinh"));
        listProvince.put(60, new Province(60, "Tuyên Quang"));
        listProvince.put(61, new Province(61, "Vĩnh Long"));
        listProvince.put(62, new Province(62, "Vĩnh Phúc"));
        listProvince.put(63, new Province(63, "Yên Bái"));
    }

    @Override
    public void add(Province province) {
        listProvince.put(province.getIdProvince(), province);
    }

    @Override
    public void edit(int id, Province province) {
        listProvince.put(id, province);
    }

    @Override
    public void delete(int id) {
        listProvince.remove(id);
    }

    @Override
    public List<Province> findAll() {
        return new ArrayList<>(listProvince.values());
    }

    @Override
    public Province selectById(int id) {
        return listProvince.get(id);
    }
}