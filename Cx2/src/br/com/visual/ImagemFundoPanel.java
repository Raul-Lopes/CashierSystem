package br.com.visual;

/**
 * <p>Title: Infocus ERP - Projeto Acadêmico</p>
 * @version	versão
 * @param	parâmetro do método
 * @return	retorno do método
 * @exception	exceção
 * @see	veja também
 *
 * <p>Class Description: Atributos de leitura de abastecimentos da placa da bomba de combustível.</p>
 *
 * <p>The MIT License</p>
 * <p>Copyright: Copyright (C) 2011 Raul Lopes</p>
 *
 * @author	<p>Raul Lopes
 *        The author may be contacted at:
 *           raul.lagoa@gmail.com</p>
 *
 */

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import javax.swing.border.Border;


//========================================================================
public class ImagemFundoPanel implements Border {

    BufferedImage mImagen = null;

    public ImagemFundoPanel(BufferedImage pImagen) {
        mImagen = pImagen;
    }

    //================================================================================
    public void paintBorder(Component c, Graphics g, int  x, int  y, int  width, int height) {

        if (mImagen != null) {
            g.drawImage(mImagen, 0, 0, width, height, null);
        }
    }

    public Insets getBorderInsets(Component c) {

        return new Insets(0, 0, 0, 0);
    }

    //================================================================================
    public boolean isBorderOpaque() {
        return true;
    }
}



