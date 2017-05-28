package edu.upc.eetac.dsa.android;

/**
 * Created by Ignacio on 23/05/2017.
 */
public class Contributor {

    String login;
    int contributions;
    String avatar_url;
    String bio;
    String email;
    String name;
    String company;


    public String getLogin() {
        return login;
    }

    public int getContributions() {
        return contributions;
    }

    public String getAvatarUrl() {
        return avatar_url;
    }

    public String getBio() {
        return bio;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }
    @Override
    public String toString() {
        return login;
    }
}