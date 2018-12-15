package cz.jjaros.study.oca;

import cz.jjaros.study.helper.Console;

public class Ex08e_Enum {

    public static void main(String[] args) {
        MyService.INSTANCE.perfAction(); // MyService#perfAction

        Console.lineDelimiter();
        System.out.println(Day.Wednesday + "=" + Day.Wednesday.shortName()); // Wednesday=WED

        Console.lineDelimiter();
        System.out.println(Month.April + "=" + Month.April.translate()); // April=duben
    }

    public enum MyService {
        INSTANCE;

        public void perfAction() {
            System.out.println("MyService#perfAction");
        }
    }

    public enum Day {
        Monday, Tuesday, Wednesday, Thursday, Friday;

        public String shortName() {
            return toString().substring(0, 3).toUpperCase();
        }
    }

    public enum Month {
        January("Leden"),
        February("Unor"),
        March("Brezen"),
        April("Duben"),
//        Unknown(null); // takto, pokud by neexistoval bezparametricky konstruktor
        Unknown();

        private String czechName;

        Month() {
            // kdyby tady nebyl bezparametricky konstruktor, muselo by byt 'Unknown(null)'
        }

        Month(String czechName) {
            this.czechName = czechName;
        }

        public String translate() {
            return czechName != null ? czechName.toLowerCase() : null;
        }
    }
}

