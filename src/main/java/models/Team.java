package models;

import java.util.ArrayList;
import java.util.Objects;

public class Team {
    private ArrayList<Member> members = new ArrayList<>();
    private String name;
    private String description;
    private int id;

    public Team(String name, String description){
        this.name = name;
        this.description = description;
    }

    public void addMember(Member member){
        members.add(member);
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public void update(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
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
                Objects.equals(members, team.members) &&
                Objects.equals(name, team.name) &&
                Objects.equals(description, team.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(members, name, description, id);
    }
}
