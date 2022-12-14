# ð¥ LeetCode ç­é¢ HOT 100

2022-08-03

### [1. ä¸¤æ°ä¹å](https://leetcode.cn/problems/two-sum/)

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {0, 0};
    }
}
```

ä¸å¼å§æç®åæåºï¼åç¨åæéå¾è§£æ³ï¼åç°æ¯ä¸è¡çï¼å ä¸ºè¿é¢è¦è¿åæ°ç»å¾ä¸æ ï¼æä»¥æåºä¼æä¹±ä¸æ å¾é¡ºåºï¼åªè½ä½¿ç¨åå±forå¾ªç¯ã



### [2. ä¸¤æ°ç¸å ](https://leetcode.cn/problems/add-two-numbers/)

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        ListNode headA = l1;
        ListNode headB = l2;
        // countä¸ºè¿ä½
        int count = 0;
        while (headA != null && headB != null) {
            int sum = headA.val + headB.val + count;
            if (sum >= 10) {
                sum -= 10;
                count = 1;
            } else {
                count = 0;
            }
            ListNode tmp = new ListNode(sum);
            pre.next = tmp;
            pre = pre.next;
            headA = headA.next;
            headB = headB.next;
        }

        // ä¸é¢èèåä¸ªé¾è¡¨æåç»æçæåµ
        /* 
        1. ç¬¬äºè¡é¾è¡¨æåç»æï¼
        ç±»ä¼¼äºï¼
        2 - 3 - 7 - 9 - 9 - 9
        1 - 2 - 5
        */
        while (headA != null) {
            int sum = headA.val + count;
            if (sum >= 10) {
                sum -= 10;
                count = 1;
            } else {
                count = 0;
            }
            ListNode tmp = new ListNode(sum);
            pre.next = tmp;
            pre = pre.next;
            headA = headA.next;
        }

        /* 
        2. ç¬¬ä¸è¡é¾è¡¨æåç»æï¼
        ç±»ä¼¼äºï¼
        1 - 2 - 5
        2 - 3 - 7 - 9 - 9 - 9
        */
        while (headB != null) {
            int sum = headB.val + count;
            if (sum >= 10) {
                sum -= 10;
                count = 1;
            } else {
                count = 0;
            }
            ListNode tmp = new ListNode(sum);
            pre.next = tmp;
            pre = pre.next;
            headB = headB.next;
        }

        // è¿å·®æåä¸æ­¥ï¼é²æ­¢ä¸ç´è¿1ä½çæåµ æ¯å¦ 9 9 9 å å°æåè¦è¿ä¸ä½
        if (count == 1) {
            pre.next = new ListNode(1);
        }

        return dummy.next;
    }
}
```

åèé¢è§£ï¼[å­çç±å­¦ä¹ ](https://www.bilibili.com/video/BV16p4y1p7jC?spm_id_from=333.337.search-card.all.click&vd_source=35aeaee52b15e78b11967f5ef3ce655a)



### [3. æ éå¤å­ç¬¦çæé¿å­ä¸²](https://leetcode.cn/problems/longest-substring-without-repeating-characters/)

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        while (right < s.length()) {
            if (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            } else {
                set.add(s.charAt(right));
                right++;
            }
            int curLen = right - left;
            maxLen = Math.max(maxLen, curLen);
        }
        return maxLen;
    }
}
```

åæ¬¡ç®å:

* whileå¾ªç¯ä¸éè¦å¤æ­leftå°äºå­ç¬¦ä¸²sçé¿åº¦ï¼å ä¸ºrightå§ç»å¨leftçå³è¾¹
* maxLenåå§åä¸º0ï¼åä¸éè¦å¯¹sè¿è¡å¤ç©ºçæä½



### [4. å¯»æ¾ä¸¤ä¸ªæ­£åºæ°ç»çä¸­ä½æ°](https://leetcode.cn/problems/median-of-two-sorted-arrays/)



### [5. æé¿åæå­ä¸²](https://leetcode.cn/problems/longest-palindromic-substring/)

```java
class Solution {
    public String longestPalindrome(String s) {
        int maxLen = 1;
        int startIndex = 0;
        for (int i = 1; i < s.length(); i++) {
            int left = i - 1;
            int right = i + 1;
            int curLen = 1;
            while (left >= 0 && s.charAt(i) == s.charAt(left)) {
                left--;
                curLen++;
            }
            while (right < s.length() && s.charAt(i) == s.charAt(right)) {
                right++;
                curLen++;
            }
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                curLen += 2;
            }
            // æå¿
            if (curLen > maxLen) {
                maxLen = curLen;
                startIndex = left + 1;
            }
        }
        return s.substring(startIndex, startIndex + maxLen);
    }
}
```



### [10. æ­£åè¡¨è¾¾å¼å¹é](https://leetcode.cn/problems/regular-expression-matching/)



### [11. çæå¤æ°´çå®¹å¨](https://leetcode.cn/problems/container-with-most-water/)

```java
class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int res = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                res = Math.max(res, (j - i) * height[i]);
                i++;
            } else {
                res = Math.max(res, (j - i) * height[j]);
                j--;
            }
        }
        return res;
    }
}
```



### [15. ä¸æ°ä¹å](https://leetcode.cn/problems/3sum/)

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // æ³¨æleftæ¯i + 1
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    set.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        // æ³¨æAPIæ¯addAll
        res.addAll(set);
        return res;
    }
}
```

