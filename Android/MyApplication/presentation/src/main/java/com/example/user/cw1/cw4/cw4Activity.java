package com.example.user.cw1.cw4;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.user.cw1.R;

/**
 * Created by ya on 01.08.2017.
 */

public class cw4Activity extends Activity {

        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cw4);
            //интент - намерение открыть ресурсы, программы и т.д. в его также можно положить какие-то другие параметры, которые можно передать.
            //данные передаенные через интент сохранятся даже в том случае, если мы свернули активити
            //вседанные которые мы передаем через интент  они хранятся внутри хмл
            //интент
            //контекст
            //апликакэйшен
            //метод финиш в манифесте - и история не сохранияется
            //метод финиш - при уходе с активити предыдущая удаляется.ф
            //*Все эелменты интерфейса наследуются от класса VIEW

        }
    }