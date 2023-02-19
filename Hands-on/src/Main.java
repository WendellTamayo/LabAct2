interface Array{
    int size=10;
    public void display();
    // display the values of the array
    public int check(int num);
    // return 1 if num is found in the array, otherwise return 0
    public void add(int num);
    // add unique elements in the array
}

class ImpArray implements Array {
    int[] array = new int[size];
    int count = 0;
    @Override
    public void display() {
        for(int i : array) {
            System.out.println(i);
        }
    }

    @Override
    public int check(int num) {
        for (int i : array) {
            if(num == i) {
                return 1;
            }
        }
        return 0;
    }

    @Override
    public void add(int num) {
        for(int i : array) {
            if(num == i) {
                return;
            }
        }
        array[count] = num;
        count++;
    }
}

class Main {
    public static void main(String[] args) {
        ImpArray arr= new ImpArray();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(4);
        arr.display();
    }
}
