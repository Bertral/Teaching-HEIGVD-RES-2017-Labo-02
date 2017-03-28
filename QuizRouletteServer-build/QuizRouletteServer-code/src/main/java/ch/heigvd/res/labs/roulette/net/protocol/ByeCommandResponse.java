package ch.heigvd.res.labs.roulette.net.protocol;

/**
 * Project : QuizRouletteServer-build
 * Author(s) : Antoine Friant
 * Date : 28.03.17
 */
public class ByeCommandResponse {
    private String status;
    private int numberOfCommands;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNumberOfCommands() {
        return numberOfCommands;
    }

    public void setNumberOfCommands(int numberOfCommands) {
        this.numberOfCommands = numberOfCommands;
    }
}
