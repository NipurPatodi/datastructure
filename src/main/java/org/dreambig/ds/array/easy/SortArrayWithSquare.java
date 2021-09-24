package org.dreambig.ds.array.easy;

import java.util.ArrayList;
import java.util.Arrays;

public class SortArrayWithSquare {


    public static ArrayList<Integer> solve(ArrayList<Integer> A) {

        ArrayList<Integer> p = new ArrayList<>();
        ArrayList<Integer> n = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();

        for (int a : A) {
            if (a < 0)
                n.add(a * a);
            else
                p.add(a * a);
        }

        int nidx = n.size() - 1, pidx = 0;

        while (nidx >= 0 && pidx < p.size()) {

            if (n.get(nidx) < p.get(pidx)) {
                res.add(n.get(nidx));
                nidx--;
            } else {
                res.add(p.get(pidx));
                pidx++;
            }

        }

        while (pidx < p.size()) {
            res.add(p.get(pidx));
            pidx++;
        }

        while (nidx >= 0) {
            res.add(n.get(nidx));
            nidx--;
        }


        return res;
    }

    public static void main(String[] args) {
        int [] ip={-3,-1,0,7,10};
        ArrayList<Integer>  ips=new ArrayList<>();
        for (int j : ip) {
            ips.add(j);
        }
        ArrayList<Integer>  res=solve(ips);
        for (int r:res)
            System.out.print(r+" ");
    }
}
