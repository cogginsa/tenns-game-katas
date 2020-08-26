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
        if (arePointsEqual() && P1point>=3){
            score = "Deuce";
        } else if (arePointsEqual() && isGameStillInPlay()){
            score = getTiedScore(P1point);
        }

        if (isAdvantageP1())
        {
            P1res = getScoreString(P1point);

            P2res = "Love";
            score = joinScores();
        }

        if (isAdvantageP2())
        {
            P2res = getScoreString(P2point);
            P1res = "Love";
            score = joinScores();
        }

        if (P1point!=P2point && isGameStillInPlay())
        {
            P1res = getScoreString(P1point);
            P2res = getScoreString(P2point);
            score = joinScores();
        }

        if (P1point > P2point && P2point >= 3)
        {
            score = "Advantage player1";
        }

        if (P2point > P1point && P1point >= 3)
        {
            score = "Advantage player2";
        }

        if(isEndOfGame()){
            if (isAheadBy2PointsOrMore(P1point, P2point))
            {
                score = "Win for player1";
            }
            else if (isAheadBy2PointsOrMore(P2point, P1point))
            {
                score = "Win for player2";
            }
        }


        return score;
    }

    public void P1Score(){
        P1point++;
    }

    public void P2Score(){
        P2point++;
    }

    private boolean arePointsEqual(){
        return P1point == P2point;
    }

    private boolean isGameStillInPlay(){
        return P1point < 4 && P2point < 4;
    }

    private boolean isAdvantageP1(){
        return P1point > 0 && P2point==0;
    }

    private boolean isAdvantageP2(){
        return P2point > 0 && P1point==0;
    }

    private boolean isEndOfGame(){
        return  P2point >= 4 || P1point >= 4;
    }

    private boolean isAheadBy2PointsOrMore(int point1, int point2){
        return (point1-point2)>=2;
    }

    private String joinScores(){
        return P1res + "-" + P2res;
    }


    private String getScoreString(int playerPoints){
        switch (playerPoints) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
        }
        return "";
    }

    private String getTiedScore(int playerPoints){
        return getScoreString(playerPoints) + "-All";
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}
