package deors.demos.cloud.awslambda;

public class HelloRequest {

    private String name;
    private Integer age;

    public HelloRequest() {
        super();
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setAge(Integer newAge) {
        this.age = newAge;
    }
}
