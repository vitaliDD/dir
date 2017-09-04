package com.example.user.cw1.dz3;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.user.cw1.BuildConfig;
import com.example.user.cw1.R;
import com.example.user.cw1.dz2.RoundTransformation;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.picasso.Picasso;


/**
 * Created by ya on 29.07.2017.
 */

public class dz3Activity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dz3);

        final Button button=(Button)findViewById(R.id.dz3Button);
        final EditText editText=(EditText) findViewById(R.id.dz3EditText);
        final TextView textView=(TextView) findViewById(R.id.dz3TextView);
        final ImageView imageView=(ImageView) findViewById(R.id.dz3ImageView);
        //final ImageView imageView2=(ImageView) findViewById(R.id.dz3ImageView2);

        //String str="http://goo.gl/images/4fhT4V";
       // Picasso.with(this).load(str).into(imageView2);
        Log.d("create",editText.getText().toString());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("click",editText.getText().toString());
                if(!editText.getText().toString().equals(""))
                Picasso.with(dz3Activity.this).load(editText.getText().toString()).transform(new RoundTransformation()).into(imageView);
                textView.setText(BuildConfig.API_ENDPOINT);

            }
        });
    }
}
