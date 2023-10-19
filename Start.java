public class Start {
    public static void main(String[] args) {
        try {
            System.out.println(1/0); //throw bad math

            intVector test = new intVector(-1000); //throw illegal
    
            System.out.println("Size: " + test.size());
    
            for(int i = 0; i < test.size(); i++) {
    
            }
        } catch(IllegalArgumentException ex) {
            System.out.println("That's illegal");
        } catch(ArithmeticException ex) {
            System.out.println("Bad math");
        }catch(Exception ex) {  //catch everything
            System.out.println("Generic Exception");
        }
        
    }
}