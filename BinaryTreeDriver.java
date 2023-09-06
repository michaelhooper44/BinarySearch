    import java.util.Scanner;
    import java.io.File;
    import java.io.FileNotFoundException;
   
    public class BinaryTreeDriver {
        public static void printCommands() {
            // Prints the initial commands prompt
            System.out.print("Commands: \n" + "(i) - Insert Item\n" +
            "(d) - Delete Item\n" + "(p) - Print Tree\n" + "(s) - Search Item\n" +
           "(l) - Count Leaf Nodes\n" + "(sp) - Find Single Parents\n" +
           "(c) - Find Cousins\n" + "(q) - Quit program\n");
       } // printCommands
  
       public static void main(String args[]){
  
           int quit = 0;
           int input;
           double dub;
           String str;
           String command;
          String inputType;
           Scanner keyboard = new Scanner(System.in);
           System.out.println("Enter list type (i - int, d - double, s - string):");
           inputType = keyboard.nextLine();
           printCommands();
           BinaryTree<Integer> ilist = new BinaryTree<>();
           BinaryTree<Double> dlist = new BinaryTree<>();
           BinaryTree<String> slist = new BinaryTree<>();
           // Checks if input type is integer
           if(inputType.equals("i")){
           try{
               File file = new File(args[0]);
               String filePath = file.getAbsolutePath();
               File file1 = new File(filePath);
               System.out.println(filePath);
               Scanner scanner = new Scanner(file1);
  
               // Inserts integers into a binary search tree of integers
               while (scanner.hasNextInt()) {
                   int number = scanner.nextInt();
                   ilist.insert(number);
               }
               scanner.close();
  
           }
           catch(FileNotFoundException e){
               System.out.println("File not found " + args[0]);
           }
       }
           // Checks if input type is double
           else if(inputType.equals("d")){
               try{
                   File file = new File(args[0]);
                   String filePath = file.getAbsolutePath();
                   File file1 = new File(filePath);
                   System.out.println(filePath);
                   Scanner scanner = new Scanner(file1);
  
                   // Inserts double values into a binary search tree of doubles
                   while (scanner.hasNextDouble()) {
                       double number = scanner.nextDouble();
                       dlist.insert(number);
                   }
                   scanner.close();
  
               }
               catch(FileNotFoundException e){
                   System.out.println("File not found " + args[0]);
               }
           }
  
           // Checks if input type is string
           else if(inputType.equals("s")){
               try{
                  File file = new File(args[0]);
                   String filePath = file.getAbsolutePath();
                   File file1 = new File(filePath);
                   System.out.println(filePath);
                   Scanner scanner = new Scanner(file1);
  
                   // Inserts strings into a binary search tree of strings
                   while (scanner.hasNextLine()) {
                       String str2 = scanner.nextLine();
                       Scanner scan2 = new Scanner(str2);
  
                       while(scan2.hasNext()) {
                           String string = scan2.next();
                          slist.insert(string);
                       }
                       scan2.close();
                   }
                   scanner.close();
  
               }
               catch(FileNotFoundException e){
                   System.out.println("File not found " + args[0]);
               }
           }
          // Handles integer input
          if(inputType.equals("i")){
         while(quit == 0){
              System.out.print("Enter a command: ");
              command = keyboard.nextLine();
              // Handles insert command
              if(command.equals("i")){
                  System.out.print("In-Order: ");
                  ilist.inOrder();
                  System.out.println();
                  System.out.print("Enter a number to insert: ");
                  input = keyboard.nextInt();
                  keyboard.nextLine();
                  if(ilist.search(input, ilist.root) == false){
                      ilist.insert(input);
                  }
                  else{
                     System.out.println("Item is already in the tree");
                  }
 
                      System.out.print("In-Order: ");
                      ilist.inOrder();
                      System.out.println();
              }
              // Handles delete command
              else if(command.equals("d"))
              {
                  System.out.print("In-Order: ");
                  ilist.inOrder();
                 System.out.println();
                  System.out.print("Enter a number to delete: ");
                  input = keyboard.nextInt();
                  keyboard.nextLine();
                  ilist.delete(input);
                  System.out.print("In-Order: ");
                  ilist.inOrder();
                  System.out.println();
              }
              // Handles print command
              else if(command.equals("p")){
                  System.out.print("In-Order: ");
                  ilist.inOrder();
                  System.out.println();
              }
              // Handles search command
              else if(command.equals("s")){
                  System.out.print("Enter a number to search: ");
                  input = keyboard.nextInt();
                  keyboard.nextLine();
                  System.out.print("In-Order: ");
                  ilist.inOrder();
                  System.out.println();
                  if(ilist.search(input, ilist.root) == true){
                      System.out.println("Item is present in the tree");
                  }
                  else{
                      System.out.println("Item is not present in the tree");
                  }
              }
              // Handles getNumLeafNodes command
              else if(command.equals("l")){
                  System.out.print("In-Order: ");
                  ilist.inOrder();
                  System.out.println();
                  System.out.println("The number of leaf nodes is " +
                  ilist.getNumLeafNodes(ilist.root));
                  ilist.resetCount();
              }
              // Handles singleParents command
              else if(command.equals("sp")){
                System.out.print("Single parents: ");
                  ilist.getSingleParent(ilist.root);
                  System.out.println();
              }
              // Handles getCousins command
              else if(command.equals("c")){
                  System.out.print("In-Order: ");
                  ilist.inOrder();
                  System.out.println();
                  System.out.print("Enter a number: ");
                  input = keyboard.nextInt();
                  keyboard.nextLine();
                  System.out.println();
                  System.out.print(input + " cousins: ");
                  ilist.getCousins(input, ilist.root);
                  System.out.println();
              }
              // Handles quit command
              else if(command.equals("q")){
                  System.out.println("Exiting the program...");
                  quit = 1;
              }
              else{
                  System.out.println("Invalid Command. Try again:");
              }
 
      }
      keyboard.close();
      // Handles string input
          } else if (inputType.equals("s")) {
           while(quit == 0){
                 System.out.print("Enter a command: ");
                 command = keyboard.nextLine();
                 // Handles insert command
                 if(command.equals("i")){
                     System.out.print("In-Order: ");
                     slist.inOrder();
                     System.out.println();
                     System.out.print("Enter a number to insert: ");
                     str = keyboard.next();
                     keyboard.nextLine();
                     if(slist.search(str, slist.root) == false){
                         slist.insert(str);
                     }
                    else{
                         System.out.println("Item is already in the tree");
                     }
 
                         System.out.print("In-Order: ");
                         slist.inOrder();
                         System.out.println();
                 }
                 // Handles delete command
                 else if(command.equals("d"))
                 {
                     System.out.print("In-Order: ");
                     slist.inOrder();
                     System.out.println();
                     System.out.print("Enter a string to delete: ");
                     str = keyboard.next();
                     keyboard.nextLine();
                     slist.delete(str);
                     System.out.print("In-Order: ");
                     slist.inOrder();
                     System.out.println();
                 }
                 // Handles print command
                 else if(command.equals("p")){
                     System.out.print("In Order: ");
                     slist.inOrder();
                     System.out.println();
                 }
                 // Handles search command
                 else if(command.equals("s")){
                     System.out.print("Enter a number to search: ");
                     str = keyboard.next();
                    keyboard.nextLine();
                     System.out.print("In-Order: ");
                     slist.inOrder();
                     System.out.println();
                     if(slist.search(str, slist.root) == true){
                         System.out.println("Item is present in the tree");
                     }
                     else{
                         System.out.println("Item is not present in the tree");
                     }
                 }
                 // Handles getNumLeafNodes command
                 else if(command.equals("l")){
                     System.out.print("In-Order: ");
                     slist.inOrder();
                     System.out.println();
                     System.out.println("The number of leaf nodes is " +
                     slist.getNumLeafNodes(slist.root));
                     slist.resetCount();
                 }
                 // Handles getSingleParents command
                 else if(command.equals("sp")){
                System.out.print("Single parents: ");
                     slist.getSingleParent(slist.root);
                     System.out.println();
 
                }
                 // Handles getCousins command
                 else if(command.equals("c")){
                     System.out.print("In-Order: ");
                     slist.inOrder();
                     System.out.println();
                     System.out.print("Enter a string: ");
                     str = keyboard.next();
                     keyboard.nextLine();
                     System.out.println();
                     System.out.print(str + " cousins: ");
                     slist.getCousins(str, slist.root);
                     System.out.println();
                 }
                 // Handles quit command
                 else if(command.equals("q")){
                     System.out.println("Exiting the program...");
                     quit = 1;
                 }
                 else{
                     System.out.println("Invalid Command. Try again:");
                 }
 
         }
        keyboard.close();
        // Handles double input
         } else if (inputType.equals("d")) {
         while(quit == 0){
                 System.out.print("Enter a command: ");
                 command = keyboard.nextLine();
                 // Handles insert command
                 if(command.equals("i")){
                     System.out.print("In-Order: ");
                     dlist.inOrder();
                     System.out.println();
                     System.out.print("Enter a number to insert: ");
                     dub = keyboard.nextDouble();
                     Double dub1 = dub;
                     keyboard.nextLine();
                    if(dlist.search(dub1, dlist.root) == false){
                         dlist.insert(dub1);
                     }
                     else{
                         System.out.println("Item is already in the tree");
                     }
 
                         System.out.print("In-Order: ");
                         dlist.inOrder();
                        System.out.println();
                 }
                 // Handles delete command
                 else if(command.equals("d"))
                 {
                     System.out.print("In-Order: ");
                     dlist.inOrder();
                     System.out.println();
                    System.out.print("Enter a number to delete: ");
                    dub = keyboard.nextDouble();
                     Double dub1 = dub;
                     keyboard.nextLine();
                     dlist.delete(dub1);
                     System.out.print("In-Order: ");
                     dlist.inOrder();
                     System.out.println();
                 }
                 // Handles print command
                 else if(command.equals("p")){
                     System.out.print("In Order: ");
                    dlist.inOrder();
                     System.out.println();
                 }
                 // Handles search command
                 else if(command.equals("s")){
                     System.out.print("Enter a number to search: ");
                     dub = keyboard.nextDouble();
                     Double dub1 = dub;
                     keyboard.nextLine();
                     System.out.print("In-Order: ");
                     dlist.inOrder();
                     System.out.println();
                     if(dlist.search(dub1, dlist.root) == true){
                        System.out.println("Item is present in the tree");
                     }
                     else{
                         System.out.println("Item is not present in the tree");
                     }
                 }
                 // Handles getNumLeafNodes command
                 else if(command.equals("l")){
                     System.out.print("In-Order: ");
                     dlist.inOrder();
                     System.out.println();
                     System.out.println("The number of leaf nodes is " +
                     dlist.getNumLeafNodes(dlist.root));
                     dlist.resetCount();
                 }
                 // Handles getSingleParents command
                else if(command.equals("sp")){
                    System.out.print("Single parents: ");
                     dlist.getSingleParent(dlist.root);
                     System.out.println();
 
                 }
                 // Handles getCousins command
                 else if(command.equals("c")){
                    System.out.print("In-Order: ");
                     dlist.inOrder();
                     System.out.println();
                     System.out.print("Enter a number: ");
                     dub = keyboard.nextDouble();
                     Double dub1 = dub;
                     keyboard.nextLine();
                     System.out.println();
                     System.out.print(dub1 + " cousins: ");
                     dlist.getCousins(dub1, dlist.root);
                     System.out.println();
                 }
                 // Handles quit command
                 else if(command.equals("q")){
                     System.out.println("Exiting the program...");
                     quit = 1;
                 }
                 else{
                     System.out.println("Invalid Command. Try again:");
                }
 
         }
         keyboard.close();
         }
    }
}

