package com.witype.hfmsample.app.index;

import com.google.gson.reflect.TypeToken;
import com.witype.hfmsample.controller.Controller;
import com.witype.hfmsample.entity.BaseEntity;
import com.witype.hfmsample.entity.Project;
import com.witype.hfmsample.utils.config.Config;
import com.witype.hfmsample.utils.config.ConfigConstant;
import com.witype.hfmsample.utils.config.GsonImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Typer_work on 2016/12/12.
 * email:witype716@gmail.com
 * desc:
 */
public class IndexController extends Controller {

    @FXML
    FlowPane index_content;

    @Override
    public void onAppear() {
        super.onAppear();
        String json = Config.get().load(ConfigConstant.CONFIG_PROJECT,null);
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
                .map(new Func1<Project, ItemApp>() {
                    @Override
                    public ItemApp call(Project project) {
                        return new ItemApp(project.getName());
                    }
                })
                .map(new Func1<ItemApp, Node>() {
                    @Override
                    public Node call(ItemApp itemApp) {
                        return itemApp.getNode();
                    }
                })
                .subscribe(new Action1<Node>() {
                    @Override
                    public void call(Node node) {
                        index_content.getChildren().add(node);
                    }
                });
    }

    private void addCreateContent() {
        AddtionApp addtionApp = new AddtionApp();
        index_content.getChildren().add(addtionApp.getNode());
    }

    @FXML
    protected void onAddClick() {

    }


}
