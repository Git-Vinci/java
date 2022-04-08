package cn.huarui.entity;

public class User {
    private int sid;
    private String  userName;
    private String address;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "sid=" + sid +
                ", userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
