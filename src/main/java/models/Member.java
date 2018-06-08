package models;

import java.util.Objects;

public class Member {
    private String name;
    private int id;

    public Member(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getId() {
        return id;
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

