package com.witype.hfmsample.view;

import javafx.scene.layout.FlowPane;

import java.util.ArrayList;

/**
 * Created by Typer_work on 2016/12/13.
 * email:witype716@gmail.com
 * desc:
 */
public class HListView<E extends ViewHolder> extends FlowPane {

    private Adapter<E> adapter;

    private ArrayList<E> parents;

    public void setAdapter(Adapter adapter) {
        this.adapter = adapter;
        adapter.sethListView(this);
        parents = new ArrayList<E>(0);
    }

    public void notifyDataSetChange() {
        if (adapter == null) return;
        int count = adapter.getItemCount();
        int changed = parents.size() - count;
        if (changed > 0) {
            for (int i = changed,last = parents.size() - 1; i > 0; i--,last--) {
                getChildren().remove(last);
            }
        }
        for (int i = 0; i < count; i++) {
            notifyDataSetChange(i);
        }

    }

    public void notifyDataSetChange(int position) {
        int size = parents.size();
        E viewHolder = size - 1 >= position  ? parents.get(position) : null;
        if (viewHolder == null) {
            viewHolder = adapter.onCreateViewHolder(adapter.getViewType(position));
            parents.add(viewHolder);
            viewHolder.getParent().minWidth(getPrefWidth());
            getChildren().add(viewHolder.getParent());
        }
        adapter.onBindViewHolder(viewHolder,position);
    }

}
