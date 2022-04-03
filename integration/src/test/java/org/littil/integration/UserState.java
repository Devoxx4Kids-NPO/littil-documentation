package org.littil.integration;

import lombok.Data;

import java.util.HashSet;

@Data
public class UserState {

    HashSet<String> emails = new HashSet<>();
    private String currentUser;

    public void addUserByEmail(String email) {
        emails.add(email);
    }

    public boolean emailExists(String email){
        return emails.contains(email);
    }
}
