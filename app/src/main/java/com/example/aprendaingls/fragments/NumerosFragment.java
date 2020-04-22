package com.example.aprendaingls.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Switch;

import com.example.aprendaingls.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumerosFragment extends Fragment implements View.OnClickListener{

    public NumerosFragment() {
        // Required empty public constructor
    }


    private ImageButton buttonUm, buttonDois, buttonTres, buttonQuatro, buttonCinco, buttonSeis;

    private MediaPlayer mediaPlayer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_numeros, container, false);

        buttonUm = view.findViewById(R.id.numeroUmID);
        buttonDois = view.findViewById(R.id.numeroDoisID);
        buttonTres = view.findViewById(R.id.numeroTresID);
        buttonQuatro = view.findViewById(R.id.numeroQuatroID);
        buttonCinco = view.findViewById(R.id.numeroCincoID);
        buttonSeis = view.findViewById(R.id.numeroSeisID);

        buttonUm.setOnClickListener( this );
        buttonDois.setOnClickListener( this );
        buttonTres.setOnClickListener( this );
        buttonQuatro.setOnClickListener( this );
        buttonCinco.setOnClickListener( this );
        buttonSeis.setOnClickListener( this );

        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.numeroUmID:
                mediaPlayer = MediaPlayer.create( getActivity(), R.raw.one);
                tocarSom();
                break;
            case R.id.numeroDoisID:
                mediaPlayer = MediaPlayer.create( getActivity(), R.raw.two);
                tocarSom();
                break;
            case R.id.numeroTresID:
                mediaPlayer = MediaPlayer.create( getActivity(), R.raw.three);
                tocarSom();
                break;
            case R.id.numeroQuatroID:
                mediaPlayer = MediaPlayer.create( getActivity(), R.raw.four);
                tocarSom();
                break;
            case R.id.numeroCincoID:
                mediaPlayer = MediaPlayer.create( getActivity(), R.raw.five);
                tocarSom();
                break;
            case R.id.numeroSeisID:
                mediaPlayer = MediaPlayer.create( getActivity(), R.raw.six);
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
