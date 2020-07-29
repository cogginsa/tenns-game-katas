public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        if (m_score1==m_score2) return getScoreStringForEqualScores(m_score1);
        else if (m_score1>=4 || m_score2>=4) return getScoreStringForScoreOver4();
        else return getScoreForGameStillInPlay();
    }

    private String getScoreForGameStillInPlay(){
        int tempScore=0;
        String result = "";
        for (int i=1; i<3; i++)
        {
            if (i==1){
                tempScore = m_score1;
            }
            else {
                result+="-";
                tempScore = m_score2;
            }

            result += getScoreSuffix(tempScore);
        }
        return result;
    }

    private String getScoreSuffix(int tempScore){
        switch(tempScore)
        {
            case 0: return "Love";
            case 1: return "Fifteen";
            case 2: return "Thirty";
            case 3: return "Forty";
            default: return "";
        }
    }

    private String getScoreStringForEqualScores(int m_score1){
        switch (m_score1)
        {
            case 0: return "Love-All";
            case 1: return "Fifteen-All";
            case 2: return "Thirty-All";
            default: return "Deuce";
        }
    }

    private String getScoreStringForScoreOver4(){
        int minusResult = m_score1-m_score2;

        if (minusResult==1) return "Advantage player1";
        else if (minusResult ==-1) return "Advantage player2";
        else if (minusResult>=2) return "Win for player1";
        else return "Win for player2";
    }
}
