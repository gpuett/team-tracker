package models;

import java.util.ArrayList;

public class Team {
    private ArrayList<String> members = new ArrayList<>();
    private String name;
    private String description;
    private int id;
    private static ArrayList<Team> teamList = new ArrayList<>();

    public Team(String name, String description){
        this.name = name;
        this.description = description;
        teamList.add(this);
        this.id = teamList.size();
    }

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

    public int getId() {
        return id;
    }

    public static void clearAllTeams(){
        teamList.clear();
    }

    public static Team findById(int id){
        return teamList.get(id-1);
    }
}
