package models;

import models.Member;
import models.Team;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TeamTest {
    @Test
    public void newTeam_teamInstantiatesCorrectly() {
        Team team = new Team("Hackers", "A group of students ready to code!");
        assertEquals(true, team instanceof Team);
    }

    @Test
    public void getName_correctlyGetsName() {
        Team team = new Team("Hackers", "A group of students ready to code!");
        assertEquals("Hackers" , team.getName());
    }

    @Test
    public void getDescription_correctlyGetsDescription() {
        Team team = new Team("Hackers", "A group of students ready to code!");
        assertEquals("A group of students ready to code!", team.getDescription());
    }



}