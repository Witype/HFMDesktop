package com.witype.hfmsample.compon;

/**
 * Created by Typer_work on 2016/12/13.
 * email:witype716@gmail.com
 * desc:
 */
public abstract class Adapter<E extends ViewHolder> {

    private HListView hListView;

    public void sethListView(HListView hListView) {
        this.hListView = hListView;
    }

    public void notifyDataSetChange() {
        hListView.notifyDataSetChange();
    }

    public void notifyDataSetChange(int position) {
        hListView.notifyDataSetChange(position);
    }

    public abstract int getItemCount();

    public abstract String getItemLayout(int viewType);

    public int getViewType(int position) {
        return 0;
    }

    public abstract void onBindViewHolder(E holder,int position);

    public abstract E onCreateViewHolder(int viewType);
}
