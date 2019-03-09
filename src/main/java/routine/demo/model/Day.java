package routine.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.validator.constraints.Length;
import routine.demo.seriallizer.DaySerializer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonSerialize(using = DaySerializer.class)
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;


    @ManyToMany(mappedBy = "days")
    private List<Tag> tags = new ArrayList<>();

    @Length(max = 50, message = "The name must be less than 50 characters")
    private String title;

    @Length(max = 200, message = "The description mu be less than 50 characters")
    private String description;

    // ------ //

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Day(@Length(max = 50, message = "The name must be less than 50 characters") String title, @Length(max = 200, message = "The description mu be less than 50 characters") String description) {
        this.title = title;
        this.description = description;
    }

    public Day() {
    }
    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        for (Tag tag : tags){
            tag.setDay(this);
        }
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
