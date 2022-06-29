package com.Validation.RestNationalId.IdValidations;

import Validation.Person;
import com.Validation.RestNationalId.Mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class FilteringIds {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/filter/date/")
    public ArrayList<Person> filteringByDate(@RequestBody Datefilter datefilter)
    {
        try{
            String sql;
            sql = "SELECT * FROM nationalid WHERE birthDate BETWEEN \"" + datefilter.getFrom() + "\" AND \"" + datefilter.getTo() + "\"";
            System.out.println(sql);
            ArrayList<Person> people = new ArrayList<>(jdbcTemplate.query(sql, new PersonMapper()));
            return people;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("There was not ids found from:" + datefilter.getFrom() + " to:" + datefilter.getTo());
        return null;
    }
}
