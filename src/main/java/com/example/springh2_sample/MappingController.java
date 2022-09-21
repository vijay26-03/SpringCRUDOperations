package com.example.springh2_sample;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class MappingController {

    private Map<String,Students> db= new HashMap<>(){{
        put("1",new Students("vijay","20"));
        }};

    @GetMapping("/getStudents")
    public Collection<Students> getStudents(){
        return db.values();
    }

    @GetMapping("getStudents/{id}")
    public Object getStudents(@PathVariable String id){
        Students student = db.get(id);
        String message = "Student not found";
        if(student == null){
            return message;
        }
        return student;
    }

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Students student){
        if(student.getName() != null && student.getAge() != null) {
            db.put(UUID.randomUUID().toString(), student);
            return "Student added successfully";
        }
        return "Fill all the fields";
    }

    @PutMapping("/updateStudent/{id}")
    public String updateStudent(@RequestBody Students student,@PathVariable String id){
        boolean IsThere = false;
        if(db.containsKey(id)){
            db.replace(id,student);
            return "Student Details Updated";
        }
        return "Student not found";

    }

    @DeleteMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable String id){
        Students student = db.remove(id);
        if(student == null){
            return "Student not found";
        }
        return "Student deleted successfully";
    }



}
