package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Human;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HumanIterrator implements Iterator<Human> {
        private int index;
        private List<Human> family;


    public HumanIterrator(List<Human> family) {
        this.family = new ArrayList<>();

        @Override
        public Human hasNext() {
            return family.size() > index;
        }

        @Override
        public Human next() {
            return family.get(index++);
        }
    }
}
