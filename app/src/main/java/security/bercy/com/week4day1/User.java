package security.bercy.com.week4day1;

/**
 * Created by Bercy on 12/19/17.
 */

public class User {
    String name;
    String type;
    String location;
    String company;

    public User() {
    }

    public User(String name, String type, String location, String company) {
        this.name = name;
        this.type = type;
        this.location = location;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
