/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.genesis.util;

import java.io.Serializable;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.html.HtmlGraphicImage;
import org.primefaces.component.dialog.Dialog;

/**
 *
 * @author orlando
 */
@ManagedBean(name = "util")
@ApplicationScoped
public class UtilidadesVarias implements Serializable {

    //<editor-fold defaultstate="collapsed" desc="Variables">  
    //Variable para mensajes del dialogo
    private StringBuilder msg = new StringBuilder();
    //Componente para mostrar las imagenes de alerta(ok,warning,error)
    private HtmlGraphicImage imgPopUp = new HtmlGraphicImage();
    //Componente para dibujar la alerta
    private Dialog popUpDialMsg = new Dialog();

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public StringBuilder getMsg() {
        return msg;
    }

    public void setMsg(StringBuilder msg) {
        this.msg = msg;
    }

    public HtmlGraphicImage getImgPopUp() {
        return imgPopUp;
    }

    public void setImgPopUp(HtmlGraphicImage imgPopUp) {
        this.imgPopUp = imgPopUp;
    }

    public Dialog getPopUpDialMsg() {
        return popUpDialMsg;
    }

    public void setPopUpDialMsg(Dialog popUpDialMsg) {
        this.popUpDialMsg = popUpDialMsg;
    }

    //<editor-fold defaultstate="collapsed" desc="Metodos"> 
    /**
     * Metodo que permite administrar un popup para mostrar mensajes al usuario,
     * tiene 3 niveles de alertas a saber: ok (todo se hizo correcto),
     * cuidado(alguna validacion es requerida)y error(no se completo la tarea)
     *
     * @param msg String que almacenara el texto del mensaje
     * @param severity Entero que determinara que icono mostrar en el dialogo
     * @throws Exception Error generico
     */
    public final void alerta(final StringBuilder msg, final int severity) {
        this.msg = msg;
        if (severity == 1) {
            imgPopUp.setUrl("/resources/imgs/ok.png");
        }
        if (severity == 2) {
            imgPopUp.setUrl("/resources/imgs/warning.png");
        }
        if (severity == 3) {
            imgPopUp.setUrl("/resources/imgs/error.jpg");
        }
        popUpDialMsg.setVisible(true);
    }

    /**
     * Permite cerrar el dialogo de los mensajes de alerta
     *
     * @throws Exception Error generico
     */
    public final void btnCerrarDialog() throws Exception {
        popUpDialMsg.setVisible(false);
    }
    

    /**
     * Creates a new instance of UtilidadesVarias
     */
    public UtilidadesVarias() {
    }

}
