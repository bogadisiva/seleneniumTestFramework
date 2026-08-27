package model;

public class EntryForm {
    private String title;
    private String fullName;
    private String email;
    private String address;
    private String password;
    private String expectedMessage;
    public EntryForm(){

    }

//    public EntryForm(
//            String title,
//            String fullName,
//            String email,
//            String address,
//            String password
//    ) {
//        this.title = title;
//        this.fullName = fullName;
//        this.email = email;
//        this.address = address;
//        this.password = password;
//    }
public String getTitle() {
    return title;
}

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getExpectedMessage() {
        return expectedMessage;
    }

    public void setExpectedMessage(
            String expectedMessage
    ) {
        this.expectedMessage = expectedMessage;
    }
}
