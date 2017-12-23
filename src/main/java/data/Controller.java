package data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller {
    private static Controller instance;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private Service service = Service.getInstance();

    public static Controller getInstance(){
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public Model getModel(){
        return service.generateList();
    }

    public void checkController(HttpServletRequest req, HttpServletResponse resp){
        request = req;
        response = resp;
        System.out.println("addControllerbtn = " + req.getParameter("btn"));
        if (req.getParameter("btn") == null) return;
        if (req.getParameter("btn").equals("change")){
            change();
        }
    }

    private void change(){
        service.change(request.getParameter("name"));
    }
}
