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

    Model generateList(){
        Model model = dao.getAllPerson();
        return model;
    }

//    void addToDB(Model model){
//        dao.insertToDB(model);
//    }

}
