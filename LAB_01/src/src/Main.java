public class Main {
    public static void main(String[] args) {
        var obj = new Lab2Porubaimikh303();

        try {
            obj.configure();
            obj.fill();
            obj.print();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}