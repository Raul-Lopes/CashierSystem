/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modelo;

import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author raul
 */
public class EmpresasDAO {

    //----------------------------------------------------------------------------------------------------------------------------
    public EmpresasBean listarEmpresasEmCodigo(int emCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {

        EmpresasBean registro = new EmpresasBean();
        registro.setEmcodigo(1);
        registro.setNomeempr("AMAZON IRELAND LTDA");
        registro.setNometela("AMAZOM.COM");
        registro.setCgc("123456789012345678");
        registro.setInscrica("ISENTO");
        registro.setEndereco("ST. PATRICK STREET");
        registro.setBairro("CENTE CITY");
        registro.setCicodigo(1);
        registro.setUf("MG");
        registro.setCep("35.590-000");
        registro.setTelefone("");
        registro.setFuncSab("");
        registro.setFuncDom("");
        return registro;
    }

    //--------------------------
    public EmpresasBean pegarEmpresasBean() {

        EmpresasBean registro = new EmpresasBean();
        registro.setEmcodigo(1);
        registro.setNomeempr("AMAZON IRELAND LTDA");
        registro.setNometela("AMAZOM.COM");
        registro.setCgc("123456789012345678");
        registro.setInscrica("ISENTO");
        registro.setEndereco("ST. PATRICK STREET");
        registro.setBairro("CENTE CITY");
        registro.setCicodigo(1);
        registro.setUf("MG");
        registro.setCep("35.590-000");
        registro.setTelefone("");
        registro.setFuncSab("");
        registro.setFuncDom("");
        
        return registro;
    }

    //-------------------------------------------------------------------------------------------
    void gravarNoRegistro() throws SQLException, ClassNotFoundException, IOException, Exception {

        EmpresasBean registro = new EmpresasBean();
        registro.setEmcodigo(1);
        registro.setNomeempr("AMAZON IRELAND LTDA");
        registro.setNometela("AMAZOM.COM");
        registro.setCgc("123456789012345678");
        registro.setInscrica("ISENTO");
        registro.setEndereco("ST. PATRICK STREET");
        registro.setBairro("CENTE CITY");
        registro.setCicodigo(1);
        registro.setUf("MG");
        registro.setCep("35.590-000");
        registro.setTelefone("");
        registro.setFuncSab("");
        registro.setFuncDom("");

    }
}
