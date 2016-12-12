package com.witype.hfmsample.entity;

/**
 * Created by Typer_work on 2016/12/12.
 * email:witype716@gmail.com
 * desc:
 */
public class BaseEntity<T> {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
