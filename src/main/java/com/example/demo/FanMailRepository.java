package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;

@Repository
public class FanMailRepository {

    @Autowired
    JdbcTemplate jdbc;
    SqlRowSet sqlRowSet;
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public ArrayList<FanMail> getAllMail() {
        ArrayList<FanMail> fanMailArray = new ArrayList<>();

        String sql = "SELECT * FROM harry_potter.fan_mail";
        sqlRowSet = jdbc.queryForRowSet(sql);

        while (sqlRowSet.next()) {
            fanMailArray.add(new FanMail(
                    sqlRowSet.getInt("mail_id"),
                    sqlRowSet.getString("sender_name"),
                    sqlRowSet.getString("title"),
                    sqlRowSet.getString("message"),
                    dateFormat.format(sqlRowSet.getDate("date"))
            ));
        }
        return fanMailArray;
    }

    public void createMail(FanMail fanMail, Date sqlDate) {
        String sql = "INSERT INTO harry_potter.fan_mail (mail_id, sender_name, title, message, date)" +
                "VALUES (default, ?, ?, ?, ?)";

        jdbc.update(sql, preparedStatement -> {
            preparedStatement.setString(1, fanMail.getSenderName());
            preparedStatement.setString(2, fanMail.getTitle());
            preparedStatement.setString(3, fanMail.getMessage());
            preparedStatement.setDate(4, (java.sql.Date) sqlDate);
        });
    }
}
