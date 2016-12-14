package com.witype.hfmsample.contract;

import com.google.gson.reflect.TypeToken;
import com.witype.easyamigo.Flavor;
import com.witype.hfmsample.entity.Project;
import com.witype.hfmsample.model.Model;
import com.witype.hfmsample.utils.GsonImpl;
import com.witype.hfmsample.utils.config.Config;
import com.witype.hfmsample.utils.constant.ConfigConstant;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Typer_work on 2016/12/14.
 * email:witype716@gmail.com
 * desc:
 */
public interface ChannelContract {

    interface IChannelPresenter {
        void doGetChannel(String appKey);
    }

    interface IChannelView {
        void onGetChannel(ArrayList<Flavor> flavors);
    }

    class ChannelModel extends Model<ArrayList<Flavor>> {

        String appKey;

        public ChannelModel(String appKey) {
            this.appKey = appKey;
        }

        @Override
        public ArrayList<Flavor> execute() {
            String load = Config.get().load(ConfigConstant.CONFIG_CHANNEL + "_" + appKey, "");
            Type type = new TypeToken<ArrayList<Flavor>>() {}.getType();
            return GsonImpl.get().toObject(load,type);
        }
    }
}
