package controller;

public class CookController {

    private static CookController instance;

    private CookController() {
    }

    public static CookController getInstance() {
        if(null == instance) {
            instance = new CookController();
        }
        return instance;
    }
}
