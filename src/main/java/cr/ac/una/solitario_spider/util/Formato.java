/*
 * To change this license header, choose License in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.solitario_spider.util;

import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.regex.Pattern;

import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextInputControl;

/**
 *
 * @author JOHAN
 */
public class Formato
{

    private static Formato INSTANCE = null;

    public DateTimeFormatter formatDateShort = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
    public DateTimeFormatter formatDateMedium = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
    public DecimalFormat decimalFormat = new DecimalFormat("#,###,###,##0.00");

    private Formato()
    {
    }

    private static void createInstance()
    {
        if (INSTANCE == null)
        {
            synchronized (Formato.class)
            {
                if (INSTANCE == null)
                {
                    INSTANCE = new Formato();
                }
            }
        }
    }

    public static Formato getInstance()
    {
        if (INSTANCE == null)
        {
            createInstance();
        }

        return INSTANCE;
    }

    @Override
    public Object clone() throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException();
    }

    public TextFormatter twoDecimalFormat()
    {
        TextFormatter formatter = new TextFormatter<>(c ->
        {
            if (c.getControlNewText().isEmpty())
            {
                return c;
            }

            if (c.getControlNewText().contains(","))
            {
                ParsePosition pos = new ParsePosition(0);
                Object result = decimalFormat.parse(c.getControlNewText(), pos);

                if (result == null || pos.getIndex() < c.getControlNewText().length())
                {
                    return null;
                }
                else
                {
                    Pattern pattern = Pattern.compile("^[0-9]*+(\\.[0-9]{0,2})?$");
                    if (pattern.matcher(c.getControlNewText().replace(",", "")).matches())
                    {
                        return c;
                    }
                    else
                    {
                        return null;
                    }
                }
            }
            else
            {
                Pattern pattern = Pattern.compile("^[0-9]*+(\\.[0-9]{0,2})?$");
                if (pattern.matcher(c.getControlNewText().replace(",", "")).matches())
                {
                    return c;
                }
                else
                {
                    return null;
                }
            }
        });

        return formatter;
    }

    public TextFormatter integerFormat()
    {
        TextFormatter formatter = new TextFormatter<>(c ->
        {
            if (c.getControlNewText().isEmpty())
            {
                return c;
            }

            Pattern pattern = Pattern.compile("\\d+");
            if (pattern.matcher(c.getControlNewText()).matches())
            {
                return c;
            }
            else
            {
                return null;
            }
        });

        return formatter;
    }

    public TextFormatter cedulaFormat(Integer maxLength)
    {
        TextFormatter<String> formatter = new TextFormatter<>(c ->
        {
            if (c.getControlNewText().isEmpty())
            {
                return c;
            }

            if (maxLength > 0)
            {
                if (((TextInputControl) c.getControl()).getLength() >= maxLength && !c.isDeleted())
                {
                    return null;
                }

                if (c.getText().length() > maxLength && !c.isDeleted())
                {
                    return null;
                }
            }

            c.setText(c.getText().replaceAll("[^a-zA-Z0-9-]", ""));

            if (c.getControlNewText().matches(".*-{2,}.*"))
            {
                return null;
            }

            return c;
        });

        return formatter;
    }

    public TextFormatter letrasFormat(Integer maxLength)
    {
        TextFormatter<String> formatter = new TextFormatter<>(c ->
        {
            if (c.getControlNewText().isEmpty())
            {
                return c;
            }

            if (maxLength > 0)
            {
                if (((TextInputControl) c.getControl()).getLength() >= maxLength && !c.isDeleted())
                {
                    return null;
                }

                if (c.getText().length() > maxLength && !c.isDeleted())
                {
                    return null;
                }
            }

            c.setText(c.getText().replaceAll("[^a-zA-Z ]", ""));

            if (c.getControlNewText().matches(".*\\s{2,}.*"))
            {
                return null;
            }

            return c;
        });

        return formatter;
    }

    public TextFormatter maxLengthFormat(Integer length)
    {
        TextFormatter formatter = new TextFormatter<>(c ->
        {
            if (c.getControlNewText().isEmpty())
            {
                return c;
            }

            if (((TextInputControl) c.getControl()).getLength() >= length && !c.isDeleted())
            {
                return null;
            }

            if (c.getText().length() > length && !c.isDeleted())
            {
                return null;
            }

            return c;
        });

        return formatter;
    }
}