æ³¨æï¼

* åå¾ªç¯çleftæ¯i + 1
* APIæ¯addAll



### [17. çµè¯å·ç çå­æ¯ç»å](https://leetcode.cn/problems/letter-combinations-of-a-phone-number/)

```java
class Solution {

    //è®¾ç½®å¨å±åè¡¨å­å¨æåçç»æ
    List<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return list;
        }
        //åå§å¯¹åºææçæ°å­ï¼ä¸ºäºç´æ¥å¯¹åº2-9ï¼æ°å¢äºä¸¤ä¸ªæ æçå­ç¬¦ä¸²""
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        //è¿­ä»£å¤ç
        backTracking(digits, numString, 0);
        return list;

    }

    //æ¯æ¬¡è¿­ä»£è·åä¸ä¸ªå­ç¬¦ä¸²ï¼æä»¥ä¼è®¾è®¡å¤§éçå­ç¬¦ä¸²æ¼æ¥ï¼æä»¥è¿ééæ©æ´ä¸ºé«æç StringBuild
    StringBuilder temp = new StringBuilder();

    //æ¯å¦digitså¦æä¸º"23",num ä¸º0ï¼åstrè¡¨ç¤º2å¯¹åºç abc
    public void backTracking(String digits, String[] numString, int num) {
        //éåå¨é¨ä¸æ¬¡è®°å½ä¸æ¬¡å¾å°çå­ç¬¦ä¸²
        if (num == digits.length()) {
            list.add(temp.toString());
            return;
        }
        //str è¡¨ç¤ºå½ånumå¯¹åºçå­ç¬¦ä¸²
        String str = numString[digits.charAt(num) - '0'];
        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            //c
            backTracking(digits, numString, num + 1);
            //åé¤æ«å°¾çç»§ç»­å°è¯
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
```



### [19. å é¤é¾è¡¨çåæ°ç¬¬ N ä¸ªç»ç¹](https://leetcode.cn/problems/remove-nth-node-from-end-of-list/)

```java
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        // fastå¿«æéååå³ç§»å¨næ­¥
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // è¿ä¸ªä¸è¦å¿è®°å¤æ­
        if (fast == null) return head.next;
        // æ³¨ææ¯head.next
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
```



### [20. ææçæ¬å·](https://leetcode.cn/problems/valid-parentheses/)

```java
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty()) {
                return false;
            } else if (c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
```



### [21. åå¹¶ä¸¤ä¸ªæåºé¾è¡¨](https://leetcode.cn/problems/merge-two-sorted-lists/)

```java
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return (list1 == null) ? list2 : list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list2.next, list1);
            return list2;
        }
    }
}
```



### [22. æ¬å·çæ](https://leetcode.cn/problems/generate-parentheses/)

```java
class Solution {

    List<String> res = new LinkedList<>();
    int pair = 0;
    public List<String> generateParenthesis(int n) {
        pair = n;
        if (n == 0) return res;
        dfs("", 0, 0);
        return res;
    }

    // leftCountè¡¨ç¤ºå·¦æ¬å·çæ°éï¼rightCountè¡¨ç¤ºå³æ¬å·çæ°é
    private void dfs(String path, int leftCount, int rightCount) {
        if (path.length() == pair * 2) {
            res.add(path);
            return;
        }
        // 1. å·¦æ¬å·å°äºæ»æ¬å·å¯¹æ°
        if (leftCount < pair) {
            dfs(path + "(", leftCount + 1, rightCount);
        }
        // 2. å³æ¬å·æ°å°äºå·¦æ¬å·æ°
        if (rightCount < leftCount) {
            dfs(path + ")", leftCount, rightCount + 1);
        }
    }
}
```



