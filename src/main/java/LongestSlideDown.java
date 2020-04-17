package main.java;

/**
 * counts maximum sum of elements while moving from top to bottom of pyramid
 */
public class LongestSlideDown {

    public static int longestSlideDown(int[][] pyramid) {
        int max = 0;
        int[][] pyramidPaths = new int[pyramid.length][];
        for (int i = 0; i < pyramid.length; i++) {
            pyramidPaths[i] = new int[pyramid[i].length];
            for (int j = 0; j < pyramid[i].length; j++) {
                int[] uppers = resolveUppers(i, j, pyramidPaths);
                pyramidPaths[i][j] = Math.max(uppers[0], uppers[1]) + pyramid[i][j];
                max = Math.max(max, pyramidPaths[i][j]);
            }
        }
        return max;
    }
    // resolve 2 elements above current (two possible way to come to current element)
    private static int[] resolveUppers(int i, int j, int[][] pyramidPaths) {
        if (i == 0) return new int[]{0, 0};
        if (j == 0) return new int[]{0, pyramidPaths[i - 1][j]};
        if (j == pyramidPaths[i].length - 1) return new int[]{pyramidPaths[i - 1][j - 1], 0};
        return new int[]{pyramidPaths[i - 1][j - 1], pyramidPaths[i - 1][j]};
    }
}