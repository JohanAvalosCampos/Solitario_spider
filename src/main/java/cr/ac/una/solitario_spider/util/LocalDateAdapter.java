package cr.ac.una.solitario_spider.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate>
{

    private static final Logger LOG = Logger.getLogger(LocalDateAdapter.class.getName());

    @Override
    public LocalDate unmarshal(String date) throws Exception
    {
        try
        {
            if (date == null)
            {
                return null;
            }
            else
            {
                return LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
            }
        }
        catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error al deserializar la fecha [" + date + "].", ex);
            throw ex;
        }
    }

    @Override
    public String marshal(LocalDate date) throws Exception
    {
        try
        {
            if (date == null)
            {
                return null;
            }
            else
            {
                return date.format(DateTimeFormatter.ISO_DATE);
            }
        }
        catch (Exception ex)
        {
            LOG.log(Level.SEVERE, "Error al serializar la fecha [" + date + "].", ex);
            throw ex;
        }
    }
}
