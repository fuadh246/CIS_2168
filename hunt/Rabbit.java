public class Rabbit extends Animal {
    private boolean haveSeenFox = false;
    private boolean canSeeFoxNow = false;
    private int distanceToFox;
    private int directionToFox;
    private int currentDirection;

    public Rabbit(Model model, int row, int column) {
        super(model, row, column);
    }

    int decideMove() {
        currentDirection = Model.random(Model.MIN_DIRECTION, Model.MAX_DIRECTION);
        canSeeFoxNow = false;
        for (int i = Model.MIN_DIRECTION; i <= Model.MAX_DIRECTION; i++) {
            if (look(i) == Model.FOX) {
                canSeeFoxNow = haveSeenFox = true;
                directionToFox = i;
            }
        }
//        System.out.println(haveSeenFox);
//        System.out.println("sid "+distanceToFox);
        if (haveSeenFox) {
//            System.out.println(haveSeenFox);
            if (canMove(Model.turn(directionToFox,4))) {
//                System.out.println(canMove(oppDic(directionToFox)));
//                System.out.println("can move");
                return Model.turn(directionToFox,4);
            } else { // rabbit was here--where did it go?
//                System.out.println("cann't move");

                haveSeenFox = false;
                currentDirection = Model.random(Model.MIN_DIRECTION,
                        Model.MAX_DIRECTION);
            }
        }
        if (canMove(currentDirection))
            return currentDirection;
        else if (canMove(Model.turn(currentDirection, 1)))
            return Model.turn(currentDirection, 1);
        else if (canMove(Model.turn(currentDirection, -1)))
            return Model.turn(currentDirection, -1);
        else {
            currentDirection = Model.random(Model.MIN_DIRECTION,
                    Model.MAX_DIRECTION);
            for (int i = 0; i < 8; i++) {
                if (canMove(currentDirection))
                    return currentDirection;
                else
                    currentDirection = Model.turn(currentDirection, 1);
            }
        }
        return Model.STAY;
    }
}
