package com.example.user.cw1.cw8;

import android.app.Activity;
import android.content.Intent;
import android.databinding.ObservableField;
import android.os.AsyncTask;
import android.util.Log;

import com.example.user.cw1.base.BaseViewModel;
import com.example.user.cw1.cw6.Cw6Activity;

/**
 * Created by user on 09.08.2017.
 */
public class Cw8ViewModel implements BaseViewModel {
    public Activity activity;
    public ObservableField<String> helloText = new ObservableField<>("Hello");

    public Cw8ViewModel(Activity activity) {
        this.activity = activity;
    }


    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    public void onSuperButtonClick() {

        Log.e("BBB", "onSuperButtonClick");
        Intent intent = new Intent(activity, Cw6Activity.class);// открываем любую активити для примера
    }

    public class MyAsyncTask extends AsyncTask<Void, Integer, String> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //выполняется в потоке UI , до начала работы метода doInBackground
            //выполняется первым привызове start
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            //ыполняется в ui
            // этот метод необходимо вызывать самостоятельно из doInBackground
        }

        @Override
        protected String doInBackground(Void... params) {
            publishProgress(20);//вызвать метод onProgressUpdate
            //тут выполняется в другом потоке
            //затем передает даныне в метод onPostExecute()
            return "";


        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //тут все выполняется в UI потоке
            //входное значение  s передается из метода doInBackground
        }
    }

}