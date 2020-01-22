public class RoomTester
{
    
    public static void main(String[] args)
    {
         Room hall = new Room("Hall", "Its Dark.");
         Room bed = new Room("Bed", "Tiny Room.");
         Room bath = new Room("Bath", "Toilets here.");
         Room dine = new Room("Dining", "Table & chairs");
         hall.setExits(bed,bath,dine,null);
         System.out.println(hall);
    }
}