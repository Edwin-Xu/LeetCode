package basicAlgorithm.permutation_and_combination;

import basicAlgorithm.permutation_and_combination.comb.CombTemplate;
import basicAlgorithm.permutation_and_combination.perm.PermTemplate;
import leetcode.util.Print;

import java.util.List;

/**
 * Created by Edwin Xu on 9/13/2020 2:09 PM
 */
public class PermCombTest {
    public static void main(String[] args) {
        CombTemplate combTemplate = new CombTemplate();
        PermTemplate permTemplate = new PermTemplate();
        int arr[] = {1,2,3,4};
        Print.printListList(combTemplate.comb(arr,3));
        Print.printListList((List)permTemplate.permutation(arr,3));
    }
}
