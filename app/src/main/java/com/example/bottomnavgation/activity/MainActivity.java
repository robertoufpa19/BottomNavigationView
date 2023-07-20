package com.example.bottomnavgation.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.bottomnavgation.R;
import com.example.bottomnavgation.databinding.ActivityMainBinding;
import com.example.bottomnavgation.fragment.AddUsuarioFragment;
import com.example.bottomnavgation.fragment.HomeFragment;
import com.example.bottomnavgation.fragment.PerfilFragment;
import com.example.bottomnavgation.fragment.PesquisaFragment;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
         // inicializar sempre na Home
        abrirFragment(new HomeFragment());


        binding.bottomNavigation.setOnItemSelectedListener(item -> {


            if(item.getItemId() == R.id.home){
                abrirFragment(new HomeFragment());
            }else if(item.getItemId() == R.id.pesquisa){
                abrirFragment(new PesquisaFragment());
            }else if(item.getItemId() == R.id.addUsuario){
                abrirFragment(new AddUsuarioFragment());
            }else if(item.getItemId() == R.id.perfil){
                abrirFragment(new PerfilFragment());
            }



            return  true;
        });

    }


    private void abrirFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.viewPager, fragment);
        fragmentTransaction.commit();
    }



}