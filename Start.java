public class Start {
    public static void main(String[] args) {
        try {
            intVector test = new intVector();
    
            System.out.println("Size: " + test.size());
    
            for(int i = 0; i < 20; i++) {
                test.add(i);
            }

            System.out.println(test);

        } catch(IllegalArgumentException ex) {
            System.out.println("That's illegal");
        } catch(ArithmeticException ex) {
            System.out.println("Bad math");
        }catch(Exception ex) {  //catch everything
            System.out.println("Generic Exception");
        }
        
    }
}