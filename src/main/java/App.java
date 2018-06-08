import models.Member;
import models.Team;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.Spark.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.sql2o.Sql2o;
import dao.*;


import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String connectionString = "jdbc:h2:~/todolist.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        Sql2oTeamDao teamDao = new Sql2oTeamDao(sql2o);
        Sql2oMemberDao memberDao = new Sql2oMemberDao(sql2o);

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Team> teams = teamDao.getAll();
            model.put("teams", teams);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


        get("/teams/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "team-form.hbs");
        }, new HandlebarsTemplateEngine());


        post("/teams/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String description = request.queryParams("description");
            Team newTeam = new Team(name, description);
            teamDao.add(newTeam);
            int newTeamId = newTeam.getId();
            String name1 = request.queryParams("member1");
            Member member1 = new Member(name1, newTeamId);
            memberDao.add(member1);
            String name2 = request.queryParams("member2");
            Member member2 = new Member(name2, newTeamId);
            memberDao.add(member2);
            String name3 = request.queryParams("member3");
            Member member3 = new Member(name3, newTeamId);
            memberDao.add(member3);
            model.put("teams", newTeam);
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        get("/teams/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfTeamToFind = Integer.parseInt(req.params("id"));
            Team foundTeam = teamDao.findById(idOfTeamToFind);
            model.put("team", foundTeam);
            List<Member> allMembersByTeam = teamDao.getAllMembersByTeam(idOfTeamToFind);
            model.put("members", allMembersByTeam);
            return new ModelAndView(model, "team-detail.hbs");
        }, new HandlebarsTemplateEngine());

        post("/teams/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String newName = req.queryParams("name");
            int idOfTeamToFind = Integer.parseInt(req.params("id"));
            Member newMember = new Member(newName, idOfTeamToFind);
            memberDao.add(newMember);
            res.redirect("/teams/" + idOfTeamToFind);
            return null;
        }, new HandlebarsTemplateEngine());
//
//        get("teams/:id/update", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            int idOfTeamToEdit = Integer.parseInt(req.params("id"));
//            Team editTeam = Team.findById(idOfTeamToEdit);
//            model.put("editTeam", editTeam);
//            return new ModelAndView(model, "team-form.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        post("teams/:id/update", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            String newName = req.queryParams("name");
//            String newDescription = req.queryParams("description");
//            int idOfTeamToEdit = Integer.parseInt(req.params("id"));
//            Team editTeam = Team.findById(idOfTeamToEdit);
//            editTeam.update(newName, newDescription);
//            return new ModelAndView(model, "success.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        get("/about", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            return new ModelAndView(model, "about.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        get("/teams/:id/delete", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            int idOfTeamToDelete = Integer.parseInt(req.params("id"));
//            Team deleteTeam = Team.findById(idOfTeamToDelete);
//            deleteTeam.deleteTeam();
//            return new ModelAndView(model, "success.hbs");
//        }, new HandlebarsTemplateEngine());
    }
}
