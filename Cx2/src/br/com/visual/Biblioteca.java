package br.com.visual;

/**
 * <p>
 * Title: Infocus ERP - Projeto Acadêmico</p>
 *
 * @version	versão
 * @param	parâmetro do método
 * @return	retorno do método
 * @exception	exceção
 * @see	veja também
 *
 * <p>
 * Class Description: Atributos de leitura de abastecimentos da placa da bomba
 * de combustível.</p>
 *
 * <p>
 * The MIT License</p>
 * <p>
 * Copyright: Copyright (C) 2011 Raul Lopes</p>
 *
 * @author
 * <p>
 * Raul Lopes The author may be contacted at: raul.lagoa@gmail.com</p>
 *
 */
import br.com.banco.Conectar;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.view.JasperViewer;
import org.jasypt.util.text.BasicTextEncryptor;

/**
 *
 * @author Raul
 */
public final class Biblioteca {

    //==========================================================
    public static String repete(String string, Integer quantidade) {
        StringBuilder retorno = new StringBuilder();
        for (int j = 0; j < quantidade; j++) {
            retorno.append(string);
        }
        return retorno.toString();
    }

    //==========================================================
    public static boolean validaCpfCnpj(String s_aux) {

        if (s_aux.length() == 11) {

            Integer d1, d2;
            Integer digito1, digito2, resto;
            Integer digitoCPF;
            String nDigResult;
            d1 = d2 = 0;
            digito1 = digito2 = resto = 0;
            for (int n_Count = 1; n_Count < s_aux.length() - 1; n_Count++) {
                digitoCPF = Integer.valueOf(s_aux.substring(n_Count - 1, n_Count)).intValue();
                d1 = d1 + (11 - n_Count) * digitoCPF;
                d2 = d2 + (12 - n_Count) * digitoCPF;
            }

            resto = (d1 % 11);
            if (resto < 2) {
                digito1 = 0;
            } else {
                digito1 = 11 - resto;
            }
            d2 += 2 * digito1;
            resto = (d2 % 11);
            if (resto < 2) {
                digito2 = 0;
            } else {
                digito2 = 11 - resto;
            }
            String nDigVerific = s_aux.substring(s_aux.length() - 2, s_aux.length());
            nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
            return nDigVerific.equals(nDigResult);
        } else if (s_aux.length() == 14) {
            Integer soma = 0, aux, dig;
            String cnpj_calc = s_aux.substring(0, 12);
            char[] chr_cnpj = s_aux.toCharArray();

            for (int i = 0; i < 4; i++) {
                if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                    soma += (chr_cnpj[i] - 48) * (6 - (i + 1));
                }
            }
            for (int i = 0; i < 8; i++) {
                if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9) {
                    soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));
                }
            }
            dig = 11 - (soma % 11);
            cnpj_calc += (dig == 10 || dig == 11)
                    ? "0" : Integer.toString(dig);
            soma = 0;
            for (int i = 0; i < 5; i++) {
                if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                    soma += (chr_cnpj[i] - 48) * (7 - (i + 1));
                }
            }
            for (int i = 0; i < 8; i++) {
                if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9) {
                    soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));
                }
            }
            dig = 11 - (soma % 11);
            cnpj_calc += (dig == 10 || dig == 11)
                    ? "0" : Integer.toString(dig);
            return s_aux.equals(cnpj_calc);
        } else {
            return false;
        }
    }

    //Função para criar hash da senha informada
    public static String md5(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        /*
         * Caros amigos, Esta rotina transforma uma String em uma cadeia de 32
         * caracteres (um hash) Ela é normalmente utilizada para criptografar
         * senha de usuários, funcionando da seguinte maneira: 
         * 1) O sistema recebe a senha, cria um hash e armazena no banco de dados 
         * 2) Para efetuar o login o sistema recebe a senha, passa pela mesma função (criando outro hash) e compara com o que está na base de dados.
         */
        String sen = "";
        MessageDigest md = null;
        md = MessageDigest.getInstance("MD5");

        //Só tomar cuidado com duas coisas.
        //a) "senha.getBytes()" pode dar resultados diferentes conforme seu sistema operacional.
        //Por exemplo, no Windows em inglês o "encoding" padrão é parecido com o ISO-8859-1, e no Linux o "encoding" padrão é UTF-8.
        //Portanto, é necessário explicitar o encoding (ou seja, algo como 'senha.getBytes("UTF-8")') para não ter problemas quando for usar a mesma base de senhas em vários sistemas operacionais.
        //b) Usar BigInteger para converter para hexadecimal é válido, mas você pode ter (a probabilidade é de aproximadamente 1/16 + 1/256, ou seja, 6,65%) uma string com menos de 32 caracteres.
        //Complete o resultado com zeros à esquerda.
        md.update(senha.getBytes("iso-8859-1"), 0, senha.length());
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
        sen = hash.toString(16);
        return sen;
    }

    //==========================================================
    public static String MD5String(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        MessageDigest md;
        md = MessageDigest.getInstance("MD5");
        byte[] md5hash = new byte[32];

        //Só tomar cuidado com duas coisas.
        //a) "senha.getBytes()" pode dar resultados diferentes conforme seu sistema operacional. Por exemplo, no Windows em inglês o "encoding" padrão é parecido com o ISO-8859-1, e no Linux o "encoding" padrão é UTF-8. Portanto, é necessário explicitar o encoding (ou seja, algo como 'senha.getBytes("UTF-8")') para não ter problemas quando for usar a mesma base de senhas em vários sistemas operacionais.
        //b) Usar BigInteger para converter para hexadecimal é válido, mas você pode ter (a probabilidade é de aproximadamente 1/16 + 1/256, ou seja, 6,65%) uma string com menos de 32 caracteres. Complete o resultado com zeros à esquerda.
        md.update(text.getBytes("iso-8859-1"), 0, text.length());
        md5hash = md.digest();
        return convertToHex(md5hash);
    }

    public static String MD5File(String arquivo) throws NoSuchAlgorithmException, FileNotFoundException {

        MessageDigest digest = MessageDigest.getInstance("MD5");
        File f = new File(arquivo);
        InputStream is = new FileInputStream(f);
        byte[] buffer = new byte[8192];
        Integer read = 0;
        try {
            while ((read = is.read(buffer)) > 0) {
                digest.update(buffer, 0, read);
            }
            byte[] md5sum = digest.digest();
            BigInteger bigInt = new BigInteger(1, md5sum);
            String output = bigInt.toString(16);
            return Biblioteca.strzero(output, 32);
        } catch (IOException e) {
            throw new RuntimeException("Impossível processar o arquivo.", e);
        } finally {
            try {
                is.close();
            } catch (IOException e) {
            }
        }
    }

    private static String convertToHex(byte[] data) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            Integer halfbyte = (data[i] >>> 4) & 0x0F;
            Integer two_halfs = 0;
            do {
                if ((0 <= halfbyte) && (halfbyte <= 9)) {
                    buf.append((char) ('0' + halfbyte));
                } else {
                    buf.append((char) ('a' + (halfbyte - 10)));
                }
                halfbyte = data[i] & 0x0F;
            } while (two_halfs++ < 1);
        }
        return buf.toString();
    }

    public static void removeLineFromFile(String file, String lineToRemove) {

        try {

            File inFile = new File(file);
            if (!inFile.isFile()) {
                throw new FileNotFoundException("Arquivo não localizado!");
            }
            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp2");
            BufferedReader br = new BufferedReader(new FileReader(file));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
            String line = null;
            //Read from the original file and write to the new
            //unless content matches data to be removed.
            while ((line = br.readLine()) != null) {
                if (!line.equals(lineToRemove)) {
                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            br.close();
            //Delete the original file
            if (!inFile.delete()) {
                throw new RuntimeException("Não foi possível apagar o arquivo!");
            }
            //Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inFile)) {
                throw new RuntimeException("Não foi possível renomear o arquivo!");
            }
        } catch (Exception ex) {
            Loggin.logDiarioExcecao(ex, true);
        }
    }

    public static void addLineFromFile(String file, String lineToAdd) {
        try {
            File inFile = new File(file);
            if (!inFile.isFile()) {
                throw new FileNotFoundException("Arquivo não localizado!");
            }
            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");
            BufferedReader br = new BufferedReader(new FileReader(file));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
            String line = null;
            //Read from the original file and write to the new
            //unless content matches data to be removed.
            while ((line = br.readLine()) != null) {
                pw.println(line);
                pw.flush();
            }
            pw.println(lineToAdd);
            pw.flush();
            pw.close();
            br.close();
            //Delete the original file
            if (!inFile.delete()) {
                throw new RuntimeException("Não foi possível apagar o arquivo!");
            }
            //Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inFile)) {
                throw new RuntimeException("Não foi possível renomear o arquivo!");
            }
        } catch (Exception ex) {
            Loggin.logDiarioExcecao(ex, true);
        }

    }

    /**
     * Método que verifica se uma data no formato dd/mm/aaaa é valida.
     *
     * @param data a ser validada
     * @return true se a data é valida, false se a data é inválida
     */
    public static boolean isDataValida(String strData) {
        try {

            if ((strData.length() != 10)) {
                return false;
            }

            Calendar dataValida = Calendar.getInstance();
            dataValida.setLenient(false);
            Integer dia = Integer.valueOf(strData.substring(0, 2));
            Integer mes = Integer.valueOf(strData.substring(3, 5));
            Integer ano = Integer.valueOf(strData.substring(6, 10));

            dataValida.set(Calendar.DAY_OF_MONTH, dia);
            dataValida.set(Calendar.MONTH, mes - 1);
            dataValida.set(Calendar.YEAR, ano);

            dataValida.getTime();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void limpaCampos(javax.swing.JPanel jpanel1) {

        java.awt.Component[] components = jpanel1.getComponents();
        javax.swing.JTextField textField = null;

        for (Component component : components) {
            if (component instanceof javax.swing.JTextField) {
                textField = (javax.swing.JTextField) component;
                textField.setText("");
            }
        }
        //chamada: limpaCampos(JPanel1);
        //chamada: limpaCampos(JPanel2);
    }

    //===========================================================================
    /*
     * public static void aplicarCorSistema(Container container) { //, Integer
     * rgb[]
     *
     * for (Component componente : container.getComponents()) {
     *
     * if (componente instanceof JPanel) { ((JPanel)
     * componente).setBackground(new Color(Caixa.rgbJan[0], Caixa.rgbJan[1],
     * Caixa.rgbJan[2])); }
     *
     * if (componente instanceof JTabbedPane) { ((JTabbedPane)
     * componente).setBackground(new Color(Caixa.rgbJan[0], Caixa.rgbJan[1],
     * Caixa.rgbJan[2])); }
     *
     * //chamada recursiva
     * ----------------------------------------------------------------
     * aplicarCorSistema((Container) componente); //, new Integer[]{rgb[0],
     * rgb[1], rgb[2]} } }
     */
    //===========================================================================
//    public static void aplicarCorSistema(Container container) {
//
//        for (Component componente : container.getComponents()) {
//
//            if (componente instanceof JPanel) {
//                ((JPanel) componente).setBackground(new Color(Caixa.rgbJan[0], Caixa.rgbJan[1], Caixa.rgbJan[2]));
//            }
//
//            if (componente instanceof JTabbedPane) {
//                ((JTabbedPane) componente).setBackground(new Color(Caixa.rgbJan[0], Caixa.rgbJan[1], Caixa.rgbJan[2]));
//            }
//
//            if (componente instanceof JLabel) {
//                ((JLabel) componente).setBackground(new Color(Caixa.rgbJan[0], Caixa.rgbJan[1], Caixa.rgbJan[2]));
//            }
//
//            if (componente instanceof JRadioButton) {
//                ((JRadioButton) componente).setBackground(new Color(Caixa.rgbJan[0], Caixa.rgbJan[1], Caixa.rgbJan[2]));
//            }
//
//            if (componente instanceof JCheckBox) {
//                ((JCheckBox) componente).setBackground(new Color(Caixa.rgbJan[0], Caixa.rgbJan[1], Caixa.rgbJan[2]));
//            }
//
//            /*
//             * if (componente instanceof JButton) { ((JButton)
//             * componente).setBackground(new Color(Caixa.rgbJan[0],
//             * Caixa.rgbJan[1], Caixa.rgbJan[2])); }
//             */
//
//            if (componente instanceof JScrollPane) {
//                ((JScrollPane) componente).setBackground(new Color(Caixa.rgbJan[0], Caixa.rgbJan[1], Caixa.rgbJan[2]));
//            }
//
//            if (componente instanceof JScrollBar) {
//                ((JScrollBar) componente).setBackground(new Color(Caixa.rgbJan[0], Caixa.rgbJan[1], Caixa.rgbJan[2]));
//            }
//
//            if (componente instanceof JTable) {
//                ((JTable) componente).setBackground(new Color(Caixa.rgbTab[0], Caixa.rgbTab[1], Caixa.rgbTab[2]));
//            }
//
//            //chamada recursiva, caso haja container dentro de outro ----------------------------------------------------------------
//            aplicarCorSistema((Container) componente);
//        }
//    }
    //======================================================================
    public static void beep() {

        //www.java2everyone.blogspot.com
        Toolkit.getDefaultToolkit().beep();
    }

    //======================================================================
    public static String semanaExtenso(int dia_da_semana) {

        switch (dia_da_semana) {
            case 1:
                return ("Domingo");
            case 2:
                return ("Segunda-Feira");
            case 3:
                return ("Terça-Feira");
            case 4:
                return ("Quarta-Feira");
            case 5:
                return ("Quinta-Feira");
            case 7:
                return ("Sexta-Feira");
            default:
                return ("Sábado");
        }
    }

    //======================================================================
    public static String mesExtenso(int mes) {

        switch (mes) {
            case 1:
                return ("Janeiro");
            case 2:
                return ("Fevereiro");
            case 3:
                return ("Março");
            case 4:
                return ("Abril");
            case 5:
                return ("Maio");
            case 7:
                return ("Junho");
            case 8:
                return ("Julho");
            case 9:
                return ("Agosto");
            case 10:
                return ("Setembro");
            case 11:
                return ("Outubro");
            case 12:
                return ("Novembro");
            default:
                return ("Dezembro");
        }
    }

    //======================================================================
    public static String horaAtual(int modo) {

        DateFormat FORMATO = null;

        if (modo == 0) {
            FORMATO = new SimpleDateFormat("HH:mm");
        }

        if (modo == 1) {
            FORMATO = new SimpleDateFormat("HH:mm:ss");
        }

        if (modo == 3) {
            FORMATO = new SimpleDateFormat("HHmmss");
        }

        if (modo == 4) {
            FORMATO = new SimpleDateFormat("HH mm ss");
        }

        if (modo == 5) {
            FORMATO = new SimpleDateFormat("HH");
        }

        if (modo == 6) {
            FORMATO = new SimpleDateFormat("mm");
        }

        if (modo == 7) {
            FORMATO = new SimpleDateFormat("ss");
        }

        Date date = new Date();
        return FORMATO.format(date).trim();
    }

    //==================================================================
    public static String dataAtual(int modo) {

        Date date = new Date();
        DateFormat dateFormat = null;

        if (modo == 0) {
            dateFormat = new SimpleDateFormat("dd/MM/yy");
        }

        if (modo == 1) {
            dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        }

        if (modo == 2) {
            dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        }

        if (modo == 3) {
            dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        }

        if (modo == 4) {
            dateFormat = new SimpleDateFormat("yyyyMMdd");
        }

        if (modo == 5) {
            dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        }

        if (modo == 6) {
            dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
        }

        if (modo == 7) {
            dateFormat = new SimpleDateFormat("dd");
        }

        if (modo == 8) {
            dateFormat = new SimpleDateFormat("MM");
        }

        if (modo == 9) {
            dateFormat = new SimpleDateFormat("yyyy");
        }

        if (modo == 10) {
            dateFormat = new SimpleDateFormat("ddMMyyyy");
        }

        if (modo == 11) {
            dateFormat = new SimpleDateFormat("ddMMyy");
        }

        return dateFormat.format(date).trim();
    }

    //========================================================
    public static String dateToString(int modo, Date date) {

        DateFormat dateFormat = null;

        if (modo == 0) {
            dateFormat = new SimpleDateFormat("dd/MM/yy");
        }

        if (modo == 1) {
            dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        }

        if (modo == 2) {
            dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        }

        if (modo == 3) {
            dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        }

        if (modo == 4) {
            dateFormat = new SimpleDateFormat("yyyyMMdd");
        }

        if (modo == 5) {
            dateFormat = new SimpleDateFormat("dd");
        }

        if (modo == 6) {
            dateFormat = new SimpleDateFormat("MM");
        }

        if (modo == 7) {
            dateFormat = new SimpleDateFormat("yyyy");
        }

        if (modo == 8) {
            dateFormat = new SimpleDateFormat("MMyyyy");
        }

        if (date != null) {
            return dateFormat.format(date).trim();
        } else {
            return null;
        }
    }

    //==================================================================
    public static java.util.Date stringToTime(int modo, String stringTime) throws ParseException {

        SimpleDateFormat formHora = new SimpleDateFormat("HHmmss");
        return formHora.parse(stringTime);

    }

    //==================================================================
    public static java.util.Date stringToDate(int modo, String stringData) throws ParseException {

        /*
         * / **
         * Converte uma String para um objeto Date. Caso a String seja vazia ou
         * nula, retorna null - para facilitar em casos onde formulários podem
         * ter campos de datas vazios. @param data String no formato dd/MM/yyyy
         * a ser formatada @return Date Objeto Date ou null caso receba uma
         * String vazia ou nula @throws Exception Caso a String esteja no
         * formato errado / public static Date formataData(String data) throws
         * Exception { if (data == null || data.equals("")) return null;
         *
         * Date date = null; try { DateFormat formatter = new
         * SimpleDateFormat("dd/MM/yyyy"); date =
         * (java.util.Date)formatter.parse(data); return date; }
         */
        if (stringData.isEmpty()) {
            return (java.util.Date) new Date();
        }

        DateFormat dateFormat = null;

        if (modo == 0) {
            dateFormat = new SimpleDateFormat("dd/MM/yy");
        }

        if (modo == 1) {
            dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        }

        if (modo == 2) {
            dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        }

        if (modo == 3) {
            dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        }

        if (modo == 4) {
            dateFormat = new SimpleDateFormat("yyyyMMdd");
        }

        java.util.Date stringConvertida = new java.sql.Date(dateFormat.parse(stringData).getTime());

        return stringConvertida;
    }

    /**
     * 19 – Adicionando Data nos seus aplicativos O aplicativo abaixo mostra dos
     * tipos de data, somente com números e a outra com o dia da semana e os
     * meses escritos com o nome. Vamos ver o aplicativo:,
     */
    public static String dataExtenso() {

        //JLabel rotulo, rotulo2;
        Integer ds, dia, mes, ano;
        Calendar data;
        String diasemana[] = {"Domingo", "Segunda - Feira", "Terça - Feira", "Quarta - Feira", "Quinta - Feira", "Sexta - Feira", "Sábado"};
        String meses[] = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

        //super("Exemplo de Data");
        //Container tela = getContentPane();
        //tela.setLayout(null);
        /*
         * rotulo = new JLabel(""); rotulo2 = new JLabel("");
         * rotulo.setBounds(20, 30, 280, 20); rotulo2.setBounds(20, 60, 280, 20);
         */
        data = Calendar.getInstance();
        ds = data.get(Calendar.DAY_OF_WEEK);
        dia = data.get(Calendar.DAY_OF_MONTH);
        mes = data.get(Calendar.MONTH);
        ano = data.get(Calendar.YEAR);

        //rotulo.setText("Data: " + ds + " " + dia + "/" + (mes + 1) + "/" + ano);
        //rotulo2.setText("Data: " + diasemana[ds - 1] + ", " + dia + " de " + meses[mes] + " de " + ano);
        //tela.add(rotulo);
        //tela.add(rotulo2);
        //setSize(300, 200);
        //setVisible(true);
        //setLocationRelativeTo(null);
        return diasemana[ds - 1] + ", " + dia + " de " + meses[mes] + " de " + ano;
    }

    /**
     * 19 – Adicionando Data nos seus aplicativos O aplicativo abaixo mostra dos
     * tipos de data, somente com números e a outra com o dia da semana e os
     * meses escritos com o nome. Vamos ver o aplicativo:,
     */
    public static String dataExtenso(java.util.Date pData) {

        //JLabel rotulo, rotulo2;
        Integer ds, dia, mes, ano;
        Calendar data;
        String diasemana[] = {"Domingo", "Segunda - Feira", "Terça - Feira", "Quarta - Feira",
            "Quinta - Feira", "Sexta - Feira", "Sábado"};
        String meses[] = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
            "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

        //super("Exemplo de Data");
        //Container tela = getContentPane();
        //tela.setLayout(null);
        /*
         * rotulo = new JLabel(""); rotulo2 = new JLabel("");
         * rotulo.setBounds(20, 30, 280, 20); rotulo2.setBounds(20, 60, 280,
         * 20);
         */
        data = Calendar.getInstance();
        data.setTime(pData);
        ds = data.get(Calendar.DAY_OF_WEEK);
        dia = data.get(Calendar.DAY_OF_MONTH);
        mes = data.get(Calendar.MONTH);
        ano = data.get(Calendar.YEAR);

        //rotulo.setText("Data: " + ds + " " + dia + "/" + (mes + 1) + "/" + ano);
        //rotulo2.setText("Data: " + diasemana[ds - 1] + ", " + dia + " de " + meses[mes] + " de " + ano);
        //tela.add(rotulo);
        //tela.add(rotulo2);
        //setSize(300, 200);
        //setVisible(true);
        //setLocationRelativeTo(null);
        return diasemana[ds - 1] + ", " + dia + " de " + meses[mes] + " de " + ano;
    }

    /**
     * Calcula a diferença de duas datas em dias <br> <b>Importante:</b> Quando
     * realiza a diferença em dias entre duas datas, este método considera as
     * horas restantes e as converte em fração de dias.
     *
     * @param dataInicial
     * @param dataFinal
     * @return quantidade de dias existentes entre a dataInicial e dataFinal.
     */
    public static double diferencaEmDias(Date dataInicial, Date dataFinal) {

        double result = 0;
        long diferenca = dataFinal.getTime() - dataInicial.getTime();
        /*
         * System.out.println("diferenca em milisegundos: " + diferenca);
         * System.out.println("diferenca em segundos: " + (diferenca / 1000));
         * System.out.println("diferenca em minutos: " + (diferenca / 1000 / 60)); 
         * System.out.println("diferenca em horas: " + (diferenca / 1000 / 60 / 60)); 
         * System.out.println("diferenca em dias: " + (diferenca / 1000 / 60 / 60 / 24));
         */
        double diferencaEmDias = (diferenca / 1000) / 60 / 60 / 24; //resultado é diferença entre as datas em dias
        long horasRestantes = (diferenca / 1000) / 60 / 60 % 24; //calcula as horas restantes
        result = diferencaEmDias + (horasRestantes / 24d); //transforma as horas restantes em fração de dias

        return Math.abs(result);
    }

    /**
     * Calcula a diferença de duas datas em horas <br> <b>Importante:</b> Quando
     * realiza a diferença em horas entre duas datas, este método considera os
     * minutos restantes e os converte em fração de horas.
     *
     * @param dataInicial
     * @param dataFinal
     * @return quantidade de horas existentes entre a dataInicial e dataFinal.
     */
    public static double diferencaEmHoras(Date dataInicial, Date dataFinal) {
        double result = 0;
        long diferenca = dataFinal.getTime() - dataInicial.getTime();
        /*
         * System.out.println("diferenca em milisegundos: " + diferenca);
         * System.out.println("diferenca em segundos: " + (diferenca / 1000));
         * System.out.println("diferenca em minutos: " + (diferenca / 1000 /
         * 60)); System.out.println("diferenca em horas: " + (diferenca / 1000 /
         * 60 / 60)); System.out.println("diferenca em dias: " + (diferenca /
         * 1000 / 60 / 60 / 24));
         */
        long diferencaEmHoras = (diferenca / 1000) / 60 / 60;
        long minutosRestantes = (diferenca / 1000) / 60 % 60;
        double horasRestantes = minutosRestantes / 60d;
        result = diferencaEmHoras + (horasRestantes);

        return Math.abs(result);
    }

    /**
     * Calcula a diferença de duas datas em minutos <br> <b>Importante:</b>
     * Quando realiza a diferença em minutos entre duas datas, este método
     * considera os segundos restantes e os converte em fração de minutos.
     *
     * @param dataInicial
     * @param dataFinal
     * @return quantidade de minutos existentes entre a dataInicial e dataFinal.
     */
    public static double diferencaEmMinutos(Date dataInicial, Date dataFinal) {
        double result = 0;
        long diferenca = dataFinal.getTime() - dataInicial.getTime();

        /*
         * System.out.println("diferenca em milisegundos: " + diferenca);
         * System.out.println("diferenca em segundos: " + (diferenca / 1000));
         * System.out.println("diferenca em minutos: " + (diferenca / 1000 /
         * 60)); System.out.println("diferenca em horas: " + (diferenca / 1000 /
         * 60 / 60)); System.out.println("diferenca em dias: " + (diferenca /
         * 1000 / 60 / 60 / 24));
         */
        double diferencaEmMinutos = (diferenca / 1000) / 60; //resultado é diferença entre as datas em minutos
        long segundosRestantes = (diferenca / 1000) % 60; //calcula os segundos restantes
        result = diferencaEmMinutos + (segundosRestantes / 60d); //transforma os segundos restantes em minutos

        return Math.abs(result);
    }
    //=======================================================================
    /*
     * realiza a formatação do valor de acordo com a mascara enviada
     */
    public static String formatarGeral(String valor, String mascara) {

        String dado = "";
        // remove caracteres nao numericos
        for (int i = 0; i < valor.length(); i++) {
            char c = valor.charAt(i);
            if (Character.isDigit(c)) {
                dado += c;
            }
        }

        Integer indMascara = mascara.length();
        Integer indCampo = dado.length();

        for (; indCampo > 0 && indMascara > 0;) {
            if (mascara.charAt(--indMascara) == '#') {
                indCampo--;
            }
        }

        String saida = "";
        for (; indMascara < mascara.length(); indMascara++) {
            saida += ((mascara.charAt(indMascara) == '#') ? dado.charAt(indCampo++) : mascara.charAt(indMascara));
        }
        return saida;
    }

    //=======================================================================
    public static String formatarCpf(String cpf) {

        if (cpf == null) {
            return "";
        }

        while (cpf.length() < 11) {
            cpf = "0" + cpf;
        }
        return formatarGeral(cpf, "###.###.###-##");
    }

    //=======================================================================
    public static String formatarCnpj(String Cnpj) {

        if (Cnpj == null) {
            return "";
        }

        while (Cnpj.length() < 14) {
            Cnpj = "0" + Cnpj;
        }
        return formatarGeral(Cnpj, "##.###.###/####-##");
    }

//=======================================================================
    public static String formatarCep(String Cep) {

        if (Cep == null) {
            return "";
        }

        while (Cep.length() < 8) {
            Cep = "0" + Cep;
        }
        return formatarGeral(Cep, "##.###-###");
    }

//=======================================================================
    public static String formatarRG(String rg) {

        if (rg == null) {
            return "";
        }

        while (rg.length() < 10) {
            rg = "0" + rg;
        }
        return formatarGeral(rg, "##.###.###-#");
    }

    //=======================================================================
    public static String formatarPlaca(String placa) {

        if (placa == null) {
            return "";
        }

        while (placa.length() < 7) {
            placa = " " + placa;
        }
        return formatarGeral(placa, "UUU-####");
    }

    //=======================================================================
    public static String formatarFone(String Fone) {

        if (Fone == null) {
            return "";
        }

        while (Fone.length() < 13) {
            Fone = "0" + Fone;
        }

        return formatarGeral(Fone, "(##)####-####");
    }

    //Numero doublo=======================================================================
    public static String formatarNumero(Double numero, String mascara) {

        if (numero == null) {
            return "0.00";
        }

        Locale Local = new Locale("pt", "BR");
        DecimalFormat decimalFormat = new DecimalFormat(mascara, new DecimalFormatSymbols(Local));

        int tam = mascara.length();
        //return repete(" ", tam - decimalFormat.format(numero).length()) + decimalFormat.format(numero);
        return decimalFormat.format(numero);
    }

    //Numero doublo=========================================================================
    public static String formatarNumero(Double numero, String mascara, boolean retornaEspaco) {

        if (numero == null) {
            //return "0.00";
            numero = 0.0;
        }

        Locale Local = new Locale("pt", "BR");
        DecimalFormat decimalFormat = new DecimalFormat(mascara, new DecimalFormatSymbols(Local));

        int tam = mascara.length();
        if (retornaEspaco) {
            return repete(" ", tam - decimalFormat.format(numero).length()) + decimalFormat.format(numero);
        } else {
            return decimalFormat.format(numero);
        }
    }

    //Numero inteiro=======================================================================
    public static String formatarNumero(Integer numero, String mascara) {

        if (numero == null) {
            return "0.00";
        }

        Locale Local = new Locale("pt", "BR");
        DecimalFormat decimalFormat = new DecimalFormat(mascara, new DecimalFormatSymbols(Local));

        int tam = mascara.length();
        return repete(" ", tam - decimalFormat.format(numero).length()) + decimalFormat.format(numero);
    }

    //Numero inteiro=======================================================================
    public static String formatarNumero(Integer numero, String mascara, boolean retornaEspaco) {

        if (numero == null) {
            return "0.00";
        }

        Locale Local = new Locale("pt", "BR");
        DecimalFormat decimalFormat = new DecimalFormat(mascara, new DecimalFormatSymbols(Local));

        int tam = mascara.length();
        if (retornaEspaco) {
            return repete(" ", tam - decimalFormat.format(numero).length()) + decimalFormat.format(numero);
        } else {
            return decimalFormat.format(numero);
        }
    }

    //Numero string =======================================================================
    public static String formatarNumero(String numero, String mascara) {
        return formatarGeral(numero, mascara);
    }

    //=======================================================================
    //completa com zeros não significativo um número decimal
    public static String strzero(Double numero, Integer quantidadeZeros) {

        String string = String.valueOf(numero).replace(".", "");

        while (string.length() < quantidadeZeros) {
            string = "0" + string;
        }
        return string;
    }

    //=======================================================================
    //completa com zeros não significativo um número inteiro
    public static String strzero(Integer numero, Integer quantidadeZeros) {

        String string = String.valueOf(numero).replace(".", "");

        while (string.length() < quantidadeZeros) {
            string = "0" + string;
        }
        return string;
    }

    //=======================================================================
    //completa com zeros não significativo um número inteiro
    public static String strzero(String numero, Integer quantidadeZeros) {

        String string = numero.replace(".", "");

        while (string.length() < quantidadeZeros) {
            string = "0" + string;
        }
        return string;
    }

    //=======================================================================
    public static String byteToHex(byte[] data) {

        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            Integer halfbyte = (data[i] >>> 4) & 0x0F;
            Integer two_halfs = 0;
            do {
                if ((0 <= halfbyte) && (halfbyte <= 9)) {
                    buf.append((char) ('0' + halfbyte));
                } else {
                    buf.append((char) ('a' + (halfbyte - 10)));
                }
                halfbyte = data[i] & 0x0F;
            } while (two_halfs++ < 1);
        }
        return buf.toString();
    }

    //==============================================
    public static String CalcCheckSum(String dado) {

        //posto
        //AA  -> checksum = 82
        //abc -> checksum = 294
        char b[] = dado.toCharArray(); //recurso tecnico p/ converter string para char
        Integer sum = 0; //soma os valores asci de cada char

        for (int i = 0; i < dado.length(); ++i) {
            sum += (int) b[i];  // cast para obter valor asci do char. Ex: A = 65
        }

        //converter a soma dos valores asci para hexadecimal
        String hexadecimal = Integer.toHexString(Integer.parseInt(String.valueOf(sum)));

        hexadecimal = hexadecimal.trim();

        //retorna as duas letras da string a direita
        String oQueMeInteressa = hexadecimal.substring(hexadecimal.length() - 2, hexadecimal.length());

        return oQueMeInteressa;
    }

    //=======================================================================
    void diferencaMeses() throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dataInicio = format.parse("01/01/2010");
        Date dataFim = format.parse("01/03/2010");

        /*
         * valor de um mes em milisegundos, sendo que os valores sao: 30 dias no
         * mes, 24 horas no dia, 60 minutos por hora, 60 segundos por minuto e
         * 1000 milisegundos
         */
        final double MES_EM_MILISEGUNDOS = 30.0 * 24.0 * 60.0 * 60.0 * 1000.0;
        //final double MES_EM_MILISEGUNDOS = 2592000000.0;
        double numeroDeMeses = (double) ((dataFim.getTime() - dataInicio.getTime()) / MES_EM_MILISEGUNDOS);

        //System.out.println("numero de meses: " + numeroDeMeses);
    }

    /*
     * Formata o campo numÃ©rico dos arquivos eletronicos de acordo com as
     * especificaÃ§Ãµes do ATO COTEPE
     */
    public static String formataNumero(Number valor, Integer tamanho, Integer decimais) {
        
        if (valor == null) {
            return repete("0", tamanho);
        } else {
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMaximumFractionDigits(decimais);
            nf.setMinimumFractionDigits(decimais);
            String strVal = nf.format(valor);
            strVal = strVal.replaceAll("\\.", "");
            strVal = strVal.replaceAll(",", "");
            strVal = repete("0", tamanho - strVal.length()) + strVal;
            return strVal.substring(0, tamanho);
        }
    }

    /**
     * Retorna uma string formatada de acordo com a configuração do sistema
     *
     * @param tipo Q para quantidade ou V para valor
     * @return string formatada
     */
    public static String formatoDecimal(String tipo, double valor) {
        int decimaisQuantidade = 3;
        int decimaisValor = 2;
        String mascara = "0.";
        if (tipo.equals("Q")) {
            for (int i = 0; i < decimaisQuantidade; i++) {
                mascara += "0";
            }
        } else if (tipo.equals("V")) {
            for (int i = 0; i < decimaisValor; i++) {
                mascara += "0";
            }
        }
        DecimalFormat formato = new DecimalFormat(mascara);
        return formato.format(valor);
    }

    /*
     * Formata o campo alfanumerico dos arquivos eletronicos de acordo com as especificações do ATO COTEPE
     */
    public static String formataString(String valor, String sequencia, Integer tamanho) {
        if (valor == null) {
            return repete(sequencia, tamanho);
        } else {
            valor = valor + repete(sequencia, tamanho - valor.length());
            return valor.substring(0, tamanho);
        }
    }

    /*
     * Formata o campo data dos arquivos eletronicos de acordo com as
     * especificações do ATO COTEPE
     */
    public static String formataData(Date data) {

        if (data != null) {
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
            return df.format(data).substring(0, 8);
        } else {
            return "        ";
        }
    }

    /*
     * Formata o campo hora dos arquivos eletronicos de acordo com as
     * especificaÃ§Ãµes do ATO COTEPE
     */
    public static String formataHora(Date hora) {
        SimpleDateFormat df = new SimpleDateFormat("HHmmSS");
        return df.format(hora).substring(0, 6);
    }

    //######################################################################
    //######################################################################
    public static String removerAcento() {

        String texto = "Av. Andrómêda, 2247 - SP";
        Pattern regra = Pattern.compile("[\\p{Alnum} ]");

        String saida = "";

        for (int i = 0; i < texto.length(); i++) {
            Matcher mt = regra.matcher(Character.toString(texto.charAt(i)));
            if (mt.matches()) {
                saida += mt.group();
            } else {
                if (!(Character.isLetter(texto.charAt(i)))) {
                    continue;
                }

                String aux = Character.toString(texto.charAt(i));
                boolean upperCaseFlag = false;

                if (Character.isUpperCase(aux.charAt(0))) {
                    upperCaseFlag = true;
                    aux = aux.toLowerCase();
                }

                aux = aux.replace('à', 'a');
                aux = aux.replace('è', 'e');
                aux = aux.replace('ì', 'i');
                aux = aux.replace('ò', 'o');
                aux = aux.replace('ù', 'u');

                aux = aux.replace('á', 'a');
                aux = aux.replace('é', 'e');
                aux = aux.replace('í', 'i');
                aux = aux.replace('ó', 'o');
                aux = aux.replace('ú', 'u');

                aux = aux.replace('â', 'a');
                aux = aux.replace('ê', 'e');
                aux = aux.replace('î', 'i');
                aux = aux.replace('ô', 'o');
                aux = aux.replace('û', 'u');

                aux = aux.replace('ã', 'a');
                aux = aux.replace('õ', 'o');

                aux = aux.replace('ä', 'a');
                aux = aux.replace('ë', 'e');
                aux = aux.replace('ï', 'i');
                aux = aux.replace('ö', 'o');
                aux = aux.replace('ü', 'u');

                aux = aux.replace('ç', 'c');

                if (upperCaseFlag) {
                    aux = aux.toUpperCase();
                }

                saida += aux;
            }
        }
        return saida;
    }

    //========================================================================
    public static String removerCaracteresEspeciais(String stringFonte) {

        //remove caracter especiais de uma string
        if (stringFonte == null) {
            return "";
        }

        String passa = stringFonte;

        passa = passa.replaceAll("[ÂÀÁÄÃ]", "A");
        passa = passa.replaceAll("[âãàáä]", "a");
        passa = passa.replaceAll("[ÊÈÉË]", "E");
        passa = passa.replaceAll("[êèéë]", "e");
        passa = passa.replaceAll("ÎÍÌÏ", "I");
        passa = passa.replaceAll("îíìï", "i");
        passa = passa.replaceAll("[ÔÕÒÓÖ]", "O");
        passa = passa.replaceAll("[ôõòóö]", "o");
        passa = passa.replaceAll("[ÛÙÚÜ]", "U");
        passa = passa.replaceAll("[ûúùü]", "u");
        passa = passa.replaceAll("Ç", "C");
        passa = passa.replaceAll("ç", "c");
        passa = passa.replaceAll("[ýÿ]", "y");
        passa = passa.replaceAll("Ý", "Y");
        passa = passa.replaceAll("ñ", "n");
        passa = passa.replaceAll("Ñ", "N");
        passa = passa.replaceAll("[-+=*&;%$#@!_]", "");
        passa = passa.replaceAll("['\"]", "");
        passa = passa.replaceAll("[<>()\\{\\}]", "");
        passa = passa.replaceAll("['\\\\.,()|/]", "");
        passa = passa.replaceAll("[^!-ÿ]{1}[^ -ÿ]{0,}[^!-ÿ]{1}|[^!-ÿ]{1}", " ");

        return passa;
    }

    //========================================================
    public String removerCaracteresEspeciais2(String string) {

        String testString = "120938H>?<E)(*l)(*L192L731O````W=-0O23423R2093820342L?><?>????D";

        String pattern = "[^A-Z]";

        String strippedString = testString.replaceAll(pattern, "");

        //System.out.println("Original String is:         "+testString);
        //System.out.println("After Replacing Characters: "+strippedString);
        string = Normalizer.normalize(string, Normalizer.Form.NFD);
        string = string.replaceAll("[^\\p{ASCII}]", "");

        return string;
    }

    /**
     * Cópia de arquivos por Stream.
     *
     * @param pOrigem arquivo de origem.
     * @param pDestino arquivo de destino.
     * @return nenhum.
     */
    public static void copyFile(File pOrigem, File pDestino) throws IOException {

        FileInputStream entradaCopy = new FileInputStream(pOrigem);
        FileOutputStream saidaCopy = new FileOutputStream(pDestino);

        // Transfere bytes da entrada para saida
        byte[] buf = new byte[1024];
        Integer len;
        while ((len = entradaCopy.read(buf)) > 0) {
            saidaCopy.write(buf, 0, len);
        }
        entradaCopy.close();
        saidaCopy.close();
    }

    /**
     * remove a mascara e carachter especiais de uma jTextFields númerico,
     * pronto para conversão númerica.
     *
     * @param texto string que sofrerá modificação.
     * @return nenhum.
     */
    public static String removerMascara(String texto) {

        if (texto == null) {
            texto = "";
        }

        texto = texto.replaceAll(":", "");
        texto = texto.replaceAll("[A-Z]", "");
        texto = texto.replaceAll("[a-z]", "");
        texto = texto.replaceAll("[ÂÀÁÄÃ]", "");
        texto = texto.replaceAll("[âãàáä]", "");
        texto = texto.replaceAll("[ÊÈÉË]", "");
        texto = texto.replaceAll("[êèéë]", "");
        texto = texto.replaceAll("ÎÍÌÏ", "");
        texto = texto.replaceAll("îíìï", "");
        texto = texto.replaceAll("[ÔÕÒÓÖ]", "");
        texto = texto.replaceAll("[ôõòóö]", "");
        texto = texto.replaceAll("[ÛÙÚÜ]", "");
        texto = texto.replaceAll("[ûúùü]", "");
        texto = texto.replaceAll("Ç", "");
        texto = texto.replaceAll("ç", "");
        texto = texto.replaceAll("[ýÿ]", "");
        texto = texto.replaceAll("Ý", "");
        texto = texto.replaceAll("ñ", "");
        texto = texto.replaceAll("Ñ", "");
        texto = texto.replaceAll("[-+=*&amp;%$#@!_]", "");
        texto = texto.replaceAll("['\"]", "");
        texto = texto.replaceAll("[<>()\\{\\}]", "");
        texto = texto.replaceAll("['\\\\.()|/]", "");
        texto = texto.replaceAll("[^!-ÿ]{1}[^ -ÿ]{0,}[^!-ÿ]{1}|[^!-ÿ]{1}", "");

        //GERAR CASAS DECIMAIS
        texto = texto.replaceAll(",", ".");

        return texto;
    }

    //==================================================================================
    public static Double removerMascara(javax.swing.JFormattedTextField campo) {

        double qtde = 0.0;

        if (campo.getText() == null || campo.getText().isEmpty()) {
            return qtde;
        } else {

            try {

                String strQuantidade = campo.getText();

                strQuantidade = strQuantidade.replace(".", "");
                strQuantidade = strQuantidade.replace(",", ".");

                qtde = Double.valueOf(strQuantidade);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Valor informado inválido", Constantes.AVISO_SISTEMA, JOptionPane.INFORMATION_MESSAGE);
            }

            return qtde;
        }
    }

    //===============================================================================
    public static void salvarPrintstack(String nomeArquivo, Exception e) {

        File file = new File(nomeArquivo);
        //File file = new File("C:\\teste.txt");

        try {

            PrintStream ps = new PrintStream(file);
            e.printStackTrace(ps);
            ps.close();

            //System.out.println("Erro salvo em: "+file);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro:" + ex.getMessage(), Constantes.AVISO_SISTEMA, JOptionPane.INFORMATION_MESSAGE);
            ex.printStackTrace();
        }
    }

    //=============================================================================
    public static void capturarImagemItem(javax.swing.JPanel panelImagem, String nomeArquivo) {

        //exibe a imagem do item selecionado na tela
        File f;
        BufferedImage tmpImagen = null;
        try {
            //labelImagemItemSelecionado.setIcon(new javax.swing.ImageIcon(getClass().getResource(nomeArquivo))); // NOI18N
            //f = new File(getClass().getResource(nomeArquivo).getFile());
            f = new File(nomeArquivo);
            tmpImagen = ImageIO.read(f);
        } catch (Exception e) {

            //imagem padrao do item: logomarca da empresa
            try {
                //labelImagemItemSelecionado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/itens/itemPadrao.jpg"))); // NOI18N
                //f = new File(getClass().getResource(Constantes.ITEM_PADRAO).getFile());
                //f = new File(Constantes.ITEM_PADRAO);

                //tmpImagen = ImageIO.read(f);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Imagem do 'Item Padrão'não encontrado. Verifique!!!", Constantes.AVISO_SISTEMA, JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }

        ImagemFundoPanel fondo = new ImagemFundoPanel(tmpImagen);
        panelImagem.setBorder(fondo);
    }

    //===================================================================
    /**
     * Ao contrário do que muitos pensam, é possível criptografar um texto e
     * descriptografá-lo em seguida e o melhor é que existe uma biblioteca que
     * nos permite fazê-lo de forma rápida, simples e objetiva. Todos sabem que
     * criar um algoritmo para criptografia não é nada simples e se pensarmos em
     * descriptografar o que criptografamos, este algoritmo ficaria mais
     * complicado ainda, porém encontramos esta biblioteca que nos permite
     * fazê-lo de forma muito simples. Primeiro baixe a biblioteca Jasypt:
     * http://www.jasypt.org/
     *
     * A primeira coisa é instanciar a classe BasicTextEncryptor
     * (org.jasypt.util.text.BasicTextEncryptor):
     *
     * BasicTextEncryptor bte = new BasicTextEncryptor();
     *
     * Em posse da instância de BasicTextEncryptor, basta utilizar seus métodos:
     * setPassword(String password) decrypt(String encryptedMessage)
     * encrypt(String message)
     *
     * @param textoSemCriptografia
     * @return
     */
    public static String Encriptar(String textoSemCriptografia) {

        //System.out.println("Texto sem criptografia: " + textoSemCriptografia);
        //instanciamos a classe BasicTextEncryptor
        BasicTextEncryptor bte = new BasicTextEncryptor();

        //inserimos uma senha qualquer: A senha que voce quizer
        bte.setPassword("meUDEus!!!");

        //criamos uma String que recebe a senha criptografada
        String textoComCriptografia = bte.encrypt(textoSemCriptografia);
        //System.out.println("Seu texto criptografado = " + textoComCriptografia);

        return textoComCriptografia;
    }

    //===================================================================
    /**
     * Ao contrário do que muitos pensam, é possível criptografar um texto e
     * descriptografá-lo em seguida e o melhor é que existe uma biblioteca que
     * nos permite fazê-lo de forma rápida, simples e objetiva. Todos sabem que
     * criar um algoritmo para criptografia não é nada simples e se pensarmos em
     * descriptografar o que criptografamos, este algoritmo ficaria mais
     * complicado ainda, porém encontramos esta biblioteca que nos permite
     * fazê-lo de forma muito simples. Primeiro baixe a biblioteca Jasypt:
     * http://www.jasypt.org/
     *
     * A primeira coisa é instanciar a classe BasicTextEncryptor
     * (org.jasypt.util.text.BasicTextEncryptor):
     *
     * BasicTextEncryptor bte = new BasicTextEncryptor();
     *
     * Em posse da instância de BasicTextEncryptor, basta utilizar seus métodos:
     * setPassword(String password) decrypt(String encryptedMessage)
     * encrypt(String message)
     *
     * @param textoSemCriptografia
     * @return
     */
    public static String Descriptografar(String textoComCriptografia) {

        //instanciamos a classe BasicTextEncryptor
        BasicTextEncryptor bte = new BasicTextEncryptor();

        //inserimos uma senha qualquer: A senha que voce quizer
        bte.setPassword("meUDEus!!!");

        //criamos uma String que recebe a senha descriptografada
        String textoSemCriptografia = bte.decrypt(textoComCriptografia);
        //System.out.println("Texto descriptografado  = " + textoSemCriptografia);

        return textoSemCriptografia;
    }

    //==================================================================
    public static String primeiroDiaMes(Integer Ano, Integer Mes) {

        Calendar cal = new GregorianCalendar(Ano, Mes - 1, 1);

        //String data = Ano.toString() + '/' + Mes.toString() + '/' + cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        return Biblioteca.strzero(cal.getActualMinimum(Calendar.DAY_OF_MONTH), 2);
    }

    //==================================================================
    public static String ultimoDiaMes(Integer Ano, Integer Mes) {

        Calendar cal = new GregorianCalendar(Ano, Mes - 1, 1);
        //String data = Ano.toString() + '/' + Mes.toString() + '/' + cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        return Biblioteca.strzero(cal.getActualMaximum(Calendar.DAY_OF_MONTH), 2);
    }

    //========================================================================
    public static Double truncar(Double f, int numLength) {

        String x = f.toString();
        x = x + "00"; //caso tenha apenas 1 casa depois da virgula
        x = x.toString().substring(0, x.indexOf(".") + (1 + numLength));
        return Double.valueOf(x);
    }

    //========================================================================
    public static String truncar2(Double num, int numLength) {

        String stringDouble = String.valueOf(num);
        int iPoint = stringDouble.indexOf(".");
        int iMore = stringDouble.length() - (iPoint + numLength + 1);

        if (iMore < 0) {
            for (int i = 0; i < (-iMore); i++) {
                stringDouble = stringDouble + "0"; //caso tenha apenas 1 casa depois da virgula
            }
        } else {
            stringDouble = stringDouble.substring(0, iPoint + numLength + 1);
        }

        return stringDouble;
    }

    //==========================================================================
    public static boolean tuplaAdulterada(String atributos, String composicaoTluplas) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        boolean tudoOk = false;
        String converteMd5;

        if (atributos == null || composicaoTluplas == null) {
            tudoOk = true;
        } else {

            converteMd5 = Biblioteca.MD5String(atributos);

            if (!converteMd5.equals(composicaoTluplas)) {
                tudoOk = true; //registro foi alterado no banco de dados
            }
        }

        return tudoOk;
    }

    public static boolean criarPasta(String nomePasta) {

        // Verificar a existência de um (sub)diretório, senao existir cria.
        boolean tudoOk = false;

        File pasta = new File(nomePasta); // pasta a ser verificada
        if (!pasta.exists()) {

            tudoOk = pasta.mkdirs(); //mkdir() cria somente um diretório, mkdirs() cria diretórios e subdiretórios.

            if (tudoOk) {
                System.out.println("Diretorio criado com sucesso!");
            } else {
                System.out.println("Erro ao criar diretorio!");

                JOptionPane.showMessageDialog(null, "\n Ops! Falha ao criar a pasta:"
                        + "\n "
                        + "\n " + nomePasta
                        + "\n "
                        + "", Constantes.AVISO_SISTEMA, JOptionPane.INFORMATION_MESSAGE);
            }

        } else {
            //System.out.println("Diretório já existente");
            tudoOk = true;
        }

        return tudoOk;
    }

    public static boolean soContemNumeros(String texto) {
        if (texto == null) {
            return false;
        }
        for (char letra : texto.toCharArray()) {
            if (letra < '0' || letra > '9') {
                return false;
            }
        }
        return true;
    }

    public static boolean soContemNumeros2(String texto) {
        return texto.matches("[0-9]");
    }

    public static Double arredondar(Double valor, int casaDecimal) {

        double aux = Double.valueOf('1' + repete("0", casaDecimal));
        return (Math.round((valor * aux))) / aux;

    }

    public static void criarTabelas(Statement stmt) throws SQLException {

        /* Comandos sql para criação das tabelas */
        final String TB_MEM_MEMBRO
                = "CREATE TABLE TB_MEM_MEMBRO ("
                + "MEM_CD_MEMBRO VARCHAR(10) NOT NULL,"
                + "MEM_NM_MEMBRO VARCHAR(50) NOT NULL, "
                + "MEM_EMAIL VARCHAR(50) NOT NULL UNIQUE,"
                + "MEM_SENHA VARCHAR(10) NOT NULL,"
                + "PRIMARY KEY (MEM_CD_Membro)"
                + ");";
        try {
            /* Executando comandos sql de atualização */
            stmt.executeUpdate(TB_MEM_MEMBRO);

            System.out.println(TB_MEM_MEMBRO);
            System.out.println("<<<<< TABELAS CRIADAS >>>>>");

        } catch (SQLException sqle) {
            throw new SQLException("Erro na criaçao das tabelas : "
                    + "getMessage()   = " + sqle.getMessage()
                    + "\ngetErrorCode() = " + sqle.getErrorCode());
        }
    }
    
    public static void imprimeVenda(String numeroCaixa, int idVenda) throws SQLException, ClassNotFoundException, IOException, Exception {

        File f = new File("./relatorios/VENDA.jasper");
        if (!f.exists()) {
            JOptionPane.showMessageDialog(null,
                    "Relatorio de venda não encontrado.\n"
                    + " Entre em contato com Suporte Técnico.\n"
                    + " Obrigado!", Constantes.AVISO_SISTEMA, JOptionPane.ERROR_MESSAGE);
            return;
        }

        //----------------------------------------
        String NOME_EMPRESA = (Caixa.empresasBean == null || Caixa.empresasBean.getNomeempr() == null) ? "X2 Lançamento LTDA" : Caixa.empresasBean.getNomeempr();
        String CNPJ_EMPRESA = (Caixa.empresasBean == null || Caixa.empresasBean.getCgc() == null) ? "123456789.12345678" : Caixa.empresasBean.getCgc();
        String END_EMPRESA = (Caixa.empresasBean == null || Caixa.empresasBean.getEndereco() == null) ? "Avendida do Contorno, 102" : Caixa.empresasBean.getEndereco();
        String CIDADE_EMPRESA = "Contagem";
        String BAIRRO_EMPRESA = (Caixa.empresasBean == null || Caixa.empresasBean.getBairro() == null) ? "Industrial" : Caixa.empresasBean.getBairro();
        String NOME_VENDEDOR = "Bruno Maya";
        String FONE_EMPRESA = (Caixa.empresasBean == null || Caixa.empresasBean.getTelefone() == null) ? "31 3265-1545" : Caixa.empresasBean.getTelefone();

        //----------------------------------------
        ImageIcon icone = new javax.swing.ImageIcon(Constantes.SH_ICONE);
        HashMap parametros = new HashMap();
        parametros.put("NOME_EMPRESA", NOME_EMPRESA);
        parametros.put("CNPJ_EMPRESA", CNPJ_EMPRESA);
        parametros.put("END_EMPRESA", END_EMPRESA);
        parametros.put("CIDADE_EMPRESA", CIDADE_EMPRESA);
        parametros.put("BAIRRO_EMPRESA", BAIRRO_EMPRESA);
        parametros.put("NOME_VENDEDOR", NOME_VENDEDOR);
        parametros.put("FONE_EMPRESA", FONE_EMPRESA);

        //-----------------------------------------
        parametros.put("ID_CAIXA", numeroCaixa);
        parametros.put("ID_VENDA", idVenda);

        try {

            //ABRIR CONEXAO COM BANCO
            Conectar acessoServidor = new Conectar();
            Connection conn = new Conectar().conectar();

            //*****************************************************************
            // compilacao do JRXML 
            //JasperReport print = JasperCompileManager.compileReport("./relatorios/DAV.jrxml");
            // preenchimento do relatorio, note que o metodo recebe 3 parametros: 
            // 1 - o relatorio 
            // 
            // 2 - um Map, com parametros que sao passados ao relatorio 
            // no momento do preenchimento. No nosso caso eh null, pois nao 
            // estamos usando nenhum parametro 
            // 
            // 3 - o data source. Note que nao devemos passar a lista diretamente, 
            // e sim "transformar" em um data source utilizando a classe 
            // JRBeanCollectionDataSource 
            //
            //==========================================
            //capturar nome impressora padrao
            //PrintService service = PrintServiceLookup.lookupDefaultPrintService();
            //System.out.println(service.getName());
            if (Caixa.ConfiguracaoBean.getModoImpremeVenda().equals("0")) {

                //JasperPrint print = JasperFillManager.fillReport("./relatorios/VENDA.jasper", parametros, conn);
                ////JasperExportManager.exportReportToPdfFile(print, "RelatorioClientes.pdf"); //exportacao do relatorio para outro formato, no caso PDF 
                //JasperViewer jv = new JasperViewer(print, false);
                //jv.setTitle("Relatorio de Venda");
                ////jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
                //jv.setIconImage(icone.getImage());
                //jv.toFront();
                //jv.requestFocus();
                //jv.setVisible(true);
                //jv.toFront();
                //**************************************************************
                //É só você adicionar o relatório jasper em um JDialog, 
                //ae o relatório vai ficar dentro do JDialog e ele vai ser modal 
                //e vai aparecer na frente de todas as telas. A solução que eu achei na internet foi essa.
                JDialog viewer = new JDialog(new javax.swing.JFrame(), true);
                viewer.setTitle("Visualização do Relatório");
                viewer.setSize(1024, 768);
                viewer.setLocationRelativeTo(null);
                viewer.setIconImage(icone.getImage());
                viewer.requestFocus();
                viewer.toFront();

                JasperPrint jasperPrint = JasperFillManager.fillReport("./relatorios/VENDA.jasper", parametros, conn);
                JasperViewer jrViewer = new JasperViewer(jasperPrint, true);
                viewer.getContentPane().add(jrViewer.getContentPane());
                viewer.setVisible(true);

            } else if (Caixa.ConfiguracaoBean.getModoImpremeVenda().equals("1")) {

                JasperPrint print = JasperFillManager.fillReport("./relatorios/VENDA.jasper", parametros, conn);
                JasperPrintManager.printPage(print, 0, true); //aparece caixa de opcoes de impressoras no sistema.

            } else if (Caixa.ConfiguracaoBean.getModoImpremeVenda().equals("2")) { //2 impressao direta

                //----------------                
                JasperPrint print = JasperFillManager.fillReport("./relatorios/VENDA.jasper", parametros, conn);
                //JasperPrintManager.printPage(print, 0, true); //aparece caixa de opcoes de impressoras no sistema.

                try {
                    //caso usuario cancele vai gerar uma excessao
                    JasperPrintManager.printPage(print, 0, false);  //manda direto para impressora padrao. Se nao tiver salva em arquivo
                } catch (Exception e) {
                }
            }

            //FECHAR CONEXAO COM BANCO -------------------------------------
            acessoServidor.desconectar();

        } catch (Exception ex) {
            Loggin.logDiarioExcecao(ex, true);
        }
    }

    public static void imprimeOrcamento(int idOrca) throws SQLException, ClassNotFoundException, IOException, Exception {

        File f = new File("./relatorios/ORCAMENTO.jasper");
        if (!f.exists()) {
            JOptionPane.showMessageDialog(null,
                    "Relatorio de orçamento não encontrado.\n"
                    + " Entre em contato com Suporte Técnico.\n"
                    + " Obrigado!", Constantes.AVISO_SISTEMA, JOptionPane.ERROR_MESSAGE);
            return;
        }

        ImageIcon icone = new javax.swing.ImageIcon(Constantes.SH_ICONE);
        HashMap parametros = new HashMap();
        parametros.put("NOME_EMPRESA", Caixa.empresasBean.getNomeempr());
        parametros.put("CNPJ_EMPRESA", Caixa.empresasBean.getCgc());
        parametros.put("ID_ORCA", idOrca);

        try {

            //ABRIR CONEXAO COM BANCO
            Conectar acessoServidor = new Conectar();
            Connection conn = new Conectar().conectar();

            //*****************************************************************
            // compilacao do JRXML 
            //JasperReport print = JasperCompileManager.compileReport("./relatorios/DAV.jrxml");
            // preenchimento do relatorio, note que o metodo recebe 3 parametros: 
            // 1 - o relatorio 
            // 
            // 2 - um Map, com parametros que sao passados ao relatorio 
            // no momento do preenchimento. No nosso caso eh null, pois nao 
            // estamos usando nenhum parametro 
            // 
            // 3 - o data source. Note que nao devemos passar a lista diretamente, 
            // e sim "transformar" em um data source utilizando a classe 
            // JRBeanCollectionDataSource 
            //
            //==========================================
            //capturar nome impressora padrao
            //PrintService service = PrintServiceLookup.lookupDefaultPrintService();
            //System.out.println(service.getName());
            if (Caixa.ConfiguracaoBean.getModoImpremeVenda().equals("0")) {

                //JasperPrint print = JasperFillManager.fillReport("./relatorios/VENDA.jasper", parametros, conn);
                ////JasperExportManager.exportReportToPdfFile(print, "RelatorioClientes.pdf"); //exportacao do relatorio para outro formato, no caso PDF 
                //JasperViewer jv = new JasperViewer(print, false);
                //jv.setTitle("Relatorio de Venda");
                ////jv.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
                //jv.setIconImage(icone.getImage());
                //jv.toFront();
                //jv.requestFocus();
                //jv.setVisible(true);
                //jv.toFront();
                //**************************************************************
                //É só você adicionar o relatório jasper em um JDialog, 
                //ae o relatório vai ficar dentro do JDialog e ele vai ser modal 
                //e vai aparecer na frente de todas as telas. A solução que eu achei na internet foi essa.
                JDialog viewer = new JDialog(new javax.swing.JFrame(), true);
                viewer.setTitle("Visualização do Relatório");
                viewer.setSize(1024, 768);
                viewer.setLocationRelativeTo(null);
                viewer.setIconImage(icone.getImage());
                viewer.requestFocus();
                viewer.toFront();

                JasperPrint jasperPrint = JasperFillManager.fillReport("./relatorios/ORCAMENTO.jasper", parametros, conn);
                JasperViewer jrViewer = new JasperViewer(jasperPrint, true);
                viewer.getContentPane().add(jrViewer.getContentPane());
                viewer.setVisible(true);

            } else if (Caixa.ConfiguracaoBean.getModoImpremeVenda().equals("1")) {

                JasperPrint print = JasperFillManager.fillReport("./relatorios/ORCAMENTO.jasper", parametros, conn);
                JasperPrintManager.printPage(print, 0, true); //aparece caixa de opcoes de impressoras no sistema.

            } else if (Caixa.ConfiguracaoBean.getModoImpremeVenda().equals("2")) { //2 impressao direta

                //----------------                
                JasperPrint print = JasperFillManager.fillReport("./relatorios/ORCAMENTO.jasper", parametros, conn);
                //JasperPrintManager.printPage(print, 0, true); //aparece caixa de opcoes de impressoras no sistema.

                try {
                    //caso usuario cancele vai gerar uma excessao
                    JasperPrintManager.printPage(print, 0, false);  //manda direto para impressora padrao. Se nao tiver salva em arquivo
                } catch (Exception e) {
                }
            }

            //FECHAR CONEXAO COM BANCO -------------------------------------
            acessoServidor.desconectar();

        } catch (Exception ex) {
            Loggin.logDiarioExcecao(ex, true);
        }
    }

    
}