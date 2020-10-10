package application;

public class StateManager {

    private static StateManager _instance = new StateManager();
    
    private Select _select = Select.EMPLOYEE;

    public enum Select {
        EMPLOYEE, PRODUCT, CUSTOMER, HOTEL, AIRLINE, TRAVEL,
    }

    public enum Product {
        HOTEL_DEAL, FLIGHT, PACKAGE_DEAL,
    }

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

    /**
     * @return Select return the select
     */
    public Select getSelect() {
        return _select;
    }

    /**
     * @param select the select to set
     */
    public void setSelect(Select select) {
        _select = select;
    }

}
