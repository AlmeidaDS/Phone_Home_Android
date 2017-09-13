package com.example.root.permissions;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Activity activity = this;
    private String numeros[] = new String[]{"932987645","987234910","936481694"};
    private String[] names = new String[]{"Almeida Santos","Pedro Antonio","Miguel Bamba","Pedro Morgado","Antoino Miguel"};
    private int [] images = new int[]{R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView)findViewById(R.id.lista);
        CustomListAdpater customListAdpater = new CustomListAdpater(this,images,names);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,numeros);
        listView.setAdapter(customListAdpater);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                permissao(numeros[position]);
            }
        });
    }
    public void iniciarChamada(String numero){
     Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + numero));
     try {
         startActivity(intent);
     }catch (SecurityException e){
         Toast.makeText(this, "Não temos permissão suficiente para fazer chamadas",Toast.LENGTH_SHORT).show();

     }

    }
    public void permissao(String numero){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
            iniciarChamada(numero);
        }else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity,Manifest.permission.CALL_PHONE)){
                Toast.makeText(this, "Precisamos de permissão parar fazer chamadas", Toast.LENGTH_SHORT).show();
            }else {
                ActivityCompat.requestPermissions(activity,new String[]{Manifest.permission.CALL_PHONE}, 0);
            }
        }

    }
}
