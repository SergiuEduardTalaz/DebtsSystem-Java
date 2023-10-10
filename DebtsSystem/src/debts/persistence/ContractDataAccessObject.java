package ro.fortech.academy.debts.persistence;

import ro.fortech.academy.debts.business.entities.Contract;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContractDataAccessObject {
    /**public static int linearSearch(int arr[], int x){
        int N = arr.length;
        for (int i = 0; i < N; i++){
            if(arr[i] == x){
            return i;
        }
        return -1;
    }
    public static void main(String args[]){
        int arr[] = {1860, 14997, 143, 107, 204, 75, 71, 6815, 1328, 253, 4234, 529, 589, 489, 207, 11, 38, 9, 112, 6432, 1833, 13078, 47, 102, 1204, 1441, 1963, 4822, 4775, 2906, 2651, 36, 2101, 5272, 938, 5721, 2370, 385, 3690};
        int x = 1204;

        int result = linearSearch(arr, x);
        if (result == -1 )
            System.out.print("Element is not present in array.");
        else
            System.out.print("Element is present in array," + result);
    }*/
    public List<Contract> loadAllContracts() {
        List<Contract> contracts = new ArrayList<>();
        try (FileReader fileReader = new FileReader("resources/contracts-in.txt")) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String currentLine = bufferedReader.readLine();
            while (!"---".equals(currentLine)) {
                Contract currentContract = readContracts(bufferedReader);
                contracts.add(currentContract);
                currentLine = bufferedReader.readLine();
            }
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        return contracts;
    }
    private Contract readContracts(BufferedReader bufferedReader) throws IOException {
        String ctrNumber = bufferedReader.readLine();
        String debtorName = bufferedReader.readLine();
        String clntName = bufferedReader.readLine();
        String billsNumbers = bufferedReader.readLine();
        String debtTotal = bufferedReader.readLine();
        String contractStatus = bufferedReader.readLine();
        return new Contract(ctrNumber, debtorName, clntName, billsNumbers, debtTotal, contractStatus);
    }
}
