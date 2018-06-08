package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class MemberTest {
    @Test
    public void newMember_memberInstantiatesCorrectly() {
        Member member = new Member("John", 1);
        assertEquals(true, member instanceof Member);
    }

    @Test
    public void getName_getNamesCorrectly() {
        Member member = new Member("John", 1);
        assertEquals("John", member.getName());
    }
}