### [23. åå¹¶Kä¸ªååºé¾è¡¨](https://leetcode.cn/problems/merge-k-sorted-lists/)

```java
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) return null;
        ListNode res = null;
        for (ListNode node : lists) {
            res = merge(res, node);
        }
        return res;
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return (list1 == null) ? list2 : list1;
        }
        if (list1.val < list2.val) {
            list1.next = merge(list1.next, list2);
            return list1;
        } else {
            list2.next = merge(list2.next, list1);
            return list2;
        }
    }
}
```



### [31. ä¸ä¸ä¸ªæå](https://leetcode.cn/problems/next-permutation/)

```java
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        // éåå¯»æ¾ï¼ä»åååéåçç¬¬ä¸ä¸ªæå
        for (int i = n - 1; i >= 0; i--) {
            if (i == 0) {
                // è¯´æææåç´ å¨é¨ååºï¼å¦[3, 2, 1]ï¼åè¿å[1, 2, 3]å³å¯
                Arrays.sort(nums);
                return;
            } else {
                // æ¾å°äºç¬¬ä¸ä¸ªéåçæåï¼æ¯å¦[1, 5, 4, 3]ä¸­æ¾å°äº5 -> 1è¿ä¸ªéåæåï¼é£ä¹åªè¦å¨1åé¢æ¾å°ä¸ä¸ªæ¯1å¤§çæå°çæ°ï¼ä¹å°±æ¯3ï¼åå°1å3äº¤æ¢ï¼å¾å°[3, 1, 4, 5]
                if (nums[i] > nums[i - 1]) {
                    // iå°nè¿è¡æåºï¼ä¸ºçå°±æ¯æ¾å°æ¯1å¤§çæå°çä¸ä¸ªæ°ï¼ä¹å°±æ¯3
                    Arrays.sort(nums, i, n);
                    for (int j = i; j < n; j++) {
                        if (nums[j] > nums[i - 1]) {
                            int tmp = nums[i - 1];
                            nums[i - 1] = nums[j];
                            nums[j] = tmp;
                            return;
                        }
                    }
                }
            }
        }
    }
}
```

