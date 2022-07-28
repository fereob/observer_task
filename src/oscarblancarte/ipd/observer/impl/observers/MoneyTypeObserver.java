/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oscarblancarte.ipd.observer.impl.observers;

import oscarblancarte.ipd.observer.impl.ConfigurationManager;
import oscarblancarte.ipd.observer.impl.IObserver;
import java.util.Currency;

/**
 *
 * @author Fernando
 */
public class MoneyTypeObserver implements IObserver{
    @Override
    public void notifyObserver(String command, Object source) {
        if(command.equals("moneyType")){
            ConfigurationManager conf = (ConfigurationManager)source;
            Currency currency = Currency.getInstance(conf.getMoneyType());
            System.out.println("Observer ==> MoneyTypeObserver.moneyTypeChange > " 
                    + currency.getSymbol());
        }
    }
    
}
