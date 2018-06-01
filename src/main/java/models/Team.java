package models;

import java.util.ArrayList;

public class Team {
    private ArrayList<String> members;
    private String name;
    private String description;

    public Team(String name, String description){
        this.name = name;
        this.description = description;
    }

    public void addMembers(String member){
        members.add(member);
    }


    public ArrayList<String> getMembers() {
        return members;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
