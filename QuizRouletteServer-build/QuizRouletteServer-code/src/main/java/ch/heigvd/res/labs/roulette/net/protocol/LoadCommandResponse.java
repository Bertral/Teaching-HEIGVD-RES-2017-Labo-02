package ch.heigvd.res.labs.roulette.net.protocol;

/**
 * Project : QuizRouletteServer-build
 * Author(s) : Antoine Friant
 * Date : 28.03.17
 */
public class LoadCommandResponse {
    private String status;
    private int numberOfNewStudents;

    public void setNumberOfNewStudents(int n) {
        numberOfNewStudents = n;
    }

    public int getNumberOfNewStudents() {
        return numberOfNewStudents;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
