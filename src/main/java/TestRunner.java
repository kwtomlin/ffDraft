/**
 * Created by kennytomlinson on 8/21/16.
 */
public class TestRunner {
    /**
     * CONFIGS
     * {int numberOfTeams, int draftPosition, int rosterSize}
     */
    // It's time for some football
    int[] timeForFootball = {10, 6, 16};

    public static void main (String[] args) {
        DraftPositionGenerator draftPositionGenerator =
                new DraftPositionGenerator(10, 6, 16);
        draftPositionGenerator.run();
    }
}
