package ro.cristiantdrc.easy_yard_sale_final.Login;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LoggedUser {
    private int userLoggedId;

    public int getUserLoggedId() {
        return userLoggedId;
    }

    public void setUserLoggedId(int userLoggedId) {
        this.userLoggedId = userLoggedId;
    }
}
