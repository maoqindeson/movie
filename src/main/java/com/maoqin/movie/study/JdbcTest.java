package com.maoqin.movie.study;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcTest {
    public static void main(String[] args) throws Exception {    //需要抛出异常
        Class.forName("com.mysql.jdbc.Driver");
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://120.79.235.233:3306/mao"
                    , "root", "root");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tb_student " +
                    "WHERE class=1 AND grade=1 AND gender=0");
            while (rs.next()) {
                System.out.println(rs.getString(1)+"\t"+rs.getInt(2)+         //column表示列的意思
                        "\t"+rs.getInt(3)+"\t"+rs.getInt(4));
            }
        } catch (Exception e) {
        }
    }
}
