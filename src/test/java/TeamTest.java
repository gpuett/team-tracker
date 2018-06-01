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

    @Test
    public void updateName_correctlyUpdatesName() {
        Team team = new Team("Hackers", "A group of students ready to code!");
        team.update("Slackers");
        assertEquals("Slackers", team.getName());
    }

    @Test
    public void getAll_correctlyGetsAll() {
        Team team = new Team("Hackers", "A group of students ready to code!");
        Team team2 = new Team("Slackers", "Not the best hackers");
        assertTrue(Team.getAll().contains(team));
        assertTrue(Team.getAll().contains(team2));
    }
}