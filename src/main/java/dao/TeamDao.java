package dao;

import models.*;
import java.util.List;

public interface TeamDao {
    List<Team> getAll();

    void add(Team team);

    Team findById(int id);

    void update(int id, String name, String description);

    void deleteById(int id);

    void clearAllTeams();

    List<Member> getAllMembersByTeam(int teamId);
}
