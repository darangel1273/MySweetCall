package com.ruipereira.MySweetCall.classesPerifericas;

import android.text.Editable;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public final class Contacto extends Pessoa{
    private int Id;
    private String Morada;
    private LatLng Endereco;
    private String Telemovel;
    private String Email;

    public Contacto(){ super() ; };
    /**
     * Construtor só com as Strings. (Tirando o id)
     * @param id
     * @param no
     * @param ap
     * @param mo
     * @param lat
     * @param lng
     * @param tel
     * @param em
     */
    public Contacto(int id , String no, String ap, String mo, String nasc, String lat, String lng, String tel, String em) {
        super( no,ap , nasc );
        setId(id);
        setMorada( mo );
        parseEndereco( lat ,lng );
        setTelemovel ( tel );
        setEmail ( em );
    }
    /**
     * Construtor para adaptar o endereço.
     */
    public Contacto(int id , String no, String ap, String mo, String nasc, double lat, double lng, String tel, String em) {
        super( no,ap , nasc );
        setId(id);
        setMorada( mo );
        setEndereco( lat ,lng );
        setTelemovel ( tel );
        setEmail ( em );
    }
    /**
     * Construtor criado para tentar centralizar os #toString() só num sítio.
     * (Não estar sempre a fazer #toString() na mainActivity.)
     */
    public Contacto(int id, Editable no, Editable ap, Editable mo, Editable nasc, Editable lat, Editable lng, Editable tel, Editable em ) {
        super( no , ap , nasc );
        setId( id );
        setMorada( mo.toString() );
        setEnderecoSTR( lat, lng );
        setTelemovel( tel.toString() );
        setEmail( em.toString() );
    }
    /**
     * Método para o adaptador mostrar o Nome o Apelido.
     * @return  #String         As duas (Nome e apelido) concatenadas.
     */
    @Override
    public String toString() {
        return getNome() + " " + getApelido() ;
    }

    //Métodos intermédios para tirar os "toString()" da MainActivity, para não me confundir tanto.
    public void setMoradaSTR(Editable morada) { setMorada( morada.toString() ); }
    public void setTelemovelSTR(Editable telemovel) { setTelemovel(telemovel.toString() );  }
    public void setEmailSTR(Editable email) {
        setEmail(email.toString() );
    }

    //Encapsulamentos propriamente ditos.
    public void setId(int id) { this.Id = id;  }
    public void setMorada(String morada) { Morada = morada; }
    /**
     * Cria um objecto dentro da classe contacto do tipo #LatLng
     * @see
     * @param       lat     latitude.
     * @param       lng     longitude.
     */
    public void parseEndereco(String lat, String lng) { setEndereco( Double.parseDouble( lat ), Double.parseDouble( lng ) ); }
    /**
     *  método intermédio para tirar o toString()
     * @see                 #Contacto
     * @param       lat     latitude.
     * @param       lng     longitude.
     */
    public void setEnderecoSTR( Editable lat, Editable lng ) { parseEndereco(lat.toString() , lng.toString() ) ; }
    public void setEndereco(double lat,double lng) {
        if ( ( validaLatitude( lat ) ) && ( validaLongitude( lng ) ) ) this.Endereco = new LatLng( lat , lng ); }
    //GETTERS (propriamente ditos) do encapsulamento.

    public void setTelemovel(String telemovel) {
        this.Telemovel = telemovel;
    }
    public void setEmail(String email) {
        Email = email;
    }
    /**
     * Não aceita latitudes fora do intervalo normal.
     * @param   lat
     * @return
     */
    private boolean validaLatitude(double lat) {
        boolean ret = false;
        if (lat >= -90 && lat <= 90) ret = true;
        else lat = lat % 90 ; //repõe uma latitude válida , dando o resto da divisão.
        return ret;
    }
    /**
     * Não aceita latitudes fora do intervalo normal.
     * @param       lng
     * @return
     */
    private boolean validaLongitude( double lng) {
        boolean ret = false;
        if ( lng  >= -180 && lng <= 180) ret = true;
        else lng = lng % 180 ; //repõe uma longitude válida , dando o resto  da divisão.
        return ret;
    }
    public int getId() {  return Id;  }
    public String getMorada() { return Morada; }
    public String getLatitudeSTR() { return String.valueOf( Endereco.latitude );  }
    public String getLongitudeSTR() { return String.valueOf( Endereco.longitude ); }
    public double getLatitude() { return Endereco.latitude;  }
    public double getLongitude() {  return Endereco.longitude;  }
    public LatLng getEndereco() { return Endereco; }
    @Deprecated public String EnderecoSTR() { return Endereco.toString();  }
    public String getTelemovel() { return String.valueOf(this.Telemovel); }
    public String getEmail() { return Email;  }
    /**
     * @deprecated
     * Antes servia para carregar dados, mas foi substítuido pela ligação à Base de Dados.
     * @see         DBHelper
     *
     * @return      a       Uma lista de Contactos.
     */
    @Deprecated public static ArrayList<Contacto> addData() {
        ArrayList<Contacto> a = new ArrayList<Contacto>();
        try {
            a.add( new Contacto(1,"nome2", "Ape1", "Mora1", "1973-06-12","39.654341", "-8.5687308", "911791682", "rui.o.pereira@gmail.com"));
            a.add( new Contacto(2,"nome1", "Ape2", "Mora2", "1973-06-12","39.654342", "8.5687307", "249093166", "rui_o_pereira@hotmail.com"));
            a.add( new Contacto(3,"nome4", "Ape3", "Mora3", "1973-06-12","39.6590936", "-8.5786347", "249549540", "ruipereira@aeourem.pt"));
            a.add( new Contacto(4,"nome6", "Ape1", "Mora1", "1973-06-12","39.654341", "8.5687308", "911791682", "rui.o.pereira@gmail.com"));
            a.add( new Contacto(5,"nome8", "Ape2", "Mora2", "1973-06-12","39.654342", "-8.5687307", "249093166", "rui_o_pereira@hotmail.com"));
            a.add( new Contacto(6,"nome10", "Ape3", "Mora3","1973-06-12", "39.6590936", "-8.5786347", "249549540", "ruipereira@aeourem.pt"));
            a.add( new Contacto(7,"nome12", "Ape1", "Mora1","1973-06-12", "-39.654341", "-8.5687308", "911791682", "rui.o.pereira@gmail.com"));
            a.add( new Contacto(8,"nome11", "Ape2", "Mora2","1973-06-12", "39.654342", "-8.5687307", "249093166", "rui_o_pereira@hotmail.com"));
            a.add( new Contacto(9,"nome9", "Ape3", "Mora3", "1973-06-12","-39.6590936", "8.5786347", "249549540", "ruipereira@aeourem.pt"));
            a.add( new Contacto(10,"nome7", "Ape1", "Mora1", "1973-06-12","39.6543411", "-8.5687308", "911791682", "rui.o.pereira@gmail.com"));
            a.add( new Contacto(11,"nome5", "Ape2", "Mora2", "1973-06-12","-39.654342", "-8.5687307", "249093166", "rui_o_pereira@hotmail.com"));
            a.add( new Contacto(12,"nome3", "Ape3", "Mora3", "1973-06-12","39.6590936", "-8.5786347", "249549540", "ruipereira@aeourem.pt"));
        } catch (Exception e) {
            a = null;
            e.printStackTrace();
            //Toast.makeText(com.ruipereira.MySweetCall.MainActivity.class, e.getLocalizedMessage() , Toast.LENGTH_SHORT).show();
        }
        return a;
    }
}
