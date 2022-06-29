package com.Validation.RestNationalId.IdValidations;

import Validation.Person;
import com.Validation.RestNationalId.Mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class RetrieveId {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/get/{id}")
    public String retrieveId(@PathVariable String id)
    {
        try{
            String sql;
            sql = "SELECT id, gender, birthDate FROM nationalid WHERE id=" + id;
            String person = jdbcTemplate.query(sql, new PersonMapper()).toString();
            if (person.length() > 2)
                return person;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return "404 NOT FOUND";
    }
}
