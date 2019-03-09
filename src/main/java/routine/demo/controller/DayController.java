package routine.demo.controller;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import routine.demo.model.Day;
import routine.demo.repository.DayRepository;

import java.util.List;

@RestController
@RequestMapping("/days")
public class DayController {

    @Autowired
    private DayRepository dayRepository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Day> getAll(){
        return Lists.newArrayList(this.dayRepository.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Day getDay(@PathVariable int id){
        return this.dayRepository.findById(id).orElse(null);
    }

    @RequestMapping(value = "/create", method =RequestMethod.POST,
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public void createDay(Day day){
        this.dayRepository.save(day);
    }
}
