package com.witype.hfmsample.app.index;

import com.witype.hfmsample.entity.Project;
import com.witype.hfmsample.compon.BaseAdapter;
import com.witype.hfmsample.compon.ViewHolder;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * Created by Typer_work on 2016/12/13.
 * email:witype716@gmail.com
 * desc:
 */
public class IndexAdapter extends BaseAdapter<Project,ViewHolder> {

    private OnFooterClickListener onFooterClickListener;

    @Override
    public String getItemLayout(int viewType) {
        if (viewType == 1) {
            return "item_index_add";
        } else {
            return "item_index";
        }
    }

    @Override
    public int getViewType(int position) {
        if (position == getItemCount() - 1) {
            return 1;
        } else {
            return super.getViewType(position);
        }
    }

    public void setOnFooterClickListener(OnFooterClickListener onFooterClickListener) {
        this.onFooterClickListener = onFooterClickListener;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        if (holder instanceof IndexViewHolder) {
            showIndex((IndexViewHolder) holder,getItem(position));
        } else if (holder instanceof IndexFooterViewHolder && onFooterClickListener != null) {
            holder.getParent().setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    onFooterClickListener.onClick();
                }
            });
        }
    }

    private void showIndex(IndexViewHolder indexViewHolder,Project project) {
        indexViewHolder.name.setText(project.getName());
        indexViewHolder.appKey.setText(project.getAppKey());
    }

    @Override
    public ViewHolder onCreateViewHolder(int viewType) {
        if (viewType == 1) {
             return new IndexFooterViewHolder(getItemLayout(viewType));
        } else {
            return new IndexViewHolder(getItemLayout(viewType));
        }
    }

    static class IndexViewHolder extends ViewHolder {

        Label name;
        Label appKey;

        IndexViewHolder(String fxml) {
            super(fxml);
            name = (Label) getParent().lookup("#name");
            appKey = (Label) getParent().lookup("#appkey");
        }

    }
    static class IndexFooterViewHolder extends ViewHolder {

        IndexFooterViewHolder(String fxml) {
            super(fxml);
        }
    }

    interface OnFooterClickListener {

        void onClick();
    }
}
