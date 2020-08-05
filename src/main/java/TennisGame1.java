import org.w3c.dom.stylesheets.LinkStyle;

import javax.sound.midi.SysexMessage;
import java.util.List;

public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score = "";
        if (m_score1==m_score2)
        {
            score = getMatchScoreString(m_score1);
        }
        else if (m_score1>=4 || m_score2>=4)
        {
            int minusPlayerScores = m_score1-m_score2;
            score = getPlayerScoreString(minusPlayerScores);
        }
        else
        {
            score = getPlayerIndividualScores();
        }
        return score;
    }

    private String getPlayerIndividualScores(){
        String scoreToReturn = "";
        int tempScore=0;

        for (int i=1; i<3; i++)
        {
            if (i==1) tempScore = m_score1;
            else { scoreToReturn+="-"; tempScore = m_score2;}
            scoreToReturn += getMatchPointSuffix(tempScore);
        }
        return scoreToReturn;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    private String getMatchScoreString(int scoreToCheck){
        switch (scoreToCheck)
        {
            case 0:
                return TennisConstants.LOVE_ALL;
            case 1:
                return TennisConstants.FIFTEEN_ALL;
            case 2:
                return TennisConstants.THIRTY_ALL;
            default:
                return TennisConstants.DEUCE;
        }
    }

    private String getPlayerScoreString(int differenceOfPlayerPoints){
        if (differenceOfPlayerPoints==1) return TennisConstants.ADV_PLAYER_1;
        else if (differenceOfPlayerPoints ==-1) return TennisConstants.ADV_PLAYER_2;
        else if (differenceOfPlayerPoints>=2) return TennisConstants.WIN_PLAYER_1;
        else return TennisConstants.WIN_PLAYER_2;
    }

    private String getMatchPointSuffix(int scoreToCheckAgainst){
        switch(scoreToCheckAgainst)
        {
            case 0:
                return TennisConstants.SUFF_LOVE;
            case 1:
                return TennisConstants.SUFF_FIFTEEN;
            case 2:
                return TennisConstants.SUFF_THIRTY;
            case 3:
                return TennisConstants.SUFF_FORTY;
        }
        return "";
    }
}

