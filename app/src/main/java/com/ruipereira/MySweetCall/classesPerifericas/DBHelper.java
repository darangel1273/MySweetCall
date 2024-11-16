package com.ruipereira.MySweetCall.classesPerifericas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

/**
 *          #sqlTXT1    Não Funciona!! (Só no computador)
 * @see     #sqlTXT2
 */
public class DBHelper extends SQLiteOpenHelper {
    private static String nomeDB = new String("contactoDB.db");//O ficheiro da BD está no diretório-raíz do projecto.
    private static int versao = 1; private SQLiteDatabase db; // Pode não ser necessário copiar a BD, julgo que se não existir, ele a cria automáticamente.
//BUG!! Não funciona ( Caminho do SO com backSlash, só no computador ) (com SQL convencional)
    String[]  sqlTXT1 = {"BEGIN TRANSACTION;",
            "CREATE TABLE IF NOT EXISTS contacto (id REAL NOT NULL PRIMARY KEY, nome TEXT NOT NULL, apelido TEXT NOT NULL,morada TEXT NOT NULL,nascimento TXT, latitude REAL NOT NULL, longitude	REAL NOT NULL, telemovel TEXT NOT NULL, email TEXT NOT NULL, foto BLOB  );" ,
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (1,'Rui','Pereira','Pinheiro',date('1973-06-12'),39.654342,8.5687307,'911791682',' rui.o.pereira@gmail.com','C:\\Users\\Utilizador\\AndroidStudioProjects\\MySweetCall\\app\\src\\main\\res\\drawable\\a1.jpg');",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (2,'Ivo','Lourenço','Pinheiro',date('1974-06-12'),39.654342,8.5687307,'911791682',' rui.o.pereira@gmail.com','C:\\Users\\Utilizador\\AndroidStudioProjects\\MySweetCall\\app\\src\\main\\res\\drawable\\a2.jpg');",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (3,'António','Vicente','Pinheiro',date('1975-06-12'),39.654342,8.5687307,'911791682',' rui.o.pereira@gmail.com','C:\\Users\\Utilizador\\AndroidStudioProjects\\MySweetCall\\app\\src\\main\\res\\drawable\\a3.jpg');",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (4,'Ana','Santos','Pinheiro',date('1976-06-12'),39.654342,8.5687307,'911791682',' rui.o.pereira@gmail.com','C:\\Users\\Utilizador\\AndroidStudioProjects\\MySweetCall\\app\\src\\main\\res\\drawable\\a4.jpg');",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (5,'Bárbara','Gonçalves','Pinheiro',date('1977-06-12'),39.654342,8.5687307,'911791682',' rui.o.pereira@gmail.com','C:\\Users\\Utilizador\\AndroidStudioProjects\\MySweetCall\\app\\src\\main\\res\\drawable\\a5.jpg');",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (6,'Nuno','Pereira','Pinheiro',date('1978-06-12'),39.654342,8.5687307,'911791682',' rui.o.pereira@gmail.com','C:\\Users\\Utilizador\\AndroidStudioProjects\\MySweetCall\\app\\src\\main\\res\\drawable\\a6.jpg');",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (7,'Nelson','Baptista','Pinheiro',date('1979-06-12'),39.654342,8.5687307,'911791682',' rui.o.pereira@gmail.com','C:\\Users\\Utilizador\\AndroidStudioProjects\\MySweetCall\\app\\src\\main\\res\\drawable\\a7.jpg');",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (8,'Carlos','Pinto','Pinheiro',date('1972-06-12'),39.654342,8.5687307,'911791682',' rui.o.pereira@gmail.com','C:\\Users\\Utilizador\\AndroidStudioProjects\\MySweetCall\\app\\src\\main\\res\\drawable\\a8.jpg');",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (9,'Carla','Gameiro','Pinheiro',date('1971-06-12'),39.654342,8.5687307,'911791682',' rui.o.pereira@gmail.com','C:\\Users\\Utilizador\\AndroidStudioProjects\\MySweetCall\\app\\src\\main\\res\\drawable\\a9.jpg');",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (10,'Luís','António','Pinheiro',date('1983-06-12'),39.654342,8.5687307,'911791682',' rui.o.pereira@gmail.com','C:\\Users\\Utilizador\\AndroidStudioProjects\\MySweetCall\\app\\src\\main\\res\\drawable\\a10.jpg');",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (11,'João','Pastor','Pinheiro',date('1984-06-12'),39.654342,8.5687307,'911791682',' rui.o.pereira@gmail.com','C:\\Users\\Utilizador\\AndroidStudioProjects\\MySweetCall\\app\\src\\main\\res\\drawable\\a11.jpg');",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (12,'Lurdes','Vieira','Pinheiro',date('1985-06-12'),39.654342,8.5687307,'911791682',' rui.o.pereira@gmail.com','C:\\Users\\Utilizador\\AndroidStudioProjects\\MySweetCall\\app\\src\\main\\res\\drawable\\a12.jpg');",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (13,'Vasco','Portas','Pinheiro',date('1986-06-12'),39.654342,8.5687307,'911791682',' rui.o.pereira@gmail.com','C:\\Users\\Utilizador\\AndroidStudioProjects\\MySweetCall\\app\\src\\main\\res\\drawable\\a13.jpg');",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (14,'Artur','Pinto','Pinheiro',date('1987-06-12'),39.654342,8.5687307,'911791682',' rui.o.pereira@gmail.com','C:\\Users\\Utilizador\\AndroidStudioProjects\\MySweetCall\\app\\src\\main\\res\\drawable\\a14.jpg');",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (15,'Diogo','Valente','Pinheiro',date('1988-06-12'),39.654342,8.5687307,'911791682',' rui.o.pereira@gmail.com','C:\\Users\\Utilizador\\AndroidStudioProjects\\MySweetCall\\app\\src\\main\\res\\drawable\\a15.jpg');",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (16,'Diego','Piedade','Pinheiro',date('1989-06-12'),39.654342,8.5687307,'911791682',' rui.o.pereira@gmail.com','C:\\Users\\Utilizador\\AndroidStudioProjects\\MySweetCall\\app\\src\\main\\res\\drawable\\a1.jpg');",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (17,'Humberto','Castor','Pinheiro',date('1990-06-12'),39.654342,8.5687307,'911791682',' rui.o.pereira@gmail.com','C:\\Users\\Utilizador\\AndroidStudioProjects\\MySweetCall\\app\\src\\main\\res\\drawable\\a2.jpg');",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (18,'Manuel','Pereira','Pinheiro',date('1991-06-12'),39.654342,8.5687307,'911791682',' rui.o.pereira@gmail.com','C:\\Users\\Utilizador\\AndroidStudioProjects\\MySweetCall\\app\\src\\main\\res\\drawable\\a3.jpg');",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (19,'Celeste','Oliveira','Pinheiro',date('1992-06-12'),39.654342,8.5687307,'911791682',' rui.o.pereira@gmail.com','C:\\Users\\Utilizador\\AndroidStudioProjects\\MySweetCall\\app\\src\\main\\res\\drawable\\a4.jpg');",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (20,'Luísa','Bicha','Pinheiro',date('1993-06-02'),39.654342,8.5687307,'911791682',' rui.o.pereira@gmail.com','C:\\Users\\Utilizador\\AndroidStudioProjects\\MySweetCall\\app\\src\\main\\res\\drawable\\a5.jpg');",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (21,'Paula','Pereira','Pinheiro',date('1994-11-21'),39.654342,8.5687307,'911791682',' rui.o.pereira@gmail.com','C:\\Users\\Utilizador\\AndroidStudioProjects\\MySweetCall\\app\\src\\main\\res\\drawable\\a6.jpg');",
            "COMMIT;",
    }; //Inserção de registos com BLOBs na Base de dados, ( com SQL convencional ) mas as "imagens" têm de estar na pasta "drawable" (Pouco realista, mas serve como exemplo, apenas para minha aprendizagem.)
    String[]  sqlTXT2 = {"BEGIN TRANSACTION;",
            "CREATE TABLE IF NOT EXISTS contacto (id REAL NOT NULL PRIMARY KEY, nome TEXT NOT NULL, apelido TEXT NOT NULL,morada TEXT NOT NULL,nascimento TXT, latitude REAL NOT NULL, longitude	REAL NOT NULL, telemovel TEXT NOT NULL, email TEXT NOT NULL, foto BLOB  );" ,
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (1,'Rui','Pereira','Pinheiro',date('1973-06-12'),39.654342,-8.5687307,'911791682',' rui.o.pereira@gmail.com','R.drawable.a1');",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (2,'Ivo','Lourenço','Pinheiro',date('1974-06-12'),39.654342,-8.5687307,'911791682',' rui.o.pereira@gmail.com','R.drawable.a2');",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (3,'António','Vicente','Pinheiro',date('1975-06-12'),-39.654342,-8.5687307,'911791682',' rui.o.pereira@gmail.com', 'R.drawable.a3' );",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (4,'Ana','Santos','Pinheiro',date('1976-06-12'),-39.654342,-8.5687307,'911791682',' rui.o.pereira@gmail.com', 'R.drawable.a4');",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (5,'Bárbara','Gonçalves','Pinheiro',date('1977-06-12'),-39.654342,8.5687307,'911791682',' rui.o.pereira@gmail.com', 'R.drawable.a5' );",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (6,'Nuno','Pereira','Pinheiro',date('1978-06-12'),39.654342,-8.5687307,'911791682',' rui.o.pereira@gmail.com', 'R.drawable.a6' );",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (7,'Nelson','Baptista','Pinheiro',date('1979-06-12'),39.654342,-8.5687307,'911791682',' rui.o.pereira@gmail.com', 'R.drawable.a7');",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (8,'Carlos','Pinto','Pinheiro',date('1972-06-12'),39.654342,-8.5687307,'911791682',' rui.o.pereira@gmail.com', 'R.drawable.a8' );",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (9,'Carla','Gameiro','Pinheiro',date('1971-06-12'),39.654342,-8.5687307,'911791682',' rui.o.pereira@gmail.com', 'R.drawable.a9' );",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (10,'Luís','António','Pinheiro',date('1983-06-12'),39.654342,-8.5687307,'911791682',' rui.o.pereira@gmail.com', 'R.drawable.a10' );",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (11,'João','Pastor','Pinheiro',date('1984-06-12'),-39.654342,-8.5687307,'911791682',' rui.o.pereira@gmail.com', 'R.drawable.a11');",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (12,'Lurdes','Vieira','Pinheiro',date('1985-06-12'),39.654342,-8.5687307,'911791682',' rui.o.pereira@gmail.com', 'R.drawable.a12' );",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (13,'Vasco','Portas','Pinheiro',date('1986-06-12'),39.654342,-8.5687307,'911791682',' rui.o.pereira@gmail.com', 'R.drawable.a13' );",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (14,'Artur','Pinto','Pinheiro',date('1987-06-12'),39.654342,-8.5687307,'911791682',' rui.o.pereira@gmail.com', 'R.drawable.a14' );",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (15,'Diogo','Valente','Pinheiro',date('1988-06-12'),39.654342,-8.5687307,'911791682',' rui.o.pereira@gmail.com','R.drawable.a15' );",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (16,'Diego','Piedade','Pinheiro',date('1989-06-12'),39.654342,-8.5687307,'911791682',' rui.o.pereira@gmail.com', 'R.drawable.a16' );",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (17,'Humberto','Castor','Pinheiro',date('1990-06-12'),39.654342,-8.5687307,'911791682',' rui.o.pereira@gmail.com', 'R.drawable.telefoneantigo' );",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (18,'Manuel','Pereira','Pinheiro',date('1991-06-12'),-39.654342,-8.5687307,'911791682',' rui.o.pereira@gmail.com', 'R.drawable.a1' );",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (19,'Celeste','Oliveira','Pinheiro',date('1992-06-12'),39.654342,-8.5687307,'911791682',' rui.o.pereira@gmail.com', 'R.drawable.a2' );",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (20,'Luísa','Bicha','Pinheiro',date('1993-06-02'),-39.654342,-8.5687307,'911791682',' rui.o.pereira@gmail.com', 'R.drawable.a3' );",
            "INSERT INTO 'contacto' ('id', 'nome','apelido','morada','nascimento','latitude','longitude','telemovel','email','foto' ) VALUES (21,'Paula','Pereira','Pinheiro',date('1994-11-21'),39.654342,-8.5687307,'911791682',' rui.o.pereira@gmail.com', 'R.drawable.a4' );",
            "COMMIT;",
    };
    public DBHelper(@Nullable Context context) { super(context, nomeDB, null, versao);  }

