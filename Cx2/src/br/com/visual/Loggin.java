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
//*******************************************************************************************************

/*
 P E R G U N T A:
 Como capturar a sa�da padr�o de uma aplica��o em um arquivo?

 R E S P O S T A:
 *
 Fonte: http://www.oocities.org/br/java_io/jfaq0096.html

 é possível capturar as saídas padrão (standard out e standard error) gravando-as em arquivos,
 o que pode ser útil para auxiliar a depuração de aplicações que apresentem problemas ou
 simplesmente gravar resultados apresentados na saída padrão.
 O código exemplificado abaixo, que pode ser adicionado aos programas que devem realizar tal operação,
 mostra como efetuar a gravação da saída padrão através do uso de dois métodos estáticos:

 - startLog() e
 - stopLog()

 Ambos disponíveis na classe Logging cujo código é dado a seguir.
 O método startLog() cria um novo arquivo de registro (log file) ou esvazia um arquivo existente iniciando
 a cópia dos caracteres enviados para a saída padrão para o arquivo. Acionando-se o método stopLog()
 o arquivo de registro é fechado e o comportamento normal da saída padrão é restaurado.

 //--------------------------------------------------------------------------------------------------

 O método startLog() inicialmente salva as saídas padrão e de erro corrente, as quais serão restauradas pelo método stopLog().
 Depois o arquivo de registro aberto e limpo se existir senão criado. Finalmente os métodos System.setOut() e System.setErr() s o chamados
 para substituir as saídas padrão pela nova saída representada pela classe Logging. O método stopLog() também fecha o arquivo de registro.
 A classe Logging, uma subclasse de java.io.PrintStream, que embora marcada como classe deprected, uma boa alternativa para a tarefa proposta.
 A compilação deve ser feita usando-se a flag -deprecated.

 javac -deprecated Loggin.java

 A classe Logging atua como um desviador pois ao mesmo tempo que os caracteres são enviados às saídas padrão também são enviados ao arquivo de registro.
 Isto se faz através da sopreposição (override) de dois métodos write() de sua superclasse.

 A implementação deste comportamento se primeiramente enviando os caracteres para o arquivo de registro e depois,
 usando o método das superclasse, para às saidas padrão. Os métodos write() não geram exceções, indicando situações
 de erro através do método setError(). A aplicação pode verificar a ocorrência de erros através do método checkError().

 ===================================================================================================================
 ==> Para testarmos a classe Logging dada sugerimos o seguinte programa, onde

 public class LoggingTest {
 public static void main(String[] args) {
 try {
 // Inicia grava��o
 Logging.startLog("log.txt");

 // Produz sa�das diversas
 System.out.println("Uma string de teste:\nABCDEFGHIJKLMNOPQRSTUVXWYZ");
 System.err.println("Testanto sa�da de erros...\nFALSO ERRO!");
 System.out.println("Teste de excecao:");
 new Exception().printStackTrace();
 } catch (Exception e) {
 e.printStackTrace();
 } finally {
 // Encerra grava��o
 Logging.stopLog();
 }
 }
 }

 ==========================================================================================================================
 Finalmente  é importante destacar que os métodos sugeridos acima produzem mensagens sobre o uso de caracter�sticas deprecated
 quando compilados, no caso o uso do construtor da classe PrintStream sendo sugerida a substitução pelo
 equivalente da classe PrintWriter. Isto não pode ser feito no caso do redirecionamento das saédas e entrada padrões,
 sendo necessario convivermos com tal aviso do Java.
 */
import br.com.controle.Controle;
import java.io.*;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

public class Loggin extends PrintStream {

    static OutputStream logfile;
    static PrintStream oldStdout;
    static PrintStream oldStderr;
    static Controle controle = new Controle();

    // Construtor
    Loggin(PrintStream ps) {
        super(ps);
    }

    // Inicia cópia da saída padrão para o arquivo "arq" especificado
    public static void startLog(String arq) throws IOException {

        // Salva saídas originais
        oldStdout = System.out;
        oldStderr = System.err;

        // Cria/abre arquivo de registro
        logfile = new PrintStream(new BufferedOutputStream(new FileOutputStream(arq)));

        // Inicia redirecionamento da saída
        System.setOut(new Loggin(System.out));
        System.setErr(new Loggin(System.err));
    }

