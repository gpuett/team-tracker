package dao;

import models.*;
import org.junit.*;
import org.sql2o.*;

import static org.junit.Assert.*;

public class Sql2oTeamDaoTest {
    private Sql2oTeamDao teamDao;
    private Sql2oMemberDao memberDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        teamDao = new Sql2oTeamDao(sql2o);
        memberDao = new Sql2oMemberDao(sql2o);
        conn = sql2o.open();

    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingTeamSetsId() throws Exception {
        Team team = new Team("Hackers", "A group of Epicodus students");
        int originalTeamId = team.getId();
        teamDao.add(team);
        assertNotEquals(originalTeamId, team.getId());
    }

    @Test
    public void getAll_getsAllCorrectly() {
        Team team1 = new Team("Hackers", "A group of Epicodus students");
        teamDao.add(team1);
        Team team2 = new Team("Slackers", "Not a group of Epicodus students");
        teamDao.add(team2);
        assertEquals(2, teamDao.getAll().size());
    }

    @Test
    public void getAllReturnsNoTeamsIfNoneAdded() throws Exception{
        assertEquals(0, teamDao.getAll().size());
    }

    @Test
    public void findById_correctlyFindsTeam() {
        Team team = new Team("Hackers", "A group of Epicodus students");
        teamDao.add(team);
        Team foundTeam = teamDao.findById(team.getId());
        assertEquals(team, foundTeam);
    }

    @Test
    public void updateUpdatesCorrectly() {

    }

    @Test
    public void deleteById() {
    }

    @Test
    public void clearAllTeams() {
    }

    @Test
    public void getAllMembersByTeam() {
    }
}