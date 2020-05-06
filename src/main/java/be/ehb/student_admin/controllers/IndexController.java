package be.ehb.student_admin.controllers;

import be.ehb.student_admin.model.Student;
import be.ehb.student_admin.model.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class IndexController {

    @Autowired
    private StudentDAO repo;

    @ModelAttribute("all")
    public Iterable<Student> findAll(){
        return repo.findAll();
    }

    @ModelAttribute("new_student")
    public Student createNew(){
        return new Student();
    }

    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
    public String showIndex(ModelMap map){
        return "index";
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.POST)
    public String saveBlog(@ModelAttribute("new_student") @Valid Student newStudent, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            //er was een fout in het formulier, toon deze pagina opnieuw
            return "index";
        }
        repo.save(newStudent);
        //redirect = verwijzen naar andere request, default een get
        return "redirect:/index";
    }
}
