package dao;

import models.*;
import java.util.List;

public interface MemberDao {

    List<Member> getAll();

    void add(Member member);

    Member findById(int id);

    void update(int id, String name, int teamId);

    void deleteById(int id);

    void clearAllMembers();
}
