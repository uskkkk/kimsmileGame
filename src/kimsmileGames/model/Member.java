package kimsmileGames.model;

import java.util.List;

public class Member {
    String id;
    String password;
    String nickName;
    Boolean Gender;
    List<GameInfo> gameInfoList;
    List<backpackItem> backpackItems;

    private static Member memberObject;

    public List<backpackItem> getBackpackItems() {
        return backpackItems;
    }

    public void setBackpackItems(List<backpackItem> backpackItems) {
        this.backpackItems = backpackItems;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Boolean getGender() {
        return Gender;
    }

    public void setGender(Boolean gender) {
        Gender = gender;
    }

    public Member(String id, String password, String nickName, Boolean gender) {
        this.id = id;
        this.password = password;
        this.nickName = nickName;
        Gender = gender;
    }

    public List<GameInfo> getGameInfoList() {
        return gameInfoList;
    }

    public void setGameInfoList(List<GameInfo> gameInfoList) {
        this.gameInfoList = gameInfoList;
    }

    private Member() {
    }

    // getInstance()
    public static Member getInstance() {
        if (memberObject == null) {
            memberObject = new Member();
        }

        return memberObject;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Member{");
        sb.append("id='").append(id).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", nickName='").append(nickName).append('\'');
        sb.append(", Gender=").append(Gender ? "남자" : "여자");
        sb.append(", gameInfoList=").append(gameInfoList);
        sb.append(", backpackItems=").append(backpackItems);
        sb.append('}');
        return sb.toString();
    }
}
