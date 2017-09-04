package com.example.user.cw1.cw2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.cw1.R;
import com.example.user.cw1.dz1.dz1Activity;

/**
 * Created by user on 26.07.2017.
 */
public class cw2Activity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cw2);

        Button intButton=(Button) findViewById(R.id.intButton);
        final EditText editText1=(EditText) findViewById(R.id.textPersonName);
        final EditText editText2=(EditText) findViewById(R.id.textPassword);
        intButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(cw2Activity.this,dz1Activity.class);
                intent.putExtra(dz1Activity.KEY_USERNAME,editText1.getText().toString());
                intent.putExtra(dz1Activity.KEY_PASSWORD, editText2.getText().toString());
                startActivity(intent);

            }
        });

    }
}
