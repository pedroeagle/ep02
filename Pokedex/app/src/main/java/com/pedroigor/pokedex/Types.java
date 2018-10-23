package com.pedroigor.pokedex;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Types extends Fragment {
    String [] types;
    public Types() {
        // Required empty public constructor

    }
    public void setTypes(String [] types){
        this.types = types;
    }
    public String [] text= {
            "opa",
            "apenas um teste",
            "se funcionar",
            "o problema",
            "é na requisição da api"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_types, container,false);

        ListView listTypes = (ListView) view.findViewById(R.id.TypesList);
        ArrayAdapter<String> adaptadorTypes = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                text
        ); //construtor do ArrayAdapter

        //Definindo o Adapter que será utilizado:
        listTypes.setAdapter(adaptadorTypes);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Types");
    }
}
