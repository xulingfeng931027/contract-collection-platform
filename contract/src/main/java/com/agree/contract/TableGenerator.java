package com.agree.contract;

import com.agree.contract.domain.customercontract.entity.CustomerContract;

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

      sb.append(underscoreName(fieldName)).append(" ");

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
      String sql = generateTableSql(CustomerContract.class, "customer_contract");
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

  /**
   * 将驼峰式命名的字符串转换为下划线大写方式。如果转换前的驼峰式命名的字符串为空，则返回空字符串。
   * 例如：HelloWorld->HELLO_WORLD
   *
   * @param name 转换前的驼峰式命名的字符串
   * @return 转换后下划线大写方式命名的字符串
   */
  private static String underscoreName(String name) {
    StringBuilder result = new StringBuilder();
    if (name != null && name.length() > 0) {
      result.append(name.charAt(0));
      // 循环处理其余字符
      for (int i = 1; i < name.length(); i++) {
        String s = name.substring(i, i + 1);
        // 在大写字母前添加下划线
        if (s.equals(s.toUpperCase()) && !Character.isDigit(s.charAt(0))) {
          result.append("_");
        }
        // 其他字符直接转成大写
        result.append(s);
      }
    }
    return result.toString().toLowerCase();
  }
  /**
   * 将下划线大写方式命名的字符串转换为驼峰式。如果转换前的下划线大写方式命名的字符串为空，则返回空字符串。  * 例如：HELLO_WORLD->HelloWorld
   *
   * @param name 转换前的下划线大写方式命名的字符串
   * @return 转换后的驼峰式命名的字符串
   */
  public static String camelName(String name) {
    StringBuilder result = new StringBuilder();
    // 快速检查
    if (name == null || name.isEmpty()) {
      // 没必要转换
      return "";
    } else if (!name.contains("_")) {
      // 不含下划线，仅将首字母小写
      return name.substring(0, 1).toLowerCase() + name.substring(1);
    }
    // 用下划线将原始字符串分割
    String camels[] = name.split("_");
    for (String camel : camels) {
      // 跳过原始字符串中开头、结尾的下换线或双重下划线
      if (camel.isEmpty()) {
        continue;
      }
      // 处理真正的驼峰片段
      if (result.length() == 0) {
        // 第一个驼峰片段，全部字母都小写
        result.append(camel.toLowerCase());
      } else {
        // 其他的驼峰片段，首字母大写
        result.append(camel.substring(0, 1).toUpperCase());
        result.append(camel.substring(1).toLowerCase());
      }
    }
    return result.toString();
  }

}
