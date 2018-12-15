package cz.jjaros.study.oca;

public class Ex08d_ArrayVariables {

    {
        // mozne zpusoby definice pole:
        int[] p1;
        int p2[];
        int[] p3, p4; // 2 pole
        int p5, p6[]; // 1 pole
        int p7[], p8; // 1 pole
        int[] p9[];   // 2d pole
    }

    {
        // vicerozmerne pole
        int[][] p1 = new int[5][5];
        int[][] p2 = new int[5][];
        p2[0] = new int[2];
        p2[1] = new int[3];

        int[][][] p3 = new int[10][20][30];

        int[] p4 = new int[]{1, 2, 3};
        int[][] p5 = new int[][]{{1, 2}, {3, 4, 5}};

    }


}