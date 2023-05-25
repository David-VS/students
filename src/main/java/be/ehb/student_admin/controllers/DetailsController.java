package be.ehb.student_admin.controllers;


import be.ehb.student_admin.model.Student;
import be.ehb.student_admin.model.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class DetailsController {

    StudentDAO repo;

    @Autowired
    public DetailsController(StudentDAO repo) {
        this.repo = repo;
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String showDetailsForID(ModelMap map, @PathVariable(value = "id") int id) {
        Optional<Student> optional = repo.findById(id);
        if (optional.isPresent()) {
            map.addAttribute("student", optional.get());
            return "details";
        }
        return "redirect:/index";
    }
}
