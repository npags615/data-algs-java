import java.util.*;



public class BinarySearchLexicon implements ILexicon {

    private ArrayList<String> myWords;
    
    public BinarySearchLexicon() {
        myWords = new ArrayList<String>();
    }
    
    public void load(Scanner s) {
        myWords.clear();
        while (s.hasNext()){
            myWords.add(s.next().toLowerCase());
        }
        Collections.sort(myWords);
    }

    public void load(ArrayList<String> list) {
        myWords.clear();
        myWords.addAll(list);
        Collections.sort(myWords);
    }

    public LexStatus wordStatus(StringBuilder s) {
        return wordStatus(s.toString());
    }

    public LexStatus wordStatus(String s) {
        
        // You need to make this code use Binary Search
    	int val = Collections.binarySearch(myWords, s);
        if(val >= 0){ return LexStatus.WORD; } 
        else{
        	int check = (val*-1) - 1;
        	if(check<myWords.size()){
        		boolean prefix = myWords.get(check).startsWith(s);
        		if(prefix){ return LexStatus.PREFIX; }
        	}
        }
    	
        return LexStatus.NOT_WORD;
    }

    public Iterator<String> iterator() {
        return myWords.iterator();
    }

    public int size() {
        return myWords.size();
    }

}
