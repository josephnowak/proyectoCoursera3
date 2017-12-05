package com.example.josep.mascotascoursera;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;


public class PerfilMascota extends Fragment
{
    ArrayList<InfoMascota> listaInfo;
    private RecyclerView listaMascota;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_perfil_mascota2, container, false);

        listaInfo = new ArrayList<>();
        for(int i = 1; i <= 9; i++)
            listaInfo.add(new InfoMascota(R.drawable.mascota1,R.drawable.patamg,R.drawable.patamg,"",String.valueOf(i),false));

        listaMascota = (RecyclerView)v.findViewById(R.id.fotosGustar);
        listaMascota.setLayoutManager(new GridLayoutManager(getContext() , 3));
        MascotaAdaptador adaptador = new MascotaAdaptador(listaInfo);
        listaMascota.setAdapter(adaptador);

        return v;
    }

}
