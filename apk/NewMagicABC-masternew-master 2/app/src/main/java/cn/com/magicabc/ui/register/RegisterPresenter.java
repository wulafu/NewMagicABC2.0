package cn.com.magicabc.ui.login.persenter;

import android.content.Context;

import javax.inject.Inject;

import cn.com.magicabc.ui.login.contract.LoginContract;
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
    public void onLogin() {
        view.loginSucess();
        //ToastUtils.showLong("login");
    }
}
