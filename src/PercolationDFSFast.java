
public class PercolationDFSFast extends PercolationDFS{
	
	public PercolationDFSFast(int size) {
		super(size);
	}
	
	@Override 
	protected void updateOnOpen(int row, int col) {
		
		if (!inBounds(row,col)) {
			return;
		}
	
		if (row == 0) {
			dfs(row,col);
			return;
		}
		int[] rowDelta = {0,0,-1,1};
		int[] colDelta = {0,0,-1,1};
		
		for (int i = 0; i < rowDelta.length; i ++) {
			int newRow = row + rowDelta[i];
			int newCol = col + colDelta[i];
			if (myGrid[newRow][newCol] == FULL) {
				dfs(row,col);
				return;
			}
		}
		
		
	
	}
	

}
