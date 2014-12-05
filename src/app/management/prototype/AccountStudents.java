package app.management.prototype;

import java.io.IOException;

public abstract class AccountStudents extends AccountParent {
	
       @Override
       public double getAmountToBePaid()
       {
           return super.amountToBePaid*0.75;
       }

     

    public AccountStudents(int aa) throws IOException {
        super(aa);
    }
	
	


}