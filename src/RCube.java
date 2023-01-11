/**
 * Processing Rubik's Cube
 */
public class RCube {

    /* 
     * Initialize 2D array storing color values of different squares on the cube
     * 0 = non-color squares
     * 1 = yellow, 2 = white
     * 3 = green, 4 = blue
     * 5 = red, 6 = orange
    */
    private int[][] colorValues = new int[9][12];
    
    /**
     * Constructor
     */
    public RCube() {
        int[][] defaultColorValues = 
        {
            {0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
            {3, 3, 3, 5, 5, 5, 4, 4, 4, 6, 6, 6},
            {3, 3, 3, 5, 5, 5, 4, 4, 4, 6, 6, 6},
            {3, 3, 3, 5, 5, 5, 4, 4, 4, 6, 6, 6},
            {0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0}
        };
        colorValues = defaultColorValues;
    }

    public void rotate(int face, boolean clockwise) {

        int rotations = 1;
        // To rotate CCW, rotate CW 3 times
        if (!clockwise) rotations = 3;
        if (face == 1) rotateRed(rotations);
        if (face == 2) rotateBlue(rotations);

    }

    private void rotateRed(int rotations) {

        for (int i = 0; i < rotations; i ++) {

            // Store previous values (before rotation)
            int[] oldValues = 
                {colorValues[2][3], colorValues[2][4], colorValues[2][5],
                colorValues[3][6], colorValues[4][6], colorValues[5][6],
                colorValues[6][5], colorValues[6][4], colorValues[6][3],
                colorValues[5][2], colorValues[4][2], colorValues[3][2]};

            // Set new values (after rotation)
            colorValues[3][6] = oldValues[0];
            colorValues[4][6] = oldValues[1];
            colorValues[5][6] = oldValues[2];
            colorValues[6][5] = oldValues[3];
            colorValues[6][4] = oldValues[4];
            colorValues[6][3] = oldValues[5];
            colorValues[5][2] = oldValues[6];
            colorValues[4][2] = oldValues[7];
            colorValues[3][2] = oldValues[8];
            colorValues[2][3] = oldValues[9];
            colorValues[2][4] = oldValues[10];
            colorValues[2][5] = oldValues[11];

        }
        
    }

    private void rotateBlue(int rotations) {
        for (int i = 0; i<rotations; i++){
            // Store previous values (before rotation)
            int oldValues[] = 
                {colorValues[5][9],colorValues[4][9],colorValues[3][9],
                colorValues[0][5],colorValues[1][5],colorValues[2][5],
                colorValues[3][5],colorValues[4][5],colorValues[5][5],
                colorValues[6][5],colorValues[7][5],colorValues[8][5]};
            
            // Set new values (after rotation)
            colorValues[0][5] = oldValues[0];
            colorValues[1][5] = oldValues[1];
            colorValues[2][5] = oldValues[2];
            colorValues[3][5] = oldValues[3];
            colorValues[4][5] = oldValues[4];
            colorValues[5][5] = oldValues[5];
            colorValues[6][5] = oldValues[6];
            colorValues[7][5] = oldValues[7];
            colorValues[8][5] = oldValues[8];
            colorValues[5][9] = oldValues[9];
            colorValues[4][9] = oldValues[10];
            colorValues[3][9] = oldValues[11];
            }

        }

    public void printCube() {
        // Iterates through rows
        for (int i = 0; i < 9; i++) {
            // Iterates through columns
            for (int j = 0; j < 12; j++) {
                System.out.print(this.colorValues[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RCube cube1 = new RCube();
        cube1.printCube();
        System.out.println();
        cube1.rotate(2, true);
        cube1.printCube();
    }
}

