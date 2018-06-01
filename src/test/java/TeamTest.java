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
    public void getMembers_correctlyGetsMembers() {
        Team.clearAllTeams();
        Team team = new Team("Hackers", "A group of students ready to code!");
        team.addMember("John");
        assertEquals(1, team.getMembers().size());
    }

    @Test
    public void getMembers_correctlyGetsMembersWhenThereAreMultipleMembers() {
        Team.clearAllTeams();
        Team team = new Team("Hackers", "A group of students ready to code!");
        team.addMember("John");
        team.addMember("Sarah");
        assertEquals(2, team.getMembers().size());
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

    @Test
    public void getId_teamInstantiatesWithAnId() {
        Team.clearAllTeams();
        Team team = new Team("Hackers", "A group of students ready to code!");
        assertEquals(1, team.getId());
    }

    @Test
    public void findById_returnsCorrectTeamId() {
        Team.clearAllTeams();
        Team team = new Team("Hackers", "A group of students ready to code!");
        assertEquals(1, Team.findById(team.getId()).getId());
    }

    @Test
    public void findReturnsCorrectTeamWhenMoreThanOneTeamExists() {
        Team.clearAllTeams();
        Team team = new Team("Hackers", "A group of students ready to code!");
        Team team2 = new Team("Slackers", "Not the best hackers");
        assertEquals(2, Team.findById(team2.getId()).getId());
    }


}