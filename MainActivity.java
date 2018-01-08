package br.com.internet.clovison.internet;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         if(estaConectada(MainActivity.this))
             setContentView(R.layout.activity_main);
         else{
             dialogo(MainActivity.this).show();
         }


        /*if(estaConectada()){
            Log.i("TRUE","Usuário está conectado!");
        }else{
            Log.i("TRUE","Usuário não conectado!");
        }*/
    }

    private  boolean estaConectada(Context context){

            ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo informacao = cm.getActiveNetworkInfo();

            if(informacao!= null && informacao.isConnectedOrConnecting()) {
                NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
                NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

                if (wifi != null && wifi.isConnectedOrConnecting() || mobile != null && mobile.isConnectedOrConnecting())

                    return true;
                else return false;
            }else{
                return false;
            }

    }



    public AlertDialog.Builder dialogo(Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Não há conexão com a Internet.");
        builder.setMessage("Você precisa de Dados Móveis ou Acesso a rede Wifi. Pressione OK para Sair");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        return  builder;
    }
}