    /**
     * @see         #sqlTXT1
     * Criação da Tabela de contactos e de registos por SQL normal, numa transacção;
     * @param       db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        for (String s : sqlTXT2) { db.execSQL(s); }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        versao++;
        db.execSQL("DROP TABLE IF EXISTS contacto;");
        onCreate(db);
    }

    /**
     *  O id na Base de dados é para substituir o AUTO_INCREMENT.
     * Serve para criar uma chave nova para o INSERT
     * Implentado para substituir o AUTO_INCREMENT na PRIMARY KEY('id') da base de dados.
     * @see     #insertSQLite( Contacto o )
     * @return  #int     O maior id que encontrou na Base de dados.
     */
    public int buscarMaiorId(){
        db = getReadableDatabase() ; Cursor c;
        c = db.rawQuery("SELECT MAX(id) FROM contacto;", null);
        c.moveToFirst() ;
        return c.getInt(0) ;
    }

    /**
     * Verifica se a foto daquele id, existe na dase de dados.
     * @param id
     * @return byte[]       mapa binário da imagem
     */
    public Boolean fotoExisteNaBD(int id ){
        db = getReadableDatabase() ; Cursor c; Boolean ret = false;
        c = db.rawQuery(" SELECT COUNT(foto) FROM contacto WHERE id = ? ; ", new String[]{ String.valueOf( id ) } );
        c.moveToFirst() ;
        if( c.getCount() > 0 ) {
            if ( c.getInt(0) > 0 ) ret = true;
        }
        return ret ;
    }

