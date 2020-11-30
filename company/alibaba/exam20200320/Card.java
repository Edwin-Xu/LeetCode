package company.alibaba.exam20200320;

/**
 * Created by Edwin Xu on 8/28/2020 5:46 PM
 *
 * 题目描述
 * 有一叠扑克牌，每张牌介于1和10之间，有四种出牌方法：
 *
 * 单牌
 * 对子
 * 顺子：如12345
 * 连对：如112233
 * 给10个数，表示1-10每种牌有几张，问最少要多少次能出完
 *
 * 输入样例
 * 1 1 1 2 2 2 2 2 1 1
 *
 * 输出样例
 * 3
 *
 */
public class Card {
    /*
    * 此题有点难啊
    * 动态？
    * 贪心？
    * 顺子至少5张？
    *
    * 动态规划+贪心算法：
    *   动态规划：每次尝试出顺子和连队
    *   贪心：对子和单牌直接贪心
    *
    *把顺子和连对这些情况放到前面，然后单牌和对子就不用进行迭代了，直接全丢出去就好了。
    * */
    public int leastTimeToSendCard(int arr[]){


        return 0;
    }
}

/*
*
*
#include <iostream>
#include <vector>
using namespace std;

const int MAX_COUNT = 40;

int recursivePoke(vector<int> &poke, int totalPoke) {
    if (totalPoke <= 0) {
        return 0;
    }
    if (totalPoke == 1) {
        return 1;
    }

    int ans = MAX_COUNT;
    int recursiveResult;
    bool flag;

    // 顺子
    if (totalPoke >= 5) {
        for (size_t i = 0; i < 10; ++i) {
            flag = true;    // 有顺子
            for (size_t j = i; j < i + 5; ++j) {
                if ((j < 10 && poke[j] == 0) || j >= 10) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                for (size_t j = i; j < i + 5; ++j) {
                    --poke[j];
                }
                recursiveResult = recursivePoke(poke, totalPoke - 5);
                if (recursiveResult + 1 < ans) {
                    ans = recursiveResult + 1;
                }
                for (size_t j = i; j < i + 5; ++j) {
                    ++poke[j];
                }
            }
        }
    }

    // 连对
    if (totalPoke >= 6) {
        for (size_t i = 0; i < 10; ++i) {
            flag = true;    // 有连对
            for (size_t j = i; j < i + 3; ++j) {
                if ((j < 10 && poke[j] < 2) || j >= 10) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                for (size_t j = i; j < i + 3; ++j) {
                    poke[j] -= 2;
                }
                recursiveResult = recursivePoke(poke, totalPoke - 6);
                if (recursiveResult + 1 < ans) {
                    ans = recursiveResult + 1;
                }
                for (size_t j = i; j < i + 3; ++j) {
                    poke[j] += 2;
                }
            }
        }
    }

    // 对子
    if (ans == MAX_COUNT) {
        recursiveResult = 0;
        for (int &num : poke) {
            recursiveResult += (num / 2);
            num %= 2;
            recursiveResult += num;
        }
        ans = recursiveResult;
    }

    // 单牌
    if (ans == MAX_COUNT) {
        ans = 0;
        for (int num : poke) {
            ans += num;
        }
    }

    return ans;
}

int main()
{
    vector<int> poke(10);
    int totalPoke = 0;
    for (int &num : poke) {
        cin >> num;
        totalPoke += num;
    }
    cout << recursivePoke(poke, totalPoke);
    return 0;
}
* */
