Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.

Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some common email to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.

 
class Solution {
    class UnionFind {
        int[] parent;
        int[] weight;
        
        public UnionFind(int num) {
            parent = new int[num];
            weight = new int[num];
            
            for(int i =  0; i < num; i++) {
                parent[i] = i;
                weight[i] = 1;
            }
        }
        
        public void union(int a, int  b) {
            int rootA = root(a);
            int rootB = root(b);
            
            if (rootA == rootB) {
                return;
            }
            
            if (weight[rootA] > weight[rootB]) {
                parent[rootB] = rootA;
                weight[rootA] += weight[rootB];
            } else {
                parent[rootA] = rootB;
                weight[rootB] += weight[rootA];
            }
        }
        
        public int root(int a) {
            if (parent[a] == a) {
                return a;
            }
            
            parent[a] = root(parent[a]);
            return parent[a];
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int size = accounts.size();

        UnionFind uf = new UnionFind(size);

        // prepare a hash with unique email address as key and index in accouts as value
        HashMap<String, Integer> emailToId = new  HashMap<>();
        for(int i = 0; i < size; i++) {
            List<String> details = accounts.get(i);
            for(int j = 1; j < details.size(); j++) {
                String email = details.get(j);
                
				// if we have already seen this email before, merge the account  "i" with previous account
				// else add it to hash
                if (emailToId.containsKey(email)) {
                    uf.union(i, emailToId.get(email));
                } else  {
                    emailToId.put(email, i);
                }
            }
        }
        
        // prepare a hash with index in accounts as key and list of unique email address for that account as value
        HashMap<Integer, List<String>> idToEmails = new HashMap<>();
        for(String key : emailToId.keySet()) {
            int root = uf.root(emailToId.get(key));
            
            if (!idToEmails.containsKey(root)) {
                idToEmails.put(root, new ArrayList<String>());
            }
            
            idToEmails.get(root).add(key);
        }
        
        // collect the emails from idToEmails, sort it and add account name at index 0 to get the final list to add to final return List
        List<List<String>> mergedDetails =  new ArrayList<>();
        for(Integer id : idToEmails.keySet()) {
            List<String> emails =  idToEmails.get(id);
            Collections.sort(emails);
            emails.add(0, accounts.get(id).get(0));
            
            mergedDetails.add(emails);
        }
        
        return  mergedDetails;
    }
}
