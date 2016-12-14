package com.witype.hfmsample.model;

/**
 * Created by Typer_work on 2016/12/14.
 * email:witype716@gmail.com
 * desc:
 */
public interface IModel<T> {

    T execute();

    IModelCallback<T> getCallback();

    <C extends IModelCallback<T>> IModel setCallback(C callback);
}
