package com.Validation.RestNationalId.IdValidations;

import Validation.Person;
import Validation.ValidateID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;



@RestController
public class ListIdValidation {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/add/ids")
    public ArrayList<Person> returnSolution(@RequestBody String[] solution) {
        ValidateID validateID = new ValidateID();
        ArrayList<Person> people = new ArrayList<>();
        for (int i = 0; i < solution.length; i++) {
            people.add(validateID.constructingPerson(solution[i]));
            people.get(i).setValid(validateID.idValidation(solution[i]));
            try {
                String sql;
                sql = "INSERT INTO nationalid (id, gender, birthDate) VALUES (?,?,?)";
                jdbcTemplate.update(sql,people.get(i).getId(),people.get(i).getGender(), people.get(i).getDate());

                if(!people.get(i).isValid()) {
                    sql = "INSERT INTO validationerror (id, errorMessage, errorCode, fk_NationalIDid) VALUES (?,?,?,?)";
                    jdbcTemplate.update(sql, people.get(i).getId(),"Wrong control digit", "101", people.get(i).getId());
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return people;

    }
}