[ç¨åºååå](https://www.bilibili.com/video/BV1SE411e7gk?spm_id_from=333.337.search-card.all.click&vd_source=35aeaee52b15e78b11967f5ef3ce655a)

![image-20220804141750837](http://milessg.oss-cn-beijing.aliyuncs.com/img/image-20220804141750837.png)





### [32. æé¿æææ¬å·](https://leetcode.cn/problems/longest-valid-parentheses/)

```java
class Solution {
    public int longestValidParentheses(String s) {
        // dpè¡¨ç¤ºä»¥æä¸ªæ¬å·ç»å°¾çå­ç¬¦ä¸²çæå¤§æææ¬å·é¿åº¦
        int[] dp = new int[s.length()];
        Arrays.fill(dp, 0);
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = 2 + dp[i - 1] + (i - dp[i - 1] - 2 > -1 ? dp[i - dp[i - 1] - 2] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
```



### [33. æç´¢æè½¬æåºæ°ç»](https://leetcode.cn/problems/search-in-rotated-sorted-array/)

```java
class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid  = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // targetå¨[nums[0], nums[mid]]
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target <= nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                // targetå¨[nums[mid], nums[nums.length - 1]]
                if (nums[mid] <= target && target <= nums[nums.length - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
```



### [34. å¨æåºæ°ç»ä¸­æ¥æ¾åç´ çç¬¬ä¸ä¸ªåæåä¸ä¸ªä½ç½®](https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/)

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = serchFirst(nums, target);
        int right = searchLast(nums, target);
        int[] res = new int[]{left, right};
        return res;
    }

    // æç´¢ç¬¬ä¸ä¸ªåºç°çæ°
    private int serchFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                // ç¬¬ä¸ä¸ªæ°ãä¸­é´çæ°!=ä¸­é´é å·¦çæ°(å³è¡¨ç¤ºä¸æ¯éå¤åç´ ) åç´æ¥è¿å
                if (mid == 0 || nums[mid] != nums[mid - 1]) {
                    return mid;
                    // å¦åå°±å·¦ç§»
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // æç´¢æåä¸ä¸ªåºç°çæ°
    private int searchLast(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                // æ¯æåä¸ä¸ªæ°ãä¸­é´çæ°!=ä¸­é´é å³çæ°(å³è¡¨ç¤ºä¸æ¯éå¤åç´ ) åç´æ¥è¿å
                if (mid == nums.length - 1 || nums[mid] != nums[mid + 1]) {
                    return mid;
                } else {
                    // å¦åå°±å³ç§»
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
```

æ¶é´å¤æåº¦è¦æ±æ¯O(log n)ï¼æä»¥åªè½æ¯binary research 

 [ç¨åºååå](https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/solution/ren-zhe-suan-fa-quan-wang-zui-qing-xi-yi-f8up/)



### [39. ç»åæ»å](https://leetcode.cn/problems/combination-sum/)

```java
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0);
        return res;
    }

    public void dfs(int[] candidates, int target, int start) {
        // è¿ä¸ªå¯ä»¥ä¸å ï¼ä»ç¨äºä¼åï¼è§ä¸å¾
        if (target < 0) return;
        if (target == 0) {
            res.add(new LinkedList(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                path.add(candidates[i]);
                // å ä¸ºå¯ä»¥éå¤ä½¿ç¨ï¼æä»¥è¿æ¯iï¼æ¯å¦è½ç¶åªæä¸ä¸ª2ï¼ä½å¯ä»¥ç¨å æ¬¡
                dfs(candidates, target - candidates[i], i);
                path.removeLast(); 
            }
        }
    }
}
```

å¯¹äºæ ·ä¾ï¼candidates [2,3,6,7], targetä¸º7

forå¾ªç¯çiå¦æä»0å¼å§ï¼åæ¬é¢çç»ææ¯ï¼[[2,2,3],[2,3,2],[3,2,2],[7]]ï¼ä¸ç¬¦åé¢æ

ä½forå¾ªç¯çiå¦æä»startå¼å§ï¼åæ¬é¢çç»ææ¯ï¼[[2,2,3],[7]]ï¼å»éäºåç´ ï¼å¤åé¢æ



### [42. æ¥é¨æ°´](https://leetcode.cn/problems/trapping-rain-water/)



### [46. å¨æå](https://leetcode.cn/problems/permutations/)

```java
class Solution {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int start) {
        if (path.size() == nums.length) {
            res.add(new LinkedList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            dfs(nums, i);
            path.removeLast();
        }
    }
}
```

å¯¹äºæ ·ä¾ï¼[1,2,3]

å¦æforå¾ªç¯çiä»startå¼å§ï¼åæç»çè¿åç»æç[[1,2,3]]ï¼ç¸å½äºå»äºéï¼ä¸ç¬¦åé¢æ

ä½å¦æforå¾ªç¯çiä»0å¼å§ï¼åæç»çè¿åç»æç[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]ï¼ç¬¦åé¢æ



### [48. æè½¬å¾å](https://leetcode.cn/problems/rotate-image/)

```java
class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int[] lie : matrix) {
            reverse(lie);
        }
    }

    // ä¸ç»´æ°ç»ä¸­äº¤æ¢arr[i]åarr[j]
    private void reverse(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }
}
```



### [49. å­æ¯å¼ä½è¯åç»](https://leetcode.cn/problems/group-anagrams/)

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //1.åå»ºä¸ä¸ªåå¸è¡¨
        Map<String,List> map = new HashMap<String, List>();
        for (String s: strs) {
            //å°å­ç¬¦ä¸²è½¬åä¸ºå­ç¬¦æ°ç»
            char[] chars = s.toCharArray();
            //å¯¹å­ç¬¦æ°ç»æç§å­æ¯é¡ºåºæåº
            Arrays.sort(chars);
            //å°æåºåçå­ç¬¦ä¸²ä½ä¸ºåå¸è¡¨ä¸­çkeyå¼
            String key = String.valueOf(chars);
            //2.å¤è¯»åå¸è¡¨ä¸­æ¯å¦æè¯¥keyå¼
            if (!map.containsKey(key)){
                //è¥ä¸å­å¨ï¼åä¸ºæ°çå¼ä½è¯è¯­ï¼å¨mapä¸­åå»ºæ°çé®å¼å¯¹
                map.put(key,new ArrayList());
            }
            //3.å°è¯¥å­ç¬¦ä¸²æ¾å¨å¯¹åºkeyçlistä¸­
            map.get(key).add(s);
        }
        //è¿åmapä¸­ææé®å¼å¯¹è±¡ææçlist
        return new ArrayList(map.values());
    }
}
```

