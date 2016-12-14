package com.witype.hfmsample.model;

/**
 * Created by Typer_work on 2016/12/14.
 * email:witype716@gmail.com
 * desc:
 */
public interface IModelCallback<T> {

    void onSuccess(T e);

    void onFailure();
}
