package cz.jjaros.study.ocp.ch09_jdbc;

import cz.jjaros.study.helper.Console;
import org.hsqldb.jdbc.JDBCDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Ex09a_Jdbc extends Ex09_CommonLogic {

    public static void main(String[] args) throws SQLException {

        // see example in parent
        JDBCDataSource dataSource = getDataSource();

        // contains:
        // Statement vs PreparedStatement
        // try with resources + AutoClosable
        createTable(dataSource);

        insertRow(dataSource);
        Console.lineDelimiter();

        selectCount(dataSource);
        Console.lineDelimiter();

        movoingResultSet(dataSource);
        Console.lineDelimiter();

        nullColumnValue(dataSource);

    }

    private static void insertRow(JDBCDataSource dataSource) throws SQLException {
        String sql = "insert into persons (name, datum_ulozeni) values (?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, "Jirka"); // 1 -> prvni otaznik
//                preparedStatement.setObject(2, LocalDate.now()); // podpora noveho Datetime API od JDBC 4.2
            preparedStatement.setTimestamp(2, new Timestamp(new java.util.Date().getTime())); // 2 -> prvni otaznik
            boolean isFirstRecordResultSet = preparedStatement.execute(); // spravne pouziti .execute() je pro DDL operace!
            int countAfterExecute = preparedStatement.getUpdateCount();
            System.out.println("isFirstRecordResultSet = " + isFirstRecordResultSet);
            System.out.println("countAfterExecute = " + countAfterExecute);

            int countAfterExecuteUpdate = preparedStatement.executeUpdate();
            System.out.println("countAfterExecuteUpdate = " + countAfterExecuteUpdate);

            // pro selecty (viz dalsi metoda/priklad):
            //      1. executeQuery() -> vraci rovnou ResultSet
            //      2. nebo execute() a pak se da na vysledku zavolat preparedStatement.getResultSet()
        }
    }

    private static void selectCount(JDBCDataSource dataSource) throws SQLException {
        String select = "select count(*) from persons";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(select)) {
            // execute vraci boolean -> ResultSet je potreba ziskat dalsim prikazem
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            if(resultSet.next()) {
                System.out.println("execute(); count=" + resultSet.getLong(1));
            }

            // executeQuery vraci rovnou ResultSet
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                System.out.println("executeQuery(); count=" + resultSet.getLong(1));
            }
        }
    }

    private static void movoingResultSet(JDBCDataSource dataSource) throws SQLException {
        String sql = "select distinct datum_ulozeni from persons";
        try (Connection connection = dataSource.getConnection();
             // ResultSet TYPE: Vychozi: ResultSet.TYPE_FORWARD_ONLY
             PreparedStatement preparedStatement =
                     connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("ResultSet#next:");
            while(resultSet.next()) {
                System.out.println(resultSet.getString("datum_ulozeni"));
            }
            System.out.println("ResultSet#previous:");
            // kdyby pri vytvoreni PreparedStatement nebylo TYPE_SCROLL_INSENSITIVE:
            // java.sql.SQLFeatureNotSupportedException: feature not supported
            while(resultSet.previous()) {
                System.out.println(resultSet.getString("datum_ulozeni"));
                // TOHLE NEPODPORUJE KAZDY DRIVER!!!!!
                // java.sql.SQLException: attempt to assign to non-updatable column
                // Caused by: org.hsqldb.HsqlException: attempt to assign to non-updatable column
//                    resultSet.updateString("datum_ulozeni", "xxxx");
            }
            System.out.println("ResultSet#next:");
            while(resultSet.next()) {
                System.out.println(resultSet.getString("datum_ulozeni"));
            }

//                resultSet.beforeFirst(); // nastavi RS PRED PRVNI zaznam
//                resultSet.afterLast();   // nastavi RS ZA POSLEDNI zaznam
//                resultSet.absolute(2); // nastavi RS NA DRUHY zaznam
//                resultSet.relative(-2); // nastavi RS NA AKTUALNI ZAZNAM - 2
        }
    }

    private static void nullColumnValue(JDBCDataSource dataSource) throws SQLException {
        String sql = "select company_id from persons";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                // pozor: toto bude vzdy nula v pripade null hodnoty v DB
                int intNullCompanyId = resultSet.getInt("company_id");
                System.out.println("intNullCompanyId = " + intNullCompanyId);

                // ochcavka s .wasNull()
                Integer integerNullCompanyId = resultSet.getInt("company_id");
                if (resultSet.wasNull()) {
                    integerNullCompanyId = null;
                }
                System.out.println("integerNullCompanyId = " + integerNullCompanyId);
            }
        }
    }

}