[å®æ¹é¢è§£](https://www.bilibili.com/video/BV1Yf4y1e7gJ?spm_id_from=333.337.search-card.all.click&vd_source=35aeaee52b15e78b11967f5ef3ce655a) 

HashMapé£è¾¹çå¤æ­åä¹åä¸ä¸æ ·ï¼è¿é¢éè¦å°ææçå¼é½addå°mapä¸­ï¼æä»¥`map.get(key).add(s);`ä¸è½åä¹åé£æ ·åºç°å¨else ifå½ä¸­ã



### [53. æå¤§å­æ°ç»å](https://leetcode.cn/problems/maximum-subarray/)

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
```



### [55. è·³è·æ¸¸æ](https://leetcode.cn/problems/jump-game/)

```java
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        // farthestä»£è¡¨è½å¤è·³å°çæè¿çè·ç¦»
        int farthest = 0;
        for (int i = 0; i < n - 1; i++) {
            // æ´æ°æè¿è·ç¦»farthest
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest <= i) {
                return false;
            }
        }
        // çæè¿çè·ç¦»æ¯å¦è½å¤è¾¾å°æåä¸ä½
        return farthest >= n - 1;
    }
}
```



### [56. åå¹¶åºé´](https://leetcode.cn/problems/merge-intervals/)

```java
class Solution {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> res = new LinkedList<>();
        // æåºé´ç start ååºæå
        Arrays.sort(intervals, (a, b) -> {return a[0] - b[0];});
        // curç¸å½äº[[1, 3],[4, 6],[8, 10],[15, 18]]ä¸­ç[1, 3]
        int[] cur = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            // æ²¡æéå ï¼iä»1å¼å§ï¼æä»¥ç¸å½äºå¨[[1, 3],[4, 6],[8, 10],[15, 18]]ä¸­ï¼[4, 6]ä¸­ç4å¤§äº[1, 3]ä¸­ç3ï¼ç´æ¥å°[1,3]å å¥res
            if (intervals[i][0] > cur[1]) {
                res.add(cur);
                // æ´æ°curä¸º[8, 10]
                cur = intervals[i];
            } else {
                // æéå ï¼æ¯å¦å¨[[1, 3],[2, 6],[8, 10],[15, 18]]ä¸­åäºç»´æ°ç»çç¬¬ä¸ä¸ªçç¬¬äºä½å³æ´æ°[1, 3]ç§cur[1] = 3
                cur[1] = Math.max(cur[1], intervals[i][1]);
            }
        }
        res.add(cur);
        // å ä¸ºè¿åçæ¯äºç»´æ°ç»ï¼æä»¥æ´çä¸ä¸ç»æ
        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
