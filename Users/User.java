package Pesron;
public class User {
    
    enum Role {STUDENT, ADMIN};

    private String personID;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role personRole;

        // Constructor 1 - Default Constructor
        public User() {
        }
    
        // Constructor 2 - Parameterized Constructor
        public User(String personID, String firstName, String lastName, String email, String password, Role personRole) {
            this.personID = personID;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.password = password;
            this.personRole = personRole;
        }
    
        // Getter and Setter for personID
        public String getPersonID() {
            return personID;
        }
    
        public void setPersonID(String personID) {
            this.personID = personID;
        }
    
        // Getter and Setter for firstName
        public String getFirstName() {
            return firstName;
        }
    
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
    
        // Getter and Setter for lastName
        public String getLastName() {
            return lastName;
        }
    
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    
        // Getter and Setter for email
        public String getEmail() {
            return email;
        }
    
        public void setEmail(String email) {
            this.email = email;
        }
    
        // Getter and Setter for password
        public String getPassword() {
            return password;
        }
    
        public void setPassword(String password) {
            this.password = password;
        }
    
        // Getter and Setter for personRole
        public Role getPersonRole() {
            return personRole;
        }
    
        public void setPersonRole(Role personRole) {
            this.personRole = personRole;
        }

}
