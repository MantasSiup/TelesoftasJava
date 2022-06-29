package com.Validation.RestNationalId.Mapper;

import Validation.Person;
import Validation.ValidateID;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {


    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person person;
        ValidateID validateID = new ValidateID();
        person = validateID.constructingPerson(rs.getString("id"));
        person.setValid(validateID.idValidation(rs.getString("id")));
        return person;
    }
}
