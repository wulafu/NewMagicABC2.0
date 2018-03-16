package cn.com.magicabc.ui.word;

import java.util.HashMap;
import java.util.List;

import cn.com.magicabc.ui.activity.view.BaseView;
import cn.com.magicabc.ui.base.BasePresenter;

/**
 * Created by hellohome on 18/3/15.
 */

public interface WorkContract {

    interface WorkView extends BaseView<Presenter> {
        void workSucess(HashMap<Integer, List<WorkListBean>> integerListHashMap);
        void workError(String message);



    }

    interface Presenter extends BasePresenter {
        void loadDataAction(String uid,String grade);

    }
}
