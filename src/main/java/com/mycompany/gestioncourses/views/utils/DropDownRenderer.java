/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestioncourses.views.utils;

import java.awt.Component;
import java.util.function.Function;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 *
 * @author Emilie
 */
public class DropDownRenderer<T> extends DefaultListCellRenderer {

    private final Function<T, String> getter;
    
    public DropDownRenderer(Function<T, String> getter) {
        this.getter = getter;
    }
    
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean selected, boolean hasFocus) {
        String toDisplay = value == null
                ? "Aucun choix"
                : this.getter.apply((T) value);
        return super.getListCellRendererComponent(list, toDisplay, index, selected, hasFocus);
    }
}
