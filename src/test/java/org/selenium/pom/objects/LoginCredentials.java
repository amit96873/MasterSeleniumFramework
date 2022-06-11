package org.selenium.pom.objects;

public class LoginCredentials {
    private String username;
    private  String password;
    private String groupname;

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }



    public LoginCredentials(){

    }

    public LoginCredentials(String username,String password){
        this.username=username;
        this.password=password;
    }





    public String getUsername() {
        return username;
    }

    public LoginCredentials setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginCredentials setPassword(String password) {
        this.password = password;
        return this;
    }


}
