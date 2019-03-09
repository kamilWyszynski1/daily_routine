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
    private ColorRepository colorRepository;
    private DayRepository dayRepository;
    private TagRepository tagRepository;

    @Autowired
    public ViewController(ColorRepository colorRepository, DayRepository dayRepository, TagRepository tagRepository) {
        this.colorRepository = colorRepository;
        this.dayRepository = dayRepository;
        this.tagRepository = tagRepository;
    }

    @RequestMapping(value = "")
    public String indexView(Model model){
        return "index";
    }

    @RequestMapping(value = "/tag")
    public String tagView(Model model){
        model.addAttribute("tag", new Tag());
        return "tag/base";
    }
}
