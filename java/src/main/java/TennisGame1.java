
public class TennisGame1 implements TennisGame {
    private final String namePlayer1;
    private final String namePlayer2;
    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;

    public TennisGame1(String namePlayer1, String namePlayer2) {
        this.namePlayer1 = namePlayer1;
        this.namePlayer2 = namePlayer2;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            scorePlayer1 += 1;
        } else {
            scorePlayer2 += 1;
        }
    }

    public String getScore() {
        return applesauce();
    }

    private String applesauce() {
        String score;
        if (isTiedScore()) {
            score = switch (scorePlayer1) {
                case 0 -> "Love-All";
                case 1 -> "Fifteen-All";
                case 2 -> "Thirty-All";
                default -> "Deuce";
            };
        } else if (isAnyPlayerAtOrAboveForty()) {
            score = getScoreStringForAtOrAbove40();
        } else {
            score = getScoreStringForOtherCases();
        }
        return score;
    }

    private String getScoreStringForOtherCases() {
        String scoreStringPlayer1 = intScoreToStringScore(scorePlayer1);
        String scoreStringPlayer2 = intScoreToStringScore(scorePlayer2);
        return "%s-%s".formatted(scoreStringPlayer1, scoreStringPlayer2);

    }

    private static String intScoreToStringScore(int scoreAsInt) {
        return switch (scoreAsInt) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> throw new IllegalStateException("Unexpected value: " + scoreAsInt);
        };
    }

    private String getScoreStringForAtOrAbove40() {
//@formatter:off
        return  isAdvantagePlayer1() ? "Advantage player1" :
                isAdvantagePlayer2() ? "Advantage player2" :
                isWinPlayer1()       ? "Win for player1"   :
                                       "Win for player2";
//@formatter:on
    }

    private boolean isWinPlayer1() {
        return scorePlayer1 >= scorePlayer2 + 2;
    }

    private boolean isAdvantagePlayer2() {
        return scorePlayer2 == scorePlayer1 + 1;
    }

    private boolean isAdvantagePlayer1() {
        return scorePlayer1 == scorePlayer2 + 1;
    }

    private boolean isAnyPlayerAtOrAboveForty() {
        return scorePlayer1 >= 4 || scorePlayer2 >= 4;
    }

    private boolean isTiedScore() {
        return scorePlayer1 == scorePlayer2;
    }
}
