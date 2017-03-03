package com.wildtigerrr.controllers;

import com.wildtigerrr.config.ApplicationConfig;
import com.wildtigerrr.config.Variables;
import com.wildtigerrr.service.FilesInteraction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(value = "/ajax")
public class AJAXController extends ApplicationConfig {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(AJAXController.class);
        return s;
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String printWelcome() {
        String page = FilesInteraction.getFileInString("\\src\\main\\webapp\\pages\\ajax\\upload.jsp");
        String UTFpage = FilesInteraction.toUTF(page);
        return UTFpage;
    }
    //    from >
    @RequestMapping(value = "/ajaxtest", method = RequestMethod.GET)
    public Set<String> ajaxTest() {
        Set<String> records = new HashSet<String>();
        records.add("Record #1");
        records.add("Record #2");

        return records;
    }

    @RequestMapping(value = "/tabletest", method = RequestMethod.GET)
    public String table() {
        String page = FilesInteraction.getFileInString("\\src\\main\\webapp\\pages\\ajax\\tabletest.jsp");
        String UTFpage = FilesInteraction.toUTF(page);
        return UTFpage;
    }
    //    from >
    @RequestMapping(value = "/tabletestfin", method = {RequestMethod.GET, RequestMethod.POST})
    public String tablefin(@RequestParam(value = "red", required = false) String redcells,
                           @RequestParam(value = "blue", required = false) String bluecells) {
        String answer = "Выделенные красные ячейки: " + redcells + ", выделенные синие ячейки: " + bluecells;
        return answer;
    }

    @RequestMapping(value = "/inputtest", method = RequestMethod.GET)
    public String inputTest() {
        String page = FilesInteraction.getFileInString("\\src\\main\\webapp\\pages\\ajax\\testget.jsp");
        String UTFpage = FilesInteraction.toUTF(page);
        return UTFpage;
    }
    //    from >
    @RequestMapping(value = "/getinputtest", method = {RequestMethod.GET, RequestMethod.POST})
    public String getInputTest(@RequestParam(value = "string", required = false) String input) {
        System.out.println(input);
        FilesInteraction.toUTF(input);
        String answer = "Введено: " + input;
        System.out.println(Variables.getPath());
        System.out.println(System.getProperty("user.dir"));
        System.out.println(answer);
        return answer;
    }

}
