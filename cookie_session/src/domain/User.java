package domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {

    private String username;
    private String password;
    private Integer id;
    private Date dateStr;

    public Date getDate() {
        return dateStr;
    }

    public void setDate(Date date) {
        this.dateStr = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }

    public String getDateStr(){
        if(dateStr != null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 :HH:mm:ss");
            return simpleDateFormat.format(dateStr);
        }else
            return "";

    }

    public User() {
    }

    public User(String username, String password, Integer id, Date date) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.dateStr = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
