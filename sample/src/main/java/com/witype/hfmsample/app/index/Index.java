package com.witype.hfmsample.app.index;

import com.google.gson.reflect.TypeToken;
import com.witype.hfmsample.app.App;
import com.witype.hfmsample.app.channel.ChannelApp;
import com.witype.hfmsample.entity.Project;
import com.witype.hfmsample.utils.config.*;
import com.witype.hfmsample.view.HListView;
import com.witype.hfmsample.view.OnItemClickListener;
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
public class Index extends App implements OnItemClickListener<Project> {

    @FXML
    private
    HListView list_content;

    private IndexAdapter indexAdapter;

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

    @Override
    public void onAppear(Intent intent) {
        super.onAppear(intent);
        String json = Config.get().load(ConfigConstant.CONFIG_PROJECT,null);
        indexAdapter = new IndexAdapter();
        indexAdapter.setOnItemClickListener(this);
        list_content.setAdapter(indexAdapter);
        addProject(json);
        addCreateContent();
    }


    private void addProject(String json) {
        Observable.just(json)
                .filter(new Func1<String, Boolean>() {
                    @Override
                    public Boolean call(String s) {
                        return s != null;
                    }
                })
                .flatMap(new Func1<String, Observable<Project>>() {
                    @Override
                    public Observable<Project> call(String s) {
                        Type type = new TypeToken<ArrayList<Project>>() {}.getType();
                        ArrayList<Project> projects = GsonImpl.get().toObject(s,type);
                        return Observable.from(projects);
                    }
                })
                .subscribe(new Subscriber<Project>() {
                    @Override
                    public void onCompleted() {
                        indexAdapter.notifyDataSetChange();
                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onNext(Project project) {
                        indexAdapter.addItem(project);
                        indexAdapter.addItem(project);
                    }
                });
    }

    private void addCreateContent() {

    }

    @Override
    public void onClick(Project item, int position) {
        Intent intent = new Intent(ChannelApp.class);
        intent.put(BundleConstant.WORK_SPACE,item.getPath());
        startApp(intent);
    }

    @FXML
    protected void onAddClick() {

    }

}
