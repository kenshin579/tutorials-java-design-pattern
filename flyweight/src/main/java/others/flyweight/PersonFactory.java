package others.flyweight;

import java.util.Hashtable;

// 일꾼 공장.
class PersonFactory {
    private Hashtable<Integer, Person> workers = new Hashtable<Integer, Person>();

    // 일꾼을 가져옵니다. 없으면 새로 생성합니다.
    public Person get(int pid) {
        Person person = workers.get(pid);
        if (person == null) {
            person = new Worker(pid);
            workers.put(pid, person);
        }
        return person;
    }

    // 총 일꾼수.
    public int size() {
        return workers.size();
    }
}