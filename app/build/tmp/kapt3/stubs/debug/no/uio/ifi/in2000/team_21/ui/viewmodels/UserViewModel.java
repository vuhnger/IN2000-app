package no.uio.ifi.in2000.team_21.ui.viewmodels;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\t\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J&\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0019J\u000e\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0019J\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00190!J\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0006\u0010#\u001a\u00020\u0017J\u000e\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\nJ\u000e\u0010&\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0019J&\u0010\'\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0019J\u000e\u0010)\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\nR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lno/uio/ifi/in2000/team_21/ui/viewmodels/UserViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_users", "", "Lno/uio/ifi/in2000/team_21/model/user/User;", "currentUser", "Landroidx/lifecycle/LiveData;", "Lno/uio/ifi/in2000/team_21/data/database/UserEntity;", "getCurrentUser", "()Landroidx/lifecycle/LiveData;", "setCurrentUser", "(Landroidx/lifecycle/LiveData;)V", "db", "Lno/uio/ifi/in2000/team_21/data/database/AppDatabase;", "defaultUser", "userCount", "", "userDao", "Lno/uio/ifi/in2000/team_21/data/database/UserDao;", "createUser", "", "name", "", "hobby", "userName", "password", "createUsername", "deleteUser", "username", "getNames", "", "getUsers", "logOut", "saveUser", "user", "setActiveUser", "testCreateUser", "hobbyDescription", "updateUser", "app_debug"})
public final class UserViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull
    private final no.uio.ifi.in2000.team_21.data.database.AppDatabase db = null;
    @org.jetbrains.annotations.NotNull
    private final no.uio.ifi.in2000.team_21.data.database.UserDao userDao = null;
    @org.jetbrains.annotations.NotNull
    private androidx.lifecycle.LiveData<no.uio.ifi.in2000.team_21.data.database.UserEntity> currentUser;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<no.uio.ifi.in2000.team_21.model.user.User> _users = null;
    @org.jetbrains.annotations.NotNull
    private final no.uio.ifi.in2000.team_21.model.user.User defaultUser = null;
    private int userCount = -1;
    
    public UserViewModel(@org.jetbrains.annotations.NotNull
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<no.uio.ifi.in2000.team_21.data.database.UserEntity> getCurrentUser() {
        return null;
    }
    
    public final void setCurrentUser(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.LiveData<no.uio.ifi.in2000.team_21.data.database.UserEntity> p0) {
    }
    
    public final void createUser(@org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    java.lang.String hobby, @org.jetbrains.annotations.NotNull
    java.lang.String userName, @org.jetbrains.annotations.NotNull
    java.lang.String password) {
    }
    
    public final void updateUser(@org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.data.database.UserEntity user) {
    }
    
    public final void logOut() {
    }
    
    public final void deleteUser(@org.jetbrains.annotations.NotNull
    java.lang.String username) {
    }
    
    public final void setActiveUser(@org.jetbrains.annotations.NotNull
    java.lang.String username) {
    }
    
    public final void saveUser(@org.jetbrains.annotations.NotNull
    no.uio.ifi.in2000.team_21.data.database.UserEntity user) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final no.uio.ifi.in2000.team_21.model.user.User testCreateUser(@org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    java.lang.String hobbyDescription, @org.jetbrains.annotations.NotNull
    java.lang.String userName, @org.jetbrains.annotations.NotNull
    java.lang.String password) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<no.uio.ifi.in2000.team_21.model.user.User> getUsers() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getNames() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String createUsername(@org.jetbrains.annotations.NotNull
    java.lang.String name) {
        return null;
    }
}