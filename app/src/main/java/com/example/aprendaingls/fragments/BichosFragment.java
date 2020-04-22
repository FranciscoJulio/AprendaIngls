package com.example.aprendaingls.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.aprendaingls.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BichosFragment extends Fragment implements View.OnClickListener{

    public BichosFragment() {
        // Required empty public constructor
    }

    private ImageButton buttonCao, buttonGato, buttonLeao, buttonMacaco, buttonOvelha, buttonVaca;

    private MediaPlayer mediaPlayer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_bichos, container, false);

        buttonCao = view.findViewById(R.id.caoID);
        buttonGato = view.findViewById(R.id.gatoID);
        buttonLeao = view.findViewById(R.id.leaoID);
        buttonMacaco = view.findViewById(R.id.macacoID);
        buttonOvelha = view.findViewById(R.id.ovelhaID);
        buttonVaca = view.findViewById(R.id.vacaID);

        buttonCao.setOnClickListener( this );
        buttonGato.setOnClickListener( this );
        buttonLeao.setOnClickListener( this );
        buttonMacaco.setOnClickListener( this );
        buttonOvelha.setOnClickListener( this );
        buttonVaca.setOnClickListener( this );


        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.caoID:
                 mediaPlayer = MediaPlayer.create(getActivity(), R.raw.dog);
                 tocarSom();
                break;
            case R.id.gatoID:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cat);
                tocarSom();
                break;
            case R.id.leaoID:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.lion);
                tocarSom();
                break;
            case R.id.macacoID:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.monkey);
                tocarSom();
                break;
            case R.id.ovelhaID:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.sheep);
                tocarSom();
                break;
            case R.id.vacaID:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cow);
                tocarSom();
                break;
        }
    }

    public void tocarSom(){

        if(mediaPlayer != null){
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer.release();
                }
            });
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }


}
