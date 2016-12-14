package com.witype.hfmsample.app.index;

import com.google.gson.reflect.TypeToken;
import com.witype.hfmsample.contract.ProjectContract;
import com.witype.hfmsample.entity.Project;
import com.witype.hfmsample.model.IModelCallback;
import com.witype.hfmsample.presenter.IPresenter;
import com.witype.hfmsample.presenter.Presenter;
import com.witype.hfmsample.utils.GsonImpl;
import com.witype.hfmsample.utils.config.Config;
import com.witype.hfmsample.utils.constant.ConfigConstant;
import rx.Observable;
import rx.Scheduler;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.JavaFxScheduler;
import rx.schedulers.Schedulers;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Typer_work on 2016/12/14.
 * email:witype716@gmail.com
 * desc:
 */

interface IIndexPresenter extends IPresenter ,ProjectContract.IProjectPresenter {

}

public class IndexPresenter extends Presenter<IIndexView> implements IIndexPresenter {

    IndexPresenter(IIndexView view) {
        super(view);
    }

    @Override
    public void doGetProject() {
        executeLocal(new ProjectContract.ProjectModel().setCallback(new IModelCallback<ArrayList<Project>>() {
            @Override
            public void onSuccess(ArrayList<Project> e) {
                getView().onGetProject(e);
            }

            @Override
            public void onFailure() {

            }
        }));
    }
}
