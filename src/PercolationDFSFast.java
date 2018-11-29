
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
			
		}
		else {
		int[] rowDelta = {0,0,-1,1};
		int[] colDelta = {-1,1,0,0};
		
		int count = 0;
		for (int i = 0; i < rowDelta.length; i ++) {
			int newRow = row + rowDelta[i];
			int newCol = col + colDelta[i];
			
			if ( inBounds(newRow,newCol) && myGrid[newRow][newCol] == FULL) {
				count +=1;
			}
		}
		
		if (count > 0) {
			dfs(row,col);
		}
		
	
	}
	}
	

}
