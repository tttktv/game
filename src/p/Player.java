package p;

public class Player {
    private String nickname;
    private int mmr;
    private int winstreak;

    public Player(String nickname, int mmr) {
        this.nickname = nickname;
        this.mmr = mmr;
        this.winstreak = 0;
    }

    public String getNickname() {
        return nickname;
    }

    public int getMmr() {
        return mmr;
    }

    public int getWinstreak() {
        return winstreak;
    }

    public void setMmr(int mmr) {
        this.mmr = mmr;
    }

    public void addMmr(int mmr) {
        this.mmr += mmr;
    }

    public void setWinstreak(int winstreak) {
        this.winstreak = winstreak;
    }

    public void win(boolean w){
        if (w) {
            if (winstreak>0){
                winstreak++;
            }
            else{
                winstreak=1;
            }
        }
        else{
            if (winstreak>0){
                winstreak=-1;
            }
            else{
                winstreak--;
            }

        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "nickname='" + nickname + '\'' +
                ", mmr=" + mmr +
                ", winstreak=" + winstreak +
                '}';
    }
}
