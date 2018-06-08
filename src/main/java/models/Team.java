package models;

import java.util.ArrayList;
import java.util.Objects;

public class Team {
    private String name;
    private String description;
    private int id;

    public Team(String name, String description){
        this.name = name;
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return id == team.id &&
                Objects.equals(name, team.name) &&
                Objects.equals(description, team.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, description, id);
    }
}
