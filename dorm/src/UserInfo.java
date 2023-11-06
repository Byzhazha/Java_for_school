public class UserInfo {
    String account;//账号
    String password;//密码


    public UserInfo(){}
    public UserInfo(String account, String password) {
        super();
        this.account = account;
        this.password = password;
    }
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
