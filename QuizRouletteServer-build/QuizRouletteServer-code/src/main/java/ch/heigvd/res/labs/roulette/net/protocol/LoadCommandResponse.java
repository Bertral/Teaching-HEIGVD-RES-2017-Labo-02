package ch.heigvd.res.labs.roulette.net.protocol;

/**
 * Project : QuizRouletteServer-build
 * Author(s) : Antoine Friant
 * Date : 28.03.17
 */
public class LoadCommandResponse {
    private int numberOfStudents;
    private String status;

    public void setNumberOfStudents(int n) {
        numberOfStudents = n;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
