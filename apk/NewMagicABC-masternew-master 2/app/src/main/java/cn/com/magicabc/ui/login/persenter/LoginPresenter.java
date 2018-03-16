package cn.com.magicabc.ui.login.persenter;

import android.content.Context;

import java.util.Set;

import javax.inject.Inject;

import cn.com.magicabc.http.HttpFactory;
import cn.com.magicabc.http.HttpResult;
import cn.com.magicabc.http.HttpTransformer;
import cn.com.magicabc.ui.login.contract.LoginContract;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by wulafu on 2018/3/8.
 */

public class LoginPresenter implements LoginContract.Presenter{
    private CompositeSubscription subscription;
    private LoginContract.LoginView  view;
    private final Context context;

    @Inject
    LoginPresenter(Context context,  LoginContract.LoginView view) {

        this.context = context;
        this.view = view;
        subscription = new CompositeSubscription();

    }
    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {

    }


    @Override
    public void onLogin(final String userphone, String pwd) {
        HttpFactory.getHttpApiSingleton()
                .loginAction(userphone,pwd)
                .compose(new HttpTransformer<HttpResult<String>,String>())
                .doOnSubscribe(new Action0() {
                    @Override public void call() {
                        view.showLoading();
                    }
                })
                .subscribe(new Subscriber<String>() {
                    @Override public void onCompleted() {

                        view.showContent();
                        JPushInterface.setAlias(context, userphone, new TagAliasCallback() {
                            @Override
                            public void gotResult(int i, String s, Set<String> set) {

                            }
                        });
                    }

                    @Override public void onError(Throwable e) {

                        view.showError();
                    }

                    @Override public void onNext(String str) {
                        //     ToastUtils.showLong(""+gankEntities.size());
                        //  view.showContent();
                        view.loginSucess(userphone);

                       // ToastUtils.showShort(str);
                    }
                });



        //ToastUtils.showLong("login");
    }
}
