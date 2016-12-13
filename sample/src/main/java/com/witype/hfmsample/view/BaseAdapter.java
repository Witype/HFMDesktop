package com.witype.hfmsample.view;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

/**
 * Created by Typer_work on 2016/12/13.
 * email:witype716@gmail.com
 * desc:
 */
public abstract class BaseAdapter<T,E extends ViewHolder> extends Adapter<E> {

    private ArrayList<T> data;

    private OnItemClickListener<T> onItemClickListener;

    public T getItem(int position) {
        return data.get(position);
    }

    public ArrayList<T> getData() {
        return data;
    }

    public void addItem(T t) {
        if (data == null) data = new ArrayList<T>(0);
        data.add(t);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public void setData(ArrayList<T> data) {
        this.data = data;
    }

    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public void onBindViewHolder(E holder, final int position) {
        if (onItemClickListener != null) {
            holder.getParent().setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    onItemClickListener.onClick(getItem(position),position);
                }
            });
        }
    }
}
