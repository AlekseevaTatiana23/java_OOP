package ru.gb.family_tree.human.comparators;

import ru.gb.family_tree.family_tree.FamilyTreeItem;
import ru.gb.family_tree.human.Human;

import java.util.Comparator;

public class HumanCompareByName<T extends FamilyTreeItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
