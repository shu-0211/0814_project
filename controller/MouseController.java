public class MouseController{
    private MouseController() {}

    private static final MouseController instance = new MouseController();

    public static MouseController getInstance() {return instance;}
}