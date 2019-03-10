package routine.demo.controller;


import org.apache.velocity.exception.ResourceNotFoundException;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.google.common.collect.Lists;
import routine.demo.model.Day;
import routine.demo.model.Tag;
import routine.demo.repository.TagRepository;

import javax.validation.Valid;
import java.io.IOException;
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
    public List<Tag> createTag(@RequestBody @Valid Tag tag){
        this.tagRepository.save(tag);
        return Lists.newArrayList(this.tagRepository.findAll());
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public List<Tag> deleteTag(@PathVariable int id){
        this.tagRepository.deleteById(id);
        return Lists.newArrayList(this.tagRepository.findAll());
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public List<Tag> updateTag(@RequestBody Tag newTag, @PathVariable int id) {
        this.tagRepository.findById(id)
                    .map(tag -> {
                        tag.setDescription(newTag.getDescription());
                        tag.setTitle(newTag.getTitle());
                        tag.setColor(newTag.getColor());
                        return this.tagRepository.save(tag);
                    })
                    .get();
        return Lists.newArrayList(this.tagRepository.findAll());
    }
}
