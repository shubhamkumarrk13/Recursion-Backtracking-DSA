// Problem Link : https://leetcode.com/problems/generate-parentheses/description/

// // ************************************** Approach 1 ******************************

// class Solution {

//     public boolean isPossible(StringBuilder s) {

//         int count = 0;

//         for(int i=0; i<s.length(); i++) {

//             char ch = s.charAt(i);

//             if(ch == '(') count++;

//             else count--;

//             if(count < 0) return false;
//         }

//         if(count == 0) return true;

//         return false;
//     }

//     public void solve(int n, StringBuilder temp, List<String> result) {

//         if(temp.length() == 2*n) {

//             if(isPossible(temp)) result.add(temp.toString());

//             return;
//         }

//         solve(n, temp.append('('), result);

//         temp.deleteCharAt(temp.length() - 1);

//         solve(n, temp.append(')'), result);

//         temp.deleteCharAt(temp.length() - 1);
//     }

//     public List<String> generateParenthesis(int n) {

//         List<String> result = new ArrayList<>();

//         StringBuilder temp = new StringBuilder();

//         solve(n, temp, result);

//         return result;
        
//     }
// }

// ************************************** Approach 2 ******************************

class Solution {

    public void solve(int n, int open, int close, StringBuilder temp, List<String> result) {

        if(temp.length() == 2*n) {

            result.add(temp.toString());

            return;
        }

        if(open < n) {

            temp.append('(');

            solve(n, open + 1, close, temp, result);

            temp.deleteCharAt(temp.length() - 1);
        }

        if(close < open) {

            temp.append(')');

            solve(n, open, close + 1, temp, result);

            temp.deleteCharAt(temp.length() - 1);

        }
    }


    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();

        StringBuilder temp = new StringBuilder();

        solve(n, 0, 0, temp, result);

        return result;
        
    }
}
