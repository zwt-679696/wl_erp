package com.weiling.wl_erp.bean;


import java.io.Serializable;
import java.util.List;
/**
 * 作者:左文统
 * 日期:2019/6/12
 * 功能:Excel数据组装实体类
 * */
public class ExcelData implements Serializable {
    private static final long serialVersionUID = 4444017239100620999L;

    // 表头
    private List<String> titles;

    // 数据
    private List<List<Object>> rows;

    // 页签名称
    private String name;

    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public List<List<Object>> getRows() {
        return rows;
    }

    public void setRows(List<List<Object>> rows) {
        this.rows = rows;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
