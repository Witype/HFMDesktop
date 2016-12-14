package com.witype.hfmsample.app.index;

import com.google.gson.reflect.TypeToken;
import com.witype.hfmsample.app.App;
import com.witype.hfmsample.app.channel.ChannelApp;
import com.witype.hfmsample.contract.ProjectContract;
import com.witype.hfmsample.entity.Project;
import com.witype.hfmsample.utils.constant.BundleConstant;
import com.witype.hfmsample.utils.GsonImpl;
import com.witype.hfmsample.utils.Intent;
import com.witype.hfmsample.utils.config.*;
import com.witype.hfmsample.utils.constant.ConfigConstant;
import com.witype.hfmsample.compon.HListView;
import com.witype.hfmsample.compon.OnItemClickListener;
import com.witype.hfmsample.view.IView;
import javafx.fxml.FXML;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Typer_work on 2016/12/12.
 * email:witype716@gmail.com
 * desc:
 */

interface IIndexView extends IView,ProjectContract.IProjectView ,IndexAdapter.OnFooterClickListener {

}

public class Index extends App<IIndexPresenter> implements OnItemClickListener<Project> , IIndexView {

    @FXML
    private
    HListView list_content;

    private IndexAdapter indexAdapter;

    @Override
    public IndexPresenter initPresenter() {
        return new IndexPresenter(this);
    }

    @Override
    public void onAppear(Intent intent) {
        super.onAppear(intent);
        indexAdapter = new IndexAdapter();
        indexAdapter.setOnItemClickListener(this);
        list_content.setAdapter(indexAdapter);
        getPresenter().doGetProject();
    }

    @Override
    public void onGetProject(ArrayList<Project> projects) {
        indexAdapter.addItem(projects);
        indexAdapter.addItem(new Project());
        indexAdapter.notifyDataSetChange();
    }

    @Override
    public void onClick(Project item, int position) {
        Intent intent = new Intent(ChannelApp.class);
        intent.put(BundleConstant.WORK_SPACE,item.getPath());
        intent.put(BundleConstant.APP_KEY,item.getAppKey());
        startApp(intent);
    }

    @Override
    public void onClick() {

    }

    @Override
    public String getPageName() {
        return "ึ๗าณ";
    }

    @Override
    public String getFxml() {
        return "list_content";
    }

    @Override
    public boolean closeAble() {
        return false;
    }

}
