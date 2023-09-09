package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.human.comparators.HumanCompareByAge;
import ru.gb.family_tree.human.comparators.HumanCompareByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyTreeItem<E>> implements Serializable, Iterable<E> {
    private long humansId;
    private List<E> family;

    public FamilyTree(List<E> family){
        this.family=family;
    }

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public boolean addHuman(E human){
        if(human == null){
            return false;
        }
        if(!family.contains(human)){
            family.add(human);
            human.setId(humansId++);
            addToParents(human);
            addToChildren(human);
            return true;
        }
        return false;
}

    private void addToParents(E human){
        for(E parent: human.getParents()){
            parent.addChild(human);
        }

    }

    private void addToChildren(E human) {
    for (E child: human.getChildren()) {
        if (human.getGender() == Gender.Male) {
            child.addParents((E) human);
        }
    }
    }

    public boolean setWedding(E man, E woman){
      if(man.getSpouse() == null && woman.getSpouse() == null){
          man.setSpouse(woman);
          woman.setSpouse(man);
          return true;
      } else {
          return false;
      }
    }

    public boolean remove(long humansId){
        if (checkId(humansId)){
            E person = getById(humansId);
            return family.remove(person);
        }
        return false;
    }

    private boolean checkId(long id){
        if (id>= humansId || id<0){
            return false;
        }
        for (E human:family){
            if(human.getId() == id){
                return true;
            }
        }
        return false;
    }

    public E getById(long id){
    for (E human:family){
        if(human.getId() == id){
            return human;
        }
    }
    return null;
    }

    public String  getInfo() {
    StringBuilder sb = new StringBuilder();
    sb.append("В семейном древе ");
    sb.append(family.size());
    sb.append(" человек: \n");
    Iterator<E> iterator = family.iterator();
    while (iterator.hasNext()){
        E human = iterator.next();
    //for (Human human: family){
        sb.append(human);
        sb.append("\n");
    }
    return sb.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterrator<>(family);
    }

    public boolean sortByName(){
        family.sort(new HumanCompareByName<>());
        return false;
    }

    public void sortByAge(){
        family.sort(new HumanCompareByAge<>());
    }
}
