package br.com.visual;

/**
 *
 * @author Raul Lopes 09/03/2011 - Desenvolvimento da primeira versÃ£o.
 */
public enum StatusCaixa {

    LIVRE { // 0-pronto para emitir venda

                @Override
                public String toString() {
                    return "0";
                }
            },
    DESATIVADO { //1-modo desativado

                @Override
                public String toString() {
                    return "1";
                }
            },
    VENDA_NORMAL { //2-venda normal em andamento

                @Override
                public String toString() {
                    return "2";
                }
            },
    ORCAMENTO {

                @Override
                public String toString() {
                    return "3";
                }
            }
}
