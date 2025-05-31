package mainService;

import entity.Management;
import enums.ManageStatus;

import static util.Util.myBank;

public class MainService {

    public boolean addTransactionValue(String title, double money, ManageStatus status) {
        for (int i = 0; i < myBank.length; i++) {
            if (myBank[i] == null) {
                Management management = new Management(title, money, status);
                myBank[i] = management;
                return true;
            }
        }

        return false;
    }

    public Management[] getTransactionList(ManageStatus status) {
        int counter = 0;

        for (Management management : myBank) {
            if (management != null && management.getManageStatus().equals(status) ) {
                counter++;
            }
        }

        Management [] data = new Management[counter];

        int index = 0;

        for (Management management: myBank) {
            if (management != null && management.getManageStatus().equals(status)) {
                data[index++] = new Management(management.getTitle(), management.getPrice(), management.getManageStatus());
            }
        }

        return data;
    }

    public double totalTransactionValue(ManageStatus manageStatus) {
        double total = 0;

        for (Management management : myBank) {
            if (management != null && management.getManageStatus().equals(manageStatus)) {
                total += management.getPrice();
            }
        }

        return total;
    }



}

