package com.example.allascopertadibomarzo;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TicketFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TicketFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_home, container, false);
        //button dichiaration card1
        ImageView centroStorico = (ImageView) v.findViewById(R.id.img1);
        TextView nomeCentro = (TextView) v.findViewById(R.id.nomePunto1);

        //method invocation
        centroStorico.setOnClickListener(c -> {
            Intent intent1 = new Intent(v.getContext(), ActivityDuomo.class);
            startActivity(intent1);
        });
        //method invocation
        nomeCentro.setOnClickListener(c -> {
            Intent intent1 = new Intent(v.getContext(), ActivityDuomo.class);
            startActivity(intent1);
        });

        //button dichiaration card2
        ImageView parco = (ImageView) v.findViewById(R.id.img2);
        TextView nomeParco = (TextView) v.findViewById(R.id.nomePunto2);
        TextView orarioParco = (TextView) v.findViewById(R.id.orarioParco);

        //method invocation
            parco.setOnClickListener(q -> {
            Intent polpette = new Intent(v.getContext(), ParcoDeiMostri.class);
            startActivity(polpette);
        });
        //method invocation
        nomeParco.setOnClickListener(c -> {
            Intent intent1 = new Intent(v.getContext(), ParcoDeiMostri.class);
            startActivity(intent1);
        });

        //button dichiaration card3
        ImageView piramide = (ImageView) v.findViewById(R.id.img3);
        TextView nomePiramide = (TextView) v.findViewById(R.id.nomePunto3);
        //TextView esperienzePiramide = (TextView) v.findViewById(R.id.esperienzePiramide);

        //method invocation
        piramide.setOnClickListener(c -> {
            Intent intent1 = new Intent(v.getContext(), ActivityPiramide.class);
            startActivity(intent1);
        });
        //method invocation
        nomePiramide.setOnClickListener(c -> {
            Intent intent1 = new Intent(v.getContext(), ActivityPiramide.class);
            startActivity(intent1);
        });
        //method invocation

            //button dichiaration card4
        ImageView palazzo = (ImageView) v.findViewById(R.id.img4);
        TextView nomePalazzo = (TextView) v.findViewById(R.id.nomePunto4);

        //method invocation
        palazzo.setOnClickListener(c -> {
            Intent intent1 = new Intent(v.getContext(), ActivityOrsini.class);
            startActivity(intent1);
        });
        //method invocation
        nomePalazzo.setOnClickListener(c -> {
            Intent intent1 = new Intent(v.getContext(), ActivityOrsini.class);
            startActivity(intent1);
        });
        return v;
    }
}