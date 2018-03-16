package cn.com.magicabc.ui.word;


import dagger.Module;
import dagger.Provides;

/**
 * Created by beifeng on 2017/5/9.
 * 此处用来初始化 @Inject   HomePresenter(Context context, HomePageContract.View view)中的view
 */
@Module public class WordModule {

  private WorkContract.WorkView view;

  public WordModule(WorkContract.WorkView view) {
    this.view = view;
  }

  @Provides WorkContract.WorkView  provideHomeContractView() {
    return view;
  }
}
