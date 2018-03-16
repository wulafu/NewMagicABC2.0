package cn.com.magicabc.http;

/**
 * Created by wulafu on 2018/3/9.
 */

public class HttpResults<T> {
    private int count;
    private boolean error;
    private T results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }
}
