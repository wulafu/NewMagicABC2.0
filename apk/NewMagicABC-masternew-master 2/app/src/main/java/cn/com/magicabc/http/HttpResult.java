package cn.com.magicabc.http;

/**
 * Created by bei on 2017/4/26.
 * 响应数据的"基类"，通过指定泛型获取想要的数据类型
 */

public class HttpResult<T> {

     private int code;
     private String msg;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
    //private String obj;
    private T result=(T) "成功";
   // private T dealut= (T) "成功";

//    public T getDealut() {
//        return dealut;
//    }
//
//    public void setDealut(T dealut) {
//        this.dealut = dealut;
//    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccessful() {
        return code == 200 ? true : false;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "[" + "code:" + code + " msg: " + msg + " data: " + result + "]";
    }
}
//    private int count;
//    private boolean error;
//    private T results;
//
//    public int getCount() {
//        return count;
//    }
//
//    public void setCount(int count) {
//        this.count = count;
//    }
//
//    public boolean isError() {
//        return error;
//    }
//
//    public void setError(boolean error) {
//        this.error = error;
//    }
//
//    public T getResults() {
//        return results;
//    }
//
//    public void setResults(T results) {
//        this.results = results;
//    }
//}