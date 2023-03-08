import Person.Person;
import com.sun.org.apache.bcel.internal.generic.RET;
import com.sun.prism.sw.SWPipeline;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

class Solution<p> {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int longestPalindromeSubseq(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];
        for (int i = length - 1; i > -1; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {

                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][length - 1];
    }


    //    public void quick(int[] arr){
//                quiclkor(arr,0,arr.length-1);
//   }
//
//    private void quiclkor(int[] arr, int i, int i1) {
//        if(i < i1){
//            swap(arr,i+ (int)Math.random()*(i1 - i +1),i1);
//          int[] res =  partion(arr,i,i1);
//          quiclkor(arr,i,res[0] -1);
//          quiclkor(arr,res[1]+1,i1);
//        }
//    }
//
//    private int[] partion(int[] arr, int i, int i1) {
//        int min = i -1;
//        int max = i1;
//        int a = 0;
//        while(i < max){
//            if(arr[i] > arr[i1]){
//                swap(arr,--max,i);
//            }else if(arr[i] < arr[i1]){
//                swap(arr,++min,i++);
//            }else {
//                i++;
//            }
//        }
//        swap(arr,max,i1);
//        return new int[]{min+1,max};
//    }
//
//    private void swap(int[] arr, int i, int i1) {
//        int temp = arr[i];
//        arr[i] = arr[i1];
//        arr[i1] = temp;
//
//    }
    public void guibin(int[] arr) {
        guibin1(arr, 0, arr.length - 1);
    }

    private void guibin1(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int mid = i + (j - i) / 2;
        guibin1(arr, i, mid);
        guibin1(arr, mid + 1, j);
        merge3(arr, i, mid, j);
    }

    private void merge3(int[] arr, int i, int mid, int j) {
        int[] p = new int[j - i + 1];
        int k = i;
        int idnex = 0;
        int y = mid + 1;
        while (k <= mid && y <= j) {
            p[idnex++] = arr[k] <= arr[y] ? arr[k++] : arr[y++];
        }
        while (k <= mid) {
            p[idnex++] = arr[k++];
        }
        while (y <= j) {
            p[idnex++] = arr[y++];
        }
        for (int m = 0; m < p.length; m++) {
            arr[i + m] = p[m];
        }


    }

    public void guibin2(int[] arr) {
        guibin22(arr, 0, arr.length - 1);
    }

    private void guibin22(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int mid = i + ((j - i) >> 1);
        guibin22(arr, i, mid);
        guibin22(arr, mid + 1, j);
        merge22(arr, i, mid, j);

    }

    private void merge22(int[] arr, int i, int mid, int j) {
        int[] help = new int[j - i + 1];
        int k = 0;
        int p = i;
        int q = mid + 1;
        while (p <= mid && q <= j) {
            help[k++] = arr[p] <= arr[q] ? arr[p++] : arr[q++];
        }
        while (p <= mid) {
            help[k++] = arr[p++];
        }
        while (q <= j) {
            help[k++] = arr[q++];
        }
        for (int m = 0; m < help.length; m++) {
            arr[i + m] = help[m];
        }
    }

    public void quicksu1(int[] arr) {
        quicksu11(arr, 0, arr.length - 1);
    }

    private void quicksu11(int[] arr, int i, int j) {
        if (i < j) {
            swap(arr, i + (int) (Math.random() * j - i + 1), j);
            int[] parion = paroin(arr, i, j);
            quicksu11(arr, i, parion[0] - 1);
            quicksu11(arr, parion[1] + 1, j);
        }
    }

    private int[] paroin(int[] arr, int i, int j) {
        int s = i - 1;
        int b = j;
        while (i < b) {
            if (arr[i] > arr[j]) {
                swap(arr, --b, i);
            } else if (arr[i] < arr[j]) {
                swap(arr, ++s, i++);
            } else {
                i++;
            }
        }
        swap(arr, b, j);
        return new int[]{s + 1, b};
    }

    private void swap(int[] arr, int v, int i1) {
        int temp = arr[v];
        arr[v] = arr[i1];
        arr[i1] = temp;
    }

    public void process(int[] arr) {
        process1(arr, 0, arr.length - 1);
    }

    private void process1(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int mid = i + ((j - i) >> 1);
        process1(arr, i, mid);
        process1(arr, mid + 1, j);
        merge(arr, i, mid, j);
    }

