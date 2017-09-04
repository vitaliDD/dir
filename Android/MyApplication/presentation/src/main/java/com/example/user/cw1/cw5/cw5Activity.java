package com.example.user.cw1.cw5;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.user.cw1.R;

/**
 * Created by user on 02.08.2017.
 */

//broadcast receiver - почта
    public class cw5Activity  extends Activity{
    private TextView cw5TextView;
    private int i=0;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cw5);
        cw5TextView=(TextView) findViewById(R.id.cw5TextView);
       // startService(new Intent(this,MyService.class)); // если сделал это , то пока не вызовешь стопСервис, то сервис будет работать

        cw5TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // stopService(new Intent(cw5Activity.this, MyService.class));
            }
        });
        Intent intent=new  Intent(cw5Activity.this, MyIntentService.class);
        intent.putExtra(MyIntentService.KEY_ACTION,"Задание 0");
        startService(intent);

        Intent intent2=new  Intent(cw5Activity.this, MyIntentService.class);
        intent2.putExtra(MyIntentService.KEY_ACTION,"Задание 1");
        startService(intent2);

        Intent intent3=new  Intent(cw5Activity.this, MyIntentService.class);
        intent3.putExtra(MyIntentService.KEY_ACTION,"Задание 2");
        startService(intent3);



    }
    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        intentFilter.addAction(MyIntentService.MY_ACTION);


        registerReceiver(receiver, intentFilter);
        Intent intent=new  Intent(cw5Activity.this, MyService.class);
       // bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE);


    }
private ServiceConnection serviceConnection=new ServiceConnection() {
    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        Log.e("AAA", "onServiceconnected");
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        Log.e("AAA", "onServiceDisconnected");
    }
};

     @Override
    protected void onStop() {
        super.onStop();
      //  unregisterReceiver(receiver);
        //unbindService(serviceConnection);
    }
    private  BroadcastReceiver receiver=new BroadcastReceiver(){

        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION))
            {
                Log.e("AAA", "onRecieve");
                i++;
                cw5TextView.setText("i = " + i);
            }else if(intent.getAction().equals((MyIntentService.MY_ACTION))){
                Log.e("AAA", "MyIntentService onRecieve");


            }
            //else()
        }
    };
}
