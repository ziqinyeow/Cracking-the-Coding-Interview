/**
 * Solution
 */
public class Solution {

    public int largestIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int max = 0, islandId = 2, m = grid.length, n = grid[0].length;
        // Map => <islandId, size>
        Map<Integer, Integer> map = new HashMap<>();

        // Add the island id and the size
        // change all the 1 into unique Id corresponse to the island
        // 1 0 0 0 1 - 2 0 0 0 3
        // 1 1 1 0 1 2 2 2 0 3
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = getIslandSize(grid, i, j, islandId);
                    max = Math.max(max, size); // get the biggest default island size before the operation
                    map.put(islandId++, size);
                }
            }
        }
        // Check the four direction of 0
        // add the island id into a set
        // then compute the max
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    for (int[] direction : directions) {
                        int x = direction[0] + i, y = direction[1] + j;
                        if (x > -1 && y > -1 && x < m && y < n && grid[x][y] != 0) {
                            set.add(grid[x][y]);
                        }
                    }
                    int sum = 1;
                    for (int num : set) {
                        int value = map.get(num);
                        sum += value;
                    }
                    max = Math.max(max, sum);
                }
            }
        }
        return max;
    }

    private int getIslandSize(int[][] grid, int i, int j, int islandId) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = islandId;
        int left = getIslandSize(grid, i, j - 1, islandId);
        int right = getIslandSize(grid, i, j + 1, islandId);
        int up = getIslandSize(grid, i - 1, j, islandId);
        int down = getIslandSize(grid, i + 1, j, islandId);
        return left + right + up + down + 1;
    }
}