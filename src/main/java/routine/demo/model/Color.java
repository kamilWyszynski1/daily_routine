package routine.demo.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@JsonAutoDetect(getterVisibility=JsonAutoDetect.Visibility.NONE)
public class Color {
    public Color() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    public Color(String hex_color) {
        this.hex_color = hex_color;
    }

    private String hex_color;

    public String getHex_color() {
        return hex_color;
    }

    public void setHex_color(String hex_color) {
        this.hex_color = hex_color;
    }
}