    // Fecha arquivo de registro e
    // restaura saídas padrão
    public static void stopLog() {
        System.setOut(oldStdout);
        System.setErr(oldStderr);
        try {
            logfile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Substituição de método write
    // (PrintStream.write override)
    @Override
    public void write(int b) {
        try {
            logfile.write(b);
        } catch (IOException e) {
            e.printStackTrace();
            setError();
        }
        super.write(b);
    }

    // Substituiçãoo de método write
    // (PrintStream.write override)
    @Override
    public void write(byte buf[], int off, int len) {
        try {
            logfile.write(buf, off, len);
        } catch (IOException e) {
            e.printStackTrace();
            setError();
        }
        super.write(buf, off, len);
    }

    //==========================================================================
    public static void logDiarioExcecao(Object objeto, boolean mostrarUsuario) {

        Exception e = null;

        if (objeto instanceof Exception) {
            e = ((Exception) objeto);
        }

        if (objeto instanceof Throwable) {
            e = ((Exception) objeto);
        }

        e.printStackTrace(); //pra eu ver o erro enquanto programo, senao só sai em arquivo

        if (!Biblioteca.criarPasta(Constantes.PASTA_LOG)) {
            return;
        }

        String nomeArquivoLog = Constantes.PASTA_LOG + "\\";
        nomeArquivoLog += Biblioteca.dataAtual(3);
        nomeArquivoLog = nomeArquivoLog.replaceAll("-", "_") + ".HTML";

        final Logger logger = Logger.getLogger("LOG DE EXCECOES"); //categoria       

        //os níveis podem ser: INFO, DEBUG, WARN, ERROR, FATAL, ALL e OFF.
        //logger.info("Roteiro do Erro: ", e); //mensagem
        logger.error("Roteiro do Erro: ", e); //mensagem        

        if (mostrarUsuario) {
            gravarExecessao(objeto);
        }
    }

    //=================================================
    public static void gravarExecessao(Object objeto) {

        Exception e = null;

        if (objeto instanceof Exception) {
            e = ((Exception) objeto);
        }
        /*Para a customização é de fundamental importância o nome dado ao logger,
         neste caso o nome acaba sendo o nome da própria classe acrescido do seu pacote
         completo (log.exemplo.configuracao.SuaClasse).*/

        //Logger.getLogger(Caixa.class.getName()).log(Level.SEVERE, null, ex);
        //Nome do arquivo de gravação da execessao, o nome é composto pelo: dia, mes, ano, horas, minutos e segundos.
        if (!Biblioteca.criarPasta(Constantes.PASTA_LOG)) {
            return;
        }

        String nomeArquivoLog = Constantes.PASTA_LOG + "\\";
        nomeArquivoLog += Biblioteca.dataExtenso();
        nomeArquivoLog += " ";
        nomeArquivoLog += Biblioteca.horaAtual(5) + "Hs ";
        nomeArquivoLog += Biblioteca.horaAtual(6) + "Min ";
        nomeArquivoLog += Biblioteca.horaAtual(7) + "Seg";
        nomeArquivoLog += ".TXT";

        //==================================================================
        //carregamento das parametrizacoes do sistema configuradas
        try {

            //============================================================================
            //A B R I R    L O G
            //============================================================================
            Loggin.startLog(nomeArquivoLog); //desvia a saida p/ arquivo

            e.printStackTrace(); //pilha de erro para ser impresso no arquivo de texto

            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++ OUTRAS INFORMACOES +++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("");
            System.out.println("");

            //=================================================================
            StackTraceElement[] element = e.getStackTrace();

            String s = e.getClass().toString();

            //imprime a classe da exception sem o "class "
            System.out.println("\n" + s);             //System.out.println("\n" + s.substring(6, s.length()));
            for (StackTraceElement o : element) {
                System.out.println("   at " + o.getClassName()
                        + "." + o.getMethodName()
                        + "(" + o.getFileName()
                        + ":" + o.getLineNumber() + ")");
            }

            //=============================================================================
            JOptionPane.showMessageDialog(null, "Ocorreu uma falha é não consigo resolver."
                    + "\n"
                    + "\n Falha: " + e.getMessage()
                    + "\n", Constantes.AVISO_SISTEMA, JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, 
                    "O sistema está sem permissão para leitura e escrita na unidade: C:\\"
                    + "Será encerrado, entre em contato com  World System."
                    + "\n"
                    + "\n Detalhe do erro: " + ex.getMessage()
                    + "\n", Constantes.AVISO_SISTEMA, JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);

        } finally {

            //============================================================================
            //fechar gravacao de erro no arquivo, como se trata de um erro.
            //Talvez seja melhor nem usá-la na clausula finaliy, pois o sistema vai sair do ar mesmo
            //============================================================================
            Loggin.stopLog();
        }
    }
}
