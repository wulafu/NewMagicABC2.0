package cn.com.magicabc.http;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by bei on 2017/4/26.
 * 对错误进行统一处理，并对返回的数据HttpResult中获取Results
 */

public class HttpTransformer<R extends HttpResult<T>, T> implements Observable.Transformer<R, T> {

    private static final String TAG = "HttpTransformer";

    @Override
    public Observable<T> call(Observable<R> rObservable) {
        return rObservable.flatMap(new Func1<R, Observable<T>>() {
            @Override
            public Observable<T> call(R r) {

                //  Log.d(TAG, r.isError() ?"HttpResult is error" : "HttpResult is right");
                    if (!r.isSuccessful()) {
                        return Observable.error(new ApiException(r.getMsg()));
                    } else {
                        return createData(r.getResult());
                    }


            }
        })
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                //  .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private Observable<T> createData(final T data) {
        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                try {
                    subscriber.onNext(data);
                } catch (Exception e) {
                    subscriber.onError(e);
                } finally {
                    subscriber.onCompleted();
                }
            }
        });
    }
}
