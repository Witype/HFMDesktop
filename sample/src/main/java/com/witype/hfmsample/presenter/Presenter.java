package com.witype.hfmsample.presenter;

import com.witype.hfmsample.model.IModel;
import com.witype.hfmsample.model.LocalExecuteImpl;
import com.witype.hfmsample.view.IView;

/**
 * Created by Typer_work on 2016/12/14.
 * email:witype716@gmail.com
 * desc:
 */
public class Presenter<T extends IView> implements IPresenter {

    private T view;

    public Presenter(T view) {
        this.view = view;
    }

    public T getView() {
        return view;
    }

    public <M extends IModel> void executeLocal(M model) {
        LocalExecuteImpl.get().execute(model);
    }
}
