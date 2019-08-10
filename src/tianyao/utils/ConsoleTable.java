package tianyao.utils;

import java.util.ArrayList;
import java.util.List;

public class ConsoleTable {

	private List<List> rows= new ArrayList();
	private int column;
	private int[] columnLen;
	private static int margin=2;
	private boolean printHeader=false;
	
	public ConsoleTable(int column,boolean printHeader) {
		this.printHeader=printHeader;
		this.column=column;
		this.columnLen=new int[column];
	}
	
	public void appendRow() {
		List row=new ArrayList(column);
		rows.add(row);
	}
	
	public ConsoleTable appendColumn(Object value) {
		if(value ==null) {
			value="NULL";
		}
		List row=rows.get(rows.size()-1);
		row.add(value);
		int len=value.toString().getBytes().length;
		if(columnLen[row.size()-1]<len)
			columnLen[row.size()-1]=len;
		return this;
	}
	
	public String toString() {
		StringBuilder buf=new StringBuilder();
		
		int sumLen=0;
		for(int len: columnLen) {
			sumLen+=len;
		}
		
		if(printHeader) {
			buf.append("|").append(printChar('=',sumLen+margin*2*column)).append("\n");
		}else {
			buf.append("|").append(printChar('-',sumLen+margin*2*column)).append("\n");
		}
		
		for(int ii=0;ii<rows.size();ii++) {
			List row=rows.get(ii);
			for(int i=0;i<column;i++) {
				String o="";
				if(i<row.size())
					o=row.get(i).toString();
				buf.append("|").append(printChar(' ',margin)).append(o);
				buf.append(printChar(' ',columnLen[i]-o.getBytes().length));
			}
			
			buf.append("|\n");
			if(printHeader && ii==0) {
				buf.append("|").append(printChar('=',sumLen+margin*2*column))
				.append("|").append("\n");
			}else {
				buf.append("|").append(printChar('-',sumLen+margin*2*column))
				.append("|").append("\n");
			}
		}
		return buf.toString();
	}

	private String printChar(char c, int len) {
		StringBuilder buf=new StringBuilder();
		for(int i=0;i<len;i++) {
			buf.append(c);
		}
		return buf.toString();
	}
	
	public static void main(String[] args) {
		ConsoleTable t=new ConsoleTable(8,true);
		t.appendRow();
		t.appendColumn("id");
		t.appendColumn("brand");
		t.appendColumn("style");
		t.appendColumn("color");
		t.appendColumn("size");
		t.appendColumn("num");
		t.appendColumn("price");
		t.appendColumn("description");
		
		System.out.println(t.toString());
	}
	
}
