package com.ruipereira.MySweetCall;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.ruipereira.mysweetcall.R;

public class Pin extends AppCompatActivity {
    Intent i_sobre , i_agenda ; MediaPlayer clk; String extraido;
    ActivityResultLauncher<Intent> lancador_sobr, lancador_segue;
    SharedPreferences pp; ActivityResult flag;
    ViewHolder vh = new ViewHolder();

    private static class ViewHolder{
        EditText et_pin; Button bt_ini, bt_sobre, bt_segue, bt_cl_app; TextView tv_est;
    }
    /**
     * Faz a associação dos objectos Gráficos ao Form.
     * Inicialmente esconde os outros botões de acesso: "sobre" e "agenda" e também o estado do pino.
     * @see     ViewHolder
     */
    public void associaFormAoViewHolder(){
        vh.et_pin = findViewById( R.id.et_pin ) ; vh.bt_ini = findViewById( R.id.bt_iniciar ) ;
        vh.bt_sobre = findViewById( R.id.bt_sobre );vh.bt_segue = findViewById( R.id.bt_avancar_agenda ) ;
        vh.tv_est = findViewById( R.id.tv_estado_pin ); vh.bt_cl_app = findViewById( R.id.bt_fechar_app );
        vh.tv_est.setVisibility( View.GONE ); vh.bt_sobre.setVisibility( View.GONE );
        vh.bt_segue.setVisibility( View.GONE );
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);
        associaFormAoViewHolder(); //Faz a associação dos objectos Gráficos ao Form.
        flag = null; //controlo para não ter de iniciar sessão quando voltas outras activitys
        pp = getSharedPreferences(  getString(   R.string.pin  )  , MODE_PRIVATE );//Abre o ficheiro 1234 das Shared preferences
        extraido = pp.getString(  getString( R.string.pin ),"1234");    //Extrai o Pino guardado do ficheiro xml : 1234
        clk = MediaPlayer.create(Pin.this , R.raw.click ); //Cria o som do click
        // iniciar Sessão
        vh.bt_ini.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( extraido.equals( vh.et_pin.getText().toString() )   ||   flag != null ){
                    clk.start();    //Som do click
                    Toast.makeText(Pin.this, "PIN VALIDO:" + extraido, Toast.LENGTH_SHORT).show();
                    vh.bt_sobre.setVisibility(View.VISIBLE); vh.bt_segue.setVisibility(View.VISIBLE);
                    vh.bt_ini.setVisibility(View.GONE); vh.et_pin.setVisibility(View.GONE ); //Esconde o botão iniciar e mostra os outros.
                }else Toast.makeText(Pin.this, "PIN INVALIDO!:" + vh.et_pin.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });
        //botão que abre o "sobre" e o relógio
        vh.bt_sobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clk.start();
                i_sobre = new Intent(Pin.this , Sobre.class);
                lancador_sobr.launch( i_sobre );
            }
        });
        //Botão abre a agenda de contactos (MainActivity)
        vh.bt_segue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clk.start();
                i_agenda = new Intent(Pin.this , MainActivity.class);
                lancador_segue.launch( i_agenda );
            }
        });
        vh.bt_cl_app.setOnClickListener(new View.OnClickListener() {  //Fecha a Applicação.
            @Override
            public void onClick(View v) { //(Bug?) Nem com exit() nem com o finish() Não fecha a Aplicação!?
                clk.start() ; finish() ; System.exit(0); //Não funciona bem.. Só reinicia a App
            }
        });
        //Quando volta da main activity
        lancador_segue = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override //Torna o resultado global, para não estar sempre a iniciar sessão.
            public void onActivityResult(ActivityResult res) {
                flag = res ;
            }
        });
        //Quando volta do Sobre
        lancador_sobr = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult res) { //Recebe o Valor do "sai" da Sobre Activity.
                vh.tv_est.setVisibility( View.GONE ) ; //Se não alterou o pin, não mostra o aviso a vermelho.
                flag = res ; //Torna o resultado global, para não estar sempre a iniciar sessão.
                if( flag.getResultCode() == 2)
                    vh.tv_est.setVisibility( View.VISIBLE ); //Se alterou o pin, avisa a vermelho.
            }
        });
    }
}