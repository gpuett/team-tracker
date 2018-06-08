package models;

import java.util.Objects;

public class Member {
    private String name;
    private int id;
    private int teamId;

    public Member(String name, int teamId){
        this.name = name;
        this.teamId = teamId;
    }

    public String getName(){
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getTeamId() {
        return teamId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return id == member.id &&
                Objects.equals(name, member.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, id);
    }
}