    /**
     * Vai buscar a foto à base de dados
     * @param id
     * @return byte[]       mapa binário da imagem
     */
    public Bitmap selectBitmap( int id ){
        Cursor c;  byte[] bytes; ByteArrayInputStream codImagem ;
        db = getReadableDatabase() ;
        c = db.rawQuery("SELECT foto FROM contacto WHERE id = ? ;", new String[]{ String.valueOf( id ) } );
        if( c.getCount() > 0 ) {
            c.moveToFirst() ;
            bytes =  c.getBlob(0) ;               //Extrair o BLOB para um array de bytes.
            codImagem = new ByteArrayInputStream( bytes ) ;  //Descomprime para uma "pré-imagem" ??
            return BitmapFactory.decodeStream( codImagem ) ; //Retorna a "conversão" para bmp ??
        }
        return null;
    }

    /**
     * Insere um contacto novo na Base de Dados.
     * @param       o       Contacto a Inserir.
     * @return      #long
     */
    public long insertSQLite(Contacto o ){
        db = getWritableDatabase();
        ContentValues cv = new ContentValues() ;
        cv.put("id" , o.getId() );   // substitui o AUTO_INCREMENT.
        cv.put("nome" , o.getNome() );
        cv.put("apelido" , o.getApelido() );
        cv.put("morada", o.getMorada() );
        if ( o.DataEVAlida( o.getNascimentoSTR() ) ) cv.put("nascimento", o.getNascimentoSTR() );
        cv.put("latitude" , o.getLatitude() );
        cv.put("longitude" , o.getLongitude() );
        cv.put("telemovel" , o.getTelemovel() );
        cv.put("email" , o.getEmail() );
        return db.insert("contacto",null , cv);
    }

