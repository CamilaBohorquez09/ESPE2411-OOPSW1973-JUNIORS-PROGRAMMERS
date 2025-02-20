package ec.edu.espe.samc.model;

public class Account {
    private String name;
    private String lastName;
    private String userName;
    private String password;

    // Instancia única de la clase
    private static Account instance;

    // Constructor privado
    private Account(String name, String lastName, String username, String password) {
        this.name = name;
        this.lastName = lastName;
        this.userName = username;
        this.password = password;
    }

    // Método estático para obtener la instancia única de la clase
    public static Account getInstance(String name, String lastName, String username, String password) {
        if (instance == null) {
            instance = new Account(name, lastName, username, password);
        }
        return instance;
    }

    // Getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
