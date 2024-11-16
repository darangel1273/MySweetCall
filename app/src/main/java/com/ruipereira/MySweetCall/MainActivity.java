package com.ruipereira.MySweetCall;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.ruipereira.MySweetCall.classesPerifericas.Contacto;
import com.ruipereira.MySweetCall.classesPerifericas.DBHelper;
import com.ruipereira.mysweetcall.R;

import java.util.ArrayList;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {
    Bundle b; Intent i_det,i_mapa; int p; Contacto co ; ViewHolder vh = new ViewHolder();
    ArrayList<Contacto> contactS; ArrayAdapter<Contacto> adapta; MediaPlayer clk;
    ActivityResultLauncher<Intent> lancador_det,lancador_mapa; DBHelper db;

    /**
     *  Inner class que faz a ligação enter os objectos do form e os objectos visuais da classe.
     */
    private static class ViewHolder{
        EditText et_n,et_a,et_m,et_t,et_e,et_la,et_lo,et_nasc; Button bt_in, bt_ed, bt_re, bt_det, bt_map,bt_s_main ;
        ImageButton bt_s_up, bt_s_dow; ListView lv_cont; TextView tv_ida; LinearLayout ll_barra;
    }

    /**
     *     Faz a associação dos objectos Gráficos ao Form.
     */
    private void associaFormAoViewHolder(){
        vh.lv_cont = findViewById( R.id.lstv_contactos );vh.et_n = findViewById( R.id.et_nome ) ;
        vh.et_a = findViewById( R.id.et_apelido ) ;      vh.et_m = findViewById( R.id.et_morada ) ;
        vh.et_la = findViewById( R.id.et_latitude ) ;    vh.et_lo = findViewById( R.id.et_longitude ) ;
        vh.et_t = findViewById( R.id.et_telemovel ) ;    vh.et_e = findViewById( R.id.et_email ) ;
        vh.et_nasc = findViewById( R.id.et_nasc) ;       vh.tv_ida = findViewById( R.id.tv_idade ) ;
        vh.bt_map = findViewById( R.id.bt_mapa ) ;       vh.bt_in = findViewById( R.id.bt_inserir ) ;
        vh.bt_ed = findViewById( R.id.bt_editar ) ;      vh.bt_re = findViewById( R.id.bt_remover ) ;
        vh.bt_det = findViewById( R.id.bt_avancado ) ;   vh.bt_s_main = findViewById( R.id.bt_voltar_main ) ;
        vh.bt_s_up = findViewById( R.id.bt_sort_up);     vh.bt_s_dow = findViewById( R.id.bt_sort_down);
        vh.ll_barra = findViewById( R.id.ll_barraBotoes ) ;
    }

    /**
     * Carrega os dados da listView no item seleccionado (indice"p") para o Form.
     */
    private void loadToForm(){
        vh.et_n.setText( contactS.get(p).getNome() );   //Carrega o objecto Contacto do array de Contactos
        vh.et_a.setText( contactS.get(p).getApelido() );// no índice clicado da ListView
        vh.et_m.setText( contactS.get(p).getMorada() ); // para as caixas de texto em cima.
        vh.et_nasc.setText( contactS.get(p).getNascimentoSTR() );
        vh.et_la.setText( contactS.get(p).getLatitudeSTR()  );
        vh.et_lo.setText( contactS.get(p).getLongitudeSTR() );
        vh.et_t.setText( contactS.get(p).getTelemovel() );
        vh.et_e.setText( contactS.get(p).getEmail() );
        vh.tv_ida.setText( contactS.get(p).getAnoSTR() );
        co = new Contacto();//Validação de data, da 1ªvez a data ficava vermelha (indicio de mal-formatada.)
        co.setNascimento(vh.et_nasc.getText().toString() ) ;
        if( co.DataEVAlida( vh.et_nasc.getText().toString() ) && camposPreenchidos() ) {
            vh.tv_ida.setText( co.getAnoSTR() ); vh.et_nasc.setTextColor( Color.GREEN ) ;
            vh.ll_barra.setVisibility(View.VISIBLE );
        }
        else{ vh.et_nasc.requestFocus() ; vh.et_nasc.setTextColor( Color.RED ) ; vh.ll_barra.setVisibility(View.GONE ) ; }
    }
    /**
     *  Limpa as caixas de texto depois de uma alteração na ListView.
     */
    private void limpaForm(){
        vh.et_n.setText( "" );   vh.et_a.setText( "" );  vh.et_m.setText( "" ); vh.et_t.setText( "" );
        vh.et_e.setText( "" ); vh.et_la.setText(  ""  ); vh.et_lo.setText( ""); vh.et_nasc.setText( "" );
        vh.tv_ida.setText( "" ) ;p =-1;
    }

    /**
     * Valida se os campos do formulário foram validados correctamente.
     * @return
     */
    private boolean camposPreenchidos(){ boolean ret = false; double a,o;
        try{
            if(!( vh.et_n.getText().toString().isEmpty() )   && !( vh.et_a.getText().toString().isEmpty() ) &&
                !( vh.et_m.getText().toString().isEmpty() )  && !( vh.et_t.getText().toString().isEmpty() ) &&
                !( vh.et_m.getText().toString().isEmpty() )  && !( vh.et_e.getText().toString().isEmpty() ) &&
                !( vh.et_la.getText().toString().isEmpty() ) && !( vh.et_lo.getText().toString().isEmpty() ) ) {
                a = Double.parseDouble(vh.et_la.getText().toString() ) ;
                o = Double.parseDouble(vh.et_lo.getText().toString() ) ;
                ret = true ;
            }
        }catch(Exception e){ret = false;}
        finally {return ret;}
    }
    /**
     * Mete todos os atributos do objecto Contacto selecionado no array:"contactS.get(p)"
     * Para dentro de um Bundle "b" (embrulho) de Extras para transitarem para a activity do detalhe.
     * @see         Detalhe
     */
    private void criarBundleDeExtras() {
        b = new Bundle(); //Cria o "embrulho" com "Extras":(chaves e valores) a ser transportado
        b.putInt("id" , contactS.get(p).getId() ); //Para activity do Detalhe.
        b.putString("nome" , contactS.get(p).getNome() );
        b.putString("apelido" , contactS.get(p).getApelido() );
        b.putString("morada" , contactS.get(p).getMorada() );
        b.putString("nascimento" , contactS.get(p).getNascimentoSTR() );
        b.putInt("idade" , contactS.get(p).getAnos() );
        b.putDouble("latitude" , contactS.get(p).getLatitude() );
        b.putDouble("longitude" , contactS.get(p).getLongitude() );
        b.putString("telemovel" , contactS.get(p).getTelemovel() );
        b.putString("email" , contactS.get(p).getEmail() );
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main);

        clk = MediaPlayer.create( MainActivity.this , R.raw.click ) ; //Cria Som do cick nos botões
        associaFormAoViewHolder(); //Faz a associação dos objectos Gráficos ao Form.
        contactS = new ArrayList<Contacto>();
        contactS = Contacto.addData(); //Carrega dados estáticos (antes da Base de dados) (Para tirar depois)
        db = new DBHelper(this); // Abre a base de dados, se ela não existir, cria-a.
        contactS = db.select();  // Carrega da BD, e escreve em cima dos dados estáticos carregados acima.
        //Cria o adaptador de lista para o Array de Contactos.
        adapta = new ArrayAdapter<Contacto>( this, android.R.layout.simple_list_item_1, contactS);
        vh.lv_cont.setAdapter( adapta ); //Ligação da lista ao adaptador
        co = new Contacto();
        if( co.DataEVAlida( vh.et_nasc.getText().toString() ) && camposPreenchidos() ) {
            // Cria um objecto Contacto com os dados que estão nas caixas de texto.
            contactS.add(co); //Adiciona o contacto "co" ao Array dos Contactos.
            adapta.notifyDataSetChanged(); //"refresca" a listView com as alterações no array.
            db.insertSQLite(co); //Insere o contato "co" novo na tabela de contactos na base de dados.
            limpaForm(); //Limpa as caixas de texto e põe um índice do array a -1.
        } else { vh.ll_barra.setVisibility(View.GONE ) ; Toast.makeText(MainActivity.this, "Campos INVÁLDOS", Toast.LENGTH_SHORT).show(); }

        vh.et_nasc.addTextChangedListener( new TextWatcher() {//Valida a formatação correcta da data
            @Override
            public void beforeTextChanged( CharSequence s, int start, int count, int after ) { }
            @Override
            public void onTextChanged( CharSequence s, int start, int before, int count ) { }
            @Override
            public void afterTextChanged( Editable s) { co = new Contacto();
                co.setNascimento( vh.et_nasc.getText().toString() ) ;
                if( co.DataEVAlida( vh.et_nasc.getText().toString() ) && camposPreenchidos() ) {
                    vh.tv_ida.setText( co.getAnoSTR() ); vh.et_nasc.setTextColor( Color.GREEN ) ;
                    vh.ll_barra.setVisibility( View.VISIBLE );
                }
                else{ vh.et_nasc.requestFocus() ; vh.et_nasc.setTextColor( Color.RED ) ; vh.ll_barra.setVisibility(View.GONE ) ; }
            }
        });
        // Buscar a posição seleccionada no array e o registo da lista para as caixas de texto no form.
        vh.lv_cont.setOnItemClickListener((parent, view, position, id) -> {
            p = position ;  //posição (índice) da lista da ArrayList ContactS, fica global.
            loadToForm();   //Carrega da ListView para as caixas de texto do Form.
        });
        // Inserir um contacto novo das caixas de texto  para a lista e para a base de dados.
        vh.bt_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clk.start(); //Som do click
                co = new Contacto() ; //Objecto meramente criado só para validar a data primeiro
                if( co.DataEVAlida( vh.et_nasc.getText().toString() ) && camposPreenchidos() ) {
                    // Cria um objecto Contacto com os dados que estão nas caixas de texto.
                    co = new Contacto(db.buscarMaiorId() + 1, vh.et_n.getText(), vh.et_a.getText(),
                            vh.et_m.getText(), vh.et_nasc.getText(), vh.et_la.getText(), vh.et_lo.getText(), vh.et_t.getText(), vh.et_e.getText());
                    contactS.add(co); //Adiciona o contacto "co" ao Array dos Contactos.
                    adapta.notifyDataSetChanged(); //"refresca" a listView com as alterações no array.
                    db.insertSQLite(co); //Insere o contato "co" novo na tabela de contactos na base de dados.
                    limpaForm(); //Limpa as caixas de texto e põe um índice do array a -1.
                } else Toast.makeText(MainActivity.this, "Campos INVÁLDOS", Toast.LENGTH_LONG).show();
            }
        });
         // Actualizar um contacto alterado para a lista e para a base de dados.
        vh.bt_ed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { clk.start(); //Som do click
                co = contactS.get(p) ; // cria um objecto, só para testar a data de nascimento;
                if(p >= 0 && p < contactS.size() ){ //Previne "ArraIndexOutOfBoundsException" (indice fora dos limites do Array)
                    if( co.DataEVAlida( vh.et_nasc.getText().toString() ) && camposPreenchidos() ) {
                        contactS.get(p).setNomeSTR( vh.et_n.getText() );   // Altera cada uma das propriedades
                        contactS.get(p).setApelidoSTR( vh.et_a.getText() );// (por encapsulamento)
                        contactS.get(p).setMoradaSTR( vh.et_m.getText() ); // do objecto Contacto naquele indice "p"
                        contactS.get(p).setMoradaSTR( vh.et_m.getText() ); // do array ContactS
                        contactS.get(p).setNascimentoSTR( vh.et_nasc.getText() );
                        contactS.get(p).setEnderecoSTR( vh.et_la.getText() , vh.et_lo.getText() );
                        contactS.get(p).setTelemovelSTR( vh.et_t.getText() );
                        contactS.get(p).setEmailSTR( vh.et_e.getText() );
                        contactS.set( p , contactS.get(p) );  // redundante....?
                        db.updateSQLite(  contactS.get(p) );  // Altera o registo na Base de Dados naquele id (apesar de oculto)
                        adapta.notifyDataSetChanged(); //Actualiza o adaptador (com o contacto alterado) que se repercute na ListView.
                        limpaForm(); //Limpa as caixas de texto e define o indice a -1.
                    } else Toast.makeText(MainActivity.this, "Campos INVÁLDOS", Toast.LENGTH_LONG ).show();
                }
            }
        });
        // alterar logo a idade depois de mudar a data nasc
        // vh.et_nasc.addTextChangedListener(new View.OnClickListener();

        // Apaga o contacto na lista e na Base de dados.
        vh.bt_re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clk.start(); //som do click
                if( co.DataEVAlida( vh.et_nasc.getText().toString() ) && camposPreenchidos() ) {
                    db.deleteSQLite(contactS.get(p)); //Apaga o registo selecionado (indice "p") na BD.
                    contactS.remove(p); // Remove o item selecionado do Array: ContactS
                    adapta.notifyDataSetChanged(); //actualiza a ListView culo Array tem agora uma contacto a menos.
                    limpaForm(); //Limpa as caixas de texto e índice é reposto a -1 (antes de uma nova selecção)
                } else Toast.makeText(MainActivity.this, "Campos INVÁLDOS", Toast.LENGTH_SHORT).show();
            }
        });
        // Passa o contacto para a detalhe Activity.
        vh.bt_det.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clk.start(); // Som do Click
                i_det = new Intent(MainActivity.this , Detalhe.class) ;
                criarBundleDeExtras();
                i_det.putExtras( b ); //Anexa o embrulho a transitar para o detalhe.
                lancador_det.launch( i_det ); //Lançador do Detalhe
            }
        });
        // Abre a activity do mapa com as coordenadas nas 2 caixas de texto e a morada.
        vh.bt_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clk.start();
                b = new Bundle();//Cria o embrulho a transitar para a activity do Mapa.
                b.putDouble( "latitude" ,  Double.parseDouble( vh.et_la.getText().toString() ) );
                b.putDouble( "longitude" , Double.parseDouble( vh.et_lo.getText().toString() ) );
                b.putString( "morada" , contactS.get(p).getMorada() );
                i_mapa = new Intent(MainActivity.this , Mapa.class ) ;
                i_mapa.putExtras(b); //Anexa o embrulho com a localização geográfica e a morada.
                lancador_mapa.launch(i_mapa); //Lançador do Mapa.
            }
        });
        //Ordena a lista por ordem crescente.
        vh.bt_s_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clk.start();
                contactS.sort(new Comparator<Contacto>() { //Algoritmo de ordenação.
                    @Override
                    public int compare(Contacto c1, Contacto c2) {
                        return c1.getNome().compareTo(c2.getNome()); //Relação para a Ordem Ascendente
                    }
                });
               adapta.notifyDataSetChanged(); //Ordena também a listView
            }
        });
        //Ordena a lista por ordem decrescente.
        vh.bt_s_dow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clk.start();
                contactS.sort(new Comparator<Contacto>() {
                    @Override
                    public int compare(Contacto c1, Contacto c2) { //Passar ao "sort", a regra de ordenção.
                        return c2.getNome().compareTo(c1.getNome()); //Relação para a Ordem Descendente
                    }
                });
                adapta.notifyDataSetChanged(); //"Refesca" a ordenação, também a listView do maior para o mais pequeno.
            }
        });
        // Fecha esta MainActivity e volta para a Pin Activity.
        vh.bt_s_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {  clk.start(); setResult(3); finish();  }
        });
        lancador_det = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                //Passa aqui quando volta do detalhe.
            }
        });
        lancador_mapa = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                //Passa aqui quando volta do mapa.
            }
        });
    }
}