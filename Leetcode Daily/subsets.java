ass Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> al1 = new ArrayList<>();
        int size =  nums.length;
        int power = (1<<size); // we can also write --> int power = Math.pow(2,size);
        
        for(int i = 0; i < power; i++){        
           
            List<Integer> al2 = new ArrayList<>();
            
            for(int j = 0; j < size; j++)
            {
                if( ( i & (1<<j) ) != 0 ) // checking whether the index is set bit or not i.e, Is it 0 or 1 ?
                    al2.add( nums[ j ] ); // if it is not 0, then add the element of that index to the list
            }
            al1.add( al2 ); //merging two lists
        }
        
        return al1;
    }
}
