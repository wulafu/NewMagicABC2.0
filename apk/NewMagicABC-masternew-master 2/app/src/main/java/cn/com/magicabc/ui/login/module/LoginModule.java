package cn.com.magicabc.ui.login.module;


import cn.com.magicabc.ui.login.contract.LoginContract;
import cn.com.magicabc.util.ActivityScoped;
import dagger.Module;
import dagger.Provides;

/**
 * Created by beifeng on 2017/5/9.
 * 此处用来初始化 @Inject   HomePresenter(Context context, HomePageContract.View view)中的view
 */
@ActivityScoped
@Module public class LoginModule {

  private LoginContract.LoginView view;

  public LoginModule(LoginContract.LoginView view) {
    this.view = view;
  }

  @Provides LoginContract.LoginView provideLoginContractView() {
    return view;
  }
}
