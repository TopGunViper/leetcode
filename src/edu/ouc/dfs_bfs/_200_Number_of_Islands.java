package edu.ouc.dfs_bfs;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally 
 * or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000

Answer: 1

Example 2:

11000
11000
00100
00011

Answer: 3
 * @author wqx
 *
 */
public class _200_Number_of_Islands {
    public int numIslands(char[][] grid) {
        int num = 0;
        for(int i = 0; i < grid.length; i++){
        	for(int j = 0; j < grid[i].length; j++){
        		if(grid[i][j] == '1'){
        			num++;
        			searchIsland(grid,i,j);
        		}
        	}
        }
        return num;
    }
    public void searchIsland(char[][] grid,int x,int y){
    	
    	if(x >= 0 && x < grid.length && y >= 0 && y< grid[x].length && grid[x][y] == '1'){
    		grid[x][y] = '2';
    		searchIsland(grid,x+1,y);
    		searchIsland(grid,x,y+1);
    		searchIsland(grid,x-1,y);
    		searchIsland(grid,x,y-1);
    	}else{
    		return;
    	}
    }
    
    int n, m;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    public int numIslands2(char[][] grid) {
        n = grid.length;
        if (n == 0)
            return 0;
        m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1') {
                    ans++;
                    find(i, j, grid);
                }
        return ans;
    }
    void find(int x, int y, char[][] grid) {
        grid[x][y] = '0';
        int tx, ty;
        for (int i = 0; i < 4; i++) {
            tx = x+dx[i];
            ty = y+dy[i];
            if (tx<0 || ty<0 || tx>=n || ty>=m)
                continue;
            if (grid[tx][ty] == '1')
                find(tx, ty, grid);
        }
    }
}
