package cn.com.magicabc.ui.activity.persenter;

import android.content.Context;

import java.util.List;

import javax.inject.Inject;

import cn.com.magicabc.http.HttpFactory;
import cn.com.magicabc.http.HttpResult;
import cn.com.magicabc.http.HttpTransformer;
import cn.com.magicabc.ui.activity.contract.HomeContract;
import cn.com.magicabc.ui.word.WorkListBean;
import cn.com.magicabc.util.LogUtils;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by beifeng on 2017/5/10.
 * 首页p层
 */

public class HomePresenter implements HomeContract.Presenter {
  private CompositeSubscription subscription;
  private HomeContract.HomeView view;
  private final Context context;
  String TAG = "homePresenter";

  @Inject HomePresenter(Context context, HomeContract.HomeView view) {

    this.context = context;
    this.view = view;
    subscription = new CompositeSubscription();
    view.setPresenter(this);
//    DaggerPresenterComponent.builder()
//        .applicationModule(new ApplicationModule(context))
//        .build()
//        .inject(this);
  }

  @Override public void loadData() {
    HttpFactory.getHttpApiSingleton()
        .getMyClassDetails("Android","")
        .compose(new HttpTransformer<HttpResult<List<WorkListBean>>,List<WorkListBean>>())
        .doOnSubscribe(new Action0() {
          @Override public void call() {
            view.showLoading();
          }
        })
        .subscribe(new Subscriber<List<WorkListBean>>() {
          @Override public void onCompleted() {
            LogUtils.d(TAG, "Completed");
            view.showContent();
          }

          @Override public void onError(Throwable e) {
            LogUtils.d(TAG, "OnError, Error is " + e.toString());
            view.showError();
          }

          @Override public void onNext(List<WorkListBean> gankEntities) {
       //     ToastUtils.showLong(""+gankEntities.size());
          //  view.showContent();
            view.displayData(gankEntities);

          }
        });
  }

  @Override public void subscribe() {
    loadData();
  }

  @Override public void unSubscribe() {

  }
}
