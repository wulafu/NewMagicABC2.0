package cn.com.magicabc.http;


import java.util.List;

import cn.com.magicabc.ui.bean.HomeWorkBean;
import cn.com.magicabc.ui.bean.UserBean;
import cn.com.magicabc.ui.homework.HomeWorkListBean;
import cn.com.magicabc.ui.word.WorkListBean;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by bei on 2017/4/26.
 * Retrofit接口，定义请求方法
 */

public interface HttpApi {

   // String BASE_URL = "http://gank.io/api/";
    String BASE_URL = "http://192.168.1.148/magicabc.app/";
//

    @GET("getMyClassDetails")
    Observable<HttpResult<List<WorkListBean>>> getMyClassDetails(@Query("uid") String userphone,
                                                                 @Query("grade") String grade);

    @GET("getAllMyHomeWorkList")
    Observable<HttpResult<List<HomeWorkBean>>> getHomeWorkBeans(@Query("userphone") String userphone,
                                                                @Query("grade") String grade);
    @GET("superviseClass")
    Observable<HttpResult<String>> getSuperviseClass(@Query("classId") String classId);
   @GET("magicabc_register")
   Observable<HttpResult<String>>   registerAction(@Query("validateCode") String validateCode
           ,@Query("userphone") String userphone, @Query("password") String password,@Query("username") String username,@Query("activity") String activity,@Query("registerRationId") String registerRationId,@Query("childAge") int childAge);
    @GET("magicabc_reset")
   Observable<HttpResult<String>>   resetAction(@Query("validateCode") String validateCode
           ,@Query("userphone") String userphone, @Query("password") String password);
    @GET("magicabc_login")
   Observable<HttpResult<String>>   loginAction(@Query("userphone") String userphone,@Query("password") String password);
    @GET("getValidateCode")
   Observable<HttpResult<String>>   getValidateCode(@Query("userphone") String userphone,@Query("nationCode") String nationCode);
    @GET("queryUser")
   Observable<HttpResult<UserBean>>   queryUser(@Query("userphone") String userphone);
    @GET("getMyHomeWorkList")
   Observable<HttpResult<HomeWorkListBean>>   getMyHomeWorkList(@Query("userphone") String userphone,@Query("grade") String grade,@Query("lesson") String lesson,@Query("classId") String classId);
}