```



### [62. ä¸åè·¯å¾](https://leetcode.cn/problems/unique-paths/)

```java
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
```

`dp[i][j]`è¡¨ç¤ºå°è¾¾è¡iåjçææè·¯å¾ï¼æä»¥å¤å´çè¾¹çä¸º1ï¼å ä¸ºåªè½ä¸ç´åå³æåä¸ã



### [64. æå°è·¯å¾å](https://leetcode.cn/problems/minimum-path-sum/)

```java
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        // åå§ådp[0][0]è¦æ³¨æä¸æ¯0ï¼èæ¯grid[0][0]
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
```



### [70. ç¬æ¥¼æ¢¯](https://leetcode.cn/problems/climbing-stairs/)

```java
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
```



### [72. ç¼è¾è·ç¦»](https://leetcode.cn/problems/edit-distance/)

```java
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(); // è¡
        int n = word2.length(); // å
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (int i = 1; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < n + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
```





### [75. é¢è²åç±»](https://leetcode.cn/problems/sort-colors/)

```java
class Solution {
    public void sortColors(int[] nums) {
        // åå§ååº0ã1ã2çé¢ç
        int numOf0 = 0;
        int numOf1 = 0;
        int numOf2 = 0;
        for (int num : nums) {
            if (num == 0) {
                numOf0++;
            } else if (num == 1) {
                numOf1++;
            } else if (num == 2) {
                numOf2++;
            }
        }
        
        for (int i = 0; i < numOf0; i++) {
            nums[i] = 0;
        }
        for (int i = numOf0; i < numOf0 + numOf1; i++) {
            nums[i] = 1;
        }
        for (int i = numOf0 + numOf1; i < nums.length; i++) {
            nums[i] = 2;
        }
        return;
    }
}
```

ç»è®¡åº0ã1ã2çé¢çï¼å¹¶å°åæ°ç»è¿è¡è¦çï¼[åæ£ä¸æççé¢è§£å·²ç»åå¸](https://leetcode.cn/problems/sort-colors/solution/by-milessg-4bkk/)

èªå·±åªåæèï¼æ»ä¼æå¾å¤§æ¶è·



### [76. æå°è¦çå­ä¸²](https://leetcode.cn/problems/minimum-window-substring/)





### [78. å­é](https://leetcode.cn/problems/subsets/)

```java
class Solution {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int start) {
        res.add(new LinkedList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i + 1);
            path.removeLast();
        }
    }
}
```

forå¾ªç¯ä¸­çiä»startå¼å§éåï¼å¦æä»0å¼å§çè¯ï¼ä¼è¶æ¶



### [79. åè¯æç´¢](https://leetcode.cn/problems/word-search/)

```java
class Solution {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
	// iåjè¡¨ç¤ºç¬¬iè¡ç¬¬jå kè¡¨ç¤ºè®¿é®å°åè¯çç¬¬å ä¸ªå­ç¬¦
    private boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length 
        || board[i][j] != word[k]) return false;
        // å¨é¨å¹éå®æ¯
        if(k == word.length - 1) return true;
        // ç¨ç¹æ®å­ç¬¦è®°å½board[i][j]ä½ç½®ï¼è¡¨ç¤ºå·²ç»è®¿é®è¿ï¼ç®çå°±æ¯é²æ­¢è¢«éå¤è®¿é®
        board[i][j] = '*';
        boolean res = dfs(board, word, i + 1, j, k + 1) 
            || dfs(board, word, i - 1, j, k + 1)
        	|| dfs(board, word, i, j + 1, k + 1) 
            || dfs(board, word, i, j - 1, k + 1);
        // æ²¡æ¾å°çè¯ï¼è¦åé
        board[i][j] = word[k];
        return res;
    }
}
```



### [84. æ±ç¶å¾ä¸­æå¤§çç©å½¢](https://leetcode.cn/problems/largest-rectangle-in-histogram/)





### [85. æå¤§ç©å½¢](https://leetcode.cn/problems/maximal-rectangle/)



### [94. äºåæ çä¸­åºéå](https://leetcode.cn/problems/binary-tree-inorder-traversal/)

```java
class Solution {

