package cr.ac.una.solitario_spider.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import javafx.scene.image.Image;


public class AppContext {

    private static AppContext INSTANCE = null;
    private static HashMap<String, Object> context = new HashMap<>();
     
    private AppContext() 
    {
        cargarPropiedades();
    }

    private static void createInstance() 
    {
        if (INSTANCE == null) 
        {
            synchronized (AppContext.class) 
            {
                if (INSTANCE == null)
                {
                    INSTANCE = new AppContext();
                }
            }
        }
    }

    public static AppContext getInstance() 
    {
        if (INSTANCE == null) 
        {
            createInstance();
        }
        return INSTANCE;
    }
    
    private void cargarPropiedades()
    {
        try 
        {
            FileInputStream configFile;
            configFile = new FileInputStream("config/properties.ini");
            Properties appProperties = new Properties();
            appProperties.load(configFile);
            configFile.close();

        } catch (IOException io) {
            System.out.println("Archivo de configuración no encontrado.");
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException 
    {
        throw new CloneNotSupportedException();
    }

    public Object get(String parameter)
    {    
        return context.get(parameter);
    }

    public void set(String nombre, Object valor) 
    {
        context.put(nombre, valor);
    }

    public void delete(String parameter) 
    {
        context.put(parameter, null);
    }
    
    public String Palos;

    public String getPalos() 
    {
        return Palos;
    }

    public void setPalos(String Palos) 
    {
        this.Palos = Palos;
    }
    
    public String Dificultad;

    public String getDificultad() 
    {
        return Dificultad;
    }

    public void setDificultad(String Dificultad) 
    {
        this.Dificultad = Dificultad;
    }
    
    public Image fondo;

    public Image getFondo() 
    {
        return fondo;
    }

    public void setFondo(Image fondo) 
    {
        this.fondo = fondo;
    }
    
}
