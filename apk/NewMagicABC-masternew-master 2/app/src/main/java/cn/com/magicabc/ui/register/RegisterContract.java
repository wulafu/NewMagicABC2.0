package cn.com.magicabc.ui.login.contract;

import cn.com.magicabc.ui.activity.view.BaseView;
import cn.com.magicabc.ui.base.BasePresenter;

/**
 * Created by wulafu on 2018/3/8.
 */

public interface LoginContract {


    interface LoginView extends BaseView<Presenter> {
        void loginSucess();
        void loginError(String message);

    }

    interface Presenter extends BasePresenter {
        void onLogin();
    }

}
