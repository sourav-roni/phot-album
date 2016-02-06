import java.util.List;
import javax.swing.table.AbstractTableModel;

public class photoTableModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6015559669759579852L;

	/**
	 * 
	 */

	String ColumnName[] = {"Photo Title"};
	
	List<Photo> pList = null;
	
	photoTableModel(List<Photo> list){
		pList = list;
	}

	public int getColumnCount() {
		return ColumnName.length;
	}

	
	public int getRowCount() {
		return pList.size();
	}

	
	public Object getValueAt(int row, int column) {
		Photo pht = pList.get(row);
		switch(column){
		case 0:
			return pht.photoTitle;
		case 1:
			return pht;
		default:
			return pht;
		}
	}
	@Override
	public Class<? extends Object> getColumnClass(int col) {
		return getValueAt(0,col).getClass();
	}
	@Override
	public String getColumnName(int col) {
		return ColumnName[col];
	}
	@Override
	public boolean isCellEditable(int row, int col) {
		return false;
	}

}