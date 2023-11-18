interface Handler {
    void setNext(Handler handler);
    void handleRequest(User user, Task task);
}

class HandlerA implements Handler {
    private Handler nextHandler;

    @Override
    public void setNext(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handleRequest(User user, Task task) {
        if (user.getNotificationPreference().equals("Preference A")) {
            System.out.println("Preference A chosen.");
        } else {
            nextHandler.handleRequest(user, task);
        }
    }
}

class HandlerB implements Handler {
    private Handler nextHandler;

    @Override
    public void setNext(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handleRequest(User user, Task task) {
        if (user.getNotificationPreference().equals("Preference B")) {
            System.out.println("Preference B chosen.");
        } else {
            nextHandler.handleRequest(user, task);
        }
    }
}
