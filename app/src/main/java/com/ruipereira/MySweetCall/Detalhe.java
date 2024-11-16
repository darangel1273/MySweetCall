package com.ruipereira.MySweetCall;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.MarkerOptions;
import com.ruipereira.MySweetCall.classesPerifericas.Contacto;
import com.ruipereira.MySweetCall.classesPerifericas.DBHelper;
import com.ruipereira.mysweetcall.R;
import com.ruipereira.mysweetcall.databinding.ActivityMapaBinding;

public class Detalhe extends AppCompatActivity {  MapaGoogle mapa ; static Contacto co; //Tentar de alguma forma, passar o "co" para o mapa...
    Bundle b; Intent este_i, tel; ViewHolder vh = new ViewHolder() ; MediaPlayer clk;  DBHelper db;
    private static class ViewHolder{ Button bt_v,bt_l; ImageView iv_foto ;
        TextView tv_det_ida,tv_det_n,tv_det_a,tv_det_m,tv_det_t,tv_det_la,tv_det_lo,tv_det_e, tv_det_nasc; }
    /**
     * Ligação enter o Formulário xml (desta Activity) ao ViewHolder
     * @see         ViewHolder
     */
    public void associaFormAoViewHolder(){
        vh.tv_det_n = findViewById(R.id.et_det_nome ) ;   vh.tv_det_a = findViewById(R.id.et_det_apelido ) ;
        vh.tv_det_m = findViewById(R.id.et_det_morada ) ; vh.tv_det_la = findViewById(R.id.et_det_latitude ) ;
        vh.tv_det_lo = findViewById(R.id.et_det_longitude);vh.tv_det_t = findViewById(R.id.et_det_telemovel ) ;
        vh.tv_det_e = findViewById(R.id.et_det_email ) ;  vh.tv_det_nasc = findViewById( R.id.et_det_nasc ) ;
        vh.tv_det_ida = findViewById( R.id.tv_det_idade );vh.iv_foto = findViewById( R.id.iv_det_foto ) ;
        vh.bt_v = findViewById(R.id.bt_voltar) ;          vh.bt_l = findViewById(R.id.bt_ligar) ;
    }
    /**
     *    Carrega o que vinha da MainActivity para o detalhe
     */
    public void loadToForm(){
        vh.tv_det_n.setText( b.getString("nome") ); vh.tv_det_a.setText( b.getString("apelido") );
        vh.tv_det_m.setText( b.getString("morada") );
        vh.tv_det_nasc.setText( b.getString("nascimento"));
        vh.tv_det_ida.setText( String.valueOf( b.getInt("idade")  ) );
        vh.tv_det_la.setText( String.valueOf( b.getDouble("latitude")  ) );
        vh.tv_det_lo.setText( String.valueOf( b.getDouble("longitude") ) );
        vh.tv_det_t.setText(b.getString("telemovel" ) ); vh.tv_det_e.setText( b.getString("email") );
    }
    /**
     * Criar contacto com ou sem foto, se tiver foto na BD
     * manda para o form, se não tiver, esconde a imageView do form.
     * @param
     */
    public void criarDetalheContacto() {
        db = new DBHelper(this);
        co = new Contacto(b.getInt("id"), b.getString("nome"), b.getString("apelido"), b.getString("morada"), b.getString("nascimento"), b.getDouble("latitude"), b.getDouble("longitude"), b.getString("telemovel"), b.getString("email"));
        if ( db.fotoExisteNaBD( co.getId() ) ) {  //Vê se aquele registo id, tem foto correspondente.
            vh.iv_foto.setImageBitmap( db.selectBitmap( co.getId() ) )  ;   //ImageView no form converte de bmp para ImageView?
            co.setFoto( db.selectBitmap( co.getId() ) );     //ImageView no objecto. converte de bmp para ImageView?
            vh.iv_foto.setVisibility(View.VISIBLE );
        }else vh.iv_foto.setVisibility(View.GONE );
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( com.ruipereira.mysweetcall.R.layout.activity_detalhe);   //Caminho completo, pois deu erro de 'linkagem'
        clk = MediaPlayer.create( Detalhe.this , R.raw.click );     //cria o som do click.
        este_i = getIntent() ;
        b = este_i.getExtras() ;
        associaFormAoViewHolder();
        loadToForm(); // Carrega o que vinha da MainActivity para o form do detalhe
        criarDetalheContacto();
        //mapa.addMarker( new MarkerOptions().position( co.getEndereco() ).title("Marcador em " + co.getMorada() ));
        //mapa.moveCamera( CameraUpdateFactory.newLatLng( co.getEndereco() ));

        vh.bt_l.setOnClickListener( new android.view.View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clk.start();
                tel = new Intent( Intent.ACTION_DIAL, Uri.parse( "tel:" + vh.tv_det_t.getText().toString() ) );
                startActivity(tel);
            }
        });
        vh.bt_v.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) { clk.start() ; setResult( 1 ) ; finish() ;  }
        });
    }
    private static class MapaGoogle extends FragmentActivity implements OnMapReadyCallback {
        private GoogleMap mMap;
        private ActivityMapaBinding binding;

        public void onMapReady(GoogleMap googleMap) {
            mMap = googleMap;
            binding = ActivityMapaBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());

            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);

            mMap.addMarker( new MarkerOptions().position( co.getEndereco() ).title("Marcador em " + co.getMorada() ));
            mMap.moveCamera( CameraUpdateFactory.newLatLng( co.getEndereco() ));
        }
    }
}