    private void merge(int[] arr, int i, int mid, int j) {
        int p = i;
        int q = mid + 1;
        int index = 0;
        int[] dp = new int[j - i + 1];
        while (p <= mid && q <= j) {
            dp[index++] = arr[p] <= arr[q] ? arr[p++] : arr[q++];
        }
        while (p <= mid) {
            dp[index++] = arr[p++];
        }
        while (q <= j) {
            dp[index++] = arr[q++];
        }
        for (int k = 0; k < dp.length; k++) {
            arr[i + k] = dp[k];
        }
    }

    public void maopao(int[] arr) {
        int length = arr.length;
        for (int i = length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public void maopao1(int[] arr) {
        int length = arr.length;
        for (int i = arr.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public void charru(int[] arr) {
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public void charu1(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public void xuanze(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int mindex = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[mindex]) {
                    mindex = j;
                }
            }
            swap(arr, mindex, i);
        }
    }

    public void xuanze1(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int mindex = i;
            for (int j = i + 1; j < len; j++) {
                mindex = arr[j] > arr[mindex] ? mindex : j;
            }
            swap(arr, i, mindex);
        }
    }

    HashMap<Integer, Integer> map;

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        StringBuilder stringBuilder = new StringBuilder();
//        binaryTreePaths1(root,res,stringBuilder);
        return res;
    }

//    private void binaryTreePaths1(TreeNode root, List<String> res, StringBuilder stringBuilder) {
//        stringBuilder.append(root.val).append("->");
//        if (root.left == null && root.right == null){
//            res.add(stringBuilder.toString());
//
//        }else if (root.right !=)
//
//    }


    public int longestValidParentheses(String s) {
        int length = s.length();
        LinkedList<Character> integers = new LinkedList<>();
        int count = 0;
        char a = '0';
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                integers.offerFirst(s.charAt(i));
                continue;
            }
            if (!integers.isEmpty()) {
                Character character = integers.peekFirst();
                a = character.charValue();
            }

            if (a == '(' && s.charAt(i) == ')') {
                integers.pollFirst();

                count = count + 2;
                continue;
            }
            integers.offerFirst(s.charAt(i));
        }
        return count;
    }

    private TreeNode constructMaximumBinaryTree1(int[] nums, int i, int length) {
        if (length - i < 1) {
            return null;
        }
        if (length - i == 1) {
            return new TreeNode(nums[i]);
        }
        int max = nums[i];
        int index = i;
        for (int k = i + 1; k < length; k++) {
            if (max < nums[k]) {
                max = nums[k];
                index = k;
            }


        }
        TreeNode root = new TreeNode(max);
        root.left = constructMaximumBinaryTree1(nums, i, index);

        root.right = constructMaximumBinaryTree1(nums, index + 1, length);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildtree1(preorder, 0, preorder.length, inorder, 0, inorder.length);

    }

    private TreeNode buildtree1(int[] preorder, int i, int length, int[] inorder, int j, int length1) {
        if (i >= length || j >= length1) {
            return null;
        }
        int minindex = map.get(preorder[i]);
        TreeNode treeNode = new TreeNode(inorder[minindex]);
        int len = minindex - j;
        treeNode.left = buildtree1(preorder, i + 1, i + 1 + len, inorder, j, minindex);
        treeNode.right = buildtree1(preorder, i + 1 + len, length, inorder, minindex + 1, length1);
        return treeNode;

    }

    public int search(int[] nums, int target) {
        int length = nums.length;
        int p = 0;
        int q = length - 1;
        while (p <= q) {
            int mid = p + (q - p) / 2;
            if (nums[mid] > target) {
                q = mid - 1;
            } else if (nums[mid] < target) {
                p = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        ArrayList<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                return lists;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int p = i + 1;
            int q = length - 1;
            while (p < q) {
                int sum = nums[p] + nums[q] + nums[i];
                if (sum > 0) {
                    q--;
                } else if (sum < 0) {
                    p++;
                } else {
                    lists.add(Arrays.asList(nums[p], nums[q], nums[i]));
                    while (p < q && nums[p] == nums[p + 1]) {
                        p++;
                    }
                    while (p < q && nums[q] == nums[q - 1]) {
                        q--;
                    }
                    p++;
                    q--;
                }
            }
        }
        return lists;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        Arrays.fill(result, -1);
        LinkedList<Integer> integers = new LinkedList<>();
        for (int i = 0; i < length; i++) {

            while (!integers.isEmpty()) {
                if (temperatures[integers.peekFirst()] < temperatures[i]) {
                    Integer integer = integers.pollFirst();
                    result[integer] = i - integer;
                } else {
                    break;
                }
            }
            integers.offerFirst(i);

        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{9, 3, 15, 20, 7};
        int[] nums2 = new int[]{9, 15, 7, 20, 3};
        String B = new String("())");


//        int[] a = new int[]{-1,0,2,99,-31321,6,88,100000};
//        Solution solution = new Solution();
////        solution.xuanze(a);
////        solution.buildTree(nums1,nums2);
////        solution.nextGreaterElement(nums1,nums2);
//        solution.quicksu1(a);
//
//        for (int i : a) {
//            System.out.println(i);
//        }
//        System.out.println(a);
//        Solution<Object> objectSolution = new Solution<>();
//        objectSolution.kk();
        List<String> list = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");

        Optional<String> max = list.stream().max((a, b) -> -1);
        System.out.println("最长的字符串：" + max.get());


        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));

        Optional<Person> max1 = personList.stream().max((a,b) -> b.getSalary() - a.getSalary());
        String m = "900";
        String n = "99";
        int l = 9;
        int v = 8;
        System.out.println(l-v);
        System.out.println("员工薪资最大值：" + max1.get().getSalary());
        String[] strArr = { "abcd", "bcdd", "defde", "fTr" };
        List<String> strList = Arrays.stream(strArr).map(x -> x.toUpperCase()).collect(Collectors.toList());
        System.out.println(strList);
        System.out.println("----------------");
        List<Integer> integerList = Arrays.asList(4, 5, 2, 1, 6, 3);
        integerList.stream().map(x -> x + 1000).forEach(System.out::println);
        List<String> stringList = Arrays.asList("mu", "CSDN", "hello",
                "world", "quickly");
        stringList.stream().map(x -> x.length()).forEach(System.out::println);
        List<Integer> doubleList = Arrays.asList(1, 2, 3, 4, 2);
//        int average = (int) doubleList.stream().map
//        System.out.println("lllllllllllllllllllll");
//        System.out.println(average);
//        double sum = doubleList.stream().mapToDouble(Number::doubleValue).sum();
//        double max22 = doubleList.stream().mapToDouble(Number::doubleValue).max().getAsDouble();
//        System.out.println("平均值：" + average + "，总和：" + sum + "，最大值：" + max);
        List<Integer> list111 = Arrays.asList(1, 3, 2, 8, 11, 4);
        // 求和方式1
        Optional<Integer> reduce = list111.stream().reduce((x, y) -> x + y);
        boolean present = reduce.isPresent();
        System.out.println(present);
        List<Person> personList3 = new ArrayList<Person>();
        personList3.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList3.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList3.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList3.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList3.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList3.add(new Person("Alisa", 7900, 26, "female", "New York"));

        // 求工资之和方式1：
        int c = personList.stream().mapToInt(Person::getSalary).sum();


//        System.out.println(integer);


    }
//    public void kk(){
//        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
//
//        stud kkk = new stud("kkk");
//        stud kkk1 = new stud("kkk");
//        boolean equals = kkk.equals(kkk1);
//        System.out.println(equals);
//        Object jhh = objectObjectHashMap.put(kkk, "666");
//        System.out.println(jhh);
//        Object jhn = objectObjectHashMap.put(kkk1, "333");
//        System.out.println(jhn);
//        System.out.println(objectObjectHashMap);
//        ArrayList<Object> objects = new ArrayList<>();
////       objectObjectHashMap.forEach(s ->{
////           System.out.println(s);
////
////       });
//
//     class stud{
//        private String name;
//
//        public stud(String name) {
//            this.name = name;
//        }
//
//         @Override
//         public String toString() {
//             return "stud{" +
//                     "name='" + name + '\'' +
//                     '}';
//         }
//
//         @Override
//         public boolean equals(Object o) {
//             if (this == o) return true;
//             if (o == null || getClass() != o.getClass()) return false;
//             stud stud = (stud) o;
//             return Objects.equals(name, stud.name);
//         }
//
//         @Override
//         public int hashCode() {
//             return Objects.hash(name);
//         }
//     }
//
//}
}