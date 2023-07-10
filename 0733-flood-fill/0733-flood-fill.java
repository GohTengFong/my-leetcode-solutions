class Solution {
    private void changeNumber(int[][] image, int sr, int sc, int newColor, int key) {
        int numOfRows = image.length;
        int numOfCols = image[0].length;

        if (sr >= numOfRows || sc >= numOfCols || sr < 0 || sc < 0){
            return;
        } else if (image[sr][sc] != key) {
            return;
        } else {
            image[sr][sc] =  newColor;

            changeNumber(image, sr - 1, sc, newColor, key); // north
            changeNumber(image, sr + 1, sc, newColor, key); // south
            changeNumber(image, sr, sc + 1, newColor, key); // east
            changeNumber(image, sr, sc - 1, newColor, key); // west
        }
    }


    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int numOfRows = image.length;
        int numOfCols = image[0].length;

        if (numOfRows <= 0 || numOfCols <= 0) {
            return image;
        }

        if (image[sr][sc] == color) {
            return image;
        }

        changeNumber(image, sr, sc, color, image[sr][sc]);

        return image;
    }
}