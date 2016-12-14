package com.witype.hfmsample.app.channel;

import com.witype.easyamigo.Flavor;
import com.witype.hfmsample.contract.ChannelContract;
import com.witype.hfmsample.model.IModelCallback;
import com.witype.hfmsample.presenter.IPresenter;
import com.witype.hfmsample.presenter.Presenter;

import java.util.ArrayList;

/**
 * Created by Typer_work on 2016/12/14.
 * email:witype716@gmail.com
 * desc:
 */

interface IChannelPresenter extends IPresenter,ChannelContract.IChannelPresenter {

}

class ChannelPresenter extends Presenter<IChannelView> implements IChannelPresenter {

    ChannelPresenter(IChannelView view) {
        super(view);
    }

    @Override
    public void doGetChannel(String appKey) {
        executeLocal(new ChannelContract.ChannelModel(appKey).setCallback(new IModelCallback<ArrayList<Flavor>>() {
            @Override
            public void onSuccess(ArrayList<Flavor> flavors) {
                getView().onGetChannel(flavors);
            }

            @Override
            public void onFailure() {

            }
        }));
    }
}
