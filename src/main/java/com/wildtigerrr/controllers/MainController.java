package com.wildtigerrr.controllers;

import com.wildtigerrr.config.ApplicationConfig;
import com.wildtigerrr.service.FilesInteraction;
import com.wildtigerrr.service.HtmlServices;
import com.wildtigerrr.service.MathCalc;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(value = "/restapp")
public class MainController extends ApplicationConfig {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(MainController.class);
        return s;
    }

    @RequestMapping(value = "",
            method = RequestMethod.GET)
    public String redir() {
        return HtmlServices.redir("http://localhost:8080/restapp/");
    }

    @RequestMapping(value = "/",
            method = RequestMethod.GET)
    public String index() {
        String page = FilesInteraction.getFileInString("pages/index.jsp");
        String UTFpage = FilesInteraction.toUTF(page);
        return UTFpage;
    }

    @RequestMapping(value = "/version",
            method = RequestMethod.GET)
    public String vers() {
        String vers = "Here must be version. But it isn't.";
        return HtmlServices.htmlWrap(vers);
    }

    @RequestMapping(value = "/test/{id}",
            method = RequestMethod.GET)
    public String getWelcome(@PathVariable(value = "id") String id) {
        System.out.println("Привет, мир!");
        return "И это должно вывести цифру, точно говорю: " + id;
    }

    @RequestMapping(value = "/math/{x}/{y}",
            method = RequestMethod.GET)
    public double pythagoreanTheorem(@PathVariable int x, @PathVariable int y) {
        double calc = MathCalc.pythagoreanTher(x, y);
        return calc;
    }

    @RequestMapping(value = "/testfile",
            method = RequestMethod.GET)
    public String testfile(){
        return FilesInteraction.create("first.txt") + FilesInteraction.write("first.txt", "Yeah") + FilesInteraction.getFileInString("first.txt");
    }

    @RequestMapping(value = "/db",
            method = RequestMethod.GET)
    public String db(){

        String page = FilesInteraction.getFileInString("machine.html");
        String UTFpage = FilesInteraction.toUTF(page);
        return UTFpage;

    }

    @RequestMapping(value = "/machine",
            method = RequestMethod.GET)
    public String machine(@RequestParam(value = "month", required = false) int airlines,
                          @RequestParam(value = "c") Integer id_c){
        String test;
        try {
            test = "Function is unavaible.";//new DBInteraction().select(id_c.toString());
        } catch (NullPointerException e){
            test = "Null pointer =(";
        }

        return test;
    }

}
