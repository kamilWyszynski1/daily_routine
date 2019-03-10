package routine.demo.controller;

import groovy.lang.Grab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import routine.demo.repository.*;
import routine.demo.model.*;

@Controller
@Grab("org.webjars:jquery:2.2.4")
@RequestMapping(value = "")
public class ViewController {

    private DayRepository dayRepository;
    private TagRepository tagRepository;

    @Autowired
    public ViewController( DayRepository dayRepository, TagRepository tagRepository) {
        this.dayRepository = dayRepository;
        this.tagRepository = tagRepository;
    }

    @RequestMapping(value = "")
    public String indexView(Model model){
        return "home";
    }

    @RequestMapping(value = "/tag")
    public String tagView(Model model){
        model.addAttribute("tag", new Tag());
        model.addAttribute("tags", this.tagRepository.findAll());
        return "tag/base";
    }

}
