package cloud.microservices.spring.boot.licensingservice.utils;

public class UserContextHolder {

    private static final ThreadLocal<UserContext> context = new ThreadLocal<>();

    private static UserContext userContext;

    public static UserContext get() {
        if(context.get() == null) {
            userContext = new UserContext();
            context.set(userContext);
        }
        return context.get();
    }

}
