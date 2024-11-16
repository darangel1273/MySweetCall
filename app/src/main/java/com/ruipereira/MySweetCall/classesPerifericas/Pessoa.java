package com.ruipereira.MySweetCall.classesPerifericas;

import android.graphics.Bitmap;
import android.text.Editable;
import android.widget.ImageView;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public abstract class Pessoa {
    private String Nome ;
    private String Apelido ;
    private LocalDate Nascimento ;
    private Period Idade ;
    private ImageView Foto ;

    public Pessoa(){};
    public Pessoa( Editable no, Editable ap, Editable nasc) { setNome( no.toString() ); setApelido( ap.toString() ); setNascimentoSTR( nasc ) ; }
    public Pessoa( String no, String ap , String nasc ) { setNome( no ); setApelido( ap ); setNascimento( nasc) ; }
    public void setNome( String no ) {  Nome = no;  }
    public void setApelido( String ap ) {
        Apelido = ap;
    }
    public void setNomeSTR( Editable nome) {  setNome( nome.toString() ) ;  }
    public void setApelidoSTR( Editable apelido) {
        setApelido( apelido.toString() ) ;
    }
    /**
     * Com a data de nascimento, calcula a Idade
     * @see     #setIdade
     * @param   nasc
     */
    public void setNascimentoSTR( Editable nasc) { setNascimento( nasc.toString() ); setIdade() ; }
    /**
     *  Verifica se a data de nascimento não está vazia e está bem preenchida e formatada,
     *  se não estiver previne a excepção no método a seguir.
     * @see     #setNascimentoSTR( Editable nasc) ,  #setNascimento( String nasc)
     *
     * @param nasc
     * @return boolean
     */
    public boolean DataEVAlida(String nasc) {
        boolean ret  = false;
        if ((nasc != null) && !(nasc.equals("")))
            try {
                Nascimento = LocalDate.parse(nasc, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                setIdade();
                ret = true;
            } catch (Exception e) {
                e.printStackTrace();
                ret = false;
            }
            return ret;
        }
    public void setNascimento( String nasc) {
        if ( DataEVAlida( nasc )  ) {
            Nascimento = LocalDate.parse(nasc, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            setIdade();
        }
    }
    public void setIdade() {
        if ( this.Nascimento != null ) this.Idade = Period.between( this.Nascimento , LocalDate.now() );
    }
    public void setFoto( Bitmap bmp ){   try{ this.Foto.setImageBitmap( bmp ); } catch(NullPointerException npe) { npe.printStackTrace();} }
    public String getNome() { return Nome; }
    public String getApelido() { return Apelido; }
    /**
     *
     * @return anos     Retorna a idade em anos.
     */
    public int getAnos() { int anos = 0;
        if( this.Idade != null )
            anos = Idade.getYears() ;
        return anos;
    }
    public String getAnoSTR() { return String.valueOf( getAnos() ) ; }

    /**
     * @deprecated
     * Não usado
     * @return
     */
    @Deprecated public Period getIdade() { return Idade; }
    public LocalDate getNascimento() { return Nascimento; }
    public ImageView getFoto() {
        return Foto; }
    public String getNascimentoSTR() { return Nascimento.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")); }
}
