import java.util.UUID;

public abstract class Account implements AccountManagement {
    private String username;
    private int password;
    private UUID accountID;

    public Account(String username, String password) {
        this.username = username;
        this.password = password.hashCode();
        accountID = UUID.randomUUID();
    }

    @Override
    public boolean validatePassword(String enteredPassword) {
        if (enteredPassword.length() < 8)
            return false ;
        return true;
    }

    @Override
    public void changeUsername(String newUsername) {
        username = newUsername ;
    }

    @Override
    public void changePassword(String newPassword) {
        password = newPassword.hashCode() ;
    }

    public abstract void Log_In(String username, String password);

    public abstract void Sign_Up(String username, String password);


}
