
public class PercolationUF implements IPercolate{
	
	private boolean[][] myGrid;
	private int myOpenCount;
	private IUnionFind myFinder;
	private final int VTOP;
	private final int VBOTTOM;
	
	public PercolationUF(int size, IUnionFind finder) {
		myGrid = new boolean[size][size];
		finder.initialize(size*size + 2);
		myFinder = finder;
		VTOP = size * size;
		myOpenCount = 0;
		VBOTTOM = size*size + 1;
	}

	
	public void open(int row, int col) {
		if (!inBounds(row,col)) {
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
		}
		
		if (myGrid[row][col] != true) {
		myGrid[row][col] = true;
		myOpenCount +=1;
		int[] rowDelta = {-1,1,0,0};
		int[] colDelta = {0,0,-1,1};
		for (int i = 0; i < rowDelta.length; i ++) {
			int newRow = row + rowDelta[i];
			int newCol = col + colDelta[i];
			if (inBounds(newRow,newCol) && isOpen(newRow, newCol)) {
			myFinder.union(row * myGrid.length + col, newRow * myGrid.length + newCol);	
		}
		if (row == 0) {
			myFinder.union(row * myGrid.length + col, VTOP);
		}
		if (row == myGrid.length -1) {
			myFinder.union(row * myGrid.length + col, VBOTTOM);
		}
		}
		
		
	}
	}

	public boolean isOpen(int row, int col) {

		if (! inBounds(row,col)) {
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
		}
		
		return myGrid[row][col];
	}

	public boolean isFull(int row, int col) {
		
		if (! inBounds(row,col)) {
			throw new IndexOutOfBoundsException(
					String.format("(%d,%d) not in bounds", row,col));
		}
		
		return myFinder.connected(row * myGrid.length + col, VTOP);
	}

	public boolean percolates() {
		return myFinder.connected(VTOP, VBOTTOM);

	
	}

	public int numberOfOpenSites() {
	
		return myOpenCount;
	}

	protected boolean inBounds(int row, int col) {
		if (row < 0 || row >= myGrid.length) return false;
		if (col < 0 || col >= myGrid[0].length) return false;
		return true;
	}
	
}
