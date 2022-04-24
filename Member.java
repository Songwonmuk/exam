package exam;

public class Member {
    private String name;
    private String phoneNumber;
    private int age;

    public Member(String name, String phoneNumber, int age) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return this.phoneNumber + " / " + this.name + " / " + this.age;
    }
}
