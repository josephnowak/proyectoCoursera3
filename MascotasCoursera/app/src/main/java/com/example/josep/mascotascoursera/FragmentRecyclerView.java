package com.example.josep.mascotascoursera;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by josep on 03/12/2017.
 */

public class FragmentRecyclerView extends Fragment
{
    ArrayList<InfoMascota> listaInfo;
    private RecyclerView listaMascota;

    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_recycler_view , container,false);

        listaInfo = new ArrayList<>();
        listaInfo.add(new InfoMascota(R.drawable.mascota1,R.drawable.patamg,R.drawable.pata,"firulais","0",false));
        //listaInfo.add(new InfoMascota(R.drawable.mascota2,R.drawable.patamg,R.drawable.pata,"firulais","0",false));
        listaInfo.add(new InfoMascota(R.drawable.mascota3,R.drawable.patamg,R.drawable.pata,"firulais","0",false));
        listaInfo.add(new InfoMascota(R.drawable.mascota4,R.drawable.patamg,R.drawable.pata,"firulais","0",false));
        listaInfo.add(new InfoMascota(R.drawable.mascota5,R.drawable.patamg,R.drawable.pata,"firulais","0",false));
        listaInfo.add(new InfoMascota(R.drawable.mascota6,R.drawable.patamg,R.drawable.pata,"firulais","0",false));
        listaInfo.add(new InfoMascota(R.drawable.mascota7,R.drawable.patamg,R.drawable.pata,"firulais","0",false));
        listaInfo.add(new InfoMascota(R.drawable.mascota8,R.drawable.patamg,R.drawable.pata,"firulais","0",false));

        listaMascota = (RecyclerView)v.findViewById(R.id.recyMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascota.setLayoutManager(llm);
        MascotaAdaptador adaptador = new MascotaAdaptador(listaInfo);
        listaMascota.setAdapter(adaptador);

       /* final ImageView favoritos = (ImageView)v.findViewById(R.id.fav);
        favoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                favoritos(view);
            }
        });*/
        return v;
    }
    public void favoritos(View view)
    {
        Intent intent = new Intent(getActivity(), MascotasFavoritas.class);
        ArrayList<InfoMascota> aux = new ArrayList<>();
        for(InfoMascota i : listaInfo)
        {
            Log.d("Info",i.getNombre());
            if(i.isA()) aux.add(i);

            if(aux.size() == 5) break;
        }
        intent.putExtra("Favoritos",aux);
        startActivity(intent);

    }
}
