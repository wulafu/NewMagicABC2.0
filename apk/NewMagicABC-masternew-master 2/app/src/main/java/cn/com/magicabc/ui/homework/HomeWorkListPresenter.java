package cn.com.magicabc.ui.word;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import cn.com.magicabc.http.HttpFactory;
import cn.com.magicabc.http.HttpResult;
import cn.com.magicabc.util.LogUtils;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by beifeng on 2017/5/10.
 * 首页p层
 */

public class WorkListPresenter implements WorkContract.Presenter {
  private CompositeSubscription subscription;
  private WorkContract.WorkView view;
  private final Context context;
  String TAG = "homePresenter";

  @Inject
  WorkListPresenter(Context context, WorkContract.WorkView view) {

    this.context = context;
    this.view = view;
    subscription = new CompositeSubscription();
    //view.setPresenter(this);
//    DaggerPresenterComponent.builder()
//        .applicationModule(new ApplicationModule(context))
//        .build()
//        .inject(this);
  }


  @Override public void subscribe() {
   // loadDataAction();
  }

  @Override public void unSubscribe() {

  }

  @Override
  public void loadDataAction(String uid, String grade) {
    HttpFactory.getHttpApiSingleton()
            .getMyClassDetails(uid,grade)
            .flatMap(new Func1<HttpResult<List<WorkListBean>>, Observable<HashMap<Integer, List<WorkListBean>>>>() {
              @Override
              public Observable<HashMap<Integer, List<WorkListBean>>> call(HttpResult<List<WorkListBean>> listHttpResult) {
                List<WorkListBean>  workListBean= listHttpResult.getResult();
                final HashMap<Integer, List<WorkListBean>> integerListHashMap = new HashMap<>();

             //   ToastUtils.showShort("22----"+workListBean.size());
                int count=0;
                if(workListBean.size()%6==0){
                  count=workListBean.size()/6;
                }else{
                  count=workListBean.size()/6+1;
                }

                for (int i = 0; i <count ; i++) {


                  if (i == count - 1) {
                    ArrayList<WorkListBean> workListBeens = new ArrayList<>();

                    if (workListBean.size() % 6 == 1) {
                      workListBeens.add(workListBean.get(i * 6 + 0));
                    } else if (workListBean.size() % 6 == 2) {
                      workListBeens.add(workListBean.get(i * 6 + 0));
                      workListBeens.add(workListBean.get(i * 6 + 1));
                    } else if (workListBean.size() % 6 == 3) {
                      workListBeens.add(workListBean.get(i * 6 + 0));
                      workListBeens.add(workListBean.get(i * 6 + 1));
                      workListBeens.add(workListBean.get(i * 6 + 2));
                    } else if (workListBean.size() % 6 == 4) {
                      workListBeens.add(workListBean.get(i * 6 + 0));
                      workListBeens.add(workListBean.get(i * 6 + 1));
                      workListBeens.add(workListBean.get(i * 6 + 2));
                      workListBeens.add(workListBean.get(i * 6 + 3));
                    } else if (workListBean.size() % 6 == 5) {
                      workListBeens.add(workListBean.get(i * 6 + 0));
                      workListBeens.add(workListBean.get(i * 6 + 1));
                      workListBeens.add(workListBean.get(i * 6 + 2));
                      workListBeens.add(workListBean.get(i * 6 + 3));
                      workListBeens.add(workListBean.get(i * 6 + 4));
                    }else{
                      workListBeens.add(workListBean.get(i * 6 + 0));
                      workListBeens.add(workListBean.get(i * 6 + 1));
                      workListBeens.add(workListBean.get(i * 6 + 2));
                      workListBeens.add(workListBean.get(i * 6 + 3));
                      workListBeens.add(workListBean.get(i * 6 + 4));
                      workListBeens.add(workListBean.get(i * 6 + 5));
                    }
                    integerListHashMap.put(i, workListBeens);
                  }
                  else {
                    ArrayList<WorkListBean> workListBeens1 = new ArrayList<>();
                    workListBeens1.add(workListBean.get(i * 6 + 0));
                    workListBeens1.add(workListBean.get(i * 6 + 1));
                    workListBeens1.add(workListBean.get(i * 6 + 2));
                    workListBeens1.add(workListBean.get(i * 6 + 3));
                    workListBeens1.add(workListBean.get(i * 6 + 4));
                    workListBeens1.add(workListBean.get(i * 6 + 5));
                    integerListHashMap.put(i, workListBeens1);

                  }


                }

                return Observable.create(new Observable.OnSubscribe<HashMap<Integer, List<WorkListBean>>>() {
                  @Override
                  public void call(Subscriber<? super HashMap<Integer, List<WorkListBean>>> subscriber) {
                    try {
                      subscriber.onNext(integerListHashMap);
                    } catch (Exception e) {
                      subscriber.onError(e);
                    } finally {
                      subscriber.onCompleted();
                    }
                  }
                });
              }
            })
            .subscribeOn(Schedulers.io())
           // .unsubscribeOn(Schedulers.io())
            //  .subscribeOn(AndroidSchedulers.mainThread())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe(new Action0() {
              @Override public void call() {
                view.showLoading();
              }
            })
            .subscribe(new Subscriber<HashMap<Integer, List<WorkListBean>>>() {
              @Override public void onCompleted() {
                LogUtils.d(TAG, "Completed");
                view.showContent();
              }

              @Override public void onError(Throwable e) {
                LogUtils.d(TAG, "OnError, Error is " + e.toString());
                view.showError();
              }

              @Override public void onNext(HashMap<Integer, List<WorkListBean>> gankEntities) {

                //  view.showContent();
                view.workSucess(gankEntities);



              }
            });
  }
}
