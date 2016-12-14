package com.witype.hfmsample.app.channel;

import com.witype.easyamigo.Flavor;
import com.witype.hfmsample.compon.BaseAdapter;
import com.witype.hfmsample.compon.OnItemClickListener;
import com.witype.hfmsample.compon.ViewHolder;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * Created by Typer_work on 2016/12/13.
 * email:witype716@gmail.com
 * desc:
 */
public class ChannelAdapter extends BaseAdapter<Flavor,ChannelAdapter.ChannelViewHolder>{

    private OnClickListener onClickListener;

    @Override
    public String getItemLayout(int viewType) {
        return "item_channel";
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public ChannelViewHolder onCreateViewHolder(int viewType) {
        return new ChannelViewHolder(getItemLayout(viewType));
    }

    @Override
    public void onBindViewHolder(ChannelViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        final Flavor flavor = getItem(position);
        if (onClickListener != null) {
            holder.add.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    onClickListener.onAddClick(flavor);
                }
            });
            holder.manager.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    onClickListener.onManagerClick(flavor);
                }
            });
            holder.delete.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    onClickListener.onDeleteClick(flavor);
                }
            });
        }
        holder.name.setText(flavor.flavorName);
        holder.desc.setText(flavor.desc);
    }

    static class ChannelViewHolder extends ViewHolder {

        VBox add;
        VBox manager;
        VBox delete;
        Label name;
        Label desc;

        ChannelViewHolder(String fxml) {
            super(fxml);
            add = (VBox) getParent().lookup("#add");
            manager = (VBox) getParent().lookup("#manager");
            delete = (VBox) getParent().lookup("#delete");
            name = (Label) getParent().lookup("#name");
            desc = (Label) getParent().lookup("#desc");
        }
    }

    interface OnClickListener {
        void onAddClick(Flavor flavor);
        void onManagerClick(Flavor flavor);
        void onDeleteClick(Flavor flavor);
    }
}
