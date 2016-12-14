package com.witype.hfmsample.app.channel;

import com.witype.easyamigo.EnvironmentImpl;
import com.witype.easyamigo.Flavor;
import com.witype.hfmsample.app.App;
import com.witype.hfmsample.app.LauncherMode;
import com.witype.hfmsample.contract.ChannelContract;
import com.witype.hfmsample.presenter.IPresenter;
import com.witype.hfmsample.utils.GsonImpl;
import com.witype.hfmsample.utils.config.Config;
import com.witype.hfmsample.utils.constant.BundleConstant;
import com.witype.hfmsample.utils.Intent;
import com.witype.hfmsample.compon.HListView;
import com.witype.hfmsample.utils.constant.ConfigConstant;
import com.witype.hfmsample.view.IView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;

/**
 * Created by Typer_work on 2016/12/13.
 * email:witype716@gmail.com
 * desc:
 */

interface IChannelView extends IView,ChannelContract.IChannelView {

}

public class ChannelApp extends App<IChannelPresenter> implements IChannelView {

    @FXML
    private HListView list_content;

    private ChannelAdapter channelAdapter;

    @Override
    public IChannelPresenter initPresenter() {
        return new ChannelPresenter(this);
    }

    @Override
    public String getPageName() {
        return "ÇþµÀ";
    }

    @Override
    public LauncherMode getLauncherMode() {
        return LauncherMode.SINGLE_TOP;
    }

    @Override
    public String getFxml() {
        return "list_content";
    }

    @Override
    public void init() {
        super.init();
        channelAdapter = new ChannelAdapter();
    }

    @Override
    public void onAppear(Intent intent) {
        super.onAppear(intent);
        list_content.setAdapter(channelAdapter);
        String workSpace = intent.get(BundleConstant.WORK_SPACE,EnvironmentImpl.DEFAULT_WORKSPACE);
        String appKey = intent.get(BundleConstant.APP_KEY,"");
        getPresenter().doGetChannel(appKey);
    }

    @Override
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String appKey = intent.get(BundleConstant.APP_KEY,"");
        channelAdapter.clear();
        getPresenter().doGetChannel(appKey);
    }

    @Override
    public void onGetChannel(ArrayList<Flavor> flavors) {
        channelAdapter.setData(flavors).notifyDataSetChange();
    }
}
