import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
/**
 *
 * @author NileW & Col P
 */
public class Utility {
    
    public static ArrayList<Account> readFile(String fileName){ //Function that returns array list
        
        ArrayList<Account> accounts = new ArrayList<>(); // An array list to store more than one account
        
        //try catch statment in case file does not open
        try{
        String line;
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        
        while((line = br.readLine()) != null){ // while each line of file is not null
            String[] currentAccount = line.split("<>"); // Create array that index is determoined by <> within text file
            
            // Assign each variable to index from String array
            String accountNumber = currentAccount[0];
            String accountName = currentAccount[1];
            String accountOpenDate = currentAccount[2];
            double accountBalance = Double.parseDouble(currentAccount[3]);
            
            //Create a new object using the asigned values from created String array
            Account acc = new Account(accountNumber,accountName,accountOpenDate,accountBalance);
            // add current account to array list
            accounts.add(acc);
            }
        
            br.close(); // close file
        }
        catch(Exception e){ //Incase file mname does not exist exception
            System.out.println(e); //print error
        }
        
        return accounts;
    }
    
    public static void writeFile(ArrayList<Account> accounts, String fileName){
        try {
            FileWriter fw= new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
                
            for (Account a : accounts){// loop through array list
                    
                bw.write(a.toString() + "<>" + a.getAccountName() + "<>" + a.getOpenDate() + "<>" + String.valueOf(a.getAccountBalance()) + "\n");
            }
            bw.close();
        }
   
        catch(Exception e){
            System.out.println(e);
        }
    }
}
