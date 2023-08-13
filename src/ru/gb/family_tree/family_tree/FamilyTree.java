package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.human.HumanCompareByAge;
import ru.gb.family_tree.human.HumnCompareByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private long humansId;
    private List<Human> family;

    public FamilyTree(List<Human> family){
        this.family=family;
    }

    public FamilyTree(){
        this(new ArrayList<>());
    }
public boolean addHuman(Human human){
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

private void addToParents(Human human){
        for(Human parent: human.getParents()){
            parent.addChild(human);
        }

}

private void addToChildren(Human human) {
    for (Human child : human.getChildren()) {
        if (human.getGender() == Gender.Male) {
            child.addParents(human);
        }
    }
}

public boolean setWedding(Human man, Human woman){
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
            Human person = getById(humansId);
            return family.remove(person);
        }
        return false;
}

private boolean checkId(long id){
        if (id>= humansId || id<0){
            return false;
        }
        for (Human human:family){
            if(human.getId() == id){
                return true;
            }
        }
        return false;
}

public Human getById(long id){
    for (Human human:family){
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
    Iterator<Human> iterator = family.iterator();
    while (iterator.hasNext()){
        Human human = iterator.next();
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
    public Iterator<Human> iterator() {
        return new HumanIterrator(family);
    }

    public void sortByName(){
        Collections.sort(family, new HumnCompareByName());
    }

    public void sortByAge(){
        Collections.sort(family, new HumanCompareByAge());
    }
}
