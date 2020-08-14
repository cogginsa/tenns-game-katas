public class TennisGame2 implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";

        if (P1point == P2point && P1point < 4)
        {
            score = getScoreStringByPlayerScore(P1point) + "-All";
        }

        if (P1point==P2point && P1point>=3)
            score = "Deuce";

        if (P1point > 0 && P2point==0)
        {
            P2res = "Love";
            P1res = getScoreStringByPlayerScore(P1point);
            score = P1res + "-" + P2res;
        }
        if (P2point > 0 && P1point==0)
        {
            P1res = "Love";
            P2res = getScoreStringByPlayerScore(P2point);
            score = P1res + "-" + P2res;
        }

        if (P2point != P1point && P2point < 4)
        {
            P1res = getScoreStringByPlayerScore(P1point);
            P2res = getScoreStringByPlayerScore(P2point);
            score = P1res + "-" + P2res;
        }
//

        if (P1point > P2point && P2point >= 3)
        {
            score = "Advantage player1";
        }

        if (P2point > P1point && P1point >= 3)
        {
            score = "Advantage player2";
        }

        if (P1point>=4 && P2point>=0 && (P1point-P2point)>=2)
        {
            score = "Win for player1";
        }
        if (P2point>=4 && P1point>=0 && (P2point-P1point)>=2)
        {
            score = "Win for player2";
        }
        return score;
    }

    public void SetP1Score(int number){

        for (int i = 0; i < number; i++)
        {
            incrementP1Score();
        }

    }

    public void SetP2Score(int number){

        for (int i = 0; i < number; i++)
        {
            incrementP2Score();
        }

    }

    private String getScoreStringByPlayerScore(int playerScore) {
        switch (playerScore){
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "no score";
        }
    }

    public void incrementP1Score(){
        P1point++;
    }

    public void incrementP2Score(){
        P2point++;
    }

    public void wonPoint(String player) {
        if (player.equals("player1"))
            incrementP1Score();
        else
            incrementP2Score();
    }
}
