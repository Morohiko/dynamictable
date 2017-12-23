package data;

class Service {
    private Service(){}
    private static Service instance;
    static Service getInstance(){
        if (instance == null) {
            instance = new Service();
        }
        return instance;
    }

    private DAO dao = DAO.getInstance();
    private Model model = null;
    Model generateList(){
        model = dao.getAllPerson();
        return model;
    }

    void change(String name){
        dao.setTableName(name);
        model = dao.getAllPerson();
    }
}
