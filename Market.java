import java.util.LinkedList;
import java.util.Queue;

interface QueueBehaviour {
    void enqueue(Person person);
    Person dequeue();
}

interface MarketBehaviour {
    void addPerson(Person person);
    void removePerson();
    void update();
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Market implements QueueBehaviour, MarketBehaviour {
    private Queue<Person> queue;

    public Market() {
        this.queue = new LinkedList<>();
    }

    @Override
    public void enqueue(Person person) {
        queue.add(person);
        System.out.println(person.getName() + " добавлен в очередь.");
    }

    @Override
    public Person dequeue() {
        Person person = queue.poll();
        if (person != null) {
            System.out.println(person.getName() + " удален из очереди.");
        }
        return person;
    }

    @Override
    public void addPerson(Person person) {
        enqueue(person);
    }

    @Override
    public void removePerson() {
        dequeue();
    }

    @Override
    public void update() {
        System.out.println("Обновление состояния магазина...");
        if (!queue.isEmpty()) {
            Person person = dequeue();
            System.out.println("Обрабатывается заказ для " + person.getName());
        } else {
            System.out.println("Очередь пуста, нет заказов для обработки.");
        }
    }

    public static void main(String[] args) {
        Market market = new Market();
        Person person1 = new Person("Иван");
        Person person2 = new Person("Мария");

        market.addPerson(person1);
        market.addPerson(person2);

        market.update();
        market.update();
        market.update();
    }
}
