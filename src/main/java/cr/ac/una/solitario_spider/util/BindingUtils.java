/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.solitario_spider.util;

import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author JOHAN
 */
public final class BindingUtils
{

    static ChangeListener<Toggle> miEscuchador = new ChangeListener<Toggle>()
    {
        @Override
        public void changed(ObservableValue<? extends Toggle> observable, Toggle valorAnterior, Toggle valorNuevo)
        {
           
        }
    };

    
    private BindingUtils()
    {
    }

    public static <T> void bindToggleGroupToProperty(final ToggleGroup grupo, final ObjectProperty<T> propiedad)
    {
       
        for (Toggle toggle : grupo.getToggles())
        {
            if (toggle.getUserData() == null)
            {
                throw new IllegalArgumentException("¡Hay un botón sin datos en el ToggleGroup!");
            }
        }

        
        for (Toggle toggle : grupo.getToggles())
        {
            if (propiedad.getValue() != null && propiedad.getValue().equals(toggle.getUserData()))
            {
                grupo.selectToggle(toggle);
                break;
            }
        }

       
        miEscuchador = new ChangeListener<Toggle>()
        {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle anterior, Toggle nuevo)
            {
                propiedad.setValue((T) nuevo.getUserData());
            }
        };

        grupo.selectedToggleProperty().addListener(miEscuchador);
    }

    public static <T> void unbindToggleGroupToProperty(final ToggleGroup grupo, final ObjectProperty<T> propiedad)
    {
        grupo.selectedToggleProperty().removeListener(miEscuchador);
    }
}
