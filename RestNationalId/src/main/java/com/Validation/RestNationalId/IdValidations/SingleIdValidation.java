package com.Validation.RestNationalId.IdValidations;

import Validation.ValidateID;
import org.springframework.web.bind.annotation.*;

@RestController
public class SingleIdValidation {

    @GetMapping("/singleid")
    public String singleId(@RequestParam(value = "id", defaultValue = "34409157850") String id)
    {
        ValidateID validateID = new ValidateID();
        boolean isValid = validateID.idValidation(id);
        return String.format("Your id is: %s. This id is %s", id, isValid ? "valid" : "not valid");
    }
}
