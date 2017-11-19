package data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Controller {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private Service service = Service.getInstance();

    public Model getModel(){
        return service.generateList();
    }

    public void checkController(HttpServletRequest req, HttpServletResponse resp){
        request = req;
        response = resp;
        if (req.getParameter("btn") != null)
            addController();
    }

    private void addController(){
//        String name = request.getParameter("name");
//        int age = Integer.parseInt(request.getParameter("age"));
//        Person person = new Person(name, age);
//        System.out.println("name = " + name + " age = " + age);
//        service.addToDB(person);
    }

    private void removeName(String name){

    }


}
