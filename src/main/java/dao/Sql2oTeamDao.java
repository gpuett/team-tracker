package dao;

import models.*;
import org.sql2o.*;
import java.util.List;

public class Sql2oTeamDao implements TeamDao{
    private final Sql2o sql2o;

    public Sql2oTeamDao(Sql2o sql2o) {
        this.sql2o - sql2o;
    }

    @Override
    public List<Team> getAll() {
        try(Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM teams")
                    .executeAndFetch(Team.class);
        }
    }


}
