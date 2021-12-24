package com.mathflat;

import com.mathflat.entity.Student;
import com.mathflat.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;
import java.util.stream.LongStream;

@Component
public class H2Runner implements ApplicationRunner {
    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    StudentRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try (Connection connection = dataSource.getConnection()) {

            System.out.println(connection.getMetaData().getURL());
            System.out.println(connection.getMetaData().getUserName());

            Statement statement = connection.createStatement();

            LongStream.rangeClosed(1, 100).forEach(i -> {
                Student student = Student.builder()
//                        .id(i)
                        .name("test")
                        .age(99)
                        .schoolType("abc")
                        .phoneNumber("000000")
                        .build();

                repository.save(student);
            });

//            String sql = "Insert into user(user_id) values(33)";
//            statement.executeUpdate(sql);
        }
    }
}
