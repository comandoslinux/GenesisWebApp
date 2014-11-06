/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.genesis.util;

import javax.faces.context.FacesContext;

/**
 *
 * @author orlando
 */
public class Util {

    public static <T> T buscarBean(String nombreBean) {
        FacesContext context = FacesContext.getCurrentInstance();
        return (T) context.getApplication().evaluateExpressionGet(context, "#{" + nombreBean + "}", Object.class);
    }
}
