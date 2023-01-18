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
        for (int i = Model.MIN_DIRECTION; i < Model.MAX_DIRECTION; i++) {
            if (look(i) == Model.FOX) {
                canSeeFoxNow = haveSeenFox = true;
                directionToFox = i;
            }
        }
//        System.out.println(haveSeenFox);
//        System.out.println("sid "+distanceToFox);
        if (haveSeenFox) {
//            System.out.println(haveSeenFox);
            if (canMove(oppDic(directionToFox))) {
//                System.out.println(canMove(oppDic(directionToFox)));
//                System.out.println("can move");
                return oppDic(directionToFox);
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

    int oppDic(int direction) {
        if (direction == Model.N) {
            int next_step = Model.random(Model.MIN_DIRECTION,
                    Model.MAX_DIRECTION);
            if (next_step != Model.N) {
                return next_step;
            }
        } else if (direction == Model.NE) {
            return Model.SW;
        } else if (direction == Model.E) {
            return Model.W;
        } else if (direction == Model.SE) {
            return Model.NW;
        } else if (direction == Model.S) {
            return Model.N;
        } else if (direction == Model.SW) {
            return Model.NE;
        } else if (direction == Model.W) {
            return Model.E;
        } else if (direction == Model.NW) {
            return Model.SW;
        }
//        else if(direction==Model.BUSH){return Model.N;}
        else {
            return Model.STAY;
        }
    }
}
