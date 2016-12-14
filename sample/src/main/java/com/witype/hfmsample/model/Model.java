package com.witype.hfmsample.model;

/**
 * Created by Typer_work on 2016/12/14.
 * email:witype716@gmail.com
 * desc:
 */
public abstract class Model<T> implements IModel<T> {

    private IModelCallback<T> callback;

    @Override
    public IModelCallback<T> getCallback() {
        return callback;
    }

    @Override
    public <C extends IModelCallback<T>> IModel setCallback(C callback) {
        this.callback = callback;
        return this;
    }
}
