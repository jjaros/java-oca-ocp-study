package cz.jjaros.study.ocp.ch06_localization;

import java.util.Locale;

public class Ex06a_Localization {

    public static void main(String[] args) {

        // defaultni locale se ziskava takto (poradi od nejvyssi priority):
        //      1. nastaveni primo v aplikaci pouzitim Locale#setDefault
        //      2. nastaveni nasledujicich parametru pri spusteni z prikazove radky (resp. via JAVA_OPTS)
        //          -Duser.language=
        //          -Duser.country
        //          -Duser.variant
        //      3. pri inicializaci JVM z hostujiciho systemu
        Locale defaultLocale = Locale.getDefault(); // zavisi na systemu nebo nastaveni JVM pri spusteni (viz vys)
        System.out.println("defaultLocale = " + defaultLocale);

        Locale.setDefault(Locale.UK);
        Locale resetDefaultLocale = Locale.getDefault();
        System.out.println("resetDefaultLocale = " + resetDefaultLocale); // en_GB

    }

}
