package AIEMC_OUEI;

import java.util.*;

public class BusyIntersection {
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(0, 1, 1, 3, 4);
        List<Integer> street = Arrays.asList(0, 1, 0, 0, 1);
        BusyIntersection busy = new BusyIntersection();
        busy.getResult(a, street);
        System.out.println(busy.getResult(a, street));
    }

    public List<Integer> getResult(List<Integer> a, List<Integer> street) {
        Deque<int[]> firstAve = new ArrayDeque<>();
        Deque<int[]> mainStreet = new ArrayDeque<>();
        int curTime = 0;
        //-1代表上一秒没车过，0代表过了辆main的，1代表过了辆first的
        int lastCar = -1;
        int[] res = new int[a.size()];

        for (int i = 0; i < a.size(); i++) {
            if (street.get(i) == 0) {
                //到达时间和到达的顺序存入
                mainStreet.add(new int[]{a.get(i), i});
            } else {
                firstAve.add(new int[]{a.get(i), i});
            }
        }

        while (!mainStreet.isEmpty() && !firstAve.isEmpty()) {
            //正常情况讨论
            int[] main = mainStreet.peek(), first = firstAve.peek();
            //当前时间已经有两辆车在路口等了
            if (curTime < main[0] && curTime < first[0]) {
                curTime = Math.min(main[0], first[0]);
                if (main[0] < first[0]) {
                    mainStreet.poll();
                    lastCar = 0;
                } else {
                    firstAve.poll();
                    lastCar = 1;
                }
            } else if (curTime >= first[0]) {   //first先到
                firstAve.poll();
                lastCar = 1;
            } else if (curTime >= main[0]) {   //main先到
                mainStreet.poll();
                lastCar = 0;
                //当前时间路口没车，直接把时间快进到第一辆车来
            } else if (curTime >= main[0] && curTime >= first[0]) {
                if (lastCar == 1) {
                    firstAve.poll();
                } else if (lastCar == 0) {
                    mainStreet.poll();
                } else {
                    //main先到
                    if (main[0] < first[0]) {
                        mainStreet.poll();
                        lastCar = 0;
                    } else {    //main后到或者一起到都是first先走
                        firstAve.poll();
                        lastCar = 1;
                    }
                }
            }
            //讨论完情况就自增时间
            if (lastCar == 1) {
                res[first[1]] = curTime;
            } else {
                res[main[1]] = curTime;
            }
            curTime++;
        }
        while (!firstAve.isEmpty()) {
            int[] first = firstAve.poll();
            if (first[0] > curTime) {
                curTime = first[0];
            }
            res[first[1]] = curTime;
            curTime++;
        }

        while (!mainStreet.isEmpty()) {
            int[] main = mainStreet.poll();
            if (main[0] > curTime) {
                curTime = main[0];
            }
            res[main[1]] = curTime;
            curTime++;
        }

        List<Integer> ans = new ArrayList<>();
        for (int num : res) {
            ans.add(num);
        }
        return ans;
    }
}
