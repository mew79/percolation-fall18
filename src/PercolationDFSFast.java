
public class PercolationDFSFast extends PercolationDFS{
	
	public PercolationDFSFast(int size) {
		super(size);
	}
	
	@Override 
	protected void updateOnOpen(int row, int col) {
	
		if (row == 0 || myGrid[row-1][col] == FULL ||(myGrid[row+1][col] == FULL) || 
				(myGrid[row][col-1] == FULL) || (myGrid[row][col+1] == FULL)) {
			dfs(row, col);
		}
	
	}
	

}
