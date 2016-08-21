/**
 * Generates draft pick positions per round
 */
class DraftPositionGenerator {
    private int numberOfTeams;
    private int draftPosition;
    private int rosterSize;
    private int[] draftPicks;
    private int numOfSelectsBeforePosition;
    private int numOfSelectsAfterPositionToEnd;
    private int currentPick;
    private int currentRound;

    DraftPositionGenerator(int numberOfTeams, int draftPosition, int rosterSize) {
        this.numberOfTeams = numberOfTeams;
        this.draftPosition = draftPosition;
        this.rosterSize = rosterSize;
        this.draftPicks = new int[rosterSize];
    }

    void run() {
        numOfSelectsBeforePosition = draftPosition - 1; // 1 is for your position
        numOfSelectsAfterPositionToEnd = numberOfTeams - draftPosition;
        currentPick = draftPicks[0] = draftPosition; // First pick
        // Kick off recursive calls
        currentRound = 2;
        processDraft();
        printArray(draftPicks);
    }

    /**
     * Iterates over round to calculate drat position per round
     */
    private void processDraft(){
        if (!isEven(currentRound)) {
            draftPicks[currentRound-1] = currentPick =
                    currentPick + (numOfSelectsBeforePosition * 2 + 1);
        } else {
            draftPicks[currentRound-1] = currentPick =
                    currentPick + (numOfSelectsAfterPositionToEnd * 2 + 1);
        }
        currentRound++;
        while ( currentRound <= rosterSize ) {
            processDraft();
        }
    }

    /**
     * Prints integer array to console
     * @param array
     */
    private void printArray (int[] array) {
        for (int i : array){
            System.out.println(i);
        }
    }

    /**
     * Checks if integer is even
     * @param thisInt
     * @return boolean
     */
    private boolean isEven(int thisInt) {
        return thisInt % 2 == 0;
    }

}
