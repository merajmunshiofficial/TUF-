import java.util.List;
import java.util.ArrayList;
import java.util.*;

class findSequences {
    private void dfs(String word, String beginWord, List<String> seq, 
                     Map<String, Integer> mpp, List<List<String>> ans) {
        
        // If the sequence is complete
        if (word.equals(beginWord)) {
            
            // Reverse the sequence
            Collections.reverse(seq);
            
            // Store in the result
            ans.add(new ArrayList<>(seq));
            
            // Reverse again for other possible sequences
            Collections.reverse(seq);
            
            // Return
            return;
        }
        
        // Steps to reach the word
        int val = mpp.get(word);
        
        // Try all possible transformations
        for (int i = 0; i < word.length(); i++) {
            char original = word.charAt(i);
            StringBuilder sb = new StringBuilder(word);
            
            for (char ch = 'a'; ch <= 'z'; ch++) {
                sb.setCharAt(i, ch);
                String newWord = sb.toString();
                
                // If a possible transformation is found
                if (mpp.containsKey(newWord) && 
                    mpp.get(newWord) + 1 == val) {
                    
                    // Update the sequence
                    seq.add(newWord);
                    
                    // Make recursive DFS call
                    dfs(newWord, beginWord, seq, mpp, ans);
                    
                    // Pop back for backtracking
                    seq.remove(seq.size() - 1);
                }
            }
        }
    }

    public List<List<String>> findSequences(String beginWord, String endWord, 
                                            List<String> wordList) {
        
        // Length of words
        int len = beginWord.length();
        
        // Add all the words to a hashset
        Set<String> st = new HashSet<>(wordList);
                                  
        /* Hash map to store the minimum 
        steps needed to reach a word */
        Map<String, Integer> mpp = new HashMap<>();
        
        // Queue for BFS traversal
        Queue<String> q = new LinkedList<>();
        
        // Pushing initial word in the queue
        q.add(beginWord);
        
        // Erasing the initial word from the set if it exists
        st.remove(beginWord);
        
        // Step count
        int steps = 1;
        
        // Storing the initial pair in map
        mpp.put(beginWord, steps);
        
        // Until the queue is empty
        while (!q.isEmpty()) {
            
            // Get the word and steps
            String word = q.poll();
            steps = mpp.get(word);

            // Check for every possible transformation
            for (int i = 0; i < len; i++) {
                char original = word.charAt(i);
                StringBuilder sb = new StringBuilder(word);
                
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    sb.setCharAt(i, ch);
                    String newWord = sb.toString();
                    
                    // If a possible transformation is found
                    if (st.contains(newWord)) {
                        
                        // Store it in map
                        mpp.put(newWord, steps + 1);
                        
                        // Push in the queue
                        q.add(newWord);
                        
                        // Erase word from list
                        st.remove(newWord);
                    }
                }
            }
        }

        /* Return an empty list if reaching 
        the target word is not possible */
        if (!mpp.containsKey(endWord))
            return new ArrayList<>();
        
        // To store the answer
        List<List<String>> ans = new ArrayList<>();
        
        // To store the possible sequence of transformations
        List<String> seq = new ArrayList<>();
        seq.add(endWord);
        
        // Backtracking step
        dfs(endWord, beginWord, seq, mpp, ans);
        
        // Return the computed result
        return ans;
    }

    public static void main(String[] args) {
        String beginWord = "der", endWord = "dfs";
        List<String> wordList = Arrays.asList(
            "des", "der", "dfr", "dgt", "dfs"
        );
        
        // Creating an instance of findSequences class
        findSequences sol = new findSequences();
        
        /* Function call to determine number of 
        steps to reach from start ward to target word */
        List<List<String>> ans = 
            sol.findSequences(beginWord, endWord, wordList);
        
        // Output
        System.out.println("The different sequences are:");
        for (List<String> seq : ans) {
            for (String word : seq) {
                System.out.print(word + " ");
            }
            System.out.println();
        }
    }
}
