import org.junit.Test;

import static org.junit.Assert.*;

public class TeamTest {
    @Test
    public void newTeam_teamInstantiatesCorrectly() {
        Team team = new Team();
        assertEquals(true, team instanceof Team);
    }
}