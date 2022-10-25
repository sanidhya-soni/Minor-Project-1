package source;

public class Tray {
    int row, column;
    int capacity, occupied;
    int tray[][];
    boolean isFull;

    Tray(int row, int column) {
        this.occupied = 0;
        this.row = row;
        this.column = column;
        this.tray = new int[this.row][this.column];
        this.capacity = this.row * this.column;
        this.isFull = false;
    }

    void add() {

        if (this.hasSpace()) {
            occupied++;
            System.out.println("Item Added");
        } else {
            System.out.println("Is Full");
        }

        this.updateStatus();
    }

    void remove() {

        if (!this.isEmpty()) {
            this.occupied--;
            System.out.println("Removed");
        }

        this.updateStatus();
    }

    boolean isEmpty() {

        return this.occupied == 0;
    }

    boolean hasSpace() {

        return this.occupied != this.capacity;
    }

    boolean isFull() {

        return this.occupied == this.capacity;
    }

    void updateStatus() {

        this.isFull = this.occupied == this.capacity;
    }
}
