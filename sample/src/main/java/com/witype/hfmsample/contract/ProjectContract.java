package com.witype.hfmsample.contract;

import com.google.gson.reflect.TypeToken;
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
public interface ProjectContract {

    interface IProjectPresenter {

        void doGetProject();
    }

    interface IProjectView {
        void onGetProject(ArrayList<Project> projects);
    }

    class ProjectModel extends Model<ArrayList<Project>> {

        @Override
        public ArrayList<Project> execute() {
            String json = Config.get().load(ConfigConstant.CONFIG_PROJECT,null);
            Type type = new TypeToken<ArrayList<Project>>() {}.getType();
            return GsonImpl.get().toObject(json,type);
        }
    }
}
