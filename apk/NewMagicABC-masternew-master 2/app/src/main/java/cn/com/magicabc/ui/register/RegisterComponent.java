package cn.com.magicabc.ui.superviseclass.component;


import cn.com.magicabc.ApplicationComponent;
import cn.com.magicabc.ui.superviseclass.SuperViseClassActivity;
import cn.com.magicabc.ui.superviseclass.module.SuperViseClassModule;
import cn.com.magicabc.util.ActivityScoped;
import dagger.Component;

/**
 * Created by beifeng on 2017/5/9.
 */
@ActivityScoped
@Component(modules = SuperViseClassModule.class, dependencies = ApplicationComponent.class)
public interface SuperViseClassComponent {
  void inject(SuperViseClassActivity activity);
}