    /**
     * Actualiza o Contacto em questão.
     * @param           o       Contacto a actualizar.
     * @return          #long
     */
    public long updateSQLite(Contacto o){
        db = getWritableDatabase();
        ContentValues cv = new ContentValues() ;
        cv.put("id" , o.getId() );
        cv.put("nome" , o.getNome() );
        cv.put("apelido" , o.getApelido() );
        cv.put("morada", o.getMorada() );
        if ( o.DataEVAlida( o.getNascimentoSTR() ) ) cv.put("nascimento", o.getNascimentoSTR() );
        cv.put("latitude" ,  o.getLatitude()  );
        cv.put("longitude" , o.getLongitude() );
        cv.put("telemovel" , o.getTelemovel()  );
        cv.put("email" , o.getEmail() );
        return db.update("contacto", cv, " id = ?", new String[] {  String.valueOf(o.getId() ) } );
    }

    /**
     * Apaga o contacto da Base de Dados
     * @param       o        Contacto a apagar.
     * @return      #long
     */
    public long deleteSQLite(Contacto o){
        db = getWritableDatabase();
        return db.delete("contacto", " id = ?", new String[]{ String.valueOf( o.getId() ) } );
    }

    /** Cria um cursor da lista de contactos
     * @see     #select()
     *
     * @return Cursor   Resultados carregados
     */
    private Cursor SelectSQLite(){
        db = getReadableDatabase();
        return db.rawQuery(" SELECT * FROM contacto ", null );
    }

