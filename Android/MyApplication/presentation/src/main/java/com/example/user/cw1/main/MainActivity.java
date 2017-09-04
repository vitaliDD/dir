package com.example.user.cw1.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.user.cw1.R;
import com.example.user.cw1.cw12.Cw12Activity;
import com.example.user.cw1.cw13.Cw13Activity;
import com.example.user.cw1.cw2.cw2Activity;
import com.example.user.cw1.cw3.cw3Activity;
import com.example.user.cw1.cw4.cw4Activity;
import com.example.user.cw1.cw5.cw5Activity;
import com.example.user.cw1.cw6.Cw6Activity;
import com.example.user.cw1.cw7.Cw7Activity;
import com.example.user.cw1.cw9.Cw9Activity;
import com.example.user.cw1.dz10.Dz10Activity;
import com.example.user.cw1.dz2.dz2Activity;
import com.example.user.cw1.dz3.dz3Activity;
import com.example.user.cw1.dz4.dz4Activity;
import com.example.user.cw1.dz5.Dz5Activity;
import com.example.user.cw1.dz7.Dz7Activity;
import com.example.user.cw1.dz9.Dz9Activity;
import com.squareup.leakcanary.LeakCanary;

import com.example.user.cw1.dz6.Dz6Activity;

import com.example.user.cw1.cw8.Cw8Activity;

import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

/**
 * Created by user on 26.07.2017.
 */
public class MainActivity extends Activity {

    public PublishSubject<String> publishSubject=PublishSubject.create();// получим только то, что приходит после подписки
    public BehaviorSubject<String> behaviorSubject=BehaviorSubject.create();//по умолчанию кэширует один объект, есть параметры,чтобы разное количество кэшировало
    public ReplaySubject<String> replaySubject=ReplaySubject.create();//хранит всю историю
    Disposable disposable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaySubject.onNext("odin");
        replaySubject.onNext("dva");
        replaySubject.onNext("tri");
        replaySubject.onNext("chetiri");
        disposable=replaySubject.subscribeWith(new DisposableObserver<String>() {
            @Override
            public void onNext(String s) {
                Log.e("AAA", s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        replaySubject.onNext("pyat'");
        replaySubject.onNext("shest");
        replaySubject.onNext("sem");


        LeakCanary.install(getApplication());
        final Button dz1Button =(Button) findViewById(R.id.dz1Button);
        final Button dz2Button =(Button) findViewById(R.id.dz2Button);
        final Button dz3Button =(Button) findViewById(R.id.dz3Button);
        final Button dz4Button =(Button) findViewById(R.id.dz4Button);
        final Button dz5Button =(Button) findViewById(R.id.dz5Button);
        final Button dz6Button =(Button) findViewById(R.id.dz6Button);
        final Button dz7Button =(Button) findViewById(R.id.dz7Button);
        final Button dz9Button =(Button) findViewById(R.id.dz9Button);
        final Button dz10Button =(Button) findViewById(R.id.dz10Button);



        final Button cw3Button =(Button) findViewById(R.id.cw3Button);
        final Button cw2Button =(Button) findViewById(R.id.cw2Button);
        final Button cw4Button =(Button) findViewById(R.id.cw4Button);
        final Button cw5Button =(Button) findViewById(R.id.cw5Button);
        final Button cw6Button =(Button) findViewById(R.id.cw6Button);
        final Button cw7Button =(Button) findViewById(R.id.cw7Button);
        final Button cw8Button =(Button) findViewById(R.id.cw8Button);
        final Button cw9Button =(Button) findViewById(R.id.cw9Button);
        final Button cw12Button =(Button) findViewById(R.id.cw12Button);
        final Button cw13Button =(Button) findViewById(R.id.cw13Button);
//        final Button cw6Button =(Button) findViewById(R.id.cw6Button);

        dz1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(MainActivity.this,cw2Activity.class);
                startActivity(intent);
            }
        });
        dz2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(MainActivity.this,dz2Activity.class);
                startActivity(intent);
            }
        });
        dz3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(MainActivity.this,dz3Activity.class);
                startActivity(intent);
            }
        });
        dz4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(MainActivity.this,dz4Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.diagonaltranslate, R.anim.rotate);
            }
        });
        dz5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(MainActivity.this,Dz5Activity.class);
                startActivity(intent);
            }
        });
        dz6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(MainActivity.this, Dz6Activity.class);
                startActivity(intent);
            }
        });
        dz7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(MainActivity.this, Dz7Activity.class);
                startActivity(intent);
            }
        });
        dz9Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Dz9Activity.class);
                // startActivity(intent);
                Dz9Activity.show(MainActivity.this);
            }
            });
        dz10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Dz10Activity.class);
                // startActivity(intent);
                Dz10Activity.show(MainActivity.this);
            }
        });




        cw3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,cw3Activity.class);
                startActivity(intent);
            }
        });
        cw2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,cw2Activity.class);
                startActivity(intent);
            }
        });
        cw4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,cw4Activity.class);
                startActivity(intent);
            }
        });
        cw5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,cw5Activity.class);
                startActivity(intent);
            }
        });
        cw6Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,Cw6Activity.class);
                startActivity(intent);
            }
        });
        cw7Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,Cw7Activity.class);
                startActivity(intent);
            }
        });
        cw8Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, Cw8Activity.class);
                startActivity(intent);
            }
        });
        cw9Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, Cw9Activity.class);
               // startActivity(intent);
                Cw9Activity.show(MainActivity.this);
            }
        });
        cw12Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, Cw12Activity.class);
                // startActivity(intent);
                Cw12Activity.show(MainActivity.this);
            }
        });
        cw13Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,Cw13Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(!disposable.isDisposed()){

            disposable.dispose();

        }
    }
}
