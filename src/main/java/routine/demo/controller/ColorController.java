package routine.demo.controller;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import routine.demo.model.Color;
import routine.demo.repository.ColorRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/colors")
public class ColorController {

    @Autowired
    private ColorRepository colorRepository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Color> getAll(){
        return Lists.newArrayList(this.colorRepository.findAll());
    }

    @RequestMapping(value = "/create", method =RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Color createDay( Color color){
        return this.colorRepository.save(color);
    }
}
