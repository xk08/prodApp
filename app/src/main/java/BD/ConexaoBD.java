package BD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.support.annotation.RequiresApi;

/**
 * Created by Marcos , Geison on 26/05/2017.
 */

public class ConexaoBD extends SQLiteOpenHelper{
    private final static String BANCO_DE_DADOS = "ProdAPP";
    private final static int VERSAO = 1;

    public ConexaoBD(Context context)
    {
        super(context, BANCO_DE_DADOS, null, VERSAO);

    }

    public void onCreate(SQLiteDatabase db) {
        /*
        * Cria a tabela "usuarios no SQLite"
        */
        String sql = "CREATE TABLE IF NOT EXISTS usuarios (" +
                "id_usuario INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE," +
                "nome_usuario TEXT(50) NULL," +
                "email_usuario TEXT(64) NULL," +
                "senha_usuario TEXT(64) NULL" +
                ")";

        db.execSQL(sql); // Executa o SQL, depois de definido a estrutura


        //INSERINDO DADOS PRÉ DEFINIDOS NA IMAGEM USUARIO
        sql = "insert into usuarios(id_usuario,nome_usuario,email_usuario,senha_usuario)" +
                "values (1 , 'prodap , prod@gmail.com , 'prodap')";

        db.execSQL(sql); // Executando a inserção dos dados


    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public static class usuarios{
        public static final String TABELA = "usuarios";
        public static final String ID_USUARIO = "id_usuario";
        public static final String NOME_USUARIO = "nome_usuario";
        public static final String EMAIL_USUARIO = "email_usuario";
        public static final String SENHA_USUARIO = "senha_usuario";

        public final static String [] COLUNAS = new String[]{
                ID_USUARIO, NOME_USUARIO, EMAIL_USUARIO, SENHA_USUARIO
        };
    }
}