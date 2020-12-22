package com.webshop.dto;

import java.util.List;

public class ResultDTO<T> {
    private T model;
    private List<T> list;

    public T getModel() {
        return this.model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public List<T> getList() {
        return this.list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
