package com.example.user.cw1.cw13;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.cw1.R;

/**
 * Created by user on 21.08.2017.
 */
public class Cw13Fragment extends Fragment {
    public static final String TEXT_KEY="TEXT_KEY";
    private String text;

    public static Cw13Fragment newInstance(FragmentManager fragmentManager,String text){
        Fragment fragment=fragmentManager.findFragmentByTag(Cw13Fragment.class.getName());
        Cw13Fragment cw13Fragment;
        if(fragment!=null&&fragment instanceof Cw13Fragment){
            cw13Fragment=(Cw13Fragment)fragment;


        }
        else{

            cw13Fragment=new Cw13Fragment();
            Bundle bundle= new Bundle();
            bundle.putString(TEXT_KEY,text);
            cw13Fragment.setArguments(bundle);

        }

        return cw13Fragment;


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle=getArguments();
        if(bundle!=null){

            text =bundle.getString(TEXT_KEY);

        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cw13,container,false);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


}
