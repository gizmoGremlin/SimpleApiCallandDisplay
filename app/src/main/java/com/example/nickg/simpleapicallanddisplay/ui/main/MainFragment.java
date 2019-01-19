package com.example.nickg.simpleapicallanddisplay.ui.main;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nickg.simpleapicallanddisplay.R;
import com.example.nickg.simpleapicallanddisplay.network.ApiResponse;

public class MainFragment extends Fragment  {

    private MainViewModel mViewModel;
    private TextView textView;
    public static MainFragment newInstance() {
        return new MainFragment();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);



    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.main_fragment, container, false);
        textView = (TextView) view.findViewById(R.id.message);
        mViewModel.getData().observe(this, new Observer<ApiResponse>() {
            @Override
            public void onChanged(ApiResponse apiResponse) {
                if (apiResponse == null){
                    Toast.makeText(getContext(),"error here main fragment", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(apiResponse.getError() == null){
                    textView.setText(Double.toString(apiResponse.exchangeValues.getCAD()));
                }else {
                    Throwable e = apiResponse.getError();
                    Toast.makeText(getContext(),"error is: " +e.getMessage(),Toast.LENGTH_SHORT).show();
                }

            }
        });



     //   textView.setText(mViewModel.getForexResultsCad().toString());



        return view;
    }



}
