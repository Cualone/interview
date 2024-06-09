package Q035;
/*200.섬의 개수*/

public class Main {
    public static void main(String[] args) {
        char[][] array = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '1'}
        };
        System.out.println(numIslands(array));
    }

    static void dfs(int i, int j, char[][] grid) {
        if (i<0 || i>= grid.length || j<0 || j>= grid[0].length || grid[i][j] == '0') return;

        grid[i][j] = '0';
        dfs(i, j + 1, grid);
        dfs(i, j - 1, grid);
        dfs(i + 1, j, grid);
        dfs(i - 1, j, grid);
    }

    static int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }
}
