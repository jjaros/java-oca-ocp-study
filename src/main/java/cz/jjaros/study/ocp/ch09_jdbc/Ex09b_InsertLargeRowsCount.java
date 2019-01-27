package cz.jjaros.study.ocp.ch09_jdbc;

import org.hsqldb.jdbc.JDBCDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ex09b_InsertLargeRowsCount extends Ex09_CommonLogic {

    public static void main(String[] args) throws SQLException {

        // see example in parent
        JDBCDataSource dataSource = getDataSource();
        // contains:
        // Statement vs PreparedStatement
        // try with resources + AutoClosable
        createTable(dataSource);

        Connection connection = dataSource.getConnection();

        // v#1:
        long startMilis = System.currentTimeMillis();
        IntStream.range(0, 100_000)
                .forEach(i -> executeForEachStatement(i, connection));
        System.out.println("100_000 INSERTU V#1 (executeForEachStatement): " + (System.currentTimeMillis() - startMilis) + " ms");

        // v#2:
        startMilis = System.currentTimeMillis();
        IntStream.range(0, 100_000)
                .forEach(i -> executeForEachPreparedStatement(i, connection));
        System.out.println("100_000 INSERTU V#2 (executeForEachPreparedStatement): " + (System.currentTimeMillis() - startMilis) + " ms");

        // v#3:
        startMilis = System.currentTimeMillis();
        String sql = "insert into persons (name, datum_ulozeni) values (?, ?)";
        PreparedStatement preparedStatementForBatch = connection.prepareStatement(sql);
        IntStream.range(0, 100_000)
                .forEach(i -> executeWith10000Batch(i, preparedStatementForBatch));
        preparedStatementForBatch.executeBatch(); // insert last records
        System.out.println("100_000 INSERTU V#3 (executeWith10000Batch): " + (System.currentTimeMillis() - startMilis) + " ms");

        // v#4
        startMilis = System.currentTimeMillis();
        executeOneLargeInsert(connection);
        System.out.println("100_000 INSERTU V#4 (oneLargeInsert): " + (System.currentTimeMillis() - startMilis) + " ms");
    }

    private static void executeForEachStatement(int i, Connection connection) {
        String sql = "insert into persons (name, datum_ulozeni) values ('executeForEachStatement#" + i + "', '2016-10-20')";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void executeForEachPreparedStatement(int i, Connection connection) {
        String sql = "insert into persons (name, datum_ulozeni) values (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, "executeForEachPreparedStatement#" + i);
            preparedStatement.setTimestamp(2, new Timestamp(new java.util.Date().getTime()));
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void executeWith10000Batch(int i, PreparedStatement preparedStatement) {
        try {
            preparedStatement.setString(1, "executeWith10000Batch#" + i);
            preparedStatement.setTimestamp(2, new Timestamp(new java.util.Date().getTime()));
            preparedStatement.addBatch();
            if(i % 10_000 == 0) {
                preparedStatement.executeBatch();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void executeOneLargeInsert(Connection connection) throws SQLException {
        // pro postgreSQL je toto (zakomentovane) nejefektivnejsi zpusob
        //            INSERT INTO films (code, title, did, date_prod, kind) VALUES
        //                ('B6717', 'Tampopo', 110, '1985-02-10', 'Comedy'),
        //                ('HG120', 'The Dinner Game', 140, DEFAULT, 'Comedy');
        String largeInsert = "insert into persons (name, datum_ulozeni) values ";
        largeInsert += IntStream.range(0, 100_000)
                .boxed()
                .map(i -> "('oneLargeInsert#" + i + "', '2016-10-20')")
                .collect(Collectors.joining(","));
        connection.prepareStatement(largeInsert).execute();
    }
}
