package cz.jjaros.study.ocp.ch09_jdbc;

import org.hsqldb.jdbc.JDBCDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex09_CommonLogic {

    public static JDBCDataSource getDataSource() {
        // stare:
        //        Connection connection  = DriverManager.getConnection("jdbc:hsqldb:mem:test", "sa", "");
        // lepsi: (ovsem nejlepsi je HikariCP)
        final JDBCDataSource dataSource = new JDBCDataSource();
        dataSource.setUrl("jdbc:hsqldb:mem:test");
        dataSource.setUser("sa");
        dataSource.setPassword("");
        return dataSource;
    }

    // contains:
    // Statement vs PreparedStatement
    // try with resources + AutoClosable
    public static void createTable(JDBCDataSource dataSource) throws SQLException {
        String sql = "create table persons (" +
                "id integer identity, " +
                "name varchar(200) not null, " +
                "datum_ulozeni date not null, " +
                "company_id integer, " + // muze byt null
                "primary key (id))";

        // AutoCloseable objekty se uzaviraji v OPACNEM PORADI nez jsou definovany!
        // tzn.
        //      1. preparedStatement.close()
        //      2. connection.close())
        try (Connection connection = dataSource.getConnection();
             // Statement: The object used for executing a static SQL statement.
             // PreparedStatement: An object that represents a precompiled SQL statement.
             //                    This object can then be used to efficiently execute this statement multiple times.
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.execute();
        }
        // takto by se uzavrelo jen 'preparedStatement'
        // k zavolani 'connection.close()' by nedoslo!
//            try (PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(sql)) {
//                preparedStatement.execute();
//            }
    }

}
