/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Properties;

/**
 *
 * @author Raul
 */
public class ConfiguracaoDAO {

    ConfiguracaoBean registro;

    public ConfiguracaoBean pegarConfiguracao() throws Exception {

        registro = new ConfiguracaoBean();

        File f = new File(System.getProperty("user.dir") + "/config.properties");
        if (f.exists()) {

            Properties arquivoAuxiliar = new Properties();
            arquivoAuxiliar.load(new FileInputStream(new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "config.properties")));

            //ex: P:\\CX2\\Projeto\\Cx2\\Cx2\\c.jpg
            registro.setPapelParede(arquivoAuxiliar.getProperty("papelparede"));

            registro.setPapelParede(System.getProperty("user.dir") + System.getProperty("file.separator") + "b.jpg");

            //ex: C1
            registro.setNumeroCaixa(arquivoAuxiliar.getProperty("numeroCaixa"));
            //setor uso: LOJA
            registro.setSetorUso(arquivoAuxiliar.getProperty("setorUso"));
            //cupom: gerar pre-venda
            registro.setEmitirCupom(arquivoAuxiliar.getProperty("emitirCupom"));
            //modo de impressao da venda
            registro.setModoImpremeVenda(arquivoAuxiliar.getProperty("modoImpremeVenda"));
            //plano de contas
            registro.setPlanoContas(arquivoAuxiliar.getProperty("planoContas"));

            registro.setCentCusto(arquivoAuxiliar.getProperty("centCusto"));

            registro.setTipoMovimento(arquivoAuxiliar.getProperty("tipoMovimento"));

            registro.setFuncionarioItem(arquivoAuxiliar.getProperty("funcionarioItem"));

        } else {
            //registro.setPapelParede("");
            //ex: C1
            registro.setNumeroCaixa("C1");
            //setor uso: LOJA
            registro.setSetorUso("LOJA");
            //cupom: gerar pre-venda
            registro.setEmitirCupom("SIM");
            //modo de impressao da venda
            registro.setModoImpremeVenda("0");
            //plano Contas
            registro.setPlanoContas("0");

            registro.setTipoMovimento("2");
            registro.setFuncionarioItem("N");

            salvarConfig(registro);
        }

        return registro;
    }

    //=========================================================================
    public void salvarConfig(ConfiguracaoBean config) throws Exception {

        File f = new File(System.getProperty("user.dir") + "/config.properties");
        if (!f.exists()) { //se não existe, cria vazio

            FileWriter gravar;
            gravar = new FileWriter(f); //cria vazio
            //PrintWriter saida = new PrintWriter(gravar);
            //saida.close();
            //gravar.close();
        }

        Properties arquivoAuxiliar = new Properties();
        arquivoAuxiliar.load(new FileInputStream(new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "config.properties")));

        //-----------------------------------------------------------------
        arquivoAuxiliar.setProperty("papelparede", config.getPapelParede());
        arquivoAuxiliar.setProperty("numeroCaixa", config.getNumeroCaixa());
        arquivoAuxiliar.setProperty("setorUso", config.getSetorUso());
        arquivoAuxiliar.setProperty("emitirCupom", config.getEmitirCupom());
        arquivoAuxiliar.setProperty("modoImpremeVenda", config.getModoImpremeVenda());
        arquivoAuxiliar.setProperty("planoContas", config.getPlanoContas());
        arquivoAuxiliar.setProperty("centCusto", config.getCentCusto());
        arquivoAuxiliar.setProperty("tipoMovimento", config.getTipoMovimento());
        arquivoAuxiliar.setProperty("funcionarioItem", config.getFuncionarioItem());

        try ( //----------------------------------------------------------------
                FileOutputStream out = new FileOutputStream(new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "config.properties"))) {
            arquivoAuxiliar.store(out, "");
        }
    }

}
