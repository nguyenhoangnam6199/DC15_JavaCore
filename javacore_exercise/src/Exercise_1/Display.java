package Exercise_1;

public class Display {
    // Fields
    private int size;
    private int numberofColors;

    //Getter and Setter

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if(size>=0){
            this.size = size;
        }
        else {
            throw new Error("Size can not be negative");
        }
    }

    public int getNumberofColors() {
        return numberofColors;
    }

    public void setNumberofColors(int numberofColors) {
        if(numberofColors>=0){
            this.numberofColors = numberofColors;
        }
        else {
            throw new Error("Number of colors can not be negative");
        }
    }

    //Constructer
    public Display()
    {
    }

    public Display(int size, int numberofColors) {
        this.size = size;
        this.numberofColors = numberofColors;
    }

    public Display(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Display{" +
                "size=" + size +
                ", numberofColors=" + numberofColors +
                '}';
    }
}
