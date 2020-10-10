package application;

public class StateManager {

    private static StateManager _instance = new StateManager();

    private StateManager() {
    }

    /**
     * Used to return the single instance of this class.
     * 
     * @return StateManager
     */
    public static StateManager getInstance() {
        return _instance;
    }
    
}
