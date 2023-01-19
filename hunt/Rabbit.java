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
                    directionToFox = i;

                    if (canMove(Model.turn(directionToFox, 3)) && distance(i) != 3)
                        return Model.turn(directionToFox, 3);
                    else if (canMove(Model.turn(directionToFox, 5)) && distance(i) != 5)
                        return Model.turn(directionToFox, 5);
                    else if (canMove(Model.turn(directionToFox, 2)) && distance(i) != 2)
                        return Model.turn(directionToFox, 2);
                    else if (canMove(Model.turn(directionToFox, 6)) && distance(i) != 6)
                        return Model.turn(directionToFox, 6);
                    else if (canMove(Model.turn(directionToFox, 7)) && distance(i) != 7)
                        return Model.turn(directionToFox, 7);
                    else if (canMove(Model.turn(directionToFox, 1)) && distance(i) != 1)
                        return Model.turn(directionToFox, 1);
                    else if (canMove(Model.turn(directionToFox, 0)) && distance(i) != 0)
                        return Model.turn(directionToFox, 0);
                    else if (canMove(Model.turn(directionToFox, 4)) && distance(i) != 4)
                        return Model.turn(directionToFox, 4);
                }
//                } else if (look(i)==Model.EDGE && distance(i)<1) {
//                    return Model.turn(i,4);
////                    System.out.println("EDGE "+i);
//                } else if (look(i)==Model.BUSH &&distance(i)<1) {
//                    return Model.turn(i,1);
//                }
        }
        return Model.STAY;
    }
}
