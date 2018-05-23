/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modelo;

import java.io.IOException;
import java.sql.SQLException;
import static java.util.Arrays.asList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author raul
 */
public class ParcfPgtDAO {

    //-------------------------------------------------------------------------------------------------------------------------------------
    public ParcfPgtBean parcfPgtFpCodigo(String fpCodigo, String sequencia) throws SQLException, ClassNotFoundException, IOException, Exception {

        ParcfPgtBean registro = new ParcfPgtBean();
        registro.setFpcodigo("1");
        registro.setSequencia(1);
        registro.setDiaslanca(30);
        registro.setPercparce(2.0);
        registro.setDataalte(new Date());
        registro.setCocodigo("2");
        registro.setCecodigo("1"  );
        registro.setPlcodigo("1");
        registro.setJuros(1.0);
        
        return registro;
    }

    //--------------------------------------------------------------------------------------------------------------
    public List<ParcfPgtBean> listaParcfPgt(String fpCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {

        ParcfPgtBean registro1 = new ParcfPgtBean();
        registro1.setFpcodigo("1");
        registro1.setSequencia(1);
        registro1.setDiaslanca(30);
        registro1.setPercparce(2.0);
        registro1.setDataalte(new Date());
        registro1.setCocodigo("2");
        registro1.setCecodigo("1"  );
        registro1.setPlcodigo("1");
        registro1.setJuros(1.0);
        
        ParcfPgtBean registro2 = new ParcfPgtBean();
        registro2.setFpcodigo("2");
        registro2.setSequencia(1);
        registro2.setDiaslanca(30);
        registro2.setPercparce(2.0);
        registro2.setDataalte(new Date());
        registro2.setCocodigo("2");
        registro2.setCecodigo("1"  );
        registro2.setPlcodigo("2");
        registro2.setJuros(1.0);
        
        return asList(registro1,registro2);
    }
}
