package cn.com.magicabc.ui.login.contract;

import android.widget.EditText;

import cn.com.magicabc.ui.activity.view.BaseView;
import cn.com.magicabc.ui.base.BasePresenter;

/**
 * Created by wulafu on 2018/3/8.
 */

public interface LoginContract {


    interface LoginView extends BaseView<Presenter> {
        void loginSucess(String userphone);
        void loginError(String message);
        String getUserphone(EditText et);
        String getPwd(EditText et);
        void startForget();
        void startRegister();

    }

    interface Presenter extends BasePresenter {
        void onLogin(String userphone,String pwd);
    }

}
