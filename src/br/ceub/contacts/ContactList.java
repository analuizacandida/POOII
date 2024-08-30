package br.ceub.contacts;

public class ContactList {
    private Node head;

    public void addContact(Contact contact) {
        Node newNode = new Node(contact);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Contact searchContact(String nameOrPhone) {
        Node current = head;
        while (current != null) {
            if (current.contact.getName().equals(nameOrPhone) || current.contact.getPhoneNumber().equals(nameOrPhone)) {
                return current.contact;
            }
            current = current.next;
        }
        return null;
    }

    public boolean removeContact(String nameOrPhone) {
        if (head == null) return false;

        if (head.contact.getName().equals(nameOrPhone) || head.contact.getPhoneNumber().equals(nameOrPhone)) {
            head = head.next;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.contact.getName().equals(nameOrPhone) || current.next.contact.getPhoneNumber().equals(nameOrPhone)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void listContacts() {
        Node current = head;
        while (current != null) {
            System.out.println(current.contact.toString());
            current = current.next;
        }
    }
}
