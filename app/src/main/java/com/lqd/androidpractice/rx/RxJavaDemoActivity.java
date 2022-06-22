package com.lqd.androidpractice.rx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.lqd.androidpractice.R;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;

public class RxJavaDemoActivity extends AppCompatActivity {

    private static final String TAG = "RxJavaDemoActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java_demo);
        testObservableObserver();
        testFlatMap();
    }

    private void testObservableObserver() {
        Observable.create(new ObservableOnSubscribe<String>() {

            @Override
            public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                observableEmitter.onNext("1");
                observableEmitter.onNext("2");
                observableEmitter.onNext("3");
                observableEmitter.onNext("4");
                observableEmitter.onComplete();

            }
        }).map(new Function<String, String>() {
            @Override
            public String apply(@NonNull String s) throws Exception {
                return s + "---";
            }
        }).subscribe(new Observer<String>() {

            private Disposable mDisposable;

            @Override
            public void onSubscribe(Disposable disposable) {
                Log.d(TAG, "onSubscribe");
                mDisposable = disposable;
            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "onNext=" + s);
            }

            @Override
            public void onError(Throwable throwable) {
                Log.d(TAG, "onError");

            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete");

            }
        });
    }

    private void test1() {
        Observable.just("a", "b", "c")
                //使用map进行转换，参数1：转换前的类型，参数2：转换后的类型
                .map(new Function<String, String>() {
                    @Override
                    public String apply(@NonNull String s) throws Exception {
                        String name = s;
                        Log.i("tag","map--1----"+s);
                        return name;
                    }
                })
                .subscribe(s -> {
                    Log.d(TAG, s);
                });
    }

    private void testFlatMap() {
        Observable.just("a", "b", "c")
                .flatMap(new Function<String, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(@NonNull String s) throws Exception {
                        return Observable.just("haha");
                    }
                }).subscribe(o -> {
            Log.d(TAG, o.toString());
        });
    }
}