    /**
     * Passa do cursor para a lista de contactos.
     * @see     #SelectSQLite
     * @return  lista       Lista de contactos.
     */
    public ArrayList<Contacto> select(){
        String no, ap, mo, nasc, te, em; double lat, lng ; int id , pId, pNo, pApe, pMo, pNas, pLat, pLng, pTel, pEm;
        ArrayList<Contacto> lista = new ArrayList<Contacto>() ;
        Cursor c = SelectSQLite();
        c.moveToFirst() ;
        pId = c.getColumnIndex("id" );
        pNo = c.getColumnIndex("nome" );
        pApe = c.getColumnIndex("apelido" );
        pMo = c.getColumnIndex("morada" );
        pNas = c.getColumnIndex("nascimento" );
        pLat = c.getColumnIndex("latitude" );
        pLng = c.getColumnIndex("longitude" );
        pTel = c.getColumnIndex("telemovel" );
        pEm =c.getColumnIndex("email" );
        if ( c.getCount() > 0 ) {
            do {
                id = Integer.parseInt(c.getString(pId));
                no = c.getString( pNo ) ;
                ap = c.getString( pApe ) ;
                mo = c.getString( pMo ) ;
                nasc = c.getString( pNas ) ;
                lat = c.getDouble( pLat ) ;
                lng = c.getDouble( pLng ) ;
                te = c.getString( pTel ) ;
                em = c.getString( pEm ) ;
                lista.add( new Contacto( id, no, ap, mo, nasc, lat, lng, te, em  )  ) ;
            } while ( c.moveToNext() );
        }
        c.close();
        return lista;
    }

    /**
     * Não foi usado, só não foi apagado para eu saber futuramrente que é criado automáticamente.
     * @param context
     * @param name
     * @param factory
     * @param version
     * @param nomeDB
     * @param versao
     */
    @Deprecated public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, String nomeDB, int versao) {
        super(context, name, factory, version);
        this.nomeDB = nomeDB;
        this.versao = versao;
    }

    /**
     * Não foi usado, só não foi apagado para eu saber futuramrente que é criado automáticamente.
     * @param context
     * @param name
     * @param factory
     * @param version
     * @param errorHandler
     * @param nomeDB
     * @param versao
     */
    @Deprecated public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler, String nomeDB, int versao) {
        super(context, name, factory, version, errorHandler);
        this.nomeDB = nomeDB;
        this.versao = versao;
    }

    /**
     * Não foi usado, só não foi apagado para eu saber futuramrente que é criado automáticamente.
     * @param context
     * @param name
     * @param version
     * @param openParams
     * @param nomeDB
     * @param versao
     */
    @Deprecated public DBHelper(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams, String nomeDB, int versao) {
        super(context, name, version, openParams);
        this.nomeDB = nomeDB;
        this.versao = versao;
    }
}
