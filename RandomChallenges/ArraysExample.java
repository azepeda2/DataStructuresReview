import java.util.ArrayList;

/**
  * An example of using ArrayLists and how they grow dynamically 
  */

  class ArraysExample {
    
    ArrayList<String> merge (String[] words, String[] more) {
        ArrayList<String> sentence = new ArrayList<String>();
        for (String w : words) sentence.add(w);
        for (String w: more) sentence.add(w);
        return sentence;
    }
    /**
     * final capacity increase n/2 elements to copy 
     * previous capacity increase: n/4 elements to copy 
     * previous capacity increase: n/8 elements to copy 
     * previous capacity increase: n/16 elements to copy
     */

     public static void main(String[] args) {
        System.out.println("Arrays compiled succesfully!");
     }
  }