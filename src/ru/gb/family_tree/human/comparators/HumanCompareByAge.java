package ru.gb.family_tree.human.comparators;

import ru.gb.family_tree.family_tree.FamilyTreeItem;
import ru.gb.family_tree.human.Human;

import java.util.Comparator;

public class HumanCompareByAge<T extends FamilyTreeItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
