// Observer pattern
interface Observer {
    void update(String taskId);
}

class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void update(String taskId) {
        System.out.println("Dear " + name + ", task " + taskId + " has been updated.");
    }
}
