package com.witype.hfmsample.model;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.JavaFxScheduler;
import rx.schedulers.Schedulers;

/**
 * Created by Typer_work on 2016/12/14.
 * email:witype716@gmail.com
 * desc:
 */
public class LocalExecuteImpl implements IExecute {

    private static LocalExecuteImpl INSTANCE = new LocalExecuteImpl();

    public static LocalExecuteImpl get() {
        return INSTANCE;
    }

    @Override
    public <T,M extends IModel<T>> void execute(final M model) {
        Observable.just(model)
                .observeOn(Schedulers.newThread())
                .map(new Func1<M, T>() {
                    @Override
                    public T call(M m) {
                        return m.execute();
                    }
                })
                .filter(new Func1<T, Boolean>() {
                    @Override
                    public Boolean call(T t) {
                        return model.getCallback() != null;
                    }
                })
                .observeOn(JavaFxScheduler.getInstance())
                .subscribe(new Subscriber<T>() {
                    @Override
                    public void onCompleted() {}

                    @Override
                    public void onError(Throwable throwable) {
                        model.getCallback().onFailure();
                    }

                    @Override
                    public void onNext(T t) {
                        model.getCallback().onSuccess(t);
                    }
                });
    }
}
