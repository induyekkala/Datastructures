package DataStructure;

class Entry
{
    Object key;
    Object value;
    Entry next;
    Entry(Object key,Object value,Entry next){
	this.key=key;
	this.value=value;
	this.next=next;
	
    }
}
public class Hashtable {
    
    private static final int SIZE=1024;
    Entry table[]=new Entry[SIZE];
    
    public void insert(Object key,Object value)
    {
	if(key==null)
	{
	    throw new IllegalArgumentException("null value exception");
	}
	int hc=key.hashCode();
	int index=hc%SIZE;
	// now insert a new Entry object into
	// the "table" array
	Entry e=new Entry(key,value,null);
	if(table[index]==null)
	{
	    table[index]=e;
	}
	
	
    }
    
    public Object lookup(Object key) {
	return null;
	
    }

}
