package util;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public int generateNumber() {
        return (int) (Math.random() * 10);
    }
}