    List<Integer> res = new LinkedList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        dfs(root);
        return res;
    }

    // ä¸­åºï¼å·¦æ ¹å³
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
    }
}
```



### ==[96. ä¸åçäºåæç´¢æ ](https://leetcode.cn/problems/unique-binary-search-trees/)==

```java
class Solution {
    public int numTrees(int n) {
        // åå§å dp æ°ç»
        int[] dp = new int[n + 1];
        // åå§å0ä¸ªèç¹å1ä¸ªèç¹çæåµ
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                //å¯¹äºç¬¬iä¸ªèç¹ï¼éè¦èè1ä½ä¸ºæ ¹èç¹ç´å°iä½ä¸ºæ ¹èç¹çæåµï¼æä»¥éè¦ç´¯å 
                //ä¸å±iä¸ªèç¹ï¼å¯¹äºæ ¹èç¹jæ¶,å·¦å­æ çèç¹ä¸ªæ°ä¸ºj-1ï¼å³å­æ çèç¹ä¸ªæ°ä¸ºi-j
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
```



### [98. éªè¯äºåæç´¢æ ](https://leetcode.cn/problems/validate-binary-search-tree/)

```java
class Solution {

    List<Integer> res = new LinkedList<>();

    public boolean isValidBST(TreeNode root) {
        dfs(root);
        // åé¢çæ¯åé¢çå¤§å°±è¿åfalse
        for (int i = 1; i < res.size(); i++) {
            if (res.get(i - 1) >= res.get(i)) {
                return false;
            }
        }
        return true;
    }

    // ä¸­åºéåï¼å·¦æ ¹å³
    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
    }
}
```



### [101. å¯¹ç§°äºåæ ](https://leetcode.cn/problems/symmetric-tree/)

```java
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return help(root.left, root.right);
    }

    private boolean help(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return help(left.left, right.right) && help(left.right, right.left);
    }
}
```



### [102. äºåæ çå±åºéå](https://leetcode.cn/problems/binary-tree-level-order-traversal/)

```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return res;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> path = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                // åpathä¸­å å¥èç¹å¼
                path.add(node.val);
                if (node.left != null) {
                    // åéåä¸­å å·¦èç¹
                    queue.add(node.left);
                }
                if (node.right != null) {
                    // åéåä¸­å å³èç¹
                    queue.add(node.right);
                }
            }
            res.add(path);
        }
        return res;
    }
}
```



### [104. äºåæ çæå¤§æ·±åº¦](https://leetcode.cn/problems/maximum-depth-of-binary-tree/)

```java
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
```



### [105. ä»ååºä¸ä¸­åºéååºåæé äºåæ ](https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)

```java
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int rootIndexInorder = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                rootIndexInorder = i;
                break;
            }
        }
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, rootIndexInorder + 1);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, rootIndexInorder);
        root.left = buildTree(leftPreorder, leftInorder);
        
        int[] rightPreorder = Arrays.copyOfRange(preorder, rootIndexInorder + 1, inorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, rootIndexInorder + 1, inorder.length);
        root.right = buildTree(rightPreorder, rightInorder);

        return root;
    }
}
```





### [114. äºåæ å±å¼ä¸ºé¾è¡¨](https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/)

```java
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
		root.left = null;
        root.right = left;

        while (root.right != null) {
            root = root.right;
        }
        root.right = right;
    }
}
```

[è·é©¬ææ¾çç¨åºå](https://www.bilibili.com/video/BV15Z4y1R7Zo?spm_id_from=333.337.search-card.all.click&vd_source=35aeaee52b15e78b11967f5ef3ce655a)

<img src="https://labuladong.github.io/algo/images/äºåæ ç³»å/2.jpeg" alt="img" style="zoom:50%;" />





### [121. ä¹°åè¡ç¥¨çæä½³æ¶æº](https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/)

```java
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            // ç¬¬iå¤©ä¸ææ = ç¬¬i-1å¤©ä¸ææå ä¸ç¬¬i-1å¤©ææç¶åç¬¬iå¤©åæ
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]); 
            // ç¬¬iå¤©ææ = ç¬¬i-1å¤©ææå ä¸ç¬¬i-1å¤©(è¿é¢æ¯ç¬¬0å¤©)ææç¶åç¬¬iå¤©ä¹°å¥
            // dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], 0 - prices[i]); 
        }
        return dp[prices.length - 1][0];
    }
}
```



### [124. äºåæ ä¸­çæå¤§è·¯å¾å](https://leetcode.cn/problems/binary-tree-maximum-path-sum/)

```java
class Solution {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        // ä»rootãroot + leftãroot + rightä¸èä¸­éåºä¸´æ¶çæå¤§å¼tmp
        int tmp = Math.max(root.val, Math.max(root.val + left, root.val + right));
        // åå å¥root + left + right ä¸ä¸´æ¶åétmpè¿è¡æ¯è¾
        res = Math.max(res, Math.max(tmp, root.val + left + right));
        return tmp;
    }
}
```





### [128. æé¿è¿ç»­åºå](https://leetcode.cn/problems/longest-consecutive-sequence/)

```java
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLen = 0;
        // å­æ¾å·²ç»ä½¿ç¨è¿çåç´ 
        Set<Integer> used = new HashSet<>();
        for (int num : set) {
            if (used.contains(num)) {
                continue;
            }
            int curLen = 1;
            while (set.contains(num + 1)) {
                curLen++;
                num++;
                used.add(num + 1);
            }
            maxLen = Math.max(maxLen, curLen);
        }
        return maxLen;
    }
}
```













### [136. åªåºç°ä¸æ¬¡çæ°å­](https://leetcode.cn/problems/single-number/)

```java
class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (int num : map.keySet()) {
            if (map.get(num) == 1) {
                return num;
            }
        }
        return -1;
    }
}
```



### [141. ç¯å½¢é¾è¡¨](https://leetcode.cn/problems/linked-list-cycle/)

```java
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (set.contains(cur)) {
                return true;
            } else {
                set.add(cur);
            }
            cur = cur.next;
        }
        return false;
    }
}
```

ä¸ç¥éä¸ºä»ä¹åå¸éé¢ä¸å¯ä»¥å­Integerï¼åªè½å­ListNode



### [142. ç¯å½¢é¾è¡¨ II](https://leetcode.cn/problems/linked-list-cycle-ii/)

```java
public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (set.contains(cur)) {
                return cur;
            } else {
                set.add(cur);
            }
            cur = cur.next;
        }
        return null;
    }
}
```



### [146. LRU ç¼å­](https://leetcode.cn/problems/lru-cache/)

```java
class LRUCache {

