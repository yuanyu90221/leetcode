package leetcodeDemo;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String [] words = {"This","is","a","book!"};
      
        int maxWidth =7;

        transerval(fullJustify(words, maxWidth));
	}
    
	
	public static List<String> fullJustify(String[] words, int maxWidth) {
		List<String> result = new ArrayList<String>();
		int indexOfwords = 0;
        do{
            int leftspace =  maxWidth;
            List<Integer> chooseWords = new ArrayList<Integer>();
            int nextLetft = 0;
            
            do{
                chooseWords.add(indexOfwords);
                leftspace -= words[indexOfwords].length();
                
                indexOfwords++;
                if(indexOfwords < words.length)
                  nextLetft = leftspace - words[indexOfwords].length();
                else
                  break;
                
            }while(nextLetft >= chooseWords.size());

            final int currentSize = chooseWords.size();
            int leftSize = currentSize; 
            StringBuilder sb = new StringBuilder();
            for(int index =0; index < currentSize;index++){
            	sb.append(words[chooseWords.get(index)]);
                if(index != currentSize-1){
            		if(indexOfwords!=words.length){
		            	if(leftspace > 0){
		            		
		            		double dSize = Double.valueOf(leftSize-1);
		            		int fen =(leftSize>2)? (int)Math.ceil(leftspace/dSize):leftspace;
		            		leftspace -= fen;
		            		leftSize--;
		            		for(int k =0 ; k < fen;k++){
		            			sb.append(" ");
		            		}
		            	}
            		}
            		else{
            			leftspace--;
            			sb.append(" ");
            		}
            	}
            	else{
            		for(int k =0 ; k < leftspace;k++){
            			sb.append(" ");
            		}
            	}
            }

            result.add(sb.toString());
        }while(indexOfwords < words.length );
        
        return result;
    }
    
    public static void transerval(List<String> result){
    	for(String str : result){
    		System.out.println("\""+str+"\"");
    	}
    }
	
}
