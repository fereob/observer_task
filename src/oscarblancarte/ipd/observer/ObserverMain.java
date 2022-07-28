package oscarblancarte.ipd.observer;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import oscarblancarte.ipd.observer.impl.ConfigurationManager;
import oscarblancarte.ipd.observer.impl.observers.DateFormatObserver;
import oscarblancarte.ipd.observer.impl.observers.MoneyFormatObserver;
import oscarblancarte.ipd.observer.impl.observers.MoneyTypeObserver;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */
public class ObserverMain {

    public static void main(String[] args) {
        ConfigurationManager conf = ConfigurationManager.getInstance();
        
        //Se establecen los valores por default.
        conf.setDefaultDateFormat(new SimpleDateFormat("yyyy/MM/dd"));
        conf.setMoneyFormat(new DecimalFormat("##.00"));
        conf.setMoneyType(new Locale("en", "US"));
        System.out.println("Established configuration");
        
        //Se dan de alta lo observers
        DateFormatObserver dateFormatObserver = new DateFormatObserver();
        MoneyFormatObserver moneyFormatObserver = new MoneyFormatObserver();
        MoneyTypeObserver moneyTypeObserver = new MoneyTypeObserver();
        conf.addObserver(dateFormatObserver);
        conf.addObserver(moneyFormatObserver);
        conf.addObserver(moneyTypeObserver);
        System.out.println("");
        
        //Se cambia la fonfiguratión
        conf.setDefaultDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
        conf.setMoneyFormat(new DecimalFormat("###,#00.00"));
        conf.setMoneyType(new Locale("es", "ES"));
        System.out.println("");
        
        //Se realiza otro cambio en la configuración.
        conf.setDefaultDateFormat(new SimpleDateFormat("MM/yyyy/dd"));
        conf.setMoneyFormat(new DecimalFormat("###,#00"));
        conf.setMoneyType(new Locale("en", "CA"));
        
        conf.removeObserver(dateFormatObserver);
        conf.removeObserver(moneyFormatObserver);
        conf.removeObserver(moneyTypeObserver);
        System.out.println("");
        
        //Se realiza otro cambio en la configuración.
        conf.setDefaultDateFormat(new SimpleDateFormat("MM/yyyy"));
        conf.setMoneyFormat(new DecimalFormat("###,##0.00"));
        conf.setMoneyType(new Locale("ja", "JP"));
    }
}