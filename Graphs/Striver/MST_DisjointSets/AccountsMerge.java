/*Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0] is
a name, and the rest of the elements are emails representing emails of the account.

        Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some
        common email to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.

        After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.



        Example 1:

        Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
        Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
        Explanation:
        The first and second John's are the same person as they have the common email "johnsmith@mail.com".
        The third John and Mary are different people as none of their email addresses are used by other accounts.
        We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
        ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.*/


package com.Graphs.Striver.MST_DisjointSets;

import java.util.*;

public class AccountsMerge {
    static class  DisjointSetv1 {
        ArrayList<Integer> rank = new ArrayList<>();
        ArrayList<Integer> parent = new ArrayList<>();
        ArrayList<Integer> size = new ArrayList<>();

        public DisjointSetv1(int n) {
            for (int i = 0; i <= n; i++) {
                rank.add(0);
                parent.add(i);
                size.add(1);
            }
        }

        public int findUPar(int node) {
            if (node == parent.get(node)) {
                return node;
            }
            int ulp = findUPar(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }

        public void unionByRank(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if (ulp_u == ulp_v) return;
            if (rank.get(ulp_u) < rank.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
            } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
                parent.set(ulp_v, ulp_u);
            } else {
                parent.set(ulp_v, ulp_u);
                int rankU = rank.get(ulp_u);
                rank.set(ulp_u, rankU + 1);
            }
        }

        public void unionBySize(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if (ulp_u == ulp_v) return;
            if (size.get(ulp_u) < size.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
            } else {
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
            }
        }
    }


    /*
    * 1.Assign indexes to every list .
    * 2.We will traverse every list starting from j=1  as j=0 is name (key) and we will put every mail
    * to hashmap with its corresponding index which we have assumed as a node.
    *
   *
    * */

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSetv1 ds = new DisjointSetv1(n);
        HashMap<String, Integer> mapMailNode = new HashMap<String, Integer>();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                //starting from 1 as first is name and emails are starting from 1
                String mail = accounts.get(i).get(j);
                if (mapMailNode.containsKey(mail)) {
                    //if mail already present means we need to connect both nodes
                    ds.unionBySize(i, mapMailNode.get(mail));
                } else {
                    //if doesn't contain then add the entry
                    mapMailNode.put(mail, i);
                }
            }
        }

        //Till now here we have created the disjoint set and hashmap of mapping also created
        //now we need to iterate over hashmap and put the corresponding mail to their
        // respective ultimate parents

        ArrayList<String> mergedMail[] = new ArrayList[n];

        for (int i = 0; i < n; i++) mergedMail[i] = new ArrayList<String>();

        for (Map.Entry<String, Integer> it : mapMailNode.entrySet()) {
            String mail = it.getKey();
            int node = ds.findUPar(it.getValue());
            mergedMail[node].add(mail);
        }

        //now as we need to give answer in a certain format as we got the input

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (mergedMail[i].size() == 0) continue;
            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<>();
            //add the key
            temp.add(accounts.get(i).get(0));
            //add the respective mails , we can also do below  -> temp.addAll(mergedMail[i]);
            for (String it : mergedMail[i]) {
                temp.add(it);
            }
            //add the temp back to answer
            ans.add(temp);
        }
        return ans;


    }




    public static void main(String[] args) {


    }
}
