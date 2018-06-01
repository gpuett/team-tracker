package models;

import java.util.ArrayList;

public class Team {
    private ArrayList<String> members;
    private String name;
    private String description;
    private int id;
    private static ArrayList<Team> teamList = new ArrayList<>();

    public Team(String name, String description){
        this.name = name;
        this.description = description;
        this.members = members;
        teamList.add(this);
        this.id = teamList.size();
    }

//    public void setMembers(ArrayList<String> members) {
//        this.members = members;
//    }

    public void addMember(String member){
        members.add(member);
    }

    public ArrayList<String> getMembers() {
        return members;
    }

    public void update(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static ArrayList<Team> getAll() {
        return teamList;
    }



}
