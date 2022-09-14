package model;

public class Medical_center {
    Integer id;
    String centreName;
    Integer user_id;

    public Medical_center() {
    }

    public Medical_center(Integer id, String centreName, Integer user_id) {
        this.id = id;
        this.centreName = centreName;
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Medical_center{" +
                "id=" + id +
                ", centreName='" + centreName + '\'' +
                ", user_id=" + user_id +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCentreName() {
        return centreName;
    }

    public void setCentreName(String centreName) {
        this.centreName = centreName;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
