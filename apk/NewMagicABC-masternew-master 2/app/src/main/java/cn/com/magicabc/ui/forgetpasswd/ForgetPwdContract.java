package cn.com.magicabc.ui.register;

import android.widget.EditText;

import cn.com.magicabc.ui.activity.view.BaseView;
import cn.com.magicabc.ui.base.BasePresenter;

/**
 * Created by wulafu on 2018/3/8.
 */

public interface RegisterContract {


    interface RegiterView extends BaseView<Presenter> {
        void registerSucess();
        void registerError(String message);
        String getUserphone(EditText et);
        String getPwd(EditText et);
        String getCode(EditText et);
        void getOnlineCode();


    }

    interface Presenter extends BasePresenter {
        void getCodeAction(String userphone,String pwd);
        void registerAction(String userphone,String pwd,String code);
    }

}
