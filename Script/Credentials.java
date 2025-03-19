public class Credentials {
    private String username;
    private String password;

    // Constructor to initialize credentials
    public Credentials() {
        this.username = "neha@intervue.io"; // You can later fetch from a file
        this.password = "Int@123neha";
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }
}
