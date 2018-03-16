package cn.com.magicabc.ui.login.component;


import cn.com.magicabc.ApplicationComponent;
import cn.com.magicabc.ui.login.LoginActivity;
import cn.com.magicabc.ui.login.module.LoginModule;
import cn.com.magicabc.util.ActivityScoped;
import dagger.Component;

/**
 * Created by beifeng on 2017/5/9.
 */
@ActivityScoped
@Component(modules = LoginModule.class, dependencies = ApplicationComponent.class)
public interface LoginComponent {
  void inject(LoginActivity activity);
}
