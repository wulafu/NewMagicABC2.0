package cn.com.magicabc.ui.register;


import cn.com.magicabc.util.ActivityScoped;
import dagger.Module;
import dagger.Provides;

/**
 * Created by beifeng on 2017/5/9.
 * 此处用来初始化 @Inject   HomePresenter(Context context, HomePageContract.View view)中的view
 */
@ActivityScoped
@Module public class RegisterModule {

  private RegisterContract.RegiterView view;

  public RegisterModule(RegisterContract.RegiterView view) {
    this.view = view;
  }

  @Provides RegisterContract.RegiterView provideRegisterContractView() {
    return view;
  }
}
