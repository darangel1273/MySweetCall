package com.ruipereira.MySweetCall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.BatteryManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ruipereira.mysweetcall.R;

import java.util.Calendar;
import java.util.Locale;

public class Sobre extends AppCompatActivity {
    MediaPlayer clk; SharedPreferences pp; SharedPreferences.Editor edit; int sai ;//retorno do "Sobre" acerca do pin alterado.
    String str_HM, str_seg, pinExtraido; boolean verBat = true, execParou = false;
    private Runnable exec; private final Handler ctrl = new Handler(); //necessários para o relógio correr segundo-a-segundo.
    private final ViewHolder vh = new ViewHolder();
    private static class ViewHolder {
        ImageView img_hide, img_show; LinearLayout ll_rodape; CheckBox chk_nBat;
        TextView tv_nBat, tv_descr, tv_author, tv_ava, tv_HM, tv_seg;
        EditText et_ch_pin, et_ch_pin2;
        Button bt_v, bt_ch_pin;
    }
    /**
     *  Recebe um Sinal do SO (android)
     */
    private final BroadcastReceiver recebe = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int nivel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            vh.tv_nBat.setText(String.valueOf(nivel).concat("% "));
        }
    };
    /**
     * Faz a associação dos objectos gráficos à InnerClass ViewHolder
     * @see     ViewHolder
     */
     public void associaFormAoViewHolder(){
         vh.bt_v =      findViewById(R.id.bt_voltar_sobre); vh.tv_HM = findViewById(R.id.tv_horasMinutos);
         vh.tv_seg =    findViewById(R.id.tv_segundos);  vh.tv_descr = findViewById(R.id.tv_descricao);
         vh.tv_author = findViewById(R.id.tv_author); vh.tv_ava = findViewById(R.id.tv_avaliacao);
         vh.ll_rodape = findViewById(R.id.linearLay); vh.img_hide = findViewById(R.id.img_hide_down);
         vh.img_show =  findViewById(R.id.img_show_up); vh.tv_ava =findViewById(R.id.tv_avaliacao);
         vh.tv_nBat =   findViewById(R.id.tv_nivelBat); vh.chk_nBat = findViewById(R.id.cb_nivelBat);
         vh.bt_ch_pin = findViewById(R.id.bt_mudar_pino); vh.et_ch_pin = findViewById(R.id.et_ch_pin);
         vh.et_ch_pin2 =findViewById(R.id.et_ch_pin2); vh.img_show.setVisibility( View.GONE );
     }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_sobre );
        associaFormAoViewHolder() ; //faz os "findViewByid"
        //Animação inicial do Rodapé
        vh.ll_rodape.animate().translationY( vh.ll_rodape.getMeasuredHeight() ).setDuration(getResources().getInteger( android.R.integer.config_longAnimTime ));
        vh.chk_nBat.setChecked( true );
        clk = MediaPlayer.create(Sobre.this , R.raw.click) ; //Cria o Som do Click
        getWindow().addFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN );
        registerReceiver( recebe , new IntentFilter( Intent.ACTION_BATTERY_CHANGED ) ); //tipo de sinal do android
        //Altera e guarda o pin depois da validação de serem iguais nas 2 caixas e de ser diferente ao que está definido.
        vh.bt_ch_pin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clk.start(); sai = 0;
                pp = getSharedPreferences(  getString(   R.string.pin  )  , MODE_PRIVATE );//Abre o ficheiro 1234 das Shared preferences
                if( vh.et_ch_pin.getText().toString().equals(vh.et_ch_pin2.getText().toString() ) ) {
                    if (!(vh.et_ch_pin.getText().toString().equals(""))) {
                        pinExtraido = pp.getString(getString(R.string.pin), "1234");//Extrai o Pino guardado do ficheiro xml : 1234
                        if (!(pinExtraido.equals(vh.et_ch_pin.getText().toString()))) { //Certifica-se que o pin não pode ser o mesmo já gravado.
                            edit = pp.edit(); //Abre o editor das "SharedPreferences"
                            edit.putString(getString(R.string.pin), vh.et_ch_pin.getText().toString()); //Escreve o novo pin no ficheiro: 1234
                            edit.apply(); //Guarda e fechas as alterações ao ficheiro xml: "1234".
                            Toast.makeText(Sobre.this, "PIN ALTERADO!:" + vh.et_ch_pin.getText().toString(), Toast.LENGTH_LONG).show();
                            sai = 2; //Para avisar a activity anterior que o pin foi alterado.
                        } else Toast.makeText(Sobre.this, "ESSE PIN JÁ FOI USADO!", Toast.LENGTH_LONG).show();
                    } else Toast.makeText(Sobre.this, "ERRO!! OS PINS ESTÃO VAZIOS! " + vh.et_ch_pin.getText().toString().concat("0 != 0").concat(vh.et_ch_pin2.getText().toString()), Toast.LENGTH_LONG).show();
                } else Toast.makeText(Sobre.this, "ERRO!! OS PINS DEVEM CORRESPONDER! " + vh.et_ch_pin.getText().toString().concat(" != ").concat(vh.et_ch_pin2.getText().toString()), Toast.LENGTH_LONG).show();
            }
        });
        //CheckBox do nível da Bateria
        vh.chk_nBat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (verBat) { verBat = false ; vh.tv_nBat.setVisibility( View.GONE ); }
                else{ verBat = true ; vh.tv_nBat.setVisibility( View.VISIBLE );}
            }
        });
        //Volta para a activity do Pino.
        vh.bt_v.setOnClickListener( new android.view.View.OnClickListener() {
            @Override //FECHA TUDO e volta à pin activity com o "sai" a dizer se alterou ou não; o pin.
            public void onClick(View v) { clk.start(); setResult(sai); finish();  }
        });
        //Esconde a barra das opções avançadas.
        vh.img_hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {    //Desce o rodapé até desaparecer, e troca os botões.
                vh.ll_rodape.animate().translationY( vh.ll_rodape.getMeasuredHeight() ).setDuration(  getResources().getInteger( android.R.integer.config_longAnimTime ) ) ;
                vh.img_show.setVisibility(View.VISIBLE );
                vh.img_hide.setVisibility(View.GONE );
            }
        });
        //Mostra a barra das opções avançadas.
        vh.img_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Sobe o rodapé até aparecer e para na posição inicial.
                vh.img_show.setVisibility( View.GONE );
                vh.ll_rodape.setVisibility( View.VISIBLE );
                vh.img_hide.setVisibility( View.VISIBLE );
                vh.ll_rodape.animate().translationY( vh.ll_rodape.getMeasuredHeight() - 575 ).setDuration(  getResources().getInteger( android.R.integer.config_longAnimTime ) ) ;
            }
        });
    }
    @Override
    protected void onStop() {
        execParou = true; //Pára o relógio, porque a activity foi "Minimizada" ou "Parada"
        super.onStop();
    }
    @Override
    protected void onResume() {
        super.onResume();
        execParou = false; //Retoma o relógio, porque a activity foi "restaurada" e voltou para o écrãn.
        actualizarHora();
    }
    /**
     * Relógio a correr de segundo-a-segundo e actualiza o ecrã instântaneamente.
     */
    private void actualizarHora() {
        exec = new Runnable() {
        @Override
        public void run() {
            if (!execParou) {
                long momentum, prox;
                Calendar c = Calendar.getInstance();
                c.setTimeInMillis(System.currentTimeMillis());
                str_HM = String.format( new Locale("pt_PT"), "%02d:%02d", c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE));
                str_seg = String.format( new Locale("pt_PT"), "%02d", c.get(Calendar.SECOND));
                vh.tv_HM.setText(str_HM);   //String formatada para as caixas.
                vh.tv_seg.setText(str_seg); // igual para os segundos. (caixa mais pequena)
                momentum = SystemClock.uptimeMillis();  //momentum - Relógio do sistema em milisegundos.
                prox = momentum + ( 1000 - ( momentum % 1000 )); //calcula o que falta até ao próximo "momentum"
                ctrl.postAtTime(exec, prox);
                }
            }
       };
       exec.run();
    }
}