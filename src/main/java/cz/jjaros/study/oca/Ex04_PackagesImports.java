package cz.jjaros.study.oca;

// NE: zastupna hvezdicka muze byt jen jednou a pouze na konci
//import java.*.Date;
//import java.*.logging.*;
//import *;
//import *.Date;

// NE: nelze importovat dve tridy se stejnym nazvem (compilation error)
// pri pouziti napr. 'new Date()' v kodu by nebylo jasne, ktera trida se ma pouzit
//import java.util.Date;
//import java.sql.Date;

// tohle projde:
// pri pouziti napr. 'new Date()' v kodu se pouzije PRIMO naimportovana trida - v tomto pripade java.sql.Date
// v pripade potreby, lze vyuzit i tridu z naimportovaneho package - v kodu pak bude 'new java.util.Date()'
import java.util.*;
import java.sql.Date;

public class Ex04_PackagesImports {

    public static void main(String[] args) {
        Date sqlDate = new Date(System.currentTimeMillis());
        java.util.Date utilDate = new java.util.Date();

        System.out.println("utilDate = " + utilDate);
        System.out.println("sqlDate = " + sqlDate);
    }
}

