package cn.com.magicabc.ui.register;

import android.content.Context;

import javax.inject.Inject;

import cn.com.magicabc.http.HttpFactory;
import cn.com.magicabc.http.HttpResult;
import cn.com.magicabc.http.HttpTransformer;
import cn.com.magicabc.util.ToastUtils;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subscriptions.CompositeSubscription;


/**
 * Created by wulafu on 2018/3/8.
 */

public class RegisterPresenter implements RegisterContract.Presenter{
    private CompositeSubscription subscription;
    private RegisterContract.RegiterView  view;
    private final Context context;

    @Inject
    RegisterPresenter(Context context, RegisterContract.RegiterView view) {

        this.context = context;
        this.view = view;
        subscription = new CompositeSubscription();
       // view.setPresenter(this);
//        DaggerPresenterComponent.builder()
//                .applicationModule(new ApplicationModule(context))
//                .build()
//                .inject(this);
    }
    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {

    }


    @Override
    public void getCodeAction(String userphone, String pwd) {
        HttpFactory.getHttpApiSingleton()
                .getValidateCode(userphone,pwd)
                .compose(new HttpTransformer<HttpResult<String>,String>())
                .doOnSubscribe(new Action0() {
                    @Override public void call() {
                        view.showLoading();
                    }
                })
                .subscribe(new Subscriber<String>() {
                    @Override public void onCompleted() {

                        view.showContent();
                    }

                    @Override public void onError(Throwable e) {
                       // ToastUtils.showShort(e.getMessage()+"ddddd");
                        view.showError();
                    }

                    @Override public void onNext(String str) {
                        //     ToastUtils.showLong(""+gankEntities.size());
                        //  view.showContent();
                       // view.registerSucess();
                       // ToastUtils.showShort(str);
                        view.getOnlineCode();
                    }
                });

    }

    @Override
    public void registerAction(String userphone, String pwd, String code) {


        HttpFactory.getHttpApiSingleton()
                .registerAction("ddd","18550444038","123456","wulafu","aaaa","aaaa",3)
                .compose(new HttpTransformer<HttpResult<String>,String>())
                .doOnSubscribe(new Action0() {
                    @Override public void call() {
                        view.showLoading();
                    }
                })
                .subscribe(new Subscriber<String>() {
                    @Override public void onCompleted() {

                        view.showContent();
                    }

                    @Override public void onError(Throwable e) {
                        ToastUtils.showShort(e.getMessage()+"ddddd");
                        view.showError();
                    }

                    @Override public void onNext(String str) {
                        //     ToastUtils.showLong(""+gankEntities.size());
                        //  view.showContent();
                        view.registerSucess();
                        ToastUtils.showShort(str);
                    }
                });


    }
}
