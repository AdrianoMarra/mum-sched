package mum.sched.controller;

import java.util.List;
import javax.validation.Valid;

import mum.sched.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mum.sched.model.Course;
import mum.sched.service.impl.CourseServiceImpl;

@Controller
public class CourseController {
    @Autowired
    private CourseServiceImpl courseServiceImpl;

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public ModelAndView students() {
        List<Course> course = courseServiceImpl.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("courses", course);
        modelAndView.setViewName("course/list");
        return modelAndView;
    }

    @RequestMapping(value = "/course", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("course", new Course());
        return "course/edit";
    }

    @RequestMapping(value = "/course", method = RequestMethod.POST)
    public String edit(@Valid @ModelAttribute("course") Course course, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "course/edit";
        }
        course = courseServiceImpl.save(course);
        return "redirect:/courses";
    }

    @RequestMapping(value = "/course/{id}", method = RequestMethod.GET)
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("course", courseServiceImpl.findOne(id).get());
        return "course/edit";
    }

    @RequestMapping(value = "/course/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id, Model model) {
        courseServiceImpl.delete(id);
        return "redirect:/course";
    }
}