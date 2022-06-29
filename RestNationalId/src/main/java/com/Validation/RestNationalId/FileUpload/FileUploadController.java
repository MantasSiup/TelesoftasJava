package com.Validation.RestNationalId.FileUpload;

import BatchProc.InOutUtils;
import BatchProc.Utilities;
import Validation.Person;
import Validation.ValidateID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

@RestController
public class FileUploadController {

    @Value("${file.upload-dir}")
    String FILE_DIRECTORY;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/uploadFile")
    public ResponseEntity<Object> fileUpload(@RequestParam("File") MultipartFile file) throws IOException{

        File myFile = new File(FILE_DIRECTORY+file.getOriginalFilename());
        myFile.createNewFile();
        FileOutputStream fos =new FileOutputStream(myFile);
        fos.write(file.getBytes());
        fos.close();
        ArrayList<Person> person = InOutUtils.readFromTxt(myFile.getAbsolutePath());
        ArrayList<Person> Valid = Utilities.filter(person, true);

        for (int i = 0; i < person.size(); i++) {

            try {
                String sql;
                sql = "INSERT INTO nationalid (id, gender, birthDate) VALUES (?,?,?)";
                jdbcTemplate.update(sql,person.get(i).getId(),person.get(i).getGender(), person.get(i).getDate());

                if(!person.get(i).isValid()) {
                    sql = "INSERT INTO validationerror (id, errorMessage, errorCode, fk_NationalIDid) VALUES (?,?,?,?)";
                    jdbcTemplate.update(sql, person.get(i).getId(),"Wrong control digit", "101", person.get(i).getId());
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return new ResponseEntity<Object>("The File Uploaded Successfully, you have:" + Valid.size() + " valid IDs of:" + person.size(), HttpStatus.OK);
    }
}
