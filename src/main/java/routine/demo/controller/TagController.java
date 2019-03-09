package routine.demo.controller;


import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.google.common.collect.Lists;
import routine.demo.model.Day;
import routine.demo.model.Tag;
import routine.demo.repository.TagRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/tags")
public class TagController {

    @Autowired
    private TagRepository tagRepository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Tag> getAll(){
        return Lists.newArrayList(this.tagRepository.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Tag getTag(@PathVariable int id){
        return this.tagRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tag not found on :" + id));
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Tag createUser(@RequestBody Tag tag){
        return  this.tagRepository.save(tag);
    }
}
