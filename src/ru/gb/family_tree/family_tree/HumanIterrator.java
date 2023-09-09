package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Human;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HumanIterrator<T> implements Iterator<T> {
    private int index;
    private List<T> family;


    public HumanIterrator(List<T> family) {
        this.family = new ArrayList<>();
    }

        @Override
        public boolean hasNext () {
            return family.size() > index;
        }

        @Override
        public T next () {
            return family.get(index++);
        }
    }

