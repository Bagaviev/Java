package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/

public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o == null || o.getClass() != this.getClass())
            return  false;
        if (!(o instanceof Solution))
            return false;
        Solution n = (Solution) o;

        if (!Objects.equals(first, n.first)) return false;
        return Objects.equals(last, n.last);

//        if (first != null ? !first.equals(solution.first) : solution.first != null) return false;
//        return last != null ? last.equals(solution.last) : solution.last == null;
    }



    @Override
    public int hashCode() {
        int result = 0;

        if (first != null && last != null)
            result = 31 * first.hashCode() + last.hashCode();
        else if (last != null)
            result = 31 * last.hashCode();
        else if (first != null)
            result = 31 * first.hashCode();
        else result = 0;

        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();


//        Solution i = new Solution("Mickey", "Mouse");
//        Solution j = new Solution("Mickey", "Mouse");
//        System.out.println(i.hashCode());
//        System.out.println(j.hashCode());
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
