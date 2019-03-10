package routine.demo.model;


import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.validator.constraints.Length;
import routine.demo.EntityIdResolver;
import routine.demo.seriallizer.TagSerializer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonSerialize(using = TagSerializer.class)
public class Tag {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Length(max = 50, message = "The name must be less than 50 characters")
    private String title;

    @Length(max = 200, message = "The description mu be less than 50 characters")
    private String description;


    private String color;

    @ManyToMany
    private List<Day> days = new ArrayList<>();

    @JsonCreator
    public Tag(@Length(max = 50, message = "The name must be less than 50 characters") @JsonProperty("title") String title,
               @Length(max = 200, message = "The description mu be less than 50 characters") @JsonProperty("description") String description,
               @JsonProperty("color") String color) {
        this.title = title;
        this.description = description;
        this.color = color;
    }

    public Tag() {

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }

    public void setDay(Day day){this.days.add(day);}
}
