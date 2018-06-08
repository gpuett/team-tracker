package dao;

import models.*;
import org.junit.*;
import org.sql2o.*;

import static org.junit.Assert.*;

public class Sql2oMemberDaoTest {
    private Sql2oMemberDao memberDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        memberDao = new Sql2oMemberDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void add_addingMemberSetsId() throws Exception {
        Member member = new Member("John", 1);
        int originalMemberId = member.getId();
        memberDao.add(member);
        assertNotEquals(originalMemberId, member.getId());
    }

    @Test
    public void getAll_getsAllCorrectly() {
        Member member1 = new Member("John", 1);
        memberDao.add(member1);
        Member member2 = new Member("Sarah", 1);
        memberDao.add(member2);
        assertEquals(2, memberDao.getAll().size());
    }

    @Test
    public void getAllReturnsNoMemberIfNoneAdded() {
        assertEquals(0, memberDao.getAll().size());
    }

    @Test
    public void findById() {
    }

    @Test
    public void update() {
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void clearAllMembers() {
    }
}