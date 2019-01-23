package cz.jjaros.study.ocp.ch06_localization;

import cz.jjaros.study.helper.Console;

import java.util.Enumeration;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Ex06b_ResourceBundle {

    public static void main(String[] args) {
        printMessageFromProperties();
        printMessageFromProperties(Locale.JAPAN);
        printMessageFromProperties(Locale.getDefault());

        Console.lineDelimiter();
        printAllMessagesFromProperties();

        Console.lineDelimiter();
        printIllegalBundleName(); // MissingResourceException (unchecked)

        Console.lineDelimiter();
        printNonExistingMessage(); // MissingResourceException (unchecked)
    }

    private static void printMessageFromProperties() {
        // pokud bude defaul nastaveno na cs_CZ, budou se texty brat z resources/Messages_cs_CZ.properties
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Messages");
        System.out.println("greeting from default: " + resourceBundle.getString("ocp.06_locale.greeting"));
    }

    private static void printMessageFromProperties(Locale locale) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Messages", locale);
        System.out.println("greeting from default: " + resourceBundle.getString("ocp.06_locale.greeting"));
    }

    private static void printAllMessagesFromProperties() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Messages");

        Enumeration<String> keys = resourceBundle.getKeys();
        for (int i = 1; keys.hasMoreElements(); i++) {
            System.out.println("resourceBundle.getKeys() [" + i + "]: " + keys.nextElement());
        }

        System.out.println();
        System.out.println("Keys with translation:");
        keys = resourceBundle.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            System.out.println(key + " => " + resourceBundle.getString(key));
        }
    }

    private static void printIllegalBundleName() {
        try {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("invalidBundleName");
        } catch (MissingResourceException e) {
            // java.util.MissingResourceException: Can't find bundle for base name invalidBundleName, locale cs_CZ
            System.out.println(e);
        }
    }

    private static void printNonExistingMessage() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Messages");
        try {
            System.out.println("greeting from default: " + resourceBundle.getString("invalid.message.key"));
        } catch (MissingResourceException e) {
            // java.util.MissingResourceException: Can't find resource for bundle java.util.PropertyResourceBundle, key invalid.message.key
            System.out.println(e);
        }
    }

}
