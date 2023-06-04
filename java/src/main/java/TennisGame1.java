
public class TennisGame1 implements TennisGame {
    
    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;
    private String namePlayer1;
    private String namePlayer2;

    public TennisGame1(String player1Name, String player2Name) {
        this.namePlayer1 = player1Name;
        this.namePlayer1 = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            scorePlayer1 += 1;
        else
            scorePlayer2 += 1;
    }

    public String getScore() {
        String score = "";
        int tempScore=0;
        if (scorePlayer1==scorePlayer2)
        {
            score = switch (scorePlayer1) {
                case 0 -> "Love-All";
                case 1 -> "Fifteen-All";
                case 2 -> "Thirty-All";
                default -> "Deuce";
            };
        }
        else if (scorePlayer1>=4 || scorePlayer2>=4)
        {
            int minusResult = scorePlayer1-scorePlayer2;
            if (minusResult==1) score ="Advantage player1";
            else if (minusResult ==-1) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = scorePlayer1;
                else { score+="-"; tempScore = scorePlayer2;}
                switch(tempScore)
                {
                    case 0:
                        score+="Love";
                        break;
                    case 1:
                        score+="Fifteen";
                        break;
                    case 2:
                        score+="Thirty";
                        break;
                    case 3:
                        score+="Forty";
                        break;
                }
            }
        }
        return score;
    }
}