    LinkedHashMap<Integer, Integer> map;
    int capacity;

    public LRUCache(int capacity) {
        map = new LinkedHashMap<>(capacity, 0.75f, true);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        return map.get(key);
    }
    
    public void put(int key, int value) {
        map.put(key, value);
        if (map.size() > capacity) {
            Iterator it = map.keySet().iterator();
            map.remove(it.next());
        }
    }
}
```

LinkedHashMapæ°æ®ç»æ



### [160. ç¸äº¤é¾è¡¨](https://leetcode.cn/problems/intersection-of-two-linked-lists/)

```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        if (lenA < lenB) {
            int diff = lenB - lenA;
            while (diff > 0) {
                headB = headB.next;
                diff--;
            }
        } else {
            int diff = lenA - lenB;
            while (diff > 0) {
                headA = headA.next;
                diff--;
            }
        }
        // å¤æ­æ¡ä»¶æ¯ä¸¤ä¸ªå¤´æéä¸ç¸ç­
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int getLen(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }
}
```



### [169. å¤æ°åç´ ](https://leetcode.cn/problems/majority-element/)

```java
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (int num : map.keySet()) {
            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }
        return -1;
    }
}
```

è¿é¢æ¯[136. åªåºç°ä¸æ¬¡çæ°å­](https://leetcode.cn/problems/single-number/)çå§å¦¹é¢



### [198. æå®¶å«è](https://leetcode.cn/problems/house-robber/)

```java
class Solution {
    public int rob(int[] nums) {
        if (nums.length <= 1) return (nums.length == 0) ? 0 : nums[0];
        int res = Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
```





### [200. å²å±¿æ°é](https://leetcode.cn/problems/number-of-islands/)

```java
class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }    
}
```



### [206. åè½¬é¾è¡¨](https://leetcode.cn/problems/reverse-linked-list/)

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
```





### [215. æ°ç»ä¸­çç¬¬Kä¸ªæå¤§åç´ ](https://leetcode.cn/problems/kth-largest-element-in-an-array/)

```java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            if (queue.size() < k) {
                queue.add(num);
            } else if (queue.peek() < num) {
                queue.poll();
                queue.add(num);
            }
        }
        return queue.peek();
    }
}
```



### [226. ç¿»è½¬äºåæ ](https://leetcode.cn/problems/invert-binary-tree/)

```java
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }
}
```



### [234. åæé¾è¡¨](https://leetcode.cn/problems/palindrome-linked-list/)

```java
class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        cur = head;
        while (!stack.isEmpty()) {
            if (stack.pop() != cur.val) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }
}
```

ä¸ç¥éä¸ºä»ä¹Stackä¸­åªè½å­Integerï¼ä¸è½å­ListNodeï¼ä½[141. ç¯å½¢é¾è¡¨](https://leetcode.cn/problems/linked-list-cycle/)åªè½ä½¿ç¨å­å¥ListNodeè¿ç§æ°æ®ç»æ



### [236. äºåæ çæè¿å¬å±ç¥å](https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/)

```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right != null) return right;
        if (left != null && right == null) return left;
        if (left != null && right != null) return root;
        return null;
    }
}
```



### [283. ç§»å¨é¶](https://leetcode.cn/problems/move-zeroes/)

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
```





### [287. å¯»æ¾éå¤æ°](https://leetcode.cn/problems/find-the-duplicate-number/)

```java
class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (int num : map.keySet()) {
            if (map.get(num) >= 2) {
                return num;
            }
        }
        return -1;
    }
}
```



### [560. åä¸º K çå­æ°ç»](https://leetcode.cn/problems/subarray-sum-equals-k/)

```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        /**
         æ«æä¸éæ°ç», ä½¿ç¨mapè®°å½åºç°åæ ·çåçæ¬¡æ°, å¯¹æ¯ä¸ªiè®¡ç®ç´¯è®¡åsumå¹¶å¤æ­mapåæ¯å¦æsum-k
         **/
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, ret = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                ret += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }
        return ret;
    }
}
```

