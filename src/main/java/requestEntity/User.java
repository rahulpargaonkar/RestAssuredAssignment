package requestEntity;

public class User {
    private String name;
    private String job;
    private String id;

    public User(String id) {
        this.id = id;
    }

    public User(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public String getJob() {
        return this.job;
    }

}
