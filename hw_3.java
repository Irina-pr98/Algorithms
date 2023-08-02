import java.util.Iterator;

public class hw_3 {

  public static void main(String[] args) {
    SingleLinkList<Contact> contactList = new SingleLinkList<>();

    contactList.addToEnd(new Contact(121, "Иванов Иван Иванович", "+79994556237"));
    contactList.addToEnd(new Contact(122, "Алексеев Михаил Степанович", "+71234567899"));
    contactList.addToEnd(new Contact(123, "Иванов Сергей Александрович", "+79057810200"));
    contactList.addToEnd(new Contact(124, "Петров Иван Иванович", "+79876543219"));
    contactList.addToEnd(new Contact(125, "Сидоров Андрей Сергеевич", "+79991112233"));

    for (Object contact : contactList) {
      System.out.println(contact);
    }
    contactList.reverse();

    System.out.println("-------------------------------------");

    for (Object contact : contactList) {
      System.out.println(contact);
    }
  }

  static class Contact {

    int id;
    String name;
    String phone;

    public Contact(int id, String name, String phone) {
      this.id = id;
      this.name = name;
      this.phone = phone;
    }

    @Override
    public String toString() {
      return "Contact{" +
          "id=" + id +
          ", name='" + name + '\'' +
          ", phone='" + phone + '\'' +
          '}';
    }
  }


  /**
   * Класс списка
   *
   * @param <T>
   */
  public static class SingleLinkList<T> implements Iterable {

    ListItem<T> head;
    ListItem<T> tail;

    @Override
    public Iterator iterator() {
      return new Iterator<T>() {
        ListItem<T> current = head;

        @Override
        public boolean hasNext() {
          return current != null;
        }

        @Override
        public T next() {
          T data = current.data;
          current = current.next;
          return data;
        }
      };
    }

    /**
     * Класс отдельного элемента
     *
     * @param <T>
     */
    private static class ListItem<T> {

      T data;
      ListItem<T> next;
    }

    public boolean isEmpty() {
      return head == null;
    }

    public void addToEnd(T item) {

      ListItem<T> newItem = new ListItem<>();
      newItem.data = item;

      if (isEmpty()) {
        head = newItem;
        tail = newItem;
      } else {
        tail.next = newItem;
        tail = newItem;
      }
    }

    public void reverse() {
      if (!isEmpty() && head.next != null) {
        tail = head;
        ListItem<T> current = head.next;
        head.next = null;
        while (current != null) {
          ListItem<T> next = current.next;
          current.next = head;
          head = current;
          current = next;
        }
      }
    }
  }
}