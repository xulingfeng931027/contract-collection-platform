package com.agree.collection;

import com.agree.collection.infrastructure.collectionrecord.po.CollectionRecordPo;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TableGenerator {
  
  public static String generateTableSql(Class<?> clazz, String tableName) {
    StringBuilder sb = new StringBuilder();
    sb.append("CREATE TABLE ").append(tableName).append(" (");

    Field[] fields = clazz.getDeclaredFields();
    for (int i = 0; i < fields.length; i++) {
      Field field = fields[i];
      String fieldName = field.getName();
      Class<?> fieldType = field.getType();
      
      sb.append(fieldName).append(" ");
      
      if (fieldType == String.class) {
        sb.append("VARCHAR(255)");
      } else if (fieldType == int.class) {
        sb.append("INT");
      } else if (fieldType == long.class) {
        sb.append("BIGINT");
      } else if (fieldType == boolean.class) {
        sb.append("BIT");
      } else if (fieldType == float.class) {
        sb.append("FLOAT");
      } else if (fieldType == double.class) {
        sb.append("DOUBLE");
      } else if (fieldType == char.class) {
        sb.append("CHAR");
      } else if (fieldType == java.math.BigDecimal.class) {
        sb.append("DECIMAL");
      } else if (fieldType == java.util.Date.class) {
        sb.append("DATE");
      } else if (fieldType == java.sql.Time.class) {
        sb.append("TIME");
      } else if (fieldType == java.sql.Timestamp.class) {
        sb.append("TIMESTAMP");
      } else if (fieldType == byte[].class) {
        sb.append("BLOB");
      } else if (fieldType == java.sql.Clob.class) {
        sb.append("CLOB");
      } else if (fieldType.isEnum()) {
        sb.append("VARCHAR(255)");
      } else {
        sb.append("TEXT");
      }// add more field type mapping here
      
      if (i != fields.length - 1) {
        sb.append(", ");
      }
    }
    
    sb.append(");");
    return sb.toString();
  }

  public static void createTable(Connection conn, String tableName, String sql) throws SQLException {
    Statement stmt = null;
    try {
      stmt = conn.createStatement();
      stmt.execute(sql);
      System.out.println("Table " + tableName + " created successfully");
    } finally {
      if (stmt != null) {
        stmt.close();
      }
    }
  }
  
  // example usage
  public static void main(String[] args) {
    Connection conn = null;
    try {
      // establish database connection
      String dbUrl = "jdbc:mysql://106.55.100.52:3306/xulingfeng";
      String username = "xulingfeng";
      String password = "123456";
      conn = DriverManager.getConnection(dbUrl, username, password);

      // generate and execute create table SQL statement
      String sql = generateTableSql(CollectionRecordPo.class, "collection_record");
      System.out.print(sql);
      createTable(conn, "1", sql);
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
