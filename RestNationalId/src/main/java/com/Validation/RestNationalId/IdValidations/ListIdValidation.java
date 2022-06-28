package com.Validation.RestNationalId.IdValidations;

import Validation.Person;
import Validation.ValidateID;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ListIdValidation {

    @PostMapping("/add/ids")
    public ArrayList<Person> returnSolution(@RequestBody String[] solution) {
        ValidateID validateID = new ValidateID();
        ArrayList<Person> people = new ArrayList<>();
        for (int i = 0; i < solution.length; i++) {
            people.add(validateID.constructingPerson(solution[i]));
            people.get(i).setValid(validateID.idValidation(solution[i]));
        }
        return people;

    }
}
