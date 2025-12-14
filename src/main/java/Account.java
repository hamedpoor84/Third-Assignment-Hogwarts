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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public UUID getAccountID() {
        return accountID;
    }

    public void setAccountID(UUID accountID) {
        this.accountID = accountID;
    }

    @Override
    public void changeUsername(String newUsername) {
        username = newUsername ;
    }

    @Override
    public void changePassword(String newPassword) {
        password = newPassword.hashCode() ;
    }



}
