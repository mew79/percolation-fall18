import java.util.LinkedList;
import java.util.Queue;

public class PercolationBFS extends PercolationDFSFast{
	
	public PercolationBFS(int size) {
		super(size);
	}
	
	@Override
	protected void dfs(int row, int col) {
		int[] rowDelta = {-1,1,0,0};
		int[] colDelta = {0,0,-1,1};
		
		Queue<Integer> qp = new LinkedList<Integer>();
		myGrid[row][col] = FULL;
		qp.add(row *myGrid.length + col);
		while (qp.size() != 0) {
			int num = qp.remove();
			int newRow = num/myGrid.length;
			int newCol = num%myGrid.length;
			
			for (int i = 0; i < rowDelta.length; i ++) {
				row = newRow + rowDelta[i];
				col = newCol + colDelta[i];
				if (inBounds(row,col) && isOpen(row, col) && myGrid[row][col] != FULL) {
					myGrid[row][col] = FULL;
					qp.add(row *myGrid.length + col);
				}
			}
		}
	}
}
