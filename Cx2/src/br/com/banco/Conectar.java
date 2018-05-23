/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.banco;

import br.com.visual.Biblioteca;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * <p>Title: Infocus ERP - Projeto Acadêmico</p>
 *
 * @version	versão
 * @param	parâmetro do método
 * @return	retorno do método
 * @exception	exceção
 * @see	veja também
 *
 * <p>Class Description: Atributos de leitura de abastecimentos da placa da
 * bomba de combustível.</p>
 *
 * <p>The MIT License</p> <p>Copyright: Copyright (C) 2011 Raul Lopes</p>
 *
 * @author	<p>Raul Lopes The author may be contacted at:
 * raul.lagoa@gmail.com</p>
 *
 */
public class Conectar {

    Connection con;
    String url;
    String usuario;
    String senha;

    //================================================================================================
    public Connection conectar() throws ClassNotFoundException, IOException, SQLException, Exception {

        Class.forName("com.mysql.jdbc.Driver"); //carregar drive

        //comunicacao padrao
        url = "jdbc:mysql://localhost:3306/dbComum";  //"jdbc:mysql://127.0.0.1/WORLD_CASH_DB?user=root&password=root"
        usuario = "root";
        senha = "";

        //-------------------------
        lerArquivoAcesso();

        try {
            con = DriverManager.getConnection(url, usuario, senha);
        } catch (Exception ex) {
            throw new RuntimeException("Falha de conexão com banco de dados. " + ex.getMessage(), ex);
        }

        return con;
    }

    //=========================================================
    public void desconectar() throws SQLException, Exception {
        try {
            con.close();
        } catch (Exception ex) {
            throw new RuntimeException("Falha na conexão com banco de dados. " + ex.getMessage(), ex);
        }
    }

    //===================================================================================
    public void lerArquivoAcesso() throws Exception {

        //captura dados de conexao com banco de dados em um arquivo com formato de texto.
        //cada parametro necessario a conexao, é separado no arquivo com ";".
        //Os parametros são: url - usuario - senha

        File f = new File("acesso.properties");
        if (f.exists()) {

            Properties arquivoAuxiliar = new Properties();
            arquivoAuxiliar.load(new FileInputStream(new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "acesso.properties")));

            String ipBanco = arquivoAuxiliar.getProperty("ip");
            String nomeBanco = arquivoAuxiliar.getProperty("banco");
            String arquivoUsuario = arquivoAuxiliar.getProperty("usuario");
            String arquivoSenha = arquivoAuxiliar.getProperty("senha");

            url = "jdbc:mysql://" + ipBanco + ":3306/" + nomeBanco;
            usuario = Biblioteca.Descriptografar(arquivoUsuario);
            senha = Biblioteca.Descriptografar(arquivoSenha);

            //System.out.println(url);
            //System.out.println(nomeBanco);
            //System.out.println(usuario);
            //System.out.println(senha);
        }
    }
}
