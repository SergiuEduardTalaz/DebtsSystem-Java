package ro.fortech.academy.debts.persistence;

import ro.fortech.academy.debts.business.entities.Bill;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

public class BillDataAccessObject {
    /**public BillDataAccessObject() {
        int[] data = {1509, 38, 2315, 1547, 9, 2105, 854, 818, 858, 352, 143, 1202, 1528, 112, 412, 621, 398, 935, 973, 1873, 1371, 2558, 1203, 47, 107, 1187, 204, 102, 75, 349, 1492, 71, 2498, 1204, 1094, 681, 1152, 6031, 1725, 878, 2507, 253, 761, 2155, 1015, 4489, 1271, 2906, 992, 540, 176, 481, 36, 1740, 2410, 740, 529, 1141, 240, 137, 385, 3740, 583, 762, 890, 719, 380, 1807, 754, 2162, 914, 1420, 207, 1962, 11};
        BillDataAccessObject dao = new BillDataAccessObject(data);
        dao.sort();
        int[] sortedData = dao.getData();
        System.out.println(Arrays.toString(sortedData));

        int searchValue = 529;
        int index = dao.binarySearch(searchValue);

        if (index >= 0) {
            System.out.println("Value of debtBill " + searchValue + " found at index " + index + ".");
        } else {
            System.out.println("Value of debtBill " + searchValue + " not found.");
        }
    }*/

    public List<Bill> loadAllBills() {
        List<Bill> bills = new ArrayList<>();
        try (FileReader fileReader = new FileReader("resources/bills-in.txt")) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String currentLine = bufferedReader.readLine();
            while (!"---".equals(currentLine)) {
                Bill currentBill = readBills(bufferedReader);
                bills.add(currentBill);
                currentLine = bufferedReader.readLine();
            }
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        return bills;
    }


    private Bill readBills(BufferedReader bufferedReader) throws IOException {
        String billNumber = bufferedReader.readLine();
        String ctrNumber = bufferedReader.readLine();
        String debtBill = bufferedReader.readLine();
        String dueDate = bufferedReader.readLine();
        String typeService = bufferedReader.readLine();
        return new Bill(billNumber, ctrNumber, debtBill, dueDate, typeService);
    }

    /**private int[] data;

    public BillDataAccessObject(int[] data) {
        this.data = data;
    }

    public void sort() {
        quickSort(data, 0, data.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;

        return i + 1;
    }
    public int binarySearch(int value) {
        return binarySearch(data, 0, data.length - 1, value);
    }

    private static int binarySearch(int[] arr, int left, int right, int value) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        if (arr[mid] == value) {
            return mid;
        } else if (arr[mid] < value) {
            return binarySearch(arr, mid + 1, right, value);
        } else {
            return binarySearch(arr, left, mid - 1, value);
        }
    }
    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }*/
}
