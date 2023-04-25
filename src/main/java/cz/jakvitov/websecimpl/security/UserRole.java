package cz.jakvitov.websecimpl.security;

public enum UserRole {

    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    UserRole(String s){
        roleString = s;
    }
    final private String roleString;

    public String getRoleString(){
        return this.roleString;
    }

}
