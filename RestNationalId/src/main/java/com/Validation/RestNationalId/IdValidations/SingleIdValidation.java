package com.Validation.RestNationalId.IdValidations;

import Validation.Person;
import Validation.ValidateID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class SingleIdValidation {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/singleid")
    public String singleId(@RequestParam(value = "id", defaultValue = "34409157850") String id)
    {
        ValidateID validateID = new ValidateID();
        boolean isValid = validateID.idValidation(id);
        int result = -1;
        try {
            Person person = validateID.constructingPerson(id);
            person.setValid(validateID.idValidation(id));
            String sql;
            sql = "INSERT INTO nationalid (id, gender, birthDate) VALUES (?,?,?)";
            result = jdbcTemplate.update(sql,person.getId(),person.getGender(), person.getDate());

            if(!person.isValid()) {
                sql = "INSERT INTO validationerror (id, errorMessage, errorCode, fk_NationalIDid) VALUES (?,?,?,?)";
                jdbcTemplate.update(sql, person.getId(),"Wrong control digit", "101", person.getId());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return String.format("Your id is: %s. This id is %s. %s", id, isValid ? "valid" : "not valid",
                result > 0 ? "Your id was imported into the database" : "Your id was not imported into the database");
    }